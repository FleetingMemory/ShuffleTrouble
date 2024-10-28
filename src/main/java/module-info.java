module com.example.shuffletrouble {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.shuffletrouble to javafx.fxml;
    exports com.example.shuffletrouble;
}