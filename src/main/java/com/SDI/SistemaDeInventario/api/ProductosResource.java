package com.SDI.SistemaDeInventario.api;

import com.SDI.SistemaDeInventario.dao.ProductoDao;
import com.SDI.SistemaDeInventario.dao.VendedorDao;
import com.SDI.SistemaDeInventario.dto.Empleados;
import com.SDI.SistemaDeInventario.dto.Productos;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductosResource {
    @RequestMapping(method = RequestMethod.GET, value = "/producto/obtener/{id}")
    public List<Productos> obtenerProductosPorId(@PathVariable("id") int id)
            throws SQLException {
        return new ProductoDao().obtenerProductosPorId(id);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/producto/obtener/{nombre}")
    public List<Productos> obtenerProductoPorNombreLike(@PathVariable("nombre") String nombre)
            throws SQLException {
        return new ProductoDao().obtenerProductosPorNombreLike("%"+nombre+"%");
    }
    @RequestMapping(method = RequestMethod.POST, value = "/producto/ingresar")
    public Productos insertarProducto(@RequestBody Productos p) throws SQLException {
        return new ProductoDao().insertarProducto(p);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/producto/borrar/{id}")
    public void borrarProducto(@PathVariable("id") int id) throws SQLException {
        new ProductoDao().borrarProductoPorId(id);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/producto/actualizar/id}")
    public Productos editarProducto(@RequestBody Productos p) throws SQLException {
        return new ProductoDao().editarProductoPorId(p);
    }
}
