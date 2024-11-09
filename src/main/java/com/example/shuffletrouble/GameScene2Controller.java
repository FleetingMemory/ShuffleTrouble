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

public class GameScene2Controller  implements Initializable {

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

    // Submit method to check if the entered values are correct
    public void submit(ActionEvent event) {
        // Get the values entered in the text fields


        String card1input = inputField1.getText().toString();
        String card2input = inputField2.getText().toString();
        String card3input = inputField3.getText().toString();
        String card4input = inputField4.getText().toString();


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

        // If all inputs are valid, proceed with your game logic
        // You can perform any action here, e.g., updating game state, changing scene, etc.
        System.out.println("All cards are valid. Proceeding with the game...");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ScoreScene.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene((new Scene(root)));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public void values(ArrayList<String> arr){
//        System.out.print("hi");
//        System.out.print(arr);
//    }

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

    public void switchToScoreScene (ActionEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("ScoreScene.fxml"));
            root = loader.load();
//            ScoreSceneController scoreController = loader.getController();
//            scoreController.setCards(card1, card2, card3, card4);

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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






