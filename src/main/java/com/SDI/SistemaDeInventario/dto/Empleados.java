package com.SDI.SistemaDeInventario.dto;

public class Empleados {
    private String usuario;
    private String nombre;
    private String apellido;
    private String correo;
    private  String contrasenha;
    private int esAdmin;

    public Empleados(String usuario, String nombre, String apellido, String correo, String contrasenha, int esAdmin) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasenha = contrasenha;
        this.esAdmin = esAdmin;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public int isEsAdmin() {
        return esAdmin;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    public void setEsAdmin(int esAdmin) {
        this.esAdmin = esAdmin;
    }
}

