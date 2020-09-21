package com.SDI.SistemaDeInventario.DAO;

import com.SDI.SistemaDeInventario.ConnectionManager;
import com.SDI.SistemaDeInventario.DTO.Empleados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//1=true, 0=false

public class vendedorDAO {
    private Connection connection = null;

    public vendedorDAO() throws SQLException {
        connection = ConnectionManager.obtenerConexion();
    }


    public void insertarVendedor(Empleados v) throws SQLException {
        String sql = " insert into EMPLEADOS_SDI(usuario, nombre, apellido, correo, contrasenha, esAdmin) " +
                " values (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, v.getUsuario());
        ps.setString(2, v.getNombre());
        ps.setString(3, v.getApellido());
        ps.setString(4, v.getCorreo());
        ps.setString(5, v.getContrasenha());
        ps.setInt(6, v.getEsAdmin());
        ps.executeUpdate();
    }

    public void borrarVendedorPorUsuario(String usuario) throws SQLException {

    String sql = " delete from EMPLEADOS_SDI " +
            " where usuario=? and esAdmin=0 ";
    PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,usuario);
        ps.executeUpdate();
}

    public void editarVendedorPorUsuario(String usuario, Empleados v) throws SQLException {
        String sql = " Update EMPLEADOS_SDI " +
                " set usuario=?, nombre=?, apellido=?, correo=?, contrasenha=? " +
                " where usuario=? and esAdmin=0 ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, v.getUsuario());
        ps.setString(2, v.getNombre());
        ps.setString(3, v.getApellido());
        ps.setString(4, v.getCorreo());
        ps.setString(5, v.getContrasenha());
        ps.setString(6, usuario);
        ps.executeUpdate();
    }

    public List<Empleados> obtenerVendedores() throws SQLException {
        String sql = "SELECT * FROM EMPLEADOS_SDI WHERE esAdmin=0";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Empleados> administradores = new ArrayList<>();
        Empleados temp = null;
        while (rs.next()) {
            temp = new Empleados(rs.getString("usuario"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("correo"),
                    rs.getString("contrasenha"),
                    rs.getInt("esAdmin"));

            administradores.add(temp);
        }
        return administradores;
    }
}
