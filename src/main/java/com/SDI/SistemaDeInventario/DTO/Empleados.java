package com.SDI.SistemaDeInventario.DTO;

import java.util.Objects;

public class Empleados {
    private String usuario;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasenha;
    private int esAdmin;

    public Empleados()
    {
        super();
    }

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

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    public int getEsAdmin() {
        return esAdmin;
    }

    public void setEsAdmin(int esAdmin) {
        this.esAdmin = esAdmin;
    }

    @Override
    public String toString() {
        return "Empleados{" +
                "usuario='" + usuario + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correo='" + correo + '\'' +
                ", contrasenha='" + contrasenha + '\'' +
                ", esAdmin=" + esAdmin +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Empleados)) return false;
        Empleados empleados = (Empleados) o;
        return esAdmin == empleados.esAdmin &&
                Objects.equals(usuario, empleados.usuario) &&
                Objects.equals(nombre, empleados.nombre) &&
                Objects.equals(apellido, empleados.apellido) &&
                Objects.equals(correo, empleados.correo) &&
                Objects.equals(contrasenha, empleados.contrasenha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario, nombre, apellido, correo, contrasenha, esAdmin);
    }
}
