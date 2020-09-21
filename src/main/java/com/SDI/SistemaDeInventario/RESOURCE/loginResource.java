package com.SDI.SistemaDeInventario.RESOURCE;


import com.SDI.SistemaDeInventario.DAO.loginDAO;
import com.SDI.SistemaDeInventario.DTO.Empleados;

import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;


@RestController
@RequestMapping("/api")
public class loginResource {


    @RequestMapping(method = RequestMethod.GET,value="/login")
    public boolean validar(@RequestParam("usuario") String usuario,
                             @RequestParam("contrasenha") String contrasenha,
                             @RequestParam("esAdmin") int esAdmin) throws SQLException {


        return new loginDAO().validar(usuario, contrasenha, esAdmin);
    }


}
