package com.SDI.SistemaDeInventario.DAO;

import com.SDI.SistemaDeInventario.ConnectionManager;
import com.SDI.SistemaDeInventario.DTO.Productos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class productosDAO {
    private Connection connection;

    public productosDAO()throws SQLException {
        connection = ConnectionManager.obtenerConexion();
    }
    public List<Productos> obtenerStock() throws SQLException {
        String sql = "SELECT * FROM PRODUCTOS WHERE stock > 1";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Productos> stock = new ArrayList<>();
        while(rs.next()){
            Productos temp = new Productos(rs.getInt("id"),
                                            rs.getString("nombre"),
                                            rs.getString("marca"),
                                            rs.getInt("precio"),
                                            rs.getInt("stock"),
                                            rs.getInt("minimo"),
                                            rs.getString("categoria"));

            stock.add(temp);
        }
        return stock;
    }
    public List<Productos> obtenerAll() throws SQLException {
        String sql = " select *  from PRODUCTOS";
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



    public List<Productos> obtenerProductosPorId(int id) throws SQLException {
        String sql = " select * from PRODUCTOS  WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
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
        String sql = " delete from PRODUCTOS where id=? ";
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
    public void editarProductoPorId(int id,Productos p) throws SQLException {
        String sql = " Update PRODUCTOS " +
                " set nombre=?, marca=?, precio=?, stock=?, minimo=?, categoria=? " +
                " where id=? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, p.getNombre());
        ps.setString(2, p.getMarca());
        ps.setInt(3, p.getPrecio());
        ps.setInt(4, p.getStock());
        ps.setInt(5, p.getMinimo());
        ps.setString(6, p.getCategoria());
        ps.setInt(7, id);
        ps.executeUpdate();
    }

    public void aumentarStockDeProducto(int id, int ingreso) throws SQLException {
        String sql = "UPDATE PRODUCTOS SET stock= stock + ?  WHERE id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, ingreso);
        ps.setInt(2, id);
        ps.executeUpdate();
    }

}
