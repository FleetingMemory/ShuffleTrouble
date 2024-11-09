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
import java.net.URL;
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

    public String username = " ";

//    public void getPlayerName(String playerName){
//        username =  playerName;
//        public void getPlayerName(String userName){
//            username =  userName;
//            System.out.print(username);
//        }

        // Function to direct player to Main screen
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