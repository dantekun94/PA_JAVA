package main;

import java.util.Random;

public class WordCreator {
    public static String createWord(int k, String alphabet){
        String word = "";
        Random r = new Random();
        for(int i = 1; i <= k; i++)
            word += alphabet.charAt(r.nextInt(alphabet.length()));
        return word;
    }
}
