package com.example.shuffletrouble;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ScoreController  implements Initializable {

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

    public String username = " ";


        ArrayList<String> quesCards;
        ArrayList<String> answerCards;

        public void setQuestionCards(ArrayList<String> ques){
            quesCards = ques;
            System.out.print(quesCards);
        }

        public void setAnswerCards(ArrayList<String> ans){
            answerCards = ans;
            System.out.print(answerCards);

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

        public int scoreController(ArrayList<String> answerCards, ArrayList<String> quesCards){
            int score = 0;
            for (int i = 0; i < 4; i++){
                if(answerCards.get(i) == answerCards.get(i)){
                    score += 10;
                }
                else if(answerCards.get(i) != answerCards.get(i)){
                    score -= 2;
                }
            }


            return score;

        }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        int sc = scoreController(quesCards , answerCards);
        String s = Integer.toString(sc);
        score.setText(s);

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