/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DServicio;
import Presentacion.Utils;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author grupo12sa
 */
public class NServicio {
    
    private DServicio dservicio;
    
    public NServicio() {
        dservicio = new DServicio();
    }
    
    public String listar(String[] params) {
        
       if (params.length > 0) {
           if (params[0].length() > 0) {
                int id = Integer.parseInt(params[0]);
                dservicio.setId(id);
                DefaultTableModel lista = dservicio.getServicio();
                return Utils.dibujarTablawithHTML(lista);
           } else {
                DefaultTableModel lista = dservicio.listar();
                return Utils.dibujarTablawithHTML(lista);
           }
           
        } else {
           DefaultTableModel lista = dservicio.listar();
           return Utils.dibujarTablawithHTML(lista);
        }
        
    }
    
    public String registrar(String[] params) {
        
        if (params.length == 2) {
            dservicio.setNombre(params[0]);
            dservicio.setDescripcion(params[1]);
            dservicio.registrar();
            return Utils.mensajeCorrecto("Se registro correctamente el servicio");
        } else {
            return Utils.mensajeError("No se proporcionaron los paramatros necesarios o exitens algunos por demas.");
        }
        
    }
    
    public String actualizar(String[] params) {
        
       if (params.length == 3) {
           dservicio.setId(Integer.parseInt(params[0]));
           dservicio.setNombre(params[1]);
           dservicio.setDescripcion(params[2]);
           dservicio.actualizar();
           return Utils.mensajeCorrecto("Se actualizo correctamente el servicio");
       } else {
          return Utils.mensajeError("No se proporcionaron los paramatros necesarios o existen paramatros por demas.");
       }
    }
    
    public String eliminar(String[] params) {
        
        if (params.length == 1) {
            dservicio.setId(Integer.parseInt(params[0]));
            dservicio.eliminar();
            return Utils.mensajeCorrecto("Se eliminó correctamente el servicio"); 
        } else {
            return Utils.mensajeError("No se proporcionaron los paramatros necesarios o existen paramatros por demas.");
        }
    }
    
}
