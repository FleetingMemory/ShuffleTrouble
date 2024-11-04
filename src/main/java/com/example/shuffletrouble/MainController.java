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
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.Pair;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ImageView shuffle;

    @FXML
    private ImageView trouble;

    //Function to direct player to game screen
    public void switchToPlayerScreen(ActionEvent event){
        try{


            //==========================================================================================

            //Game data variables
            Pair<String , Integer> p1= new Pair<>("Roy" , 1200);
            ArrayList<Pair<String , Integer>> leaderBoard = new ArrayList<>();
            leaderBoard.add(p1);

            //==========================================================================================
//            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("PlayerScene.fxml")));

            FXMLLoader loader = new FXMLLoader(getClass().getResource("PlayerScene.fxml"));
            root = loader.load();

            PlayerController playerController = loader.getController();
            playerController.manageLeaderboard(leaderBoard);

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    //=====================================================================================================
    //Title card animation
    //=====================================================================================================
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        TranslateTransition translate1 = new TranslateTransition();
        translate1.setNode(shuffle);
        translate1.setDuration(Duration.millis(1000));
        translate1.setByX(670);
        translate1.play();

        TranslateTransition translate2 = new TranslateTransition();
        translate2.setNode(trouble);
        translate2.setDuration(Duration.millis(1000));
        translate2.setByX(-250);
        translate2.setByY(70);
        translate2.play();

    }



















    //Exit game controller code
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
