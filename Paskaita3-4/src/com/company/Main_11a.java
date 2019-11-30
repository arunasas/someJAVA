package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

//12c
public class Main_11a {
    public static void main(String[] args) {
        String vardai = readFromFile("vardai.txt");
        String skaiciai = readFromFile("skaiciai.txt");
        //System.out.println("Kokios raides zodzius isvesti?");
        //Scanner sc = new Scanner(System.in);
        //char ch = sc.next().charAt(0);
        //toConsole(vardai, ch);
        //toConsole(skaiciai);
        //toConsoleOnlyA(vardai);
        toConsoleSorted("vardai.txt");
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

    public static void toConsole(String string){
        System.out.println(string);
    };

    public static void toConsole(String string, char ch){
        List<String> vardai = new ArrayList<>();
        vardai = Arrays.asList(string.split("\n"));
        //System.out.println(vardai);
        for (String item : vardai) {
            if (item.charAt(0) == ch) {
                System.out.println(item);
            }
        }
    }

    public static void toConsoleSorted (String file) {
        List<String> vardai = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File(file));
            while (sc.hasNextLine()) {
                vardai.add(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Collections.sort(vardai);
        System.out.println(vardai);
    }



//    public static void toConsoleSorted (String skaic) {
//        List<Integer> skaiciai = new ArrayList<>();
//        while (skaic.hasNextInt()) {
//            skaiciai.add(skaic.nextInt());
//        }
//        skaiciai = Arrays.asList(skaic.split("\n"));
//        Collections.sort(skaiciai);
//    }
}
