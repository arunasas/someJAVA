package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main10 {
    public static void main(String[] args) {
//        ArrayList<String> sarasas = new ArrayList<>();
//        sarasas.add("pirmas elementas");
//        sarasas.add("antras elementas");
//        sarasas.add("trecias elementas");
//        sarasas.add("asdasfasfsdfasdfasd");
//        System.out.println(sarasas);
//        if (sarasas.contains("trecias elementas")) {
//            System.out.println("Radome trecias elementas");
//            System.out.println(sarasas.indexOf("trecias elementas"));
//        }
//        sarasas.remove("trecias elementas");
//        System.out.println(sarasas);
//        sarasas.addAll(sarasas);
//        System.out.println(sarasas);

        Map<String, String> map = new HashMap<>();
        map.put("pirmas", "vieno reiksme");
        map.put("antras", "antro reiksme");
        map.put("trecias", "trecio reiksme");

        String result = map.get("antras");
        System.out.println("Resultatas: " + result);
//        if (result instanceof String) {
//
//        }
        System.out.println(map.values());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String raktas = entry.getKey();
            String reiksme = entry.getValue();
            if (reiksme.equals("antro reiksme")) {
                System.out.println("Raktas: " + raktas);
            }
        }
    }
}
