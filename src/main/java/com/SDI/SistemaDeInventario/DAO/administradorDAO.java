package com.SDI.SistemaDeInventario.DAO;

import com.SDI.SistemaDeInventario.ConnectionManager;
import com.SDI.SistemaDeInventario.DTO.EmailSender;
import com.SDI.SistemaDeInventario.DTO.Empleados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class administradorDAO {

    private Connection connection;
    public administradorDAO() throws SQLException{
        connection = ConnectionManager.obtenerConexion();
    }



    public List<Empleados> obtenerAdministradorPorUsuario(String usuario) throws SQLException {
        String sql = " select * " +
                " from EMPLEADOS_SDI " +
                " where usuario=? and esAdmin=1";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, usuario);
        ResultSet rs = ps.executeQuery();
        List<Empleados> administradores = new LinkedList<>();
        while (rs.next()) {
            Empleados a = new Empleados(
                    rs.getString("usuario"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("correo"),
                    rs.getString("contrasenha"),
                    rs.getInt("esAdmin")
            );
            administradores.add(a);
        }
        return administradores;
    }
    public Empleados insertarAdministrador(Empleados administrador) throws SQLException {
        String sql = " insert into EMPLEADOS_SDI(usuario, nombre, apellido, correo, contrasenha, esAdmin) " +
                " values (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        String contrasenha = new PasswordGenerator().generate();
        ps.setString(1, administrador.getUsuario());
        ps.setString(2, administrador.getNombre());
        ps.setString(3, administrador.getApellido());
        ps.setString(4, administrador.getCorreo());
        ps.setString(5, contrasenha);
        ps.setInt(6, administrador.getEsAdmin());
        ps.executeUpdate();

        Empleados contacto = new Empleados(administrador.getUsuario(),
                                           administrador.getNombre(),
                                            administrador.getApellido(),
                                            administrador.getCorreo(),
                                            contrasenha,
                                            administrador.getEsAdmin());

        return contacto;
    }
    public void borrarAdministradorPorUsuario(String usuario) throws SQLException {
        String sql = " delete from EMPLEADOS_SDI " +
                " where usuario=? and esAdmin=1 ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, usuario);
        ps.executeUpdate();

    }
    public void editarAdministradorPorUsuario(String usuario,Empleados a) throws SQLException {
        String sql = " Update EMPLEADOS_SDI " +
                " set usuario=?, nombre=?, apellido=?, correo=?, contrasenha=? " +
                " where usuario=? and esAdmin=1 ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, a.getUsuario());
        ps.setString(2, a.getNombre());
        ps.setString(3, a.getApellido());
        ps.setString(4, a.getCorreo());
        ps.setString(5, a.getContrasenha());
        ps.setString(6, usuario);
        ps.executeUpdate();
    }

    public List<Empleados> obtenerAdministradores() throws SQLException {
        String sql="SELECT * FROM EMPLEADOS_SDI WHERE esAdmin=1";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Empleados> administradores = new ArrayList<>();
        Empleados temp = null;
        while(rs.next()){
            temp = new Empleados(rs.getString("usuario"),
                                rs.getString("nombre"),
                                rs.getString("apellido"),
                                rs.getString("correo"),
                                rs.getString("contrasenha"),
                                rs.getInt("esAdmin"));

            administradores.add(temp);
        }
        return administradores;
    }

    public void cambiarContraseña(String usuario,String contrasenha) throws SQLException {
        String sql="update EMPLEADOS_SDI SET contrasenha=? where usuario=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,contrasenha);
        ps.setString(2,usuario);
        ps.executeUpdate();
    }



}
