package com.example;

public class Main {
    public static void main(String[] args) {
        Database database = new Database("name_dbsql");
        //database.printAll();
        //database.insert("Ponas", "Ponaitis", 34, 23);
        //database.updateName(2, "Auksinis vardas");
        //database.deleteById(3);
        //System.out.println("Po iterpimo:");
        //database.printAll();
        //database.createTable("useriai");
        //database.createTable("useriai2");
        database.deleteTable("useriai");
        database.deleteTable("useriai2");
    }
}
