package com.SDI.SistemaDeInventario.RESOURCE;

import com.SDI.SistemaDeInventario.DAO.vendedorDAO;
import com.SDI.SistemaDeInventario.DTO.Empleados;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class vendedoresResource {
    @RequestMapping(method = RequestMethod.GET, value = "/vendedor/obtener/{usuario}")
    public List<Empleados> obtenerEmpleadoPorUsuario(@PathVariable("usuario") String usuario)
            throws SQLException {
        return new vendedorDAO().obtenerVendedorPorUsuario(usuario);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/vendedor/ingresar")
    public Empleados insertarVendedor(@RequestBody Empleados v) throws SQLException {
        return new vendedorDAO().insertarVendedor(v);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/vendedor/borrar/{usuario}")
    public void borrarVendedor(@PathVariable("usuario") String usuario) throws SQLException {
        new vendedorDAO().borrarVendedorPorUsuario(usuario);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/vendedor/actualizar/{usuario}")
    public Empleados editarVendedor(@RequestBody Empleados v) throws SQLException {
        return new vendedorDAO().editarVendedorPorUsuario(v);
    }

}
