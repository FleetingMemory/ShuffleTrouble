package com.example.shuffletrouble;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

import static javafx.application.ConditionalFeature.FXML;

public class PlayerController {

    public void manageLeaderboard(ArrayList<Pair<String, Integer>> leaderboard) {
        System.out.print(leaderboard);
    }

    @FXML
    TextField nameTextFeild;

    private Stage stage;
    private Scene scene;
     private Parent root;


//
//    public void gameScene(ActionEvent event ) throws IOException {
//        String EnterName =  nameTextFeild.getText();
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("GameScene.fxml"));
//        root = loader.load();
//        PlayerController playerController = loader.getController();
//        playerController.disName(EnterName);
//        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//
//
//    }
//
//    private void disName(String enterName) {
//    }


    //Function to direct player to game screen
    public void switchToGameScreen(ActionEvent event) {
        try {


            FXMLLoader loader = new FXMLLoader(getClass().getResource("GameScene.fxml"));


            root = loader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }




    }
        

        public void switchToMain (ActionEvent event){
            try {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
                root = loader.load();
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();


            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

