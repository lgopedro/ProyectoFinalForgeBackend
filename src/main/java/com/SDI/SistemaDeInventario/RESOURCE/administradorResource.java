package com.SDI.SistemaDeInventario.RESOURCE;

import com.SDI.SistemaDeInventario.DAO.administradorDAO;
import com.SDI.SistemaDeInventario.DAO.vendedorDAO;
import com.SDI.SistemaDeInventario.DTO.EmailSender;
import com.SDI.SistemaDeInventario.DTO.Empleados;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class administradorResource {

@Autowired
private EmailSender emailSender;


    @RequestMapping(method = RequestMethod.GET,value = "/administrador")
    public List<Empleados> obtenerAdministradores() throws SQLException {
        List<Empleados> administradores = new administradorDAO().obtenerAdministradores();
        return administradores;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/administrador")
    public Empleados insertarAdministrador(@RequestBody Empleados administrador) {

        Empleados temp= null;
        try{
          temp =  new administradorDAO().insertarAdministrador(administrador);
        }catch (SQLServerException x){
            System.out.println(x.toString());
            if (x.toString().contains("Violation of PRIMARY KEY")) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "El usuario ya esta siendo usado");
            }else if(x.toString().contains("Violation of UNIQUE KEY")){
                throw new ResponseStatusException(HttpStatus.LENGTH_REQUIRED,"El correo ya esta siendo usando");
            }
        }catch (SQLException y){
            System.out.println(y.toString());
        }

        emailSender.sendEmail(temp.getNombre(), temp.getApellido(), temp.getContrasenha(), temp.getCorreo());
        return temp;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/administrador/{administrador}")
    public void borrarAdministrador(@PathVariable("administrador") String administrador) throws SQLException {
        new administradorDAO().borrarAdministradorPorUsuario(administrador);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/administrador/{usuario}")
    public void editarAdministrador(@PathVariable("usuario") String usuario,  @RequestBody Empleados a) throws SQLException {
        try{
            new administradorDAO().editarAdministradorPorUsuario(usuario,a);
        }catch (SQLServerException x){
            System.out.println(x.toString());
            if (x.toString().contains("Violation of PRIMARY KEY")) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "El usuario ya esta siendo usado");
            }else if(x.toString().contains("Violation of UNIQUE KEY")){
                throw new ResponseStatusException(HttpStatus.LENGTH_REQUIRED,"El correo ya esta siendo usando");
            }
        }catch (SQLException y){
            System.out.println(y.toString());
        }
    }


    @RequestMapping(method = RequestMethod.PUT,value="/admin/{usuario}")
    public void cambiarContrasenha(@PathVariable("usuario") String usuario,@RequestBody String contrasenha) throws SQLException {
        new administradorDAO().cambiarContraseña(usuario, contrasenha);
    }

}
