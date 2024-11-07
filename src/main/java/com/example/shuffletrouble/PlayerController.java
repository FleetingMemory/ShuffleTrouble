package com.example.shuffletrouble;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

public class PlayerController {

    public void manageLeaderboard(ArrayList<Pair<String, Integer>> leaderboard) {
        System.out.print(leaderboard);
    }

    private Stage stage;
    private Scene scene;
    private Parent root;

    //Function to direct player to game screen
    public void switchToGameScreen(ActionEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("GameScene2.fxml"));
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

