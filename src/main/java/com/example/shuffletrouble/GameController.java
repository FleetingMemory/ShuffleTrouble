package com.example.shuffletrouble;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

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
    @FXML
    ImageView card2;
    @FXML
    ImageView card3;
    @FXML
    ImageView card4;


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

                                //REMOVING REMEMBER TEXT
                                remember.setScaleX(0);
                                remember.setScaleY(0);
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
        startButton.setOpacity(0);



        //Setting of images in game
        ArrayList<String> cards = new ArrayList<>();
        cards.add("ace.jpg");
        cards.add("king.jpg");
        cards.add("queen.jpg");
        cards.add("joker.jpg");
        int cnt = 1;


        ArrayList<String> ansCards = new ArrayList<>();

        //RANDOMLY GENERATE CARDS FOR GAME
        for (int i = 0 ; i < 4; i++){
            int min = 0;
            int max = 3;
            int range = max - min + 1;
            int idx = (int) (Math.random() * range) + min;
            ansCards.add(cards.get(idx));
            Image img = new Image(cards.get(idx));
            if(cnt == 1){
                card1.setImage(img);
                cnt++;
            }
            else if(cnt == 2){
                card2.setImage(img);
                cnt++;
            }
            else if(cnt == 3){
                card3.setImage(img);
                cnt++;
            }
            else if(cnt == 4){
                card4.setImage(img);
                cnt++;
            }
        }
        GameScene2Controller gameScene2Controller = new GameScene2Controller();
//        gameScene2Controller.rememberCards(ansCards);

    }

    public void switchToGameScene2(ActionEvent event){
        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("GameScene2.fxml"));
            root = loader.load();

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    Label nameLabel;
    public void disName(String EnterName){
        nameLabel.setText(EnterName);
    }




}
