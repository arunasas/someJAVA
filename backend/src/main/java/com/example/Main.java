package com.example;

import spark.*;

import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        //Spark.ipAddress("localhost");
        Spark.port(80);
        Spark.get("/test", (Route) (request, response) -> loadHtml("index.html"));
        Spark.post("/login", (request, response) -> {
            String username = request.queryParams("username");
            String password = request.queryParams("password");
            return "Prisijungimas sekmingas. Username: " + username;
        });
    }
    public static String loadHtml(String path) {
        try {
            URI fullPath = Main.class.getClassLoader().getResource(path).toURI();
            String html = new String(Files.readAllBytes(Paths.get(fullPath)), Charset.forName("UTF-8"));
            return html;
        } catch (Exception e) {
            e.printStackTrace();
            return "Loading error";
        }
    }
}
