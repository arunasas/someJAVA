package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main9 {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        while (true) {
            int randomSk = rand.nextInt(10) + 1;
            System.out.println("Iveskite spejama sk");
            int sk = scan.nextInt();
            if (sk == 0) {
                System.out.println("Nutraukta. Buvo " + sk);
                break;
            } else if (sk != randomSk){
                System.out.println("Neatspeta. Buvo " + randomSk);
            }
            else {
                System.out.println("Atspeta");
                break;
            }
        }
    }
}
