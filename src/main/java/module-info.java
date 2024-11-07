module com.example.shuffletrouble {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.shuffletrouble to javafx.fxml;
    exports com.example.shuffletrouble;
}