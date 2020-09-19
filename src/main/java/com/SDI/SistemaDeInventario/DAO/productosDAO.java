package com.SDI.SistemaDeInventario.DAO;

import com.SDI.SistemaDeInventario.ConnectionManager;
import com.SDI.SistemaDeInventario.DTO.Productos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class productosDAO {
    private Connection connection;

    public productosDAO()throws SQLException {
        connection = ConnectionManager.obtenerConexion();
    }

    public List<Productos> obtenerAll() throws SQLException {
        String sql = " select * " +
                " from PRODUCTOS ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Productos> productos = new LinkedList<>();
        while (rs.next()) {
            Productos p = new Productos(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("marca"),
                    rs.getInt("precio"),
                    rs.getInt("stock"),
                    rs.getInt("minimo"),
                    rs.getString("categoria")
            );
            productos.add(p);
        }
        return productos;
    }



    public List<Productos> obtenerProductosPorId(int Id) throws SQLException {
        String sql = " select * " +
                " from PRODUCTOS " +
                " where id=? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, Id);
        ResultSet rs = ps.executeQuery();
        List<Productos> productos = new LinkedList<>();
        while (rs.next()) {
            Productos p = new Productos(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("marca"),
                    rs.getInt("precio"),
                    rs.getInt("stock"),
                    rs.getInt("minimo"),
                    rs.getString("categoria")
            );
            productos.add(p);
        }
        return productos;
    }
    public List<Productos> obtenerProductosPorNombreLike(String nombre) throws SQLException {
        String sql = " select * " +
                " from PRODUCTOS " +
                " where nombre ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, nombre);
        ResultSet rs = ps.executeQuery();
        List<Productos> productos = new LinkedList<>();
        while (rs.next()) {
            Productos p = new Productos(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("marca"),
                    rs.getInt("precio"),
                    rs.getInt("stock"),
                    rs.getInt("minimo"),
                    rs.getString("categoria")
            );
            productos.add(p);
        }
        return productos;
    }
    public void borrarProductoPorId(int id) throws SQLException {
        String sql = " delete from PRODUCTOS " +
                " where id=? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();

    }
    public Productos insertarProducto(Productos p) throws SQLException {
        String sql = " insert into PRODUCTOS(nombre, marca, precio, stock, minimo, categoria) " +
                " values (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, p.getNombre());
        ps.setString(2, p.getMarca());
        ps.setInt(3, p.getPrecio());
        ps.setInt(4, p.getStock());
        ps.setInt(5, p.getMinimo());
        ps.setString(6, p.getCategoria());
        ps.executeUpdate();
        return p;
    }
    public Productos editarProductoPorId(Productos p) throws SQLException {
        String sql = " Update PRODUCTOS " +
                " set id=?, nombre=?, marca=?, precio=?, stock=?, minimo=?, categoria=? " +
                " where id=? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, p.getId());
        ps.setString(2, p.getNombre());
        ps.setString(3, p.getMarca());
        ps.setInt(4, p.getPrecio());
        ps.setInt(5, p.getStock());
        ps.setInt(6, p.getMinimo());
        ps.setString(7, p.getCategoria());
        ps.setInt(8, p.getId());
        ps.executeUpdate();
        return obtenerProductosPorId(p.getId()).get(0);
    }
}
