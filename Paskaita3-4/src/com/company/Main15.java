package com.company;

import com.sun.source.tree.IfTree;

import java.util.Arrays;
import java.util.List;

public class Main15 {
    public static void main(String[] args) {
        List<String> sarasas = Arrays.asList("desimt", "dvidesimt", "trisdesimt", "Astuonesdesimt", "Antradienis");
        String apjungtas = apjungti(sarasas);
        System.out.println(apjungtas);
    }

    private static String apjungti(List<String> sarasas) {
        String result = "";
        for (String zodis : sarasas) {
            if (zodis.charAt(0) == 'A'){
                result += zodis;
            }
        }
        return result;
    }
}
