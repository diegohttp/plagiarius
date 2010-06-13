/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Utilitarios;

import antiplagium.BE.UsuarioBE;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author piere
 */
public class EnviarCorreo {

    public EnviarCorreo(UsuarioBE usuarioBE, int opcion){
        try {
            String protocolo="smtp";
            String hostCorreo="smtp.gmail.com";
            String TLS="true";
            String puerto="587";
            String cuentaSistema="sistemaantiplagium@gmail.com";
            String authentication="true";
            InternetAddress remitenteE=new InternetAddress(cuentaSistema);
            InternetAddress destinatarioE=new InternetAddress(usuarioBE.getEmail());


            Properties props = new Properties();
            // Nombre del host de correo, es smtp.gmail.com
            props.setProperty("mail.smtp.host",hostCorreo);
            // TLS si está disponible
            props.setProperty("mail.smtp.starttls.enable", TLS);
            // Puerto de gmail para envio de correos
            props.setProperty("mail.smtp.port", puerto);
            // Nombre del usuario
            props.setProperty("mail.smtp.user", cuentaSistema);
            // Si requiere o no usuario y password para conectarse.
            props.setProperty("mail.smtp.auth",authentication);

            Session session = Session.getDefaultInstance(props);
            //session.setDebug(true);
            
            MimeMessage message = new MimeMessage(session);
            // Quien envia el correo
            message.setFrom(remitenteE);
            // A quien va dirigido
            message.addRecipient(Message.RecipientType.TO, destinatarioE);
            message.addRecipient(Message.RecipientType.BCC, remitenteE);

            message.setSubject("Administracion de Sistema Antiplagium");
            //message.setText("Mensajito con Java Mail"+"de los buenos."+"poque si");
            if (opcion==1){
                message.setText("<b>Recuperacion de contrasena.</b><br>"+
                                "Su contrasena es: <i> "+usuarioBE.getPassword()+"</i>",
                                "ISO-8859-1","html");
            }
            else if (opcion==2){
                message.setText("<b>Recuperacion de nombre de usuario.</b><br>"+
                                "Su nombre de usuario es: <i> "+usuarioBE.getNombreUsuario()+"</i>",
                                "ISO-8859-1","html");

            }
            else if (opcion==3){

            }

            Transport t = session.getTransport(protocolo);
            t.connect(cuentaSistema,"mundial2010");
            t.sendMessage(message,message.getAllRecipients());
            t.close();

        } catch (MessagingException ex) {
            Logger.getLogger(EnviarCorreo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
