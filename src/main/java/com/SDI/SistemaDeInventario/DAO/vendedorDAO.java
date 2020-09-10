package com.SDI.SistemaDeInventario.DAO;

import com.SDI.SistemaDeInventario.ConnectionManager;
import com.SDI.SistemaDeInventario.DTO.Empleados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
//1=true, 0=false

public class vendedorDAO {
    private final Connection connection;

    public vendedorDAO() throws SQLException {
        connection = ConnectionManager.obtenerConexion();
    }

    public List<Empleados> obtenerVendedorPorUsuario(String usuario) throws SQLException {
        String sql = " select * " +
                " from EMPLEADOS_SDI " +
                " where usuario=? and es_Admin=0 ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, usuario);
        ResultSet rs = ps.executeQuery();
        List<Empleados> vendedores = new LinkedList<>();
        while (rs.next()) {
            Empleados v = new Empleados(
                    rs.getString("usuario"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("correo"),
                    rs.getString("contrasenha"),
                    rs.getInt("es_Admin")
            );
            vendedores.add(v);
        }
        return vendedores;
    }
    public Empleados insertarVendedor(Empleados v) throws SQLException {
        String sql = " insert into EMPLEADOS_SDI(usuario, nombre, apellido, correo, contrasenha, es_Admin) " +
                " values (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, v.getUsuario());
        ps.setString(2, v.getNombre());
        ps.setString(3, v.getApellido());
        ps.setString(4, v.getCorreo());
        ps.setString(5, v.getContrasenha());
        ps.setInt(6, v.getEsAdmin()
        );
        ps.executeUpdate();
        return v;
    }
    public void borrarVendedorPorUsuario(String usuario) throws SQLException {
        String sql = " delete from EMPLEADOS_SDI " +
                " where usuario=? and es_Admin=0 ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, usuario);
        ps.executeUpdate();

    }
    public Empleados editarVendedorPorUsuario(Empleados v) throws SQLException {
        String sql = " Update EMPLEADOS_SDI " +
                " set usuario=?, nombre=?, apellido=?, correo=?, contrasenha=? " +
                " where usuario=? and es_Admin=0 ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, v.getUsuario());
        ps.setString(2, v.getNombre());
        ps.setString(3, v.getApellido());
        ps.setString(4, v.getCorreo());
        ps.setString(5, v.getContrasenha());
        ps.setString(6, v.getUsuario());
        ps.setInt(7, v.getEsAdmin());
        ps.executeUpdate();
        return obtenerVendedorPorUsuario(v.getUsuario()).get(0);
    }

}
