package com.company;

import java.util.Scanner;

public class Main7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Iveskite zodi arba sakini");
        String String = sc.nextLine();
        Paieska(String);
    }

    static void Paieska(String String) {
        String NewString = String.replaceAll("\\s", "");
        int k = 0;
        for (int i = 0; i < NewString.length() / 2; i++) {
            if (NewString.charAt(i) == NewString.charAt(NewString.length() - 1 - i)) {
                k++;
            }
        }
        System.out.println(NewString);
        System.out.println(k);
        System.out.println(NewString.length() / 2);
        if (k == NewString.length() / 2) {
                System.out.println("Ivestas zodis arba sakinys yra polindromas");
        } else {
            System.out.println("Ivestas zodis NE polindromas");
        }
    }
}
