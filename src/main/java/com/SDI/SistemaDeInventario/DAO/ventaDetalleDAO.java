package com.SDI.SistemaDeInventario.DAO;

import com.SDI.SistemaDeInventario.ConnectionManager;
import com.SDI.SistemaDeInventario.DTO.Venta;
import com.SDI.SistemaDeInventario.DTO.VentaDetalle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ventaDetalleDAO {

    private Connection connection;
    public ventaDetalleDAO() throws SQLException {
        connection = ConnectionManager.obtenerConexion();
    }


    public void insertarVenta(VentaDetalle[] nuevaVenta) throws SQLException {

        String sql = "INSERT INTO DETALLE_VENTA(idVenta,idProducto,nombreProducto,precio,cantidad,descuento) VALUES (?,?,?,?,?,?)";
        String sqlActualizarProductos="UPDATE PRODUCTOS SET stock= stock-? WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        PreparedStatement ps2 = connection.prepareStatement(sqlActualizarProductos);
        for (int i = 0; i < nuevaVenta.length ; i++) {

           ps.setInt(1,nuevaVenta[i].getIdVenta());
           ps.setInt(2,nuevaVenta[i].getIdProducto());
           ps.setString(3,nuevaVenta[i].getNombreProducto());
           ps.setInt(4,nuevaVenta[i].getPrecio());
           ps.setInt(5,nuevaVenta[i].getCantidad());
           ps.setInt(6,nuevaVenta[i].getDescuento());
           ps.executeUpdate();
           ps2.setInt(1,nuevaVenta[i].getCantidad());
           ps2.setInt(2,nuevaVenta[i].getIdProducto());
           ps2.executeUpdate();
        }

    }

    public List<VentaDetalle> obtenerDetalles() throws SQLException {
        String sql="SELECT * from DETALLE_VENTA where idVenta=(SELECT MAX (idVenta) from VENTA)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<VentaDetalle> detallesDeVentas = new ArrayList<>();
        VentaDetalle temp = null;
        while(rs.next()){
            temp= new VentaDetalle(rs.getInt("id"),
                    rs.getInt("idVenta"),
                    rs.getInt("idProducto"),
                    rs.getString("nombreProducto"),
                    rs.getInt("precio"),
                    rs.getInt("cantidad"),
                    rs.getInt("descuento"));

            detallesDeVentas.add(temp);
        }
        return detallesDeVentas;
    }


}
