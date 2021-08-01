/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DTarifa;
import Presentacion.Utils;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author grupo12sa
 */
public class NTarifa {
    
    private DTarifa dtarifa;
    
    public NTarifa() {
        this.dtarifa = new DTarifa();
    }
    
    public String listar(String[] params) {
        
       if (params.length > 0) {
           if (params[0].length() > 0) {
                int id = Integer.parseInt(params[0]);
                dtarifa.setId(id);
                DefaultTableModel lista = dtarifa.getTarifa();
                return Utils.dibujarTablawithHTML(lista);
           } else {
               DefaultTableModel lista = dtarifa.listar();
                return Utils.dibujarTablawithHTML(lista);
           }
           
        } else {
           DefaultTableModel lista = dtarifa.listar();
           return Utils.dibujarTablawithHTML(lista);
        }
        
    }
    
    public String registrar(String[] params) {
        
        if (params.length > 0) {
            dtarifa.setNombre(params[0]);
            dtarifa.setTramo(params[1]);
            dtarifa.setPrecio(Double.parseDouble(params[2]));
            dtarifa.setIdservicio(Integer.parseInt(params[3]));
            dtarifa.registrar();
            return Utils.mensajeCorrecto("Se registro correctamente la tarifa");
        } else {
            return Utils.mensajeError("No se proporcionaron los paramatros necesarios.");
        }
        
    }
    
    public String actualizar(String[] params) {
        
       if (params.length > 0) {
           dtarifa.setId(Integer.parseInt(params[0]));
           dtarifa.setNombre(params[1]);
           dtarifa.setTramo(params[2]);
            dtarifa.setPrecio(Integer.parseInt(params[3]));
           dtarifa.actualizar();
           return Utils.mensajeCorrecto("Se actualizo correctamente la tarifa");
       } else {
          return Utils.mensajeError("No se proporcionaron los paramatros necesarios o existen paramatros por demas.");
       }
    }
    
    public String eliminar(String[] params) {
        
        if (params.length == 1) {
            dtarifa.setId(Integer.parseInt(params[0]));
            dtarifa.eliminar();
            return Utils.mensajeCorrecto("Se eliminó correctamente la tarifa"); 
        } else {
            return Utils.mensajeError("No se proporcionaron los paramatros necesarios o existen paramatros por demas.");
        }
        
    }
    
}
