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

    public Empleados validar(Empleados empleado) throws SQLException {

        String sql = "SELECT * FROM EMPLEADOS_SDI where esAdmin=? and usuario=? and contrasenha=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, empleado.getEsAdmin());
        ps.setString(2,empleado.getUsuario());
        ps.setString(3,empleado.getContrasenha());
        Empleados temp = null;
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            temp = new Empleados(rs.getString("usuario"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("correo"),
                    rs.getString("contrasenha"),
                    rs.getInt("esAdmin"));
        }

        if(temp!=null){
            temp.setContrasenha(null);
        }
    return temp;
    }
}
