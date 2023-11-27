module com.example.spoitfy {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    exports com.example.spotify;
    opens com.example.spotify.controller to javafx.fxml;
}