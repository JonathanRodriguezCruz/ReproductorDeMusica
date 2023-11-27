package com.example.spotify.controller;

import javafx.scene.control.Alert;

import java.sql.*;

public class UserConexion {

    static PreparedStatement preparedStatement;
    ResultSet resultSet;
    static Connection conexion;


    public UserConexion() {
        conexion= Conexion.getConnection();

    }

    // Comprueba si el usuario esta en la DB
    public User login(String email, String passw) {
        User userLogin = new User();
        String sql = "select * from Usuario where email = ? and password = ?";
        try {
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,passw);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                userLogin.setEmail(resultSet.getString("email"));
                userLogin.setPassword(resultSet.getString("password"));
                userLogin.setName(resultSet.getString("userName"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return userLogin;
    }

    // Valida los datos introducidos por el ususario al iniciar sesion
    public static boolean validLogin(String email, String passw) {
        boolean credencialesValidas = false;
        // Consulta SQL con PreparedStatement para evitar la inyección de SQL
        String sql = "select * from Usuario where email = ? and password = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, email);
            statement.setString(2, passw);

            try (ResultSet resultSet = statement.executeQuery()) {
                // Verificar si se encontraron resultados
                if (resultSet.next()) {
                    credencialesValidas = true;
                } else {
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return credencialesValidas;
    }

    // Regsitra al usuario en la DB
    public boolean sigUpUser(String name, String email, String passw) {
        if (conexion != null){
            String sql = "insert into Usuario(userName,email,password) values(?,?,?)";
            try {
                preparedStatement = conexion.prepareStatement(sql);
                preparedStatement.setString(1,name);
                preparedStatement.setString(2,email);
                preparedStatement.setString(3,passw);
                preparedStatement.execute();
            } catch (SQLException e) {
                return false;
            }
            return true;
        }
        return false;
    }



}
