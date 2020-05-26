package Domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.Buffer;
import java.sql.SQLOutput;
import java.util.Scanner;

public class GameClient {
    private static String raspuns;

    public static void main(String[] args) throws IOException {
        String adresaServer = "localhost"; // Adresa IP a serverului
        int PORT = 8800; // Portul la care serverul ofera serviciul
        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        Scanner scanner = null;


        try {
            socket = new Socket(adresaServer, PORT);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            scanner = new Scanner(System.in);

            while(true){
                System.out.printf("Introduceti comanda");
                String comanda = scanner.nextLine();
                System.out.printf("Comanda trimisa");
                out.println(comanda);
                System.out.printf("Raspuns primit");
                raspuns = in.readLine();

                if(comanda.equals("exit")){
                    break;
                }
            }
        } catch (UnknownHostException e) {
            System.err.println(e);
        } finally {
            socket.close();
        }
    }
}