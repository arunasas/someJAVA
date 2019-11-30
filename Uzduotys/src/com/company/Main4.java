package com.company;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        int suma = 0;
        Scanner scanner = new Scanner(System.in);
        for (; ;) {
            System.out.println("Iveskite skaiciu");
            int sk = scanner.nextInt();
            suma += sk;
            if (sk == 0) {
                System.out.println("Ivedete 0; Suma lygu: " + suma);
                break;
            }
        }
    }
}