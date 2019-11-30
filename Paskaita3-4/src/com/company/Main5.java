package com.company;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Iveskite zodi");
        String String = sc.next();
        System.out.println("Kokios raides ieskome");
        char Char = sc.next().charAt(0);
        System.out.println(Char + " kiekis " + KiekA(String, Char));
        //KiekA(null);
    }

    static int KiekA(String String, char Char){
        if (String == null){
            System.out.println("0");
            return 0;
        }
        int k = 0;
        for (int i = 0; i < String.length(); i++) {
            if(String.charAt(i) == Char){k++;}
        }
        return k;
    }
}
