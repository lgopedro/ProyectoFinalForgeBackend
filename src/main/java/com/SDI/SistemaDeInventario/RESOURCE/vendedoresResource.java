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

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/api")
public class vendedoresResource {

    @Autowired
    private EmailSender emailSender;

    @RequestMapping(method = RequestMethod.POST, value = "/vendedor")
    public Empleados insertarVendedor(@RequestBody Empleados v) {
        Empleados temp = null;
        try {
               temp = new vendedorDAO().insertarVendedor(v);
        } catch (SQLServerException e) {
            System.out.println(e.toString());
            if (e.toString().contains("Violation of PRIMARY KEY")) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "El usuario ya esta siendo utilizado");
            } else if (e.toString().contains("Violation of UNIQUE KEY")) {
                throw new ResponseStatusException(HttpStatus.LENGTH_REQUIRED, "El correo ya esta siendo usado");
            }
        } catch (SQLException y) {
            System.out.println(y.toString());
        }
        emailSender.sendEmail(temp.getNombre(), temp.getApellido(), temp.getContrasenha(), temp.getCorreo());
        return temp;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/vendedor/{usuario}")
    public void borrarVendedor(@PathVariable("usuario") String usuario) throws SQLException {
        new vendedorDAO().borrarVendedorPorUsuario(usuario);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/vendedor/{usuario}")
    public void editarVendedor(@PathVariable("usuario") String usuario,  @RequestBody Empleados v) throws SQLException {
        try{
            new vendedorDAO().editarVendedorPorUsuario(usuario,v);
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

    @RequestMapping(method = RequestMethod.GET,value = "/vendedor")
    public List<Empleados> obtenerVendedores() throws SQLException {
        return new vendedorDAO().obtenerVendedores();
    }

    @RequestMapping(method = RequestMethod.PUT,value="/vendedor/restar/{usuario}")
    public void cambiarContrasenha(@PathVariable("usuario") String usuario,@RequestBody String contrasenha) throws SQLException {
        new vendedorDAO().cambiarContraseña(usuario, contrasenha);
    }






}
