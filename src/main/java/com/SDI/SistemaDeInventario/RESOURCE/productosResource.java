package com.SDI.SistemaDeInventario.RESOURCE;


import com.SDI.SistemaDeInventario.DAO.administradorDAO;
import com.SDI.SistemaDeInventario.DAO.productosDAO;
import com.SDI.SistemaDeInventario.DTO.Empleados;
import com.SDI.SistemaDeInventario.DTO.Productos;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;


@RestController
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

    @RequestMapping(method = RequestMethod.GET, value = "/productos/obtenerPorId/{id}")
    public List<Productos> obtenerProductosPorId(@PathVariable("id") int id)
            throws SQLException {
        return new productosDAO().obtenerProductosPorId(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/productos/ingresar")
    public Productos insertarProducto(@RequestBody Productos p) throws SQLException {
        return new productosDAO().insertarProducto(p);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/productos/borrar/{id}")
    public void borrarProducto(@PathVariable("id") int id) throws SQLException {
        new productosDAO().borrarProductoPorId(id);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/productos/actualizar/{id}")
    public void editarProducto(@PathVariable("id") int id,  @RequestBody Productos p) throws SQLException {
        new productosDAO().editarProductoPorId(id,p);
    }


}
