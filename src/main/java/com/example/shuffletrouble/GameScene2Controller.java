package com.example.shuffletrouble;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

import javax.swing.*;

public class GameScene2Controller {
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

    // Utility method to show an error message
    private void showError(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Input Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
