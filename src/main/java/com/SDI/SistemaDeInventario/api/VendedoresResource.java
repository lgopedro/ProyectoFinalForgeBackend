package com.SDI.SistemaDeInventario.api;

import com.SDI.SistemaDeInventario.dao.VendedorDao;
import com.SDI.SistemaDeInventario.dto.Empleados;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class VendedoresResource {
    @RequestMapping(method = RequestMethod.GET, value = "/vendedor/obtener/{usuario}")
    public List<Empleados> obtenerEmpleadoPorUsuario(@PathVariable("usuario") String usuario)
            throws SQLException {
        return new VendedorDao().obtenerVendedorPorUsuario(usuario);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/vendedor/ingresar")
    public Empleados insertarVendedor(@RequestBody Empleados v) throws SQLException {
        return new VendedorDao().insertarVendedor(v);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/vendedor/borrar/{usuario}")
    public void borrarVendedor(@PathVariable("usuario") String usuario) throws SQLException {
        new VendedorDao().borrarVendedorPorUsuario(usuario);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/vendedor/actualizar/{usuario}")
    public Empleados editarVendedor(@RequestBody Empleados v) throws SQLException {
        return new VendedorDao().editarVendedorPorUsuario(v);
    }

}
