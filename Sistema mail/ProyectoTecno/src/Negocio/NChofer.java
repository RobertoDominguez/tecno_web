/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DChofer;
import Presentacion.Utils;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author grupo12sa
 */
public class NChofer {
    
    private DChofer dchofer;
    
    public NChofer() {
        dchofer = new DChofer();
    }
    
    public String listar(String[] params) {
        
       if (params.length > 0) {
            if (params[0].length() > 0) {
                int id = Integer.parseInt(params[0]);
                dchofer.setId(id);
                DefaultTableModel lista = dchofer.getChofer();
                return Utils.dibujarTablawithHTML(lista);
            } else {
                DefaultTableModel lista = dchofer.listar();
                return Utils.dibujarTablawithHTML(lista);
            }
           
        } else {
           DefaultTableModel lista = dchofer.listar();
           return Utils.dibujarTablawithHTML(lista);
        }
        
    }
    
    public String registrar(String[] params) {
        
        if (params.length == 6) {
            dchofer.setCi(params[0]);
            dchofer.setNombre(params[1]);
            dchofer.setApellido(params[2]);
            dchofer.setLicencia(params[3]);
            dchofer.setCelular(params[4]);
            dchofer.setDireccion(params[5]);
            dchofer.registrar();
            return Utils.mensajeCorrecto("Se registro correctamente el chofer");
        } else {
            return Utils.mensajeError("No se proporcionaron los paramatros necesarios.");
        }
        
    }
    
    public String actualizar(String[] params) {
        
       if (params.length == 3) {
           dchofer.setId(Integer.parseInt(params[0]));
           dchofer.setCelular(params[1]);
           dchofer.setDireccion(params[2]);
           dchofer.actualizar();
           return Utils.mensajeCorrecto("Se actualizo correctamente el chofer");
       } else {
          return Utils.mensajeError("No se proporcionaron los paramatros necesarios o existen paramatros por demas.");
       }
    }
    
    public String eliminar(String[] params) {
        
        if (params.length == 1) {
            dchofer.setId(Integer.parseInt(params[0]));
            dchofer.eliminar();
            return Utils.mensajeCorrecto("Se eliminó correctamente el chofer"); 
        } else {
            return Utils.mensajeError("No se proporcionaron los paramatros necesarios o existen paramatros por demas.");
        }
        
    }
    
}
