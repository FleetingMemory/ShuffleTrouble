package com.example.shuffletrouble;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.IOException;
import java.util.ArrayList;

public class PlayerScene extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void manageLeaderboard(ArrayList<Pair<String , Integer>> leaderboard){
        System.out.print(leaderboard);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {


    }
}

