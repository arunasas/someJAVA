package com.example;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

import java.io.IOException;

public class Main extends Application {
    private static ServerioSasaja sasaja;

    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost")
                .addConverterFactory(MoshiConverterFactory.create())
                .build();
        sasaja = retrofit.create(ServerioSasaja.class);
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Client");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        TextField email = new TextField();
        grid.add(email, 1, 1);

        PasswordField password = new PasswordField();
        grid.add(password, 1, 2);

        Button loginButton = new Button("Prisijungti");
        grid.add(loginButton, 1, 3);
        loginButton.setOnMouseClicked(mouseEvent -> {
            String emailText = email.getText();
            String passwordText = password.getText();
            Call<ResponseBody> login = sasaja.login(emailText, passwordText);
            try {
                Response<ResponseBody> response = login.execute();
                String result = response.body().string();
                System.out.println(result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        Scene scene = new Scene(grid, 300, 275);
        stage.setScene(scene);
        stage.show();
    }
}
