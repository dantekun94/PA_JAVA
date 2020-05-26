package Domain;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //resident creation, the ugly way XD
        Resident r0 = new Resident("R0");
        Resident r1 = new Resident("R1");
        Resident r2 = new Resident("R2");
        Resident r3 = new Resident("R3");

        List<Resident> residentList = new ArrayList<>();
        // add elements, one by one
        residentList.add(r0);
        residentList.add(r1);
        residentList.add(r2);
        residentList.add(r3);

        //Using functions
        Collections.sort(residentList, Comparator.comparing(Resident::getName));

        //hospital creation, the ugly way again XD
        Hospital h0 = new Hospital("H0", 1);
        Hospital h1 = new Hospital("H1", 2);
        Hospital h2 = new Hospital("H2", 2);

        TreeSet<Hospital> hospitalTreeSet = new TreeSet<Hospital>();
        hospitalTreeSet.add(h0);
        hospitalTreeSet.add(h1);
        hospitalTreeSet.add(h2);


        // Create two different implementations of maps
        Map<Resident, List<Hospital>> PrefMap_resident = new HashMap<>();
        PrefMap_resident.put(r0, Arrays.asList(h0, h1, h2));
        PrefMap_resident.put(r1, Arrays.asList(h0, h1, h2));
        PrefMap_resident.put(r2, Arrays.asList(h0, h1));
        PrefMap_resident.put(r3, Arrays.asList(h0, h2));
        System.out.println(Collections.singletonList(PrefMap_resident));


        Map<Hospital, List<Resident>> PrefMap_hospital = new LinkedHashMap<>();
        PrefMap_hospital.put(h0, Arrays.asList(r3, r0, r1, r2));
        PrefMap_hospital.put(h1, Arrays.asList(r0, r2, r1));
        PrefMap_hospital.put(h2, Arrays.asList(r0, r1, r3));
        System.out.println(Collections.singletonList(PrefMap_hospital));

        System.out.println("printing the residents who accept H0 & H2");
        residentList.stream()
                .filter(res -> PrefMap_resident.get(res).contains(h0))
                .filter(res -> PrefMap_resident.get(res).contains(h2))
                .forEach(System.out::println);

        System.out.println("printing the hospitals that have R0 as top preference");
        PrefMap_hospital.entrySet().stream()
                .filter(hos -> PrefMap_hospital.get(hos).get(0).getName().equals(r0.getName()))
                .forEach(System.out::println);
    }

}
