package com.SDI.SistemaDeInventario.RESOURCE;


import com.SDI.SistemaDeInventario.DAO.administradorDAO;
import com.SDI.SistemaDeInventario.DAO.ventaDAO;
import com.SDI.SistemaDeInventario.DTO.Empleados;
import com.SDI.SistemaDeInventario.DTO.Venta;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Array;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ventaResource {


    @RequestMapping(method = RequestMethod.POST, value = "/venta")
    public void crearVenta(@RequestBody Venta nuevaVenta) throws SQLException {
            new ventaDAO().insertarVenta(nuevaVenta);
    }

    @RequestMapping(method = RequestMethod.GET, value="/venta/{idVendedor}")
    public Venta ultimaVenta(@PathVariable("idVendedor") String id) throws SQLException{
        return new ventaDAO().obtenerUltimaVenta(id);
    }

    @RequestMapping(method = RequestMethod.GET, value="/venta")
    public List<Venta> Ventas() throws SQLException{
        return new ventaDAO().obtenerVentas();
    }

}
