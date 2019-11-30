package com.example;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label nameLabel = new Label("Vardas: ");
        nameLabel.setTextFill(Color.GREEN);

        grid.add(nameLabel, 0, 0);

        Text text = new Text("Sveiki pasauliai");
        text.setWrappingWidth(80.0);
        text.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
        text.setFill(Color.DARKBLUE);
        grid.add(text, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Button btn = new Button("Sign in");
        grid.add(btn, 1, 2);
        Button btn2 = new Button("Sign in2");
        grid.add(btn2, 1, 3);

        btn.setOnMouseClicked(mouseEvent -> {
            String inputText = userTextField.getText();
            nameLabel.setText(inputText);
        });

        btn2.setOnMouseClicked(mouseEvent -> {
//            TextInputDialog dialog = new TextInputDialog();
//            dialog.showAndWait();
//            String result = dialog.getResult();
//            nameLabel.setText(result);
//            System.out.println(result);

            ChoiceDialog<Integer> dialog = new ChoiceDialog(2, 1, 2, 3, 4, 5, 6, 7, 7, 6);
            dialog.showAndWait();
            int choice = dialog.getSelectedItem();
            System.out.printf("You selected: %d\n", choice);


        });







        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}