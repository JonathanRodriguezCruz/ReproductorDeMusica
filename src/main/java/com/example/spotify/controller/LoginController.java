package com.example.spotify.controller;

import com.example.spotify.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Calse LoginController
 */
public class LoginController implements Initializable {

    @FXML
    public TextField emailTxt;
    @FXML
    public PasswordField passwTxt;
    @FXML
    public Button loginBtn;
    @FXML
    public Button signUpBtn;
    User users = new User();
    UserConexion users_sql = new UserConexion();
    UserConexion userConexion;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Conexion.initConnection();
        userConexion = new UserConexion();
    }

    // Logea a un user ya registrado
    public void login(ActionEvent actionEvent) throws IOException {
        if (userConexion.validLogin(emailTxt.getText(),passwTxt.getText())) {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Reproductor");
            stage.setScene(scene);
            stage.show();

            // Cierra la pestaña de inicio de sesion al darle al boton de login
            Stage login = (Stage) loginBtn.getScene().getWindow();
            login.close();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Correo o contraseña erroneos.");
            alert.showAndWait();
        }


    }

    // Registra a un user nuevo
    public void singUp(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("signUp-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Inicio de Sesión");
        stage.setScene(scene);
        stage.show();
    }
}
