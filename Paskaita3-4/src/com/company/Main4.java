package com.company;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        //8c uzduotis

        int Length = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Kiek skaiciu ivesite?");
        Length = sc.nextInt();
        for (int item : Apvertimas(Ivedimas(Length))
             ) {
            System.out.println(item);
        }
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

    static int[] Apvertimas(int[] Skaiciai){
        int[] Apverstas = new int[Skaiciai.length];
        int k = Skaiciai.length - 1;
        for (int i = 0; i < Skaiciai.length ; i++) {
            Apverstas[k] = Skaiciai[i];
            k--;
        }
        return Apverstas;
    }
}
