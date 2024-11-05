package com.example.shuffletrouble;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import javafx.util.Pair;
import com.example.shuffletrouble.Timer;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    @FXML
    private Button startButton;
    @FXML
    private Label timeCounter;

    Timer timer = new Timer(6);

    Timeline timeline = new Timeline(
            new KeyFrame(Duration.seconds(0.7) ,
                        e -> {
                                timer.onSecondPassed();

                                timeCounter.setText(timer.getSeconds());

                            if(Integer.parseInt(timer.getSeconds()) == 0) {
                                System.out.print("fin");
                            }
                        }
                    )
    );

    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timeCounter.setText("");
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();


    }
}
