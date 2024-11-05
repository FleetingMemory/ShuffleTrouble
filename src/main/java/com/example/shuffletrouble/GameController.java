package com.example.shuffletrouble;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.util.Pair;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    @FXML
    private ListView<Pair<Integer , ImageView>> myListView;

    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}
