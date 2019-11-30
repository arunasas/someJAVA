package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	//6b uzduotis
        Scanner sc = new Scanner(System.in);
        System.out.println("Skaiciuotuvas paprastas");
        char Ans2;
        do {
        System.out.println("Iveskite 1 skaiciu");
        int Sk1 = sc.nextInt();
        System.out.println("Iveskite 2 skaiciu");
        int Sk2 = sc.nextInt();
        System.out.println("Iveskite zenkla skaiciu");
        char Veiksmas = sc.next().charAt(0);
        PrintOut(Aritmetika(Sk1, Sk2, Veiksmas));
        System.out.println("Ar testi toliau, Taip - y, Ne - betkas");
        Ans2 = sc.next().charAt(0);
    } while(Ans2 == 'y');

    }
    static double Aritmetika(int Sk1, int Sk2, char Veiksmas){
        double Ans = 0;
        switch (Veiksmas){
            case '+': Ans = Sk1 + Sk2; break;
            case '-': Ans = Sk1 - Sk2; break;
            case '*': Ans = Sk1 * Sk2; break;
            case '/':
                if(Sk2 == 0){
                    System.out.println("Dalyba is 0 negalima");
                } else {
                    Ans = (double) Sk1 / Sk2;
                }
                break;
        }
        return Ans;
    }

    static void PrintOut(double Ans){
        System.out.println("Atsakymas: " + Ans);
    }
}
