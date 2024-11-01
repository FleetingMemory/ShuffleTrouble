package com.example.shuffletrouble;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainController {

    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;

    @FXML
    private AnchorPane anchorPane;



    //Function to direct player to game screen
    public void switchToGameScreen(ActionEvent event){
        try{
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("GameScene.fxml")));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public void exitGame(ActionEvent event){
        stage = (Stage) anchorPane.getScene().getWindow();
        System.out.print("exiting");
        Alert alert= new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("Do you want to exit");

        if(alert.showAndWait().get() == ButtonType.OK){
            stage.close();
        }
    }

}
