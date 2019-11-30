package com.example;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JavafxSample extends Application {
   @Override     
   public void start(Stage primaryStage) throws Exception {
      /* 
      Code for JavaFX application. 
      (Stage, scene, scene graph) 
      */

      Text text = new Text();
      text.setFont(new Font(30));
      text.setX(50);
      text.setY(150);
      text.setFill(Color.BURLYWOOD);
      text.setText("Welcome to Tutorialspoint");

      Group root = new Group();
      ObservableList list = root.getChildren();
      list.add(text);


      Line line = new Line();
      line.setStartX(100.0);
      line.setStartY(150.0);
      line.setEndX(500.0);
      line.setEndY(150.0);
      //Group root = new Group(line);



      //Group root = new Group();
      Scene scene = new Scene(root,600, 300);
      //scene.setFill(Color.BLACK);
      primaryStage.setTitle("Sample Application");

      primaryStage.setScene(scene);
      primaryStage.show();


   }

   public static void main(String args[]){           
      launch(args);      
   } 
} 