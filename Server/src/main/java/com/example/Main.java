package com.example;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class Main {
    public static void main(String[] args) {
        Spark.port(80);
        Spark.post("/login", (request, response) -> {
            String email = request.queryParams("username");
            String password = request.queryParams("password");
            Database db = new Database("name_dbsql");
            boolean success = db.login(email, password);
            return success ? "true" : "false";
        });
    }
}
