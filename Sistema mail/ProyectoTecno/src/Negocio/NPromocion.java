/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DPromocion;
import Presentacion.Utils;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author grupo12sa
 */
public class NPromocion {
    
    private DPromocion dpromocion;
    
    public NPromocion() {
        this.dpromocion = new DPromocion();
    }
    
    public String listar(String[] params) {
        
       if (params.length > 0) {
           if (params[0].length() > 0) {
                int id = Integer.parseInt(params[0]);
                dpromocion.setId(id);
                DefaultTableModel lista = dpromocion.getPromocion();
                return Utils.dibujarTablawithHTML(lista);
           } else {
                DefaultTableModel lista = dpromocion.listar();
                return Utils.dibujarTablawithHTML(lista);
           }
           
        } else {
           DefaultTableModel lista = dpromocion.listar();
           return Utils.dibujarTablawithHTML(lista);
        }
        
    }
    
        public String registrar(String[] params) {
        
        //if (params.length > 4 && (params.length - 4) % 3 == 0) {
        if (params.length > 4) {
            dpromocion.setNombre(params[0]);
            dpromocion.setDescripcion(params[1]);
            dpromocion.setFecha_inicio(params[2]);
            dpromocion.setFecha_fin(params[3]);
            String[] params2 = new String[params.length - 4];
            int j = 0;
            for (int i = 4; i < params.length; i++) {
                params2[j] = params[i];
                j++;
            }
            dpromocion.registrar(params2);
            return Utils.mensajeCorrecto("Se registro correctamente la promoción");
        } else {
            return Utils.mensajeError("No se proporcionaron los paramatros necesarios.");
        }
        
    }
    
    public String actualizar(String[] params) {
        
       if (params.length > 2) {
            dpromocion.setId(Integer.parseInt(params[0]));
            dpromocion.setNombre(params[1]);
            dpromocion.setDescripcion(params[2]);
           
            String[] params2 = new String[params.length - 3];
            int j = 0;
            for (int i = 3; i < params.length; i++) {
                System.out.println("det => " + params[i]);
                params2[j] = params[i];
                j++;
            }
            
            dpromocion.actualizar(params2);
            return Utils.mensajeCorrecto("Se actualizo correctamente la promoción.");
       } else {
          return Utils.mensajeError("No se proporcionaron los paramatros necesarios.");
       }
    }
    
    public String eliminar(String[] params) {
        
        if (params.length == 1) {
            dpromocion.setId(Integer.parseInt(params[0]));
            dpromocion.eliminar();
            return Utils.mensajeCorrecto("Se eliminó correctamente la promoción"); 
        } else {
            return Utils.mensajeError("No se proporcionaron los paramatros necesarios o existen paramatros por demas.");
        }
        
    }
    
    public String reportePromocion(String[] params) {
        
        if (params.length == 2) {
            return Utils.dibujarTablawithHTML(dpromocion.reportePromocion(params[0], params[1]));
        } else {
            return Utils.mensajeError("No se proporcionaron los paramatros necesarios o existen paramatros por demas.");
        }
        
    }
    
}
