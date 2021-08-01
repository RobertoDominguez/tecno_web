/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentacion;

import Negocio.NChofer;
import Negocio.NCliente;
import Negocio.NMovil;
import Negocio.NParada;
import Negocio.NPermiso;
import Negocio.NPromocion;
import Negocio.NServicio;
import Negocio.NTarifa;
import java.io.IOException;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Manejador {
    private int max = 0;
    private PopMessage m_PopMessage2;
    private SMTPMessage m_SMTPMessage2;
    
    private String g_metodo="";
    private String g_origen="";   

    public Manejador() {
        m_PopMessage2 = new PopMessage();
        max = m_PopMessage2.getSize();
        m_PopMessage2.cerrar();
    }

    public void leer() {
        m_PopMessage2 = new PopMessage();
        if (m_PopMessage2.getSize() > max) {
            max++;
            //analizarLineas(m_PopMessage2.getMessageArray(max));
            boolean estado=analizarLineasSi(m_PopMessage2.getMessageArray(max));
            if (estado) {
                enviar_respuesta_(true);
            }else{
                enviar_respuesta_(false);
            }
        }
        m_PopMessage2.cerrar();
    }

    public void analizarLineas(List<String> messageArray) {
        String lineaMetodo = "";
        String lineaUsuario = "";
        int i=0;
        for (String line : messageArray) {
            //System.out.println(line.toString());
            if (line.contains("Return-Path:")) {
              lineaUsuario = line;
            }
            if (line.contains("Subject:")||line.contains("subject:")) {
                if (line.regionMatches(0, "Subject:", 0,8 )||line.regionMatches(0, "subject:", 0,8 )) {
                    while(!messageArray.get(i).contains("]")){
                        lineaMetodo=lineaMetodo+messageArray.get(i);
                        i++;
                    }
                    lineaMetodo=lineaMetodo+messageArray.get(i);
                }                
            }
            i++;
            }
        System.out.println("linea encontrada=>"+lineaMetodo);
            //i++;
        
        //obtener mail usuario
        String mailFrom = getCorreoEmisor(lineaUsuario);
        System.out.println(mailFrom);
        
            //obtener metodo
            //posisiones para metodo y parametros
            int posIni = lineaMetodo.indexOf("[");
            int posFin = lineaMetodo.indexOf("]");
            String metodo = getMetodo(lineaMetodo, posIni);
            System.out.println("metodo-"+metodo);
            //obtener parametros        
            String[] parametros = getParametros(lineaMetodo, posIni, posFin);
            System.out.println(parametros.toString());
            ejecutarMetodos(metodo, parametros, mailFrom);
        

    }

    private String getMetodo(String lineaMetodo, int posIni) {
        //obtener metodo
        String metodo = lineaMetodo.substring(8, posIni).trim();
        metodo=metodo.toUpperCase();
        if (metodo.length() == 0) {
            metodo = "COMANDOS";
        }
        return metodo;
    }

    private String[] getParametros(String lineaMetodo, int posIni, int posFin) {
        String[] parametros = lineaMetodo.substring(posIni + 1, posFin).split(",");
        return parametros;
    }

    private String getCorreoEmisor(String lineaUsuario) {
        //posiciones para usuario mail
        int posIni1 = lineaUsuario.indexOf("<");
        int posFin1 = lineaUsuario.indexOf(">");
        return lineaUsuario.substring(posIni1 + 1, posFin1);
    }
      private void enviarMensajeCorreoOrigen(String prt_mailFrom, String prt_asunto, String prt_mensaje) {
        m_SMTPMessage2 = new SMTPMessage();
        m_SMTPMessage2.sendMessage("grupo12sa@tecnoweb.org.bo", prt_mailFrom, prt_asunto, prt_mensaje);
        m_SMTPMessage2.cerrar();
    }

    private boolean analizarLineasSi(List<String> messageArray) {
        g_origen="";
        g_metodo="";        
        
        String lineaMetodo = "";
        String lineaUsuario = "";
        int i=0;
        for (String line : messageArray) {
            //System.out.println(line.toString());
            if (line.contains("Return-Path:")) {
              lineaUsuario = line;
              //guardar linea correo origen
              g_origen=lineaUsuario;              
            }
            if (line.contains("Subject:")||line.contains("subject:")) {
                if (line.regionMatches(0, "Subject:", 0,8 )||line.regionMatches(0, "subject:", 0,8 )) {
                    while(!messageArray.get(i).contains("]")){
                        lineaMetodo=lineaMetodo+messageArray.get(i);
                        i++;
                    }
                    
                    lineaMetodo=lineaMetodo+messageArray.get(i);
                    //guardar linea metodo globa;
                    
                    g_metodo=lineaMetodo;
                    return true;
                }                
            }
            i++;
            }
        return false;
    }

    private void enviar_respuesta_(boolean b) {
        if (b) {
            String mailFrom = getCorreoEmisor(g_origen);
            
            int posIni = g_metodo.indexOf("[");
            int posFin = g_metodo.indexOf("]");
            String metodo = getMetodo(g_metodo, posIni);
            
            String[] parametros = getParametros(g_metodo, posIni, posFin);
            
            ejecutarMetodos(metodo, parametros, mailFrom);
        }else{
            System.out.println("lo siento no se pudo mandar no se encontro el metodo.. \r\n");
        }
    }

    private void ejecutarMetodos(String prt_asunto, String[] prt_parametros, String prt_mailFrom) {
        String mensaje = "";
        String respuesta = "";
        System.out.println(prt_asunto + "...\r\n");
        
        NCliente ncliente = new NCliente();
        NChofer nchofer = new NChofer();
        NMovil nmovil = new NMovil();
        NParada nparada = new NParada();
        NPromocion npromocion = new NPromocion();
        NTarifa ntarifa = new NTarifa();
        NPermiso npermiso = new NPermiso();
        NServicio nservicio = new NServicio();
        
        switch (prt_asunto) {
            //domi CASO DE USO #1
           //CLIENTE
            case "LISTCLIENTE": //metodo para listar clientes
                System.out.println(prt_asunto + "...\r\n");
                respuesta = ncliente.listar(prt_parametros);
                enviarMensajeCorreoOrigen(prt_mailFrom, prt_asunto, respuesta);
                break;   
            case "REGCLIENTE":  
                System.out.println(prt_asunto + "...\r\n");
                respuesta = ncliente.registrar(prt_parametros);
                enviarMensajeCorreoOrigen(prt_mailFrom, prt_asunto, respuesta);
                break;
            case "EDITCLIENTE":
                respuesta = ncliente.actualizar(prt_parametros);
                enviarMensajeCorreoOrigen(prt_mailFrom, prt_asunto, respuesta);
                break;
            case "DELCLIENTE":
                respuesta = ncliente.eliminar(prt_parametros);
                enviarMensajeCorreoOrigen(prt_mailFrom, prt_asunto, respuesta);
                break;    
            //CHOFER 
            case "LISTCHOFER":
                respuesta = nchofer.listar(prt_parametros);
                enviarMensajeCorreoOrigen(prt_mailFrom, prt_asunto, respuesta);
                break;
            case "REGCHOFER":
                respuesta = nchofer.registrar(prt_parametros);
                enviarMensajeCorreoOrigen(prt_mailFrom, prt_asunto, respuesta);
                break;
            case "EDITCHOFER":
                respuesta = nchofer.actualizar(prt_parametros);
                enviarMensajeCorreoOrigen(prt_mailFrom, prt_asunto, respuesta);
                break;
            case "DELCHOFER":
                respuesta = nchofer.eliminar(prt_parametros);
                enviarMensajeCorreoOrigen(prt_mailFrom, prt_asunto, respuesta);
                break;
            //ABML MOVILES
            case "LISTMOVIL":
                respuesta = nmovil.listar(prt_parametros);
                enviarMensajeCorreoOrigen(prt_mailFrom, prt_asunto, respuesta);
                break;
            case "REGMOVIL":
                respuesta = nmovil.registrar(prt_parametros);
                enviarMensajeCorreoOrigen(prt_mailFrom, prt_asunto, respuesta);
                break;
            case "EDITMOVIL":
                respuesta = nmovil.actualizar(prt_parametros);
                enviarMensajeCorreoOrigen(prt_mailFrom, prt_asunto, respuesta);
                break;
            case "DELMOVIL":
                respuesta = nmovil.eliminar(prt_parametros);
                enviarMensajeCorreoOrigen(prt_mailFrom, prt_asunto, respuesta);
                break;
            //ABML PARADAS
            case "LISTPARADA":
                respuesta = nparada.listar(prt_parametros);
                enviarMensajeCorreoOrigen(prt_mailFrom, prt_asunto, respuesta);
                break;
            case "REGPARADA":
                respuesta = nparada.registrar(prt_parametros);
                enviarMensajeCorreoOrigen(prt_mailFrom, prt_asunto, respuesta);
                break;
            case "EDITPARADA":
                respuesta = nparada.actualizar(prt_parametros);
                enviarMensajeCorreoOrigen(prt_mailFrom, prt_asunto, respuesta);
                break;    
            case "DELPARADA":
                respuesta = nparada.eliminar(prt_parametros);
                enviarMensajeCorreoOrigen(prt_mailFrom, prt_asunto, respuesta);
                break;
            //ABML PROMOCIONES    
            case "LISTPROMOCION":
                respuesta = npromocion.listar(prt_parametros);
                enviarMensajeCorreoOrigen(prt_mailFrom, prt_asunto, respuesta);
                break;
            case "REGPROMOCION":
                respuesta = npromocion.registrar(prt_parametros);
                enviarMensajeCorreoOrigen(prt_mailFrom, prt_asunto, respuesta);
                break;
            case "EDITPROMOCION":
                respuesta = npromocion.actualizar(prt_parametros);
                enviarMensajeCorreoOrigen(prt_mailFrom, prt_asunto, respuesta);
                break;
            case "DELPROMOCION":
                respuesta = npromocion.eliminar(prt_parametros);
                enviarMensajeCorreoOrigen(prt_mailFrom, prt_asunto, respuesta);
                break;
                
            //ABML TARIFAS
            case "LISTTARIFA":
                respuesta = ntarifa.listar(prt_parametros);
                enviarMensajeCorreoOrigen(prt_mailFrom, prt_asunto, respuesta);
                break;
            case "REGTARIFA":
                respuesta = ntarifa.registrar(prt_parametros);
                enviarMensajeCorreoOrigen(prt_mailFrom, prt_asunto, respuesta);
                break;
            case "EDITTARIFA":
                respuesta = ntarifa.actualizar(prt_parametros);
                enviarMensajeCorreoOrigen(prt_mailFrom, prt_asunto, respuesta);
                break;
            case "DELTARIFA":
                respuesta = ntarifa.eliminar(prt_parametros);
                enviarMensajeCorreoOrigen(prt_mailFrom, prt_asunto, respuesta);
                break;
            //ABML PERMISOS
            case "LISTPERMISO":
                respuesta = npermiso.listar(prt_parametros);
                enviarMensajeCorreoOrigen(prt_mailFrom, prt_asunto, respuesta);
                break;
            case "REGPERMISO":
                respuesta = npermiso.registrar(prt_parametros);
                enviarMensajeCorreoOrigen(prt_mailFrom, prt_asunto, respuesta);
                break;
            case "EDITPERMISO":
                respuesta = npermiso.actualizar(prt_parametros);
                enviarMensajeCorreoOrigen(prt_mailFrom, prt_asunto, respuesta);
                break;
            case "DELPERMISO":
                respuesta = npermiso.eliminar(prt_parametros);
                enviarMensajeCorreoOrigen(prt_mailFrom, prt_asunto, respuesta);
                break;
                
            //ABML SERVICIO    
            case "LISTSERVICIO":
                respuesta = nservicio.listar(prt_parametros);
                enviarMensajeCorreoOrigen(prt_mailFrom, prt_asunto, respuesta);
                break;
            case "REGSERVICIO":
                respuesta = nservicio.registrar(prt_parametros);
                enviarMensajeCorreoOrigen(prt_mailFrom, prt_asunto, respuesta);
                break;
            case "EDITSERVICIO":
                respuesta = nservicio.actualizar(prt_parametros);
                enviarMensajeCorreoOrigen(prt_mailFrom, prt_asunto, respuesta);
                break;
            case "DELSERVICIO":
                respuesta = nservicio.eliminar(prt_parametros);
                enviarMensajeCorreoOrigen(prt_mailFrom, prt_asunto, respuesta);
                break;
                
            //REPORTE
            case "REPORTE":
                respuesta = npromocion.reportePromocion(prt_parametros);
                enviarMensajeCorreoOrigen(prt_mailFrom, prt_asunto, respuesta);
                break;
            //ESTADISTICA
            case "ESTADISTICA":
                respuesta = npermiso.estadisticaPorMes(prt_parametros);
                enviarMensajeCorreoOrigen(prt_mailFrom, prt_asunto, respuesta);
                break;
                
            case "HELP": //metodo para comandos
                System.out.println("La cantidad de caracteres de:"+prt_asunto.length());
                System.out.println("la direccion origen es: "+prt_mailFrom);
                System.out.println("el asunto del mensaje es: "+prt_asunto);
                enviarMensajeCorreoOrigen(prt_mailFrom, prt_asunto,getMensajeAyuda());
                break;     
                

            default:
                 //******************************//
                  //***La cantidad de caracteres deberia ser 13 para el REGESTUDIANTE***/////
                  //******************************//
                System.out.println("La cantidad de caracteres de:"+prt_asunto.length());
                System.out.println("la direccion origen es: "+prt_mailFrom);
                System.out.println("el asunto del mensaje es: "+prt_asunto);
                
                System.out.println(prt_asunto + " no existe ...\r\n");
                String mensaje5 = "<div class='error'><strong>ERROR!!! </strong><p class='texto-error'>en la instruccion porfavor revisa  al enviado HELP[]; de la aplicacion</p></div>";
                enviarMensajeCorreoOrigen(prt_mailFrom, prt_asunto, getMensajeRespuesta(mensaje5));
                break;
                
        }
    }
    
    //******************************//
    //***ESTILO PARA LA VISTA***/////
    //******************************//
    public String getMensajeAyuda(){
        
        String estilo="<link rel='stylesheet' href='https://codepen.io/ingyas/pen/NENBOm.css'>";
        String titulo="<div>\n" +
        " <h2>Comandos de la aplicacion \"Sistema para Radio Movil\"</h2>\n" +
        "</div>";
        String ayuda = "<div class=\"box\">\n" +
                            "<div class=\"box-title\">\n" +
                               "<h3>COMANDOS DE GESTION CLIENTE</h3>\n" +
                            "</div>\n" +
                //CLIENTE
                            "<strong>LISTAR CLIENTES :</strong>\n" +
                            "<p>Listar todos los clientes => LISTCLIENTE[]</p>\n" +
                            "<p>listar un cliente en especifico => LISTCLIENTE[id]</p>\n" +
                           
                            "<strong>REGISTRAR CLIENTES :</strong> \n" +
                            "<p>REGCLIENTE[ci,nombre,apellido,celular,direccion];</p>\n" +
                            "<strong>EJEMPLO DE REGISTRAR CLIENTE :</strong> \n" +
                            "<p>REGCLIENTE[4563534,Maria,Gonzales,78569352,Av. Santos Dumont/ B. 5 de Octubre Nro. 512];</p>\n" +

                            "<strong>EDITAR CLIENTE :</strong>\n" +
                            "<p>EDITCLIENTE[id,celular,direccion];</p> \n" +
                            "<strong>EJEMPLO DE EDITAR CLIENTE :</strong> \n" +
                            "<p>EDITCLIENTE[1,74589632,Av Pirai 2do anillo];</p> \n" +

                            " <strong>ELIMINAR CLIENTE :</strong>\n" +
                            " <p>DELCLIENTE[id];</p>\n" +
                            " <strong>EJEMPLO DE ELIMINAR CLIENTE :</strong>\n" +
                            " <p>DELCLIENTE[1];</p>\n" +
                
                //CHOFER
                            "<div class=\"box-title\">\n" +
                            "<h3>COMANDOS DE GESTION CHOFER</h3>\n" +
                            "</div>\n" +
                
                            "<strong>LISTAR CHOFERES :</strong>\n" +
                            "<p>Listar todos los chofer => LISTCHOFER[]</p>\n" +
                            "<p>Listar un chofer en especifico => LISTCHOFER[id]</p>\n" +
                           
                            "<strong>REGISTRAR CHOFERES :</strong> \n" +
                            "<p>REGCHOFER[ci,nombre,apellido,licencia,celular,direccion];</p>\n" +
                            "<strong>EJEMPLO DE REGISTRAR CHOFER :</strong> \n" +
                            "<p>REGCHOFER[6542367,Mario,Martinez,B,74523698,Av Santos Dumont];</p>\n" +

                            "<strong>EDITAR CHOFER :</strong>\n" +
                            "<p>EDITCHOFER[id,celular,direccion];</p> \n" +
                            "<strong>EJEMPLO DE EDITAR CHOFER :</strong> \n" +
                            "<p>EDITCHOFER[1,78956214,Av Irala];</p> \n" +

                            " <strong>ELIMINAR CHOFER :</strong>\n" +
                            " <p>DELCHOFER[id];</p>\n" +
                            " <strong>EJEMPLO DE ELIMINAR CHOFER :</strong>\n" +
                            " <p>DELCHOFER[1];</p>\n" +
                //MOVIL
                            "<div class=\"box-title\">\n" +
                            "<h3>GESTION MOVILES</h3>\n" +
                            "</div>\n" +
                
                            "<strong>LISTAR MOVILES :</strong>\n" +
                            "<p>Listar todas los moviles => LISTMOVIL[]</p>\n" +
                            "<p>Un movil en especifico => LISTMOVIL[id]</p>\n" +
                           
                            "<strong>REGISTRAR MOVIL :</strong> \n" +
                            "<p>REGMOVIL[placa,modelo,año,descripcion,idchofer,idparada];</p>\n" +
                            "<strong>EJEMPLO DE REGISTRAR MOVIL :</strong> \n" +
                            "<p>REGMOVIL[4258DAC,TOYOTA,2019,Auto de color negro,1,1];</p>\n" +

                            "<strong>EDITAR MOVIL :</strong>\n" +
                            "<p>EDITMOVIL[id,descripcion,idchofer,idparada];</p> \n" +
                            "<strong>EJEMPLO DE EDITAR MOVIL :</strong> \n" +
                            "<p>EDITMOVIL[1,Auto de color Rojo,1,1];</p> \n" +

                            " <strong>ELIMINAR MOVIL :</strong>\n" +
                            " <p>DELMOVIL[id];</p>\n" +
                            " <strong>EJEMPLO DE ELIMINAR MOVIL :</strong>\n" +
                            " <p>DELMOVIL[1];</p>\n" +
                //PARADAS
                            "<div class=\"box-title\">\n" +
                            "<h3>COMANDOS DE GESTION PARADAS</h3>\n" +
                            "</div>\n" +
                
                            "<strong>LISTAR PARADAS :</strong>\n" +
                            "<p>Listar todas las paradas => LISTPARADA[]</p>\n" +
                            "<p>Listar una parada en especifico => LISTPARADA[id]</p>\n" +
                           
                            "<strong>REGISTRAR PARADA :</strong> \n" +
                            "<p>REGPARADA[nombre,descripcion,direccion];</p>\n" +
                            "<strong>EJEMPLO DE REGISTRAR PARADA :</strong> \n" +
                            "<p>REGPARADA[Parada 7,Parada para atender solicitudes de ese Barrio,Av Paragua];</p>\n" +

                            "<strong>EDITAR PARADA :</strong>\n" +
                            "<p>EDITPARADA[id,nombre,descripcion,direccion];</p> \n" +
                            "<strong>EJEMPLO DE EDITAR PARADA :</strong> \n" +
                            "<p>EDITPARADA[1,Parada 7,Parada para atender solicitudes de ese Barrio Z,Av Paragua 2];</p> \n" +

                            " <strong>ELIMINAR Parada :</strong>\n" +
                            " <p>DELPARADA[id];</p>\n" +
                            " <strong>EJEMPLO DE ELIMINAR PARADA :</strong>\n" +
                            " <p>DELPARADA[1];</p>\n" +
                
                //PROMOCIONES
                            "<div class=\"box-title\">\n" +
                            "<h3>COMANDOS DE GESTION PROMOCIONES</h3>\n" +
                            "</div>\n" +
                
                            "<strong>LISTAR PROMOCIONES :</strong>\n" +
                            "<p>Listar todas las promociones => LISTPROMOCION[]</p>\n" +
                            "<p>Listar una promoción en especifico => LISTPROMOCION[id]</p>\n" +
                           
                            "<strong>REGISTRAR PROMOCION :</strong> \n" +
                            "<p>REGPROMOCION[nombre,descripcion,fecha incio,fecha fin,descuento1,nota1,idtarifa1,descuento2,nota2,idtarifa2,...];</p>\n" +
                            "<strong>EJEMPLO DE REGISTRAR PROMOCION :</strong> \n" +
                            "<p>REGPROMOCION[Promocion Navidad,Promocion de Navidad nro 20,2020-12-01,2020-12-31,10,Descuento del 10%,1,5,Descuento del 5%,2];</p>\n" +

                            "<strong>EDITAR PROMOCION :</strong>\n" +
                            "<p>Si coloca un nuevo detalle se reemplazara al anterior, el detalle es opcional.</p>" +
                            "<p>EDITPROMOCION[id,nombre,descripcion,descuento1,nota1,idtarifa1,descuento2,nota2,idtarifa2,...];</p> \n" +
                            "<strong>EJEMPLO DE EDITAR PROMOCION :</strong> \n" +
                            "<p>EDITPROMOCION[1,Promocion Navidad 2,Promocion de Navidad nro 21];</p> \n" +
                            "<p>Para este ejemplo se mantiene el detalle</p>" +

                            " <strong>ELIMINAR PROMOCION :</strong>\n" +
                            " <p>DELPROMOCION[id];</p>\n" +
                            " <strong>EJEMPLO DE ELIMINAR PARADA :</strong>\n" +
                            " <p>DELPROMOCION[1];</p>\n" +
                
                //TARIFAS
                            "<div class=\"box-title\">\n" +
                            "<h3>COMANDOS DE GESTION TARIFAS</h3>\n" +
                            "</div>\n" +
                
                            "<strong>LISTAR TARIFAS :</strong>\n" +
                            "<p>Listar todas las tarifas => LISTTARIFA[]</p>\n" +
                            "<p>Listar una tarifa en especifico => LISTTARIFA[id]</p>\n" +
                           
                            "<strong>REGISTRAR TARIFA :</strong> \n" +
                            "<p>REGTARIFA[nombre,tramo,precio,idservicio];</p>\n" +
                            "<strong>EJEMPLO DE REGISTRAR TARIFA :</strong> \n" +
                            "<p>REGTARIFA[Tarifa X,Entre 1 a 5Km,20,1];</p>\n" +

                            "<strong>EDITAR TARIFA :</strong>\n" +
                            "<p>EDITTARIFA[id,nombre,tramo,precio];</p> \n" +
                            "<strong>EJEMPLO DE EDITAR TARIFA :</strong> \n" +
                            "<p>EDITTARIFA[1,Tarifa Z,de 5 a 10km,50];</p> \n" +

                            " <strong>ELIMINAR TARIFA :</strong>\n" +
                            " <p>DELTARIFA[id];</p>\n" +
                            " <strong>EJEMPLO DE ELIMINAR TARIFA :</strong>\n" +
                            " <p>DELTARIFA[1];</p>\n" +
                //PERMISOS
                            "<div class=\"box-title\">\n" +
                            "<h3>COMANDOS DE GESTION DE PERMISOS</h3>\n" +
                            "</div>\n" +
                
                            "<strong>LISTAR PERMISOS :</strong>\n" +
                            "<p>Listar todas los permisos => LISTPERMISO[]</p>\n" +
                            "<p>Listar una permiso en especifico => LISTPERMISO[id]</p>\n" +
                           
                            "<strong>REGISTRAR PERMISO :</strong> \n" +
                            "<p>REGPERMISO[motivo,fecha,fecha inicio,fecha fin,idchofer];</p>\n" +
                            "<strong>EJEMPLO DE REGISTRAR PERMISO :</strong> \n" +
                            "<p>REGPERMISO[Covid-19,2021-01-14,2021-01-15,2021-01-30,1];</p>\n" +

                            "<strong>EDITAR PERMISO :</strong>\n" +
                            "<p>EDITPERMISO[id,motivo,fecha,fecha inicio,fecha fin];</p> \n" +
                            "<strong>EJEMPLO DE EDITAR PERMISO :</strong> \n" +
                            "<p>EDITPERMISO[1,Covid-19,2021-01-14,2021-01-15,2021-01-30];</p> \n" +

                            " <strong>ELIMINAR PERMISO :</strong>\n" +
                            " <p>DELPERMISO[id];</p>\n" +
                            " <strong>EJEMPLO DE ELIMINAR PERMISO :</strong>\n" +
                            " <p>DELPERMISO[1];</p>\n" +
                
                //SERVICIOS
                            "<div class=\"box-title\">\n" +
                            "<h3>COMANDOS DE GESTION DE SERVICIOS</h3>\n" +
                            "</div>\n" +
                
                            "<strong>LISTAR SERVICIOS :</strong>\n" +
                            "<p>Listar todas los servicios => LISTSERVICIO[]</p>\n" +
                            "<p>Listar una servicio en especifico => LISTSERVICIO[id]</p>\n" +
                           
                            "<strong>REGISTRAR SERVICIO :</strong> \n" +
                            "<p>REGSERVICIO[nombre,descripcion];</p>\n" +
                            "<strong>EJEMPLO DE REGISTRAR SERVICIO :</strong> \n" +
                            "<p>REGSERVICIO[Delivery,Entregas a domicilio];</p>\n" +

                            "<strong>EDITAR SERVICIO :</strong>\n" +
                            "<p>EDITSERVICIO[id,nombre,descripcion];</p> \n" +
                            "<strong>EJEMPLO DE EDITAR PERMISO :</strong> \n" +
                            "<p>EDITSERVICIO[1,Delivery 2,Entregas a domicilio];</p> \n" +

                            " <strong>ELIMINAR SERVICIO :</strong>\n" +
                            " <p>DELSERVICIO[id];</p>\n" +
                            " <strong>EJEMPLO DE ELIMINAR SERVICIO :</strong>\n" +
                            " <p>DELSERVICIO[1];</p>\n" +
                //REPORTES Y ESTADISTICAS
                            "<div class=\"box-title\">\n" +
                            "<h3>COMANDOS DE REPORTES Y ESTADISTICAS</h3>\n" +
                            "</div>\n" +
                            
                             "<strong>REPORTE PROMOCION :</strong>\n" +
                            "<p>REPORTE[fecha inicio, fecha fin];</p> \n" +
                            "<p>Reporte de todas las promociones desde una fecha a otra fecha</p>" +
                            "<p>REPORTE[2020-01-01, 2021-02-28];</p> \n" +
                
                            "<strong>Estadistica de los permisos del ultimo año :</strong>\n" +
                            "<p>ESTADISTICA[];</p> \n" +
                            "<p>Muestra en un diagrama de barras el porcentaje de los permisos solicitados por mes del ultimo año.</p>" +
                            "<p>REPORTE[2020-01-01, 2021-02-28];</p> \n" +
                
                " \n" +
                
                
"</div>";
  
  
        return "Content-Type:text/html;\r\n<html>"
                +estilo               
                +titulo
                +ayuda
                + "</html>";
        
    }
    
    public String getMensajeTabla(String res){
        String estilo="<link rel='stylesheet' href='https://codepen.io/ingyas/pen/NENBOm.css'>";
        return "Content-Type:text/html;\r\n<html>"+estilo+res+"</html>";
                
    }
 
    public String getMensajeRespuesta(String res){
        
        String estilo="<link rel='stylesheet' href='https://codepen.io/ingyas/pen/NENBOm.css'>";
        return "Content-Type:text/html;\r\n<html>"+estilo+res+"</html>";
    }

    
}
