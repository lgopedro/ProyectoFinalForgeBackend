package com.SDI.SistemaDeInventario.DAO;

public class PasswordGenerator {

    String rango = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    int largo = 6;


    public String generate() {
        String password="";
        for (int i = 0; i < largo; i++) {
            int rand = (int) Math.floor((Math.random()*(rango.length())));
            password += rango.charAt(rand);
        }
    return password;
    }
}