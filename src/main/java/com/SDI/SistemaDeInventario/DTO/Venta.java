package com.SDI.SistemaDeInventario.DTO;

import java.sql.Date;
import java.sql.Timestamp;

public class Venta {

    private int idVenta;
    private String idVendedor;
    private Timestamp fechaHora;
    private String formaDePago;
    private int total;

    public Venta(int idVenta, String idVendedor, Timestamp fechaHora, String formaDePago, int total) {
        this.idVenta = idVenta;
        this.idVendedor = idVendedor;
        this.fechaHora = fechaHora;
        this.formaDePago = formaDePago;
        this.total = total;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(String idVendedor) {
        this.idVendedor = idVendedor;
    }

    public Timestamp getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Timestamp fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(String formaDePago) {
        this.formaDePago = formaDePago;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "idVenta=" + idVenta +
                ", idVendedor='" + idVendedor + '\'' +
                ", fechaHora=" + fechaHora +
                ", formaDePago='" + formaDePago + '\'' +
                ", total=" + total +
                '}';
    }
}
