package com.SDI.SistemaDeInventario.DAO;

import com.SDI.SistemaDeInventario.ConnectionManager;
import com.SDI.SistemaDeInventario.DTO.Empleados;
import com.SDI.SistemaDeInventario.DTO.Validador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class loginDAO {

    private Connection connection;

    public loginDAO() throws SQLException {
        connection = ConnectionManager.obtenerConexion();
    }

    public boolean validar(String usuario, String contrasenha, int esAdmin) throws SQLException {
            boolean login=false;
        String sql = "SELECT * FROM EMPLEADOS_SDI where esAdmin=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, esAdmin);
        Empleados temp = null;
        List<Empleados> lista = new ArrayList<>();
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            temp = new Empleados(rs.getString("usuario"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("correo"),
                    rs.getString("contrasenha"),
                    rs.getInt("esAdmin"));
            lista.add(temp);
        }
        int i=0;
        while(i<lista.size()){
            if(lista.get(i).getUsuario().contains(usuario) && lista.get(i).getContrasenha().contains(contrasenha)){
                login = true;
                break;
            }
            i++;
        }


        return login;
    }
}
