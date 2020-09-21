package com.SDI.SistemaDeInventario.DTO;

public class Validador {
    private String usuario;
    private String contrasenha;
    private int esAdmin;

    public Validador(String usuario, String contrasenha, int esAdmin) {
        this.usuario = usuario;
        this.contrasenha = contrasenha;
        this.esAdmin = esAdmin;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
        return "Validador{" +
                "usuario='" + usuario + '\'' +
                ", contrasenha='" + contrasenha + '\'' +
                ", esAdmin=" + esAdmin +
                '}';
    }

}
