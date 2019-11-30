package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Main9 {
    public static void main(String[] args) {
        System.out.println(readFromFile("naujastextas.txt"));
        //System.out.println(readFromFileSum("text.txt"));
        writeToFile("naujastextas.txt", "\njkfkdlasdj kjflasjflasjfd salfdjlsa;fjlsa;jf sjfasl; df");
    }

    public static String readFromFile(String fileName) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String result = "";
        while (scanner.hasNextLine()) {
            result += scanner.nextLine() + "\n";
        }
        return result;
    }

    public static int readFromFileSum(String fileName) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int suma = 0;
        while (scanner.hasNextLine()) {
            if (scanner.hasNext()) {
                scanner.next();
                suma += scanner.nextInt();
            }
        }
        return suma;
    }

    public static void writeToFile(String fileName, String text) {
        try {
            Files.write(Paths.get(fileName), text.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
