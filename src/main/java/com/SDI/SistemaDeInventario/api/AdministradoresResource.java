package com.SDI.SistemaDeInventario.api;

import com.SDI.SistemaDeInventario.dao.AdministradorDao;
import com.SDI.SistemaDeInventario.dto.Empleados;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AdministradoresResource {
    @RequestMapping(method = RequestMethod.GET, value = "/administrador/obtener/{usuario}")
    public List<Empleados> obtenerAdministradorPorUsuario(@PathVariable("usuario") String usuario)
            throws SQLException {
        return new AdministradorDao().obtenerAdministradorPorUsuario(usuario);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/administrador/ingresar")
    public Empleados insertarAdministrador(@RequestBody Empleados a) throws SQLException {
        return new AdministradorDao().insertarAdministrador(a);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/administrador/borrar/{usuario}")
    public void borrarAdministrador(@PathVariable("usuario") String usuario) throws SQLException {
        new AdministradorDao().borrarAdministradorPorUsuario(usuario);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/administrador/actualizar/{usuario}")
    public Empleados editarAdministrador(@RequestBody Empleados a) throws SQLException {
        return new AdministradorDao().editarAdministradorPorUsuario(a);
    }
}
