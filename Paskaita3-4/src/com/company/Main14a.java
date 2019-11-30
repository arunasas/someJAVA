package com.company;

public class Main14a {
    public static void main(String[] args) {
        boolean arYraSkaiciu = arYraSkaiciu("qwertydsdsdsdsdsdsdsd");
        System.out.println(arYraSkaiciu);
    }

    private static boolean arYraSkaiciu(String tekstas) {
        for (int i = 0; i < tekstas.length(); i++) {
            char simbolis = tekstas.charAt(i);
            if ((int) simbolis > 47 && (int) simbolis < 58) {
            return true;
            }
        }
        return false;
    }
}
