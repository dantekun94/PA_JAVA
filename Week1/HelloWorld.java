package main;

import java.sql.SQLOutput;

public class HelloWorld{

    public static void main(String []args){

/*
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        int n = (int) (Math.random() * 1_000_000);

        System.out.println("Hello World");

        System.out.println("Numarul random generat este: " + n);

        int result = (n * 3 + Integer.parseInt("10101",2) + Integer.parseInt("FF",16)) * 6 ;

        System.out.println("Suma este: " + result);

        int sum = 0;
        while (result > 0) {
            sum = sum + result % 10;
            result = result / 10;
        }

        System.out.println("Suma cifrelor din result este: " + sum);

        int sum_one_digit = 0;

        while (sum > 0) {
            sum_one_digit = sum_one_digit + sum % 10;
            sum = sum / 10;
        }

        System.out.println("Suma de o cifra este: " + sum_one_digit);

        System.out.println("Willy-nilly, this semester I will learn " + languages[sum_one_digit]);
*/

        long startTime = System.nanoTime();
        if(args.length < 3){
            System.out.println("Avem nevoie de 3 parametri");
            System.exit(-1);
        }
        try{
            int n = Integer.parseInt(args[0]);
            int k = Integer.parseInt(args[1]);
            String alphabet = "";
            for (int i = 2; i < args.length; i++) {
                alphabet += args[i];
            }
            String[] words = new String[n];
            System.out.println("Generated array of words");
            for(int i = 0; i < n; i++) {
                words[i] = WordCreator.createWord(k, alphabet);
                System.out.print(words[i]);
                System.out.print(" ");
            }
            System.out.println("\n");

            int matrix[][] = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    boolean adjacentLetter = false;
                    for (int x = 0; x < k; x++) {
                        for (int y = 0; y < k; y++) {
                            if((words[i].charAt(x))==(words[j].charAt(y))) {
                                adjacentLetter = true;
                            }
                        }
                    }
                    if(adjacentLetter) {
                        matrix[i][j] = 1;
                    }
                }
            }
            System.out.println("Adjacent words Matrix: ");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }

            int maxIndex = 0, minIndex = 0, maxSum = 0, minSum = n;
            for(int i = 0 ; i < n ; i++){
                int sum = 0;
                for(int j = 0; j < k ; j++)
                    sum += matrix[i][j];
                if(sum < minSum){
                    minSum = sum;
                    minIndex = i;
                }
                else if(sum > maxSum){
                    maxSum = sum;
                    maxIndex = i;
                }
            }
            if(minSum == maxSum) {
                System.out.println("All words have the same number of neighbours");
                return;
            }
            System.out.print("The words with the least neighbours: " + words[minIndex]);
            System.out.println();
            System.out.print("The words with the most neighbours: " + words[maxIndex]);
            System.out.println();
        } catch(Exception ex) {
            System.out.println("Primii 2 parametri trebuie sa fie de tip int");
        }
        long endTime = System.nanoTime();
        System.out.println("The running time of the application in nanoseconds\n" + String.valueOf(endTime - startTime));
    }
}