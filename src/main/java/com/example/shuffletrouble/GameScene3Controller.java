package com.example.shuffletrouble;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GameScene3Controller  {

    @FXML
    private ImageView shuffle;
    @FXML
    private ImageView trouble;

    @FXML
    private TextField inputField1;  // For Card 1 input
    @FXML
    private TextField inputField2;  // For Card 2 input
    @FXML
    private TextField inputField3;  // For Card 3 input
    @FXML
    private TextField inputField4;// For Card 4 input
    @FXML
    private TextField inputField5;
    @FXML
    private TextField inputField6;

    public ArrayList<String> qu;


    // Define a list of valid card names (you can add more cards as needed)
    private String[] validCards = {"ace", "king", "queen", "joker","two","six","seven","nine"};

    // Validation method to check if the entered card is valid
    private boolean isValidCard(String cardName) {
        for (String validCard : validCards) {
            if (validCard.equalsIgnoreCase(cardName)) {
                return true;
            }
        }
        return false;
    }

    public void setQuestionCards(ArrayList<String> ques) {
        qu = ques;
        System.out.println(qu);
    }

    // Submit method to check if the entered values are correct
    public void submit(ActionEvent event) {
        // Get the values entered in the text fields


        String card1input = inputField1.getText().toString();
        String card2input = inputField2.getText().toString();
        String card3input = inputField3.getText().toString();
        String card4input = inputField4.getText().toString();
        String card5input = inputField5.getText().toString();
        String card6input = inputField6.getText().toString();


        // Validate each input
        if (!isValidCard(card1input) ) {
            showError("This not for card 1.");
            System.out.println(card1input);
            return; // Stop further processing if validation fails
        }
        if (!isValidCard(card2input)) {
            showError("This is not for card 2.");
            System.out.println(card2input);
            return;

        }
        if (!isValidCard(card3input)) {
            showError("This is not for card 3.");
            System.out.println(card3input);
            return;
        }
        if (!isValidCard(card4input)) {
            showError("This is not for card 4.");
            System.out.println(card4input);
            return;
        }
        if (!isValidCard(card5input)) {
            showError("This is not for card 5.");
            System.out.println(card4input);
            return;
        }
        if (!isValidCard(card6input)) {
            showError("This is not for card 6.");
            System.out.println(card4input);
            return;
        }





        // If all inputs are valid, proceed with your game logic
        // You can perform any action here, e.g., updating game state, changing scene, etc.
        System.out.println("All cards are valid. Proceeding with the game...");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ScoreScene.fxml"));
            Parent root = loader.load();

            ArrayList<String> answerCards = new ArrayList<>();
            answerCards.add(card1input+".jpg");
            answerCards.add(card2input+".jpg");
            answerCards.add(card3input+".jpg");
            answerCards.add(card4input+".jpg");
            answerCards.add(card5input+".jpg");
            answerCards.add(card6input+".jpg");

            ScoreCal scoreCal = loader.getController();
            scoreCal.setAnswerCards(answerCards);
            ArrayList<String> ques = new ArrayList<>();
            ques.add(qu.get(0));
            ques.add(qu.get(1));
            ques.add(qu.get(2));
            ques.add(qu.get(3));
            ques.add(qu.get(4));
            ques.add(qu.get(5));

//            scoreCal.setQuestionCards(ques);


            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene((new Scene(root)));
            stage.show();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Utility method to show an error message
    private void showError(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Wrong input");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }




    private Stage stage;
    private Scene scene;
    private Parent root;


//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        //translate for shuffle
//        TranslateTransition translate1 = new TranslateTransition();
//        translate1.setNode(shuffle);
//        translate1.setDuration(Duration.millis(300));
//        translate1.setCycleCount(TranslateTransition.INDEFINITE);
//        translate1.setByX(5);
//        translate1.setAutoReverse(true);
//        translate1.play();
//
//        //translate for trouble
//        TranslateTransition translate2= new TranslateTransition();
//        translate2.setNode(trouble);
//        translate2.setDuration(Duration.millis(300));
//        translate2.setCycleCount(TranslateTransition.INDEFINITE);
//        translate2.setByY(5);
//        translate2.setAutoReverse(true);
//        translate2.play();
//
//
//    }

}






