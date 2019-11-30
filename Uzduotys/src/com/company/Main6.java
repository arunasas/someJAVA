package com.company;

import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        String[] zodziai = new String[5];
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("Iveskite zodi");
            zodziai[i] = scan.next();
        }
        System.out.println("Ivesti zodziai:");
        for (int i = 0; i < 5; i++) {
            //System.out.println("Ivestas zodis:");
            System.out.println(zodziai[i]);
        }
    }
}
