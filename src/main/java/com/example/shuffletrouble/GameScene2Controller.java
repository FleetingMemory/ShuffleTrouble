package com.example.shuffletrouble;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameScene2Controller {


    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;

    @FXML
    private TextField inputField1;

    @FXML
    private TextField inputField2;

    @FXML
    private TextField inputField3;

    @FXML
    private TextField inputField4;


    @FXML
//    private ListView<String> cardListView; // ListView to display the entered cards

    // Define a list of valid card names (you can add more cards as needed)
    private final String[] validCards = {"ace", "king", "queen", "joker"};

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
    public void submitHandler(ActionEvent event) throws IOException {
        // Get the values entered in the text fields
        String card1input = inputField1.getText();
        String card2input = inputField2.getText();
        String card3input = inputField3.getText();
        String card4input = inputField4.getText();

        // Validate each input
        if (!isValidCard(card1input)) {
            showError("Invalid card name for Card 1.");
            System.out.println(card1input);
            return; // Stop further processing if validation fails
        }
        if (!isValidCard(card2input)) {
            showError("Invalid card name for Card 2.");
            System.out.println(card2input);
            return;
        }
        if (!isValidCard(card3input)) {
            showError("Invalid card name for Card 3.");
            System.out.println(card3input);
            return;
        }
        if (!isValidCard(card4input)) {
            showError("Invalid card name for Card 4.");
            System.out.println(card4input);
            return;
        }

        System.out.println("All cards are valid. Proceeding with the game...");

        // Add valid card names to the ListView
//        cardListView.getItems().clear();
//        cardListView.getItems().addAll(card1input, card2input, card3input, card4input);

        // Switch to the score scene
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ScoreScene.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showError(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Not a card name");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
