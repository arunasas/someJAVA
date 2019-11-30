package com.company;

import java.util.Scanner;

public class Main8 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Kiek skaiciu ivesite?");
        int[] skaiciai = new int[scan.nextInt()];
        for (int i = 0; i < skaiciai.length; i++) {
            System.out.println("Iveskite skaiciu");
            skaiciai[i] = scan.nextInt();
        }
        spausdinam(skaiciai);
    }

        static void spausdinam(int[] skaiciai) {
            System.out.println("Skaicia didesni uz 100");
            for (var item : skaiciai) {
                if (item > 100) {
                    System.out.println(item);
                }
        }
    }
}
