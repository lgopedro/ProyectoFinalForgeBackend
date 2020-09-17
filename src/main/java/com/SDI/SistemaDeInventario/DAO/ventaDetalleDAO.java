package com.SDI.SistemaDeInventario.DAO;

import com.SDI.SistemaDeInventario.ConnectionManager;
import com.SDI.SistemaDeInventario.DTO.VentaDetalle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ventaDetalleDAO {

    private Connection connection;
    public ventaDetalleDAO() throws SQLException {
        connection = ConnectionManager.obtenerConexion();
    }


    public void insertarVenta(VentaDetalle[] nuevaVenta) throws SQLException {

        String sql = "INSERT INTO DETALLE_VENTA(idVenta,idProducto,precio,cantidad,descuento) VALUES (?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        for (int i = 0; i < nuevaVenta.length ; i++) {

           ps.setInt(1,nuevaVenta[i].getIdVenta());
           ps.setInt(2,nuevaVenta[i].getIdProducto());
           ps.setInt(3,nuevaVenta[i].getPrecio());
           ps.setInt(4,nuevaVenta[i].getCantidad());
           ps.setInt(5,nuevaVenta[i].getDescuento());

           ps.executeUpdate();

        }

    }
}
