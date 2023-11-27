package com.example.spotify.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    public Pane panelPlaylists;
    @FXML
    public Pane panelSongs;
    @FXML
    public Label playlistLink;
    @FXML
    public ListView playlistList;
    @FXML
    public ListView songsList;
    @FXML
    public ImageView playImg;
    @FXML
    public ImageView pauseImg;
    @FXML
    public ProgressBar musicTime;
    PlaylistConexion playlistConexion;
    User user;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Conexion.initConnection();
        playlistConexion = new PlaylistConexion();
        user = new User();
        playImg.setVisible(true);
        pauseImg.setVisible(false);
        musicTime = new ProgressBar(0);
    }

    // Elimina una playlist
    public void deletePlaylist(MouseEvent mouseEvent) throws SQLException {
        playlistConexion.eliminarContacto(playlistList);
    }

    // Crea playlist nuevas
    public void addPlaylist(MouseEvent mouseEvent) {
        playlistConexion.createPlaylist(user.getName(),"Miau");
    }

    // Al pulsar el icono te lleva al home de la app
    public void goHome(MouseEvent mouseEvent) {
        // TODO regresa al user al home
    }

    // Muestra la lista de playlists
    public void showPlaylist(MouseEvent mouseEvent) {
        panelSongs.setVisible(false);
        panelPlaylists.setVisible(true);
    }

    // Muestra la lista de canciones
    public void showSongs(MouseEvent mouseEvent) {
        panelSongs.setVisible(true);
        panelPlaylists.setVisible(false);
    }

    // Muestra tanto las playlist como las canciones
    public void showAll(MouseEvent mouseEvent) {
        panelSongs.setVisible(true);
        panelPlaylists.setVisible(true);
    }

    // Reproduce la musica
    public void playMusic(MouseEvent mouseEvent) {
        playImg.setVisible(false);
        pauseImg.setVisible(true);

    }

    // Pausa la musica
    public void pauseMusic(MouseEvent mouseEvent) {
        playImg.setVisible(true);
        pauseImg.setVisible(false);
    }
}
