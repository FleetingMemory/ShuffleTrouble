package com.example.shuffletrouble;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.IOException;
import java.util.ArrayList;

import static javafx.application.ConditionalFeature.FXML;

public class PlayerController {

    public void manageLeaderboard(ArrayList<Pair<String , Integer>> leaderboard){
        System.out.print(leaderboard);
    }
    private Stage stage;
    private Scene scene;
    private Parent root;

    //Function to direct player to game screen
    public void switchToGameScreen(ActionEvent event){
        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("GameScene.fxml"));
            root = loader.load();
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
