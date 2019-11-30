package com.company;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        //7b uzduotis
        Scanner sc = new Scanner(System.in);
        int Skaicius = 0;
        char Veiksmas;

        System.out.println("Iveskite skaiciu?");
        Skaicius = sc.nextInt();
        System.out.println("Iveskite suma + arba daugyba *");
        Veiksmas = sc.next().charAt(0);

        if(Skaicius < 1){
            System.out.println("Ivedete maziau uz 1");
        } else if (Veiksmas == '+') {
            System.out.println("Suma lygi: " + Suma(Skaicius));
        } else if (Veiksmas == '*'){
            System.out.println("Daugyba lygi: " + Multi(Skaicius));
        }
    }
    static int Suma(int Skaicius){
        int suma = 0;
        for (int i = 1; i < Skaicius+1; i++) {
            suma += i;
        }
        return suma;
    }
    static int Multi(int Skaicius){
        int Multi = 1;
        for (int i = 1; i < Skaicius+1; i++) {
            Multi *= i;
        }
        return Multi;
    }

}
