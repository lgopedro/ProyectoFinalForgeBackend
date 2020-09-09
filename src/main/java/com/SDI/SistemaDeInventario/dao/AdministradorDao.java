package com.SDI.SistemaDeInventario.dao;

import com.SDI.SistemaDeInventario.ConnectionManager;
import com.SDI.SistemaDeInventario.dto.Empleados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class AdministradorDao {
    private final Connection connection;

    public AdministradorDao() throws SQLException {
        connection = ConnectionManager.obtenerConexion();
    }

    public List<Empleados> obtenerAdministradorPorUsuario(String usuario) throws SQLException {
        String sql = " select * " +
                " from EMPLEADOS_SDI " +
                " where usuario=? and es_Admin=1";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, usuario);
        ResultSet rs = ps.executeQuery();
        List<Empleados> administradores = new LinkedList<>();
        while (rs.next()) {
            Empleados a = new Empleados(
                    rs.getString("usuario"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("correo"),
                    rs.getString("contrasenha"),
                    rs.getInt("es_Admin")
            );
            administradores.add(a);
        }
        return administradores;
    }
    public Empleados insertarAdministrador(Empleados a) throws SQLException {
        String sql = " insert into EMPLEADOS_SDI(usuario, nombre, apellido, correo, contrasenha, es_Admin) " +
                " values (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, a.getUsuario());
        ps.setString(2, a.getNombre());
        ps.setString(3, a.getApellido());
        ps.setString(4, a.getCorreo());
        ps.setString(5, a.getContrasenha());
        ps.setInt(6, a.isEsAdmin());
        ps.executeUpdate();
        return a;
    }
    public void borrarAdministradorPorUsuario(String usuario) throws SQLException {
        String sql = " delete from EMPLEADOS_SDI " +
                " where usuario=? and es_Admin=1 ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, usuario);
        ps.executeUpdate();

    }
    public Empleados editarAdministradorPorUsuario(Empleados a) throws SQLException {
        String sql = " Update EMPLEADOS_SDI " +
                " set usuario=?, nombre=?, apellido=?, correo=?, contrasenha=? " +
                " where usuario=? and es_Admin=1 ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, a.getUsuario());
        ps.setString(2, a.getNombre());
        ps.setString(3, a.getApellido());
        ps.setString(4, a.getCorreo());
        ps.setString(5, a.getContrasenha());
        ps.setString(6, a.getUsuario());
        ps.executeUpdate();
        return obtenerAdministradorPorUsuario(a.getUsuario()).get(0);
    }
}
