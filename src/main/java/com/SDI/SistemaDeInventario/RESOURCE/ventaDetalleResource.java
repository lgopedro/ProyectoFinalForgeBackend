package com.SDI.SistemaDeInventario.RESOURCE;

import com.SDI.SistemaDeInventario.DAO.ventaDAO;
import com.SDI.SistemaDeInventario.DAO.ventaDetalleDAO;
import com.SDI.SistemaDeInventario.DTO.Venta;
import com.SDI.SistemaDeInventario.DTO.VentaDetalle;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Array;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ventaDetalleResource {



    @RequestMapping(method = RequestMethod.POST, value = "/ventaDetalle")
    public void crearVenta(@RequestBody VentaDetalle[] nuevaVenta) throws SQLException {
        new ventaDetalleDAO().insertarVenta(nuevaVenta);
    }

    @RequestMapping(method = RequestMethod.GET, value="/ventaDetalle")
    public List<VentaDetalle> DetallesDeVentas() throws SQLException{
        return new ventaDetalleDAO().obtenerDetalles();
    }


}
