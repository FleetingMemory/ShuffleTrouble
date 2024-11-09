package com.example.shuffletrouble;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ScoreController  implements Initializable {

    @FXML
    private ImageView shuffle;
    @FXML
    private ImageView trouble;

    public String username = " ";
    ArrayList<String> questionCards;

    public void getPlayerName(String playerName){
        username =  playerName;
        System.out.print(username);
    }

    public void setQuestionCards(ArrayList<String> ques){
        questionCards = ques;
        System.out.print("ques->" + questionCards);
    }

    public void setAnswerCards(ArrayList<String> ans){
//        questionCards = ques;
//        System.out.print("ques->" + questionCards);
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
