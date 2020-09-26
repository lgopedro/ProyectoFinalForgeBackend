package com.SDI.SistemaDeInventario.RESOURCE;

import com.SDI.SistemaDeInventario.DAO.administradorDAO;
import com.SDI.SistemaDeInventario.DAO.vendedorDAO;
import com.SDI.SistemaDeInventario.DTO.Empleados;
import org.springframework.web.bind.annotation.*;
import sun.misc.Request;

import java.sql.SQLException;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")

public class vendedoresResource {


    @RequestMapping(method = RequestMethod.GET, value = "/vendedor")
    public List<Empleados> obtenerVendedores() throws SQLException{
        List<Empleados> vendedores = new vendedorDAO().obtenerVendedores();
        return vendedores;

    }

    @RequestMapping(method = RequestMethod.GET, value = "/vendedor/{usuario}")
    public List<Empleados> obtenerEmpleadoPorUsuario(@PathVariable("usuario") String usuario)
            throws SQLException {
        return new vendedorDAO().obtenerVendedorPorUsuario(usuario);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/vendedor")
    public Empleados insertarVendedor(@RequestBody Empleados v) throws SQLException {
        return new vendedorDAO().insertarVendedor(v);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/vendedor/{usuario}")
    public void borrarVendedor(@PathVariable("usuario") String usuario) throws SQLException {
        new vendedorDAO().borrarVendedorPorUsuario(usuario);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/vendedor/{usuario}")
    public Empleados editarVendedor(@RequestBody Empleados v) throws SQLException {
        return new vendedorDAO().editarVendedorPorUsuario(v);
    }

}
