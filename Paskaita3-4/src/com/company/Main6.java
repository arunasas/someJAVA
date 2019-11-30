package com.company;

import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Iveskite zodi");
        String String = sc.next();
        System.out.println("Kokio derinio ieskome?");
        String String2 = sc.next();
        System.out.println("deriniu kiekis " + String2 + " yra " + KiekDer(String, String2));
        //KiekA(null);
    }

    static int KiekDer(String String, String String2){
        if (String == null || String2 == null){
            System.out.println("0");
            return 0;
        }
        int k = 0;
        char Char1 = String2.charAt(0);
        char Char2 = String2.charAt(1);
        for (int i = 0; i < String.length()-1; i++) {
            if(String.charAt(i) == Char1 && String.charAt(i+1) == Char2) {
                k++;
            }
        }
        return k;
    }
}