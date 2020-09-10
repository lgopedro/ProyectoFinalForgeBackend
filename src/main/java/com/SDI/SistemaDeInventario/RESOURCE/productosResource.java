package com.SDI.SistemaDeInventario.RESOURCE;

import com.SDI.SistemaDeInventario.DAO.productosDAO;
import com.SDI.SistemaDeInventario.DTO.Productos;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class productosResource {
    @RequestMapping(method = RequestMethod.GET, value = "/producto/obtener/{id}")
    public List<Productos> obtenerProductosPorId(@PathVariable("id") int id)
            throws SQLException {
        return new productosDAO().obtenerProductosPorId(id);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/producto/obtener/{nombre}")
    public List<Productos> obtenerProductoPorNombreLike(@PathVariable("nombre") String nombre)
            throws SQLException {
        return new productosDAO().obtenerProductosPorNombreLike("%"+nombre+"%");
    }
    @RequestMapping(method = RequestMethod.POST, value = "/producto/ingresar")
    public Productos insertarProducto(@RequestBody Productos p) throws SQLException {
        return new productosDAO().insertarProducto(p);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/producto/borrar/{id}")
    public void borrarProducto(@PathVariable("id") int id) throws SQLException {
        new productosDAO().borrarProductoPorId(id);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/producto/actualizar/id}")
    public Productos editarProducto(@RequestBody Productos p) throws SQLException {
        return new productosDAO().editarProductoPorId(p);
    }
}
