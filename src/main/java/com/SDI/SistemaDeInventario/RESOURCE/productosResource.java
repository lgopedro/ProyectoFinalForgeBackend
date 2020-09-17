package com.SDI.SistemaDeInventario.RESOURCE;


import com.SDI.SistemaDeInventario.DAO.administradorDAO;
import com.SDI.SistemaDeInventario.DAO.productosDAO;
import com.SDI.SistemaDeInventario.DTO.Empleados;
import com.SDI.SistemaDeInventario.DTO.Productos;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;


@RestController
@RequestMapping("/api")
public class productosResource {

    @RequestMapping(method = RequestMethod.GET,value = "/productos")
    public List<Productos> obtenerStock() throws SQLException {
        List<Productos> stockList = new productosDAO().obtenerStock();
        return stockList;
    }



}
