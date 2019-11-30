package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainAuto {
    public static void main(String[] args) {
        try {
            List<Auto> sarasas = new ArrayList<>();
            Scanner sc = new Scanner(new File("auto.txt"));
            while (sc.hasNextLine()) {
                String marke = sc.next();
                String modelis = sc.next();
                double uzmiestis = sc.nextDouble();
                double miestas = sc.nextDouble();
                double vidutines = sc.nextDouble();
                Auto auto = new Auto(marke, modelis, uzmiestis, miestas, vidutines);
                sarasas.add(auto);
            }
            String marke = "aaas";
            for (Auto auto : sarasas) {
                if (auto.getMarke().equalsIgnoreCase(marke)) {
                    System.out.println("radome: " + auto.getMarke() + " " + auto.getModelis());
                    System.out.println(auto);
                    System.out.println(auto.toString());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
