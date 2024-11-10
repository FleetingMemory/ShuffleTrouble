package com.example.shuffletrouble;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ScoreCal {

    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    private ImageView shuffle;
    @FXML
    private ImageView trouble;
    @FXML
    private Label playerName;
    @FXML
    private Label score;
    @FXML

    public String username = " ";


    ArrayList<String> quesCards;
    ArrayList<String> answerCards;

    public void setQuestionCards() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GameScene.fxml"));
        root = loader.load();
        GameController gameController = loader.getController();
        quesCards = gameController.returnQuestionCards();
    }

    public void setAnswerCards(ArrayList<String> ans){
        answerCards = ans;
        System.out.print("ans->" + answerCards);

    }
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
    // Function to direct player to player screen
    public void switchToPlayerScene(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PlayerScene.fxml"));
            root = loader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int scoreController(ArrayList<String> answerCards) throws IOException {
        int score = 0;
        setQuestionCards();
        for (int i = 0; i < 4; i++){
            if(quesCards.get(i) == answerCards.get(i)){
                score += 10;
            }
            else if(quesCards.get(i) != answerCards.get(i)){
                score -= 2;
            }
        }


        return score;

    }
}
