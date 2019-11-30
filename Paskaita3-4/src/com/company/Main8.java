package com.company;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

//10a ir 10b uzduotys
public class Main8 {
    public static void main(String[] args) {
        List<Integer> digits = new ArrayList<>(List.of(2, 5, 1, 9, -999, 9879, 55, 26));
        System.out.println(digits);
        //Collections.sort(digits);
        Sorting(digits);
        System.out.println(digits);

        Collections.reverse(digits);
        System.out.println(digits);

    }
    static List<Integer> Sorting(List<Integer> digits){
        Collections.sort(digits);
        return digits;
    }
}
