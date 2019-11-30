package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main13c {
    public static void main(String[] args) {
//            try {
//                //searchByName(readData());
//
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
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

        private static Map<String, String> readDataDictLt(String dictname) throws FileNotFoundException {
            Scanner sc = new Scanner(new File(dictname));
            Map<String, String> map = new HashMap<>();
            while (sc.hasNextLine()) {
                String lt = sc.next();
                String en = sc.next();
                map.put(lt, en);
            }
            return map;
        }

    private static Map<String, String> readDataEnLT(String dictname) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(dictname));
        Map<String, String> map = new HashMap<>();
        while (sc.hasNextLine()) {
            String lt = sc.next();
            String en = sc.next();
            map.put(en, lt);
        }
        return map;
    }
}

