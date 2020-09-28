package com.SDI.SistemaDeInventario.DTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailSender {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String nombre, String apellido, String contrasenha,String correo) {
        System.out.println("Sending mail");
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("sdi.system.group2020@gmail.com");
        msg.setTo(correo);
        msg.setSubject("Bienvenido a SDI GROUP");
        msg.setText(nombre+" "+apellido+" ahora formas parte de SDI GROUP\n\nTu contraseña provisional será: "+contrasenha+" \n" +
                "Si deseas cambiarla puedes hacerlo en el apartado de perfil o pulsando  en  ¿Olvidaste tu contraseña? antes de iniciar sesión ");

        javaMailSender.send(msg);

        System.out.println("Mail sending succesfully");
    }


}
