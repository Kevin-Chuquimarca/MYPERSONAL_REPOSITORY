/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.controlador;

import ec.edu.monster.modelo.Correo;
import ec.edu.monster.modelo.EmisorCorreo;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author santi
 */
public class EmisorCorreoController {
     private EmisorCorreo modelo;
    private Properties propiedades;
    private Session sesion;
    
    public EmisorCorreoController() {
        this.modelo = new EmisorCorreo();
        this.modelo.setCorreo("santi.kevin0983@gmail.com");
        this.modelo.setPassword("rsspamigisxvpexu");
        this.modelo.setHost("smtp.gmail.com");
        this.modelo.setPort(587);
        this.modelo.setSsl(true);
        this.inicializarEmisor();
    }
    
    private void inicializarEmisor() {
        propiedades = new Properties();
        propiedades.put("mail.smtp.auth", true);
        propiedades.put("mail.smtp.starttls.enable", modelo.isSsl());
        propiedades.put("mail.smtp.host", modelo.getHost());
        propiedades.put("mail.smtp.port", modelo.getPort());
        sesion = Session.getInstance(propiedades, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(modelo.getCorreo(), 
                        modelo.getPassword());
            }
        });
    }
    
    public void enviarCorreo(Correo correo) {
        Message message = new MimeMessage(sesion);
        try {
            message.setFrom(new InternetAddress(correo.getEmisor()));
            message.setRecipients(Message.RecipientType.TO, 
                    InternetAddress.parse(correo.getReceptor()));
            message.setSubject(correo.getAsunto());
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(correo.getCuerpo(), "text/html; charset=utf-8");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
            message.setContent(multipart);
            Transport.send(message);
        } catch (AddressException ex) {
            Logger.getLogger(EmisorCorreoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(EmisorCorreoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void enviarCorreoNuevoUsuario(
        String correoUsuario, 
        String nombreUsuario, 
        String clave
    ) {
        String asunto = "Te has registrado satisfactoriamente!";
        String cuerpo = "Hola " + nombreUsuario + " tu clave es: <br> " +
                        "<bold>" + clave + "<bold>";
        Correo correo = new Correo();
        correo.setEmisor(modelo.getCorreo()); // Correo de soporte del server
        correo.setReceptor(correoUsuario);
        correo.setAsunto(asunto);
        correo.setCuerpo(cuerpo);
        enviarCorreo(correo);
    }
}
