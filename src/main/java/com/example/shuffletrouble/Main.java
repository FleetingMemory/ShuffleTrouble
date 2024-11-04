package com.example.shuffletrouble;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {


        //Initializtion of gamescreen
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Main.fxml")));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);


        //Setting up custom game icon
        Image icon = new Image("gameIcon.png");
        primaryStage.getIcons().add(icon);


        //On close application is clicked following code is executed
        primaryStage.setOnCloseRequest(windowEvent -> {
            windowEvent.consume();
            exitGame(primaryStage);
        });



        primaryStage.show();

    }


    //Function to handle close action
    public void exitGame(Stage stage){

        System.out.print("exiting");
        Alert alert= new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("Do you want to exit");

        if(alert.showAndWait().get() == ButtonType.OK){
            stage.close();
        }
    }
}
