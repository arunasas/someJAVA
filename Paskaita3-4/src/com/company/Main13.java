package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main13 {
    public static void main(String[] args) {
        try {
            //searchByName(readData());
            searchByNameColor(readDataStrings());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void searchByName(Map<String, Integer> map) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        System.out.println("Iveskite varda:");
        String vardas = console.next();
        Integer amzius = map.get(vardas);
        if (amzius != null) {
            System.out.println("Amzius " + amzius);
        } else {
            System.out.println("Neradome");
        }
    }

    private static void searchByNameColor(Map<String, String> map) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        System.out.println("Iveskite varda:");
        String vardas = console.next();
        String color = map.get(vardas);
        if (color != null) {
            System.out.println("Spalva " + color);
        } else {
            System.out.println("Neradome");
        }
    }

    private static Map<String, Integer> readData() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("text.txt"));
        Map<String, Integer> map = new HashMap<>();
        while (sc.hasNextLine()) {
            String vardas = sc.next();
            int amzius = sc.nextInt();
            map.put(vardas, amzius);
        }
        return map;
    }

    private static Map<String, String> readDataStrings() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("colors.txt"));
        Map<String, String> map = new HashMap<>();
        while (sc.hasNextLine()) {
            String vardas = sc.next();
            String color = sc.next();
            map.put(vardas, color);
        }
        return map;
    }
}
