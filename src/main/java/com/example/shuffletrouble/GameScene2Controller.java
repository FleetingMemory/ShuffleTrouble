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

    private TextField inputField1;  // For Card 1 input
    private TextField inputField2;  // For Card 2 input
    private TextField inputField3;  // For Card 3 input
    private TextField inputField4;  // For Card 4 input

    // Define a list of valid card names (you can add more cards as needed)
    private String[] validCards = {"Ace", "King", "Queen", "Joker"};

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
        String card1input = inputField1.getText();
        String card2input = inputField2.getText();
        String card3input = inputField3.getText();
        String card4input = inputField4.getText();

        // Validate each input
        if (!isValidCard(card1input)) {
            showError("Invalid card name for Card 1.");
            return; // Stop further processing if validation fails
        }
        if (!isValidCard(card2input)) {
            showError("Invalid card name for Card 2.");
            return;
        }
        if (!isValidCard(card3input)) {
            showError("Invalid card name for Card 3.");
            return;
        }
        if (!isValidCard(card4input)) {
            showError("Invalid card name for Card 4.");
            return;
        }

        // If all inputs are valid, proceed with your game logic
        // You can perform any action here, e.g., updating game state, changing scene, etc.
        System.out.println("All cards are valid. Proceeding with the game...");

    }

    public void values(ArrayList<String> arr){
        System.out.print("hi");
        System.out.print(arr);
    }

    // Utility method to show an error message
    private void showError(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Input Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }




    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToScoreScene (ActionEvent event){
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("ScoreScene.fxml"));
            root = loader.load();
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

