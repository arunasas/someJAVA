package com.company;

import java.util.Scanner;

public class Main7 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Iveskite mase");
        double mase = scan.nextInt();
        System.out.println("Iveskite ugi");
        double ugis = scan.nextDouble();

        System.out.println("KMI: " + skaiciuojamKMI(mase, ugis));

    }
    public static double skaiciuojamKMI(double mase, double ugis) {

        double kmi = mase / (ugis * ugis);
        return kmi;
    }
}

