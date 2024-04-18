package com.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 * Write a list and add an aleatory number of Strings. In the end, print out how
 * many distinct itens exists on the list.
 *
 */
public class TASK3 {

    private static final Random random = new Random();

    public static void main(String[] args) {
        ArrayList<String> listStrings = new ArrayList<String>();

        int numberOfStrings = (random.nextInt(10));
        for (int i = 0; i < numberOfStrings; i++) {
            listStrings.add(randomString());
        }

        System.out.println("List of strings created:");
        for (String str : listStrings) {
            System.out.println(str);
        }

        HashSet<String> setListStrings = new HashSet<String>(listStrings);
        System.out.println("\nQuantity of distinct items: " + setListStrings.size());
    }

    private static String randomString() {
        StringBuilder sb = new StringBuilder();
        int length = (random.nextInt(5));
        for (int i = 0; i < length; i++) {
            char randomChar = (char) ('a' + Math.random() * 26);
            sb.append(randomChar);
        }
        return sb.toString();
    }
}
