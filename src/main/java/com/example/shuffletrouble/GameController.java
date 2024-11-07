package com.example.shuffletrouble;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.Pair;
import com.example.shuffletrouble.Timer;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    @FXML
    private Button startButton;
    @FXML
    private Label timeCounter;

    @FXML
    private Label remember;

    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    private Rectangle rectangle;

    @FXML
    ImageView card1;


    Timer timer = new Timer(6);

    Timeline timeline = new Timeline(
            new KeyFrame(Duration.seconds(1) ,
                        e -> {
                                timer.onSecondPassed();

                                timeCounter.setText(timer.getSeconds());

                            if(Integer.parseInt(timer.getSeconds()) == 0) {
                                System.out.print("fin");
                                rectangle.setOpacity(1);
                                startButton.setOpacity(1);
                                remember.setOpacity(0);
                                return;
                                
                            }
                        }
                    )
    );

    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timeCounter.setText("Readdyyyy?");
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        rectangle.setOpacity(0);
        startButton.setOpacity(0);


        System.out.print(card1.getId());
        


    }
}
