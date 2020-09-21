package com.SDI.SistemaDeInventario.DAO;

import com.SDI.SistemaDeInventario.ConnectionManager;
import com.SDI.SistemaDeInventario.DTO.Empleados;
import com.SDI.SistemaDeInventario.DTO.Venta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ventaDAO {

    private Connection connection;
    public ventaDAO() throws SQLException {
        connection = ConnectionManager.obtenerConexion();
    }

    public void insertarVenta(Venta nuevaVenta) throws SQLException {
        Timestamp fechaHora = new Timestamp(System.currentTimeMillis());
        String sql="INSERT INTO VENTA (idVendedor,fechaHora,formaDePago,total) VALUES (?,?,?,?)";
         PreparedStatement ps = connection.prepareStatement(sql);
         ps.setString(1,nuevaVenta.getIdVendedor());
         ps.setTimestamp(2, fechaHora);
         ps.setString(3,nuevaVenta.getFormaDePago());
         ps.setInt(4,nuevaVenta.getTotal());
         ps.executeUpdate();
    }

    public Venta obtenerUltimaVenta(String id) throws SQLException {
        String sql="SELECT * from VENTA where idVenta=(SELECT MAX (idVenta) from venta where idVendedor = ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,id);
        ResultSet rs = ps.executeQuery();
        Venta ultima=null;
        while(rs.next()){
                ultima= new Venta(rs.getInt("idVenta"),
                                    rs.getString("idVendedor"),
                                    rs.getTimestamp("fechaHora"),
                                    rs.getString("formaDePago"),
                                    rs.getInt("total"));

        }
        return ultima;
    }

    public List<Venta> obtenerVentas() throws SQLException {
        String sql="SELECT * FROM VENTA";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Venta> ventas = new ArrayList<>();
        Venta temp = null;
        while(rs.next()){
            temp= new Venta(rs.getInt("idVenta"),
                    rs.getString("idVendedor"),
                    rs.getTimestamp("fechaHora"),
                    rs.getString("formaDePago"),
                    rs.getInt("total"));

            ventas.add(temp);
        }
        return ventas;
    }

}
