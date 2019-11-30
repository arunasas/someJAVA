package com.company;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        int[] skaiciai = new int[5];
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("Iveskite skaiciu");
            skaiciai[i] = scan.nextInt();
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("Iveskite skaiciai:");
            System.out.println(skaiciai[i]);
        }
        int suma = 0;
        for (int i = 0; i < skaiciai.length; i++) {
            suma += skaiciai[i];
        }
        System.out.println("Skaiciu suma: " + suma);
    }
}
