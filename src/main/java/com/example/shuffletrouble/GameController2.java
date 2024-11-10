package com.example.shuffletrouble;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GameController2 implements Initializable {
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
    private TextField inputField4;  // For Card 4 input

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

    public ArrayList<String> ques = new ArrayList<>();

    public void setQuestionCards(ArrayList<String> q){
        ques = q;
    }

    public void submit(ActionEvent event) {
        // Get the values entered in the text fields


        String card1input = inputField1.getText();
        String card2input = inputField2.getText();
        String card3input = inputField3.getText();
        String card4input = inputField4.getText();


        // Validate each input
        if (!isValidCard(card1input)) {
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


        // If all inputs are valid, proceed with your game logic
        // You can perform any action here, e.g., updating game state, changing scene, etc.
        System.out.println("All cards are valid. Proceeding with the game...");
        System.out.println("ques in game 2->"+ques);

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ScoreScene.fxml"));
            Parent root = loader.load();

            ArrayList<String> answerCards = new ArrayList<>();
            answerCards.add(card1input+".jpg");
            answerCards.add(card2input+".jpg");
            answerCards.add(card3input+".jpg");
            answerCards.add(card4input+".jpg");

            ScoreCal scoreCal = loader.getController();
            scoreCal.setAnswerCards(answerCards);


//            ArrayList<String> qq = new ArrayList<>();
//            answerCards.add(ques.get(0));
//            answerCards.add(ques.get(1));
//            answerCards.add(ques.get(2));
//            answerCards.add(ques.get(3));

            System.out.println("to score"+ques);


            scoreCal.scoreController(answerCards , ques);


            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene((new Scene(root)));
            stage.show();


        } catch (Exception e) {
            e.printStackTrace();
        }




    }


    // Utility method to show an error message
    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Wrong input");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
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
