package com.example;

import javafx.application.Application;
import javafx.scene.Group; 
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.text.Text; 
         
public class TextExample extends Application { 
   @Override 
   public void start(Stage stage) {       
      //Creating a Text object 
      Text text = new Text();

      text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
      //Setting the text to be added. 
      text.setText("Hello how are you?");
       
      //setting the position of the text 
      text.setX(50); 
      text.setY(50); 
         
      //Creating a Group object  
      Group root = new Group(text);   
               
      //Creating a scene object 
      Scene scene = new Scene(root, 600, 300);  
      
      //Setting title to the Stage 
      stage.setTitle("Sample Application"); 
         
      //Adding scene to the stage 
      stage.setScene(scene); 
         
      //Displaying the contents of the stage 
      stage.show(); 
   }      
   public static void main(String args[]){ 
      launch(args); 
   } 
} 