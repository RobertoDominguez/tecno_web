/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DParada;
import Presentacion.Utils;

/**
 *
 * @author grupo12sa
 */
public class NParada {
    
    private DParada dparada;
    
    public NParada() {
        dparada = new DParada();
    }
    
    public String listar(String[] params) {
        
        if (params.length > 0) {
            if (params[0].length() > 0) {
                dparada.setId(Integer.parseInt(params[0]));
                return Utils.dibujarTablawithHTML(dparada.getParada());
            } else {
                return Utils.dibujarTablawithHTML(dparada.listar());
            }
        } else {
            return Utils.dibujarTablawithHTML(dparada.listar());
        }
        
    }
    
    public String registrar(String[] params) {
        
        if (params.length == 3) {
            dparada.setNombre(params[0]);
            dparada.setDescripcion(params[1]);
            dparada.setDireccion(params[2]);
            dparada.registrar();
            return Utils.mensajeCorrecto("Se registro correctamente la parada");
        } else {
            return Utils.mensajeError("No se proporcionaron los paramatros necesarios.");
        }
        
    }
    
    public String actualizar(String[] params) {
        
       if (params.length == 4) {
           dparada.setId(Integer.parseInt(params[0]));
           dparada.setNombre(params[1]);
           dparada.setDescripcion(params[2]);
           dparada.setDireccion(params[3]);
           dparada.actualizar();
           return Utils.mensajeCorrecto("Se actualizo correctamente la parada.");
       } else {
          return Utils.mensajeError("No se proporcionaron los paramatros necesarios o existen paramatros por demas.");
       }
    }
    
    public String eliminar(String[] params) {
        
        if (params.length == 1) {
            dparada.setId(Integer.parseInt(params[0]));
            dparada.eliminar();
            return Utils.mensajeCorrecto("Se eliminó correctamente la parada"); 
        } else {
            return Utils.mensajeError("No se proporcionaron los paramatros necesarios o existen paramatros por demas.");
        }
        
    }
    
}
