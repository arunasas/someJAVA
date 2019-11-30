package com.company;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        int Length = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Kiek skaiciu ivesite?");
        Length = sc.nextInt();
        //Ivedimas(Length);
        System.out.println("Suma lygi: " + Suma(Ivedimas(Length)));
    }

    static int[] Ivedimas(int Length){
        Scanner sc = new Scanner(System.in);
        int[] Skaiciai = new int[Length];
        int Sk = 0;
        for (int i = 0; i < Length; i++) {
            System.out.printf("Iveskite %d skaiciu \n", (i + 1));
            Sk = sc.nextInt();
            if (Sk < 1) {
                System.out.println("Ivestas skaicius mazesnis uz 1");
                break;
            } else {
                Skaiciai[i] = Sk;
            }
        }
        return Skaiciai;
    }

    static int Suma(int[] Skaiciai){
        int Suma = 0;
        for (int i = 0; i < Skaiciai.length ; i++) {
            Suma += Skaiciai[i];
        }
        return Suma;
    }
}
