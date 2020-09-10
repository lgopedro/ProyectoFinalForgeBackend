package com.SDI.SistemaDeInventario.RESOURCE;

import com.SDI.SistemaDeInventario.DAO.administradorDAO;
import com.SDI.SistemaDeInventario.DTO.Empleados;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class administradorResource {



    @RequestMapping(method = RequestMethod.GET,value = "/administrador/")
    public List<Empleados> obtenerAdministradores() throws SQLException {
        List<Empleados> administradores = new administradorDAO().obtenerAdministradores();
        return administradores;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/administrador/")
    public String insertarAdministrador(@RequestBody Empleados administrador) throws SQLException {
            String temp = new administradorDAO().insertarAdministrador(administrador);
            return temp;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/administrador/{administrador}")
    public void borrarAdministrador(@PathVariable("administrador") String administrador) throws SQLException {
        new administradorDAO().borrarAdministradorPorUsuario(administrador);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/administrador/{usuario}")
    public Empleados editarAdministrador(@RequestBody Empleados a) throws SQLException {
        return new administradorDAO().editarAdministradorPorUsuario(a);
    }
}
