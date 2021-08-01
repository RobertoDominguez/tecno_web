/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.io.*; 
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
/**
 *
 * @author grupo12sa
 */
public class HTMLMail {
    static public int SIMPLE = 0;
    static public int MULTIPART = 1;

    public static String ERROR_01_LOADFILE = "Error al cargar el fichero";
    public static String ERROR_02_SENDMAIL = "Error al enviar el mail";
    /**
     * Variables
     */
    private Properties props = new Properties();
    private String host, protocol, user, password;
    private String from, content, to;
    private String subject = "";

    MimeMultipart multipart = new MimeMultipart("related");

    public HTMLMail(String host, String user, String password) {
        props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", host);
        props.setProperty("mail.user", user);
        props.setProperty("mail.password", password);
    }
//-----

    static public void trazas(String metodo, String mensaje) {
// TODO: reemplazar para usar Log4J
        System.out.println("[" + HTMLMail.class.getName() + "][" + metodo
                + "]:[" + mensaje + "]");
    }
// -----

    static public String loadHTMLFile(String pathname) throws Exception {
        String content = "";
        File f = null;
        BufferedReader in = null;
        try {
            f = new File(pathname);
            if (f.exists()) {
                long len_bytes = f.length();
                trazas("loadHTMLFile", "pathname:" + pathname + ", len:" + len_bytes);
            }
            in = new BufferedReader(new FileReader(f));
            String str;
            while ((str = in.readLine()) != null) {
// process(str);
                str = str.trim();
                content = content + str;
            }
            in.close();
            return content;
        } catch (Exception e) {
            String MENSAJE_ERROR = ERROR_01_LOADFILE + ": ['" + pathname + "'] : " + e.toString();
            throw new Exception(MENSAJE_ERROR);
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }
// ----

    
    public static void main(String[] args) throws Exception {
        try {
// cargar en un string el template del HTML que se va a enviar
            String contenidoHTML = HTMLMail.loadHTMLFile("/home/grupo12sa/articulo.html");
            System.out.println("contenido HTML:" + contenidoHTML);
// propiedades de conexion al servidor de correo
            HTMLMail mail = new HTMLMail("correo", "grupo12sa", "grupo12sa");
            mail.setFrom("javalangnullpointer");
            mail.setSubject("NOTICIAS XD");
            mail.setTo("jhon.doe@gmail.com");
// fijar el contenido
//contenidoHTML=contenidoHTML+"<br/>Saludos, <br/><img src='cidimage01'>";
            mail.addContent(contenidoHTML);
// CID de una imagen
            mail.addCID("cidimage01", "/home/grupo12sa/firma.gif");
// enviar atachados un par de ficheros
            mail.addAttach("/home/grupo12sa/image.gif");
//mail.addAttach("/home/grupo12sa/bison_1_0.zip");
// enviar el correo MULTIPART
            mail.sendMultipart();
// para un correo SIMPLE seria:
// mail.setContent(contenidoHTML);
// mail.send();
            System.out.println("[ Mail enviado ]");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
// ------

    /**
     * Añade el contenido base al multipart
     *
     * @throws Exception Excepcion levantada en caso de error
     */
    public void addContentToMultipart() throws Exception {
// first part (the html)
        BodyPart messageBodyPart = new MimeBodyPart();
        String htmlText = this.getContent();
        messageBodyPart.setContent(htmlText, "text/html");
// add it
        this.multipart.addBodyPart(messageBodyPart);
    }
// -----

    /**
     * Añade el contenido base al multipart
     *
     * @param htmlText contenido html que se muestra en el mensaje de correo
     * @throws Exception Excepcion levantada en caso de error
     */
    public void addContent(String htmlText) throws Exception {
// first part (the html)
        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(htmlText, "text/html");
// add it
        this.multipart.addBodyPart(messageBodyPart);
    }
// -----

    /**
     * Añade al mensaje un cid:name utilizado para guardar las imagenes
     * referenciadas en el HTML de la forma <img src=cid:name />
     *
     * @param cidname identificador que se le da a la imagen. suele ser un
     * string generado aleatoriamente.
     * @param pathname ruta del fichero que almacena la imagen
     * @throws Exception excepcion levantada en caso de error
     */
    public void addCID(String cidname, String pathname) throws Exception {
        DataSource fds = new FileDataSource(pathname);
        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setDataHandler(new DataHandler(fds));
        messageBodyPart.setHeader("Content-ID", "<" + cidname + ">");
        this.multipart.addBodyPart(messageBodyPart);
    }
// ----

    /**
     * Añade un attachement al mensaje de email
     *
     * @param pathname ruta del fichero
     * @throws Exception excepcion levantada en caso de error
     */
    public void addAttach(String pathname) throws Exception {
        File file = new File(pathname);
        BodyPart messageBodyPart = new MimeBodyPart();
        DataSource ds = new FileDataSource(file);
        messageBodyPart.setDataHandler(new DataHandler(ds));
        messageBodyPart.setFileName(file.getName());
        messageBodyPart.setDisposition(Part.ATTACHMENT);
        this.multipart.addBodyPart(messageBodyPart);
    }
// ----

    /**
     * Envia un correo multipart
     *
     * @throws Exception Excepcion levantada en caso de error
     */
    public void sendMultipart() throws Exception {
        Session mailSession = Session.getDefaultInstance(this.props, null);
        mailSession.setDebug(true);
        Transport transport = mailSession.getTransport();
        MimeMessage message = new MimeMessage(mailSession);
        message.setSubject(this.getSubject());
        message.setFrom(new InternetAddress(this.getFrom()));
        message.addRecipient(Message.RecipientType.TO,
                new InternetAddress(this.getTo()));
// put everything together
        message.setContent(multipart);
        transport.connect();
        transport.sendMessage(message,
                message.getRecipients(Message.RecipientType.TO));
        transport.close();
    }
// -----

    /**
     * Envia un correo simple
     *
     * @throws Exception Excepcion levantada en caso de error
     */
    public void send() throws Exception {
        try {
            Session mailSession = Session.getDefaultInstance(this.props, null);
            mailSession.setDebug(true);
            Transport transport = mailSession.getTransport();
            MimeMessage message = new MimeMessage(mailSession);
            message.setSubject(this.getSubject());
            message.setFrom(new InternetAddress(this.getFrom()));
            message.setContent(this.getContent(), "text/html");
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(this.getTo()));
            transport.connect();
            transport.sendMessage(message,
                    message.getRecipients(Message.RecipientType.TO));
            transport.close();
        } catch (Exception e) {
            String MENSAJE_ERROR = ERROR_02_SENDMAIL + " : " + e.toString();
            throw new Exception(MENSAJE_ERROR);
        }
    }
//-----

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
