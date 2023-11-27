package com.example.spotify.controller;

import javafx.scene.control.ListView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaylistConexion {
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    Connection conexion;

    public PlaylistConexion() {
        conexion = Conexion.getConnection();
    }

    // Borra una playlist dado su nombre y el userName
    public void deletePlaylist(String name,String userName) {
        if (conexion != null) {
            String sql = "delete from personalList where userName = ? and playListName = ?";
            try {
                preparedStatement = conexion.prepareStatement(sql);
                preparedStatement.setString(1,userName);
                preparedStatement.setString(2,name);
                resultSet = preparedStatement.executeQuery();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //
    public boolean createPlaylist(String userName,String name) {
        if (conexion != null) {
            String sql = "insert into personalList(userName,playListName) values(?,?)";
            try {
                preparedStatement = conexion.prepareStatement(sql);
                preparedStatement.setString(1,userName);
                preparedStatement.setString(2,name);
                preparedStatement.execute();
            } catch (SQLException e) {
                return false;
            }
            return true;
        }
        return false;
    }

    public void eliminarContacto(ListView visor) throws SQLException{


        int fila = visor.getSelectionModel().getSelectedIndex();
        String valor = visor.getParent().toString();
        PreparedStatement ps = conexion.prepareStatement("delete from personalList where idList ='" + valor + "'");

        ps.executeUpdate();
        ps.close();
    }
}
