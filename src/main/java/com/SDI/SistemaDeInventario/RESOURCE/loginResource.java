package com.SDI.SistemaDeInventario.RESOURCE;


import com.SDI.SistemaDeInventario.DAO.loginDAO;
import com.SDI.SistemaDeInventario.DTO.Empleados;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;


@RestController
@RequestMapping("/api")
public class loginResource {


    @RequestMapping(method = RequestMethod.POST,value="/login")
    public Empleados validar(@RequestBody Empleados empleado) throws SQLException {
        Empleados empleadoValidado= new loginDAO().validar(empleado);
        if(empleadoValidado==null){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"usuario invalido");

        }
        return empleadoValidado;

    }


}
