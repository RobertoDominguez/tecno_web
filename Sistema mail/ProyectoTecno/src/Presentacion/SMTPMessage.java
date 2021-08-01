/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentacion;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SMTPMessage {
   private Socket skCliente;
   // private String HOST = "virtual.fcet.uagrm.edu.bo";
    private String HOST = "mail.tecnoweb.org.bo";
    private int PORT = 25;
    private BufferedReader entrada;
    private DataOutputStream salida;
    String user_local="grupo12sa";
    String pass_local="grup012grup012";

    public SMTPMessage() {
        try {
            skCliente = new Socket(HOST, PORT);
            entrada = new BufferedReader(new InputStreamReader(skCliente.getInputStream()));
            salida = new DataOutputStream(skCliente.getOutputStream());
        } catch (Exception e) {
            System.out.println("message....error  iniciar " + e);
        }
    }

    public void sendMessage(String fromTo,String rcptTo,String subject,String message){
        
        /*//PARA CUNADO SE TENGAO HABILITADO LA IP
        HTMLMail mail = new HTMLMail(HOST,user_local,pass_local);
        
        mail.setFrom(fromTo);
        mail.setSubject(subject);
        mail.setTo(rcptTo);
        try {
           // fijar el contenido
           //mail.addContent(contenidoHTML);
           mail.addContent(message);
           mail.sendMultipart();
       } catch (Exception ex) {
           Logger.getLogger(SMTPMessage.class.getName()).log(Level.SEVERE, null, ex);
       }*/
       
        
        //desde aca para cuando no se tenga habilitado la ip
        String remitente = "xjosexa145@gmail.com";
        String clave = "@lex123456";
        
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", clave);
        
        Session session = Session.getDefaultInstance(props);
        MimeMessage mensaje = new MimeMessage(session);
        
        try {
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(rcptTo));
            mensaje.setSubject(subject);
            mensaje.setText(message);
            //mensaje.addHeader(clave, clave);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, clave);
            transport.sendMessage(mensaje, mensaje.getAllRecipients());
            transport.close();
        } catch(Exception e) {
            System.out.println("Error ==> " + e.getMessage());
        }
        
        //hasta aca
        
        
        /*try {
            System.out.println(entrada.readLine());
            salida.writeBytes("EHLO mail.tecnoweb.org.bo\r\n");
           // System.out.println("ccc1 "+entrada.readLine());
           // System.out.println("ccc1 "+leerLineas(entrada));
            entrada.readLine();
            leerLineas(entrada);
            salida.writeBytes("MAIL FROM:"+fromTo+"\r\n");
            //System.out.println("ccc1 "+entrada.readLine());
            String l1 = entrada.readLine();
            System.out.println("L1 => " + l1);
            salida.writeBytes("RCPT TO:"+rcptTo+"\r\n");
           //System.out.println("ccc1 "+entrada.readLine());
            String l2 = entrada.readLine();
            
            salida.writeBytes("DATA\r\n");  
           //System.out.println("ccc1 "+entrada.readLine());
            String l3 = entrada.readLine();
                        
            //---String comando="Subject:DEMO X\r\n"+"Probando\n"+"el envio de mensajes\n"+".\r\n";
            String comando="Subject:"+subject+"\r\n"+message+"\n"+".\r\n";
            salida.writeBytes(comando);
           //System.out.println("ccc1 "+entrada.readLine());
            entrada.readLine();
            System.out.println("correo grupo:"+fromTo);
            System.out.println("correo origen de destino:"+rcptTo);
            System.out.println("mensaje de respuesta enviado");

        } catch (Exception e) {
            System.out.println("message....al querer escribir mensaje " + e);
        }*/
    }
    
    public List<String> leerLineas(BufferedReader in) {
        List<String> lines = new ArrayList<String>();
        try {
           while (true){
            String line = in.readLine();
            if (line == null){
            }
            if (line.charAt(3)==' '){
                lines.add(line);
                break;
            }           
            lines.add(line);
        }        
        } catch (Exception e) {
        }
        return lines;
    }

    public void cerrar() {
        try {
            salida.writeBytes("QUIT\r\n");
            entrada.readLine();
            entrada.close();
            salida.close();
            skCliente.close();
        } catch (Exception e) {
            System.out.println("error al cerrar " + e);
        }
    }
    
    public static void sendMessageFromGmail(String destinatario, String asunto, String cuerpo) {
        
        String remitente = "grupo12sa@gmail.com";
        String clave = "bananero76697796";
        
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", clave);
        
        Session session = Session.getDefaultInstance(props);
        MimeMessage mensaje = new MimeMessage(session);
        
        try {
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            mensaje.setSubject(asunto);
            mensaje.setText(cuerpo);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, clave);
            transport.sendMessage(mensaje, mensaje.getAllRecipients());
            transport.close();
        } catch(Exception e) {
            System.out.println("Eerror ==> " + e.getMessage());
        }
    }
    
}
