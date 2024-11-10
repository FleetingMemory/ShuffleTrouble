package com.example.shuffletrouble;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.Pair;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static javafx.application.ConditionalFeature.FXML;

public class PlayerController  implements  Initializable{


    @FXML
    private ImageView shuffle;
    @FXML
    private ImageView trouble;

    @FXML
    private TextField textInput;
    @FXML
    private Rectangle wrong;

    public void manageLeaderboard(ArrayList<Pair<String, Integer>> leaderboard) {
        System.out.print(leaderboard);
    }

    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;


    //LEVEL HANDLER
    @FXML
    private ChoiceBox<String> level;


    private String[] levels = {"easy" , "medium" , "hard"};


    public void validityCheck(ActionEvent event) {
        String username = textInput.getText();
        String selectedLevel = level.getValue();
        if (username.length() == 0 || username.length() > 20 || selectedLevel == null) {
            System.out.print("wrong");
            wrong.setOpacity(1);

        } else {

            switchToGameScreen(event , username);

        }
    }







    //Function to direct player to game screen
    public void switchToGameScreen(ActionEvent event , String username) {
        try {


            FXMLLoader loader = new FXMLLoader(getClass().getResource("GameScene.fxml"));


            root = loader.load();

            String choice = level.getValue().toLowerCase();

            GameController gameController = loader.getController();

            //Data transmitted to gamecontroller
            gameController.setLevel(choice);
            gameController.playerName(username);


            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

     // Function to direct player to Main screen
    public void switchToMain(ActionEvent event) {
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








        // Animation adding to Shuffle trouble
        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            level.getItems().addAll(levels);







            //translate for shuffle
            TranslateTransition translate1 = new TranslateTransition();
            translate1.setNode(shuffle);
            translate1.setDuration(Duration.millis(300));
            translate1.setCycleCount(TranslateTransition.INDEFINITE);
            translate1.setByX(5);
            translate1.setAutoReverse(true);
            translate1.play();

             //translate for trouble
            TranslateTransition translate2= new TranslateTransition();
            translate2.setNode(trouble);
            translate2.setDuration(Duration.millis(300));
            translate2.setCycleCount(TranslateTransition.INDEFINITE);
            translate2.setByY(5);
            translate2.setAutoReverse(true);
            translate2.play();

        }
    }






