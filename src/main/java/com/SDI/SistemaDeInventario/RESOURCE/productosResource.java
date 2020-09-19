package com.SDI.SistemaDeInventario.RESOURCE;

import com.SDI.SistemaDeInventario.DAO.productosDAO;
import com.SDI.SistemaDeInventario.DTO.Productos;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class productosResource {


    @RequestMapping(method = RequestMethod.GET, value = "/productos")
    public List<Productos>  ObtenerAll() throws SQLException {
        return new productosDAO().obtenerAll();

    }

    @RequestMapping(method = RequestMethod.GET, value = "/productos/obtenerPorId/{id}")
    public List<Productos> obtenerProductosPorId(@PathVariable("id") int id)
            throws SQLException {
        return new productosDAO().obtenerProductosPorId(id);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/productos/obtener/{nombre}")
    public List<Productos> obtenerProductoPorNombreLike(@PathVariable("nombre") String nombre)
            throws SQLException {
        return new productosDAO().obtenerProductosPorNombreLike("%"+nombre+"%");
    }
    @RequestMapping(method = RequestMethod.POST, value = "/productos/ingresar")
    public Productos insertarProducto(@RequestBody Productos p) throws SQLException {
        return new productosDAO().insertarProducto(p);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/productos/borrar/{id}")
    public void borrarProducto(@PathVariable("id") int id) throws SQLException {
        new productosDAO().borrarProductoPorId(id);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/productos/actualizar/id}")
    public Productos editarProducto(@RequestBody Productos p) throws SQLException {
        return new productosDAO().editarProductoPorId(p);
    }
}
