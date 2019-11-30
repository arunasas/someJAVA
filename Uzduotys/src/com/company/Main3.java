package com.company;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        for (; ;) {
            System.out.println("Iveskite zodi");
            String tekstas = scanner.nextLine();

            if (tekstas.equals("pabaiga")) {
                System.out.println("Ivedete pabaiga");
                break;
            }
        }
    }
}


