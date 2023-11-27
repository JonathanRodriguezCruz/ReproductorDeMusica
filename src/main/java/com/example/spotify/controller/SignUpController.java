package com.example.spotify.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Clase SignUp
 */
public class SignUpController implements Initializable {
    @FXML
    public TextField userNameTxt;
    @FXML
    public TextField userEmailTxt;
    @FXML
    public PasswordField passTxt;
    UserConexion userConexion;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Conexion.initConnection();
        userConexion = new UserConexion();
    }

    // Registra al user en la DB
    public void signUp(ActionEvent actionEvent) {
        userConexion.sigUpUser(userNameTxt.getText(),userEmailTxt.getText(),passTxt.getText());
    }

    public void cancel(ActionEvent actionEvent) {
        // TODO close the signUp window
    }
}
