package com.example.shuffletrouble;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
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
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    @FXML
    private ImageView shuffle;
    @FXML
    private ImageView trouble;




    //==============================================================================
    //GAME COMPONENTS VARIABLES
    //==============================================================================

    @FXML
    private Label remember;

    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;


    @FXML
    private GridPane easyGrid;

    @FXML
    private GridPane medGrid;
    @FXML
    private GridPane hardGrid1;
    @FXML
    private GridPane hardGrid2;

    @FXML
    private Rectangle rectangle;

    @FXML
    private ImageView escard1;
    @FXML
    private ImageView escard2;
    @FXML
    private ImageView escard3;

    @FXML
    private ImageView escard4;

    @FXML
    private ImageView medcard1;

    @FXML
    private ImageView medcard2;

    @FXML
    private ImageView medcard3;

    @FXML
    private ImageView medcard4;

    @FXML
    private ImageView medcard5;

    @FXML
    private ImageView medcard6;

    @FXML
    private ImageView hardcard1;

    @FXML
    private ImageView hardcard2;

    @FXML
    private ImageView hardcard3;

    @FXML
    private ImageView hardcard4;

    @FXML
    private ImageView hardcard5;

    @FXML
    private ImageView hardcard6;
    @FXML
    private ImageView hardcard7;

    @FXML
    private ImageView hardcard8;


    @FXML
    private Label timeCounter;


    @FXML
    private Button startButton;

    //==============================================================================
    //GAME COMPONENTS VARIABLES
    //==============================================================================


    public String level;
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
                                
                            }
                        }
                    )
    );


    public ArrayList<String> easyLoad(ArrayList<String> cards){
        int cnt = 1;
        medGrid.setScaleX(0);
        medGrid.setScaleY(0);
        hardcard1.setScaleX(0);
        ArrayList<String> ansCards = new ArrayList<>();
//        easyGrid.setScaleX(1000);
//        easyGrid.setScaleY(300);

        for (int i = 0 ; i < 4; i++){
            int min = 0;
            int max = 3;
            int range = max - min + 1;
            int idx = (int) (Math.random() * range) + min;
            ansCards.add(cards.get(idx));
            Image img = new Image(cards.get(idx));
            if(cnt == 1){
                escard1.setImage(img);
                cnt++;
            }
            else if(cnt == 2){
                escard2.setImage(img);
                cnt++;
            }
            else if(cnt == 3){
                escard3.setImage(img);
                cnt++;
            }
            else if(cnt == 4){
                escard4.setImage(img);
                cnt++;
            }
        }

        return ansCards;
    }

    public ArrayList<String> medLoad(ArrayList<String> cards){
        int cnt = 1;
        easyGrid.setScaleX(0);
        easyGrid.setScaleY(0);
        hardGrid1.setScaleX(0);
        hardGrid2.setScaleX(0);
        ArrayList<String> ansCards = new ArrayList<>();
//        easyGrid.setScaleX(1000);
//        easyGrid.setScaleY(300);

        for (int i = 0 ; i < 6; i++){
            int min = 0;
            int max = 3;
            int range = max - min + 1;
            int idx = (int) (Math.random() * range) + min;
            ansCards.add(cards.get(idx));
            Image img = new Image(cards.get(idx));
            if(cnt == 1){
                medcard1.setImage(img);
                cnt++;
            }
            else if(cnt == 2){
                medcard2.setImage(img);
                cnt++;
            }
            else if(cnt == 3){
                medcard3.setImage(img);
                cnt++;
            }
            else if(cnt == 4){
                medcard4.setImage(img);
                cnt++;
            }
            else if(cnt == 5){
                medcard5.setImage(img);
                cnt++;
            }
            else if(cnt == 6){
                medcard6.setImage(img);
                cnt++;
            }
        }

        return ansCards;
    }

    public ArrayList<String> hardLoad(ArrayList<String> cards){
        int cnt = 1;
        easyGrid.setScaleX(0);
        easyGrid.setScaleY(0);
        medGrid.setScaleX(0);
        ArrayList<String> ansCards = new ArrayList<>();
//        easyGrid.setScaleX(1000);
//        easyGrid.setScaleY(300);

        for (int i = 0 ; i < 8; i++){
            int min = 0;
            int max = 3;
            int range = max - min + 1;
            int idx = (int) (Math.random() * range) + min;
            ansCards.add(cards.get(idx));
            Image img = new Image(cards.get(idx));
            if(cnt == 1){
                hardcard1.setImage(img);
                cnt++;
            }
            else if(cnt == 2){
                hardcard2.setImage(img);
                cnt++;
            }
            else if(cnt == 3){
                hardcard3.setImage(img);
                cnt++;
            }
            else if(cnt == 4){
                hardcard4.setImage(img);
                cnt++;
            }
            else if(cnt == 5){
                hardcard5.setImage(img);
                cnt++;
            }
            else if(cnt == 6){
                hardcard6.setImage(img);
                cnt++;
            }
            else if(cnt == 7){
                hardcard7.setImage(img);
                cnt++;
            }
            else if(cnt == 8){
                hardcard8.setImage(img);
                cnt++;
            }
        }

        return ansCards;
    }

    public void setLevel(String curLevel){
        level = curLevel;
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



        timeCounter.setText("Readdyyyy?");
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        startButton.setOpacity(0);

//        easyGrid.setScaleZ(-1);
//        easyGrid.setScaleX(0);
//        easyGrid.setScaleY(0);


        //Setting of images in game
        ArrayList<String> cards = new ArrayList<>();
        cards.add("ace.jpg");
        cards.add("king.jpg");
        cards.add("queen.jpg");
        cards.add("joker.jpg");
        int cnt = 1;


        //RANDOMLY GENERATE CARDS FOR GAME

        System.out.print(level);

        if(level == "easy") {
            ArrayList<String> ansCards = easyLoad(cards);
        }

        else if(level == "medium"){
            ArrayList<String> ansCards = medLoad(cards);
        }
        else{
            ArrayList<String> ansCards = hardLoad(cards);
        }




        //FOR REMEMBERING CARDS TO THE NEXT SCENE
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

    @FXML
    Label namelabel;
    public void setToscoreScene(String username){
        namelabel.setText(username);
    }



}
