package com.SDI.SistemaDeInventario.RESOURCE;


import com.SDI.SistemaDeInventario.DAO.administradorDAO;
import com.SDI.SistemaDeInventario.DAO.productosDAO;
import com.SDI.SistemaDeInventario.DTO.Empleados;
import com.SDI.SistemaDeInventario.DTO.Productos;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.sql.SQLException;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/api")
public class productosResource {

    @RequestMapping(method = RequestMethod.GET,value = "/productos/stock")
    public List<Productos> obtenerStock() throws SQLException {
        List<Productos> stockList = new productosDAO().obtenerStock();
        return stockList;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/productos")
    public List<Productos>  ObtenerAll() throws SQLException {
        return new productosDAO().obtenerAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/productos")
    public Productos insertarProducto(@RequestBody Productos p) throws SQLException {
        return new productosDAO().insertarProducto(p);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/productos/{id}")
    public void borrarProducto(@PathVariable("id") int id) throws SQLException {
        new productosDAO().borrarProductoPorId(id);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/productos/{id}")
    public void editarProducto(@PathVariable("id") int id,  @RequestBody Productos p) throws SQLException {
        new productosDAO().editarProductoPorId(id,p);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/productos/stock/{id}")
    public void editarProducto(@PathVariable("id") int id, @RequestBody int ingreso) throws SQLException {
        new productosDAO().aumentarStockDeProducto(id, ingreso);

    }

}
