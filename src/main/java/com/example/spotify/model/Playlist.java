package com.example.spotify.model;

public class Playlist {
    private int idList;
    private String name;
    private String userName;
    private int numSongs;
    private double duracion;

    public Playlist(String name, String userName) {
        this.name = name;
        this.userName = userName;
        this.numSongs = 0;
        this.duracion = 0;
    }

    // Getters & Setters
    public int getIdList() {
        return idList;
    }
    public void setIdList(int idList) {
        this.idList = idList;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public int getNumSongs() {
        return numSongs;
    }
    public void setNumSongs(int numSongs) {
        this.numSongs = numSongs;
    }
    public double getDuracion() {
        return duracion;
    }
    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }


}
