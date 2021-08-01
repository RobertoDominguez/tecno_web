/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DMovil;
import Presentacion.Utils;

/**
 *
 * @author grupo12sa
 */
public class NMovil {
    
    private DMovil dmovil;
    
    public NMovil() {
        dmovil = new DMovil();
    }
    
    public String listar(String[] params) {
        
        if (params.length > 0) {
            if (params[0].length() > 0) {
                int id = Integer.parseInt(params[0]);
                dmovil.setId(id);
                return Utils.dibujarTablawithHTML(dmovil.getMovil());
            } else {
                return Utils.dibujarTablawithHTML(dmovil.listar());
            }
        } else {
            return Utils.dibujarTablawithHTML(dmovil.listar());
        }
        
    }
    
    public String registrar(String[] params) {
        
        if (params.length == 6) {
            dmovil.setPlaca(params[0]);
            dmovil.setModelo(params[1]);
            dmovil.setAnio(Integer.parseInt(params[2]));
            dmovil.setDescripcion(params[3]);
            dmovil.setIdchofer(Integer.parseInt(params[4]));
            dmovil.setIdparada(Integer.parseInt(params[5]));
            dmovil.registrar();
            return Utils.mensajeCorrecto("Se registro correctamente el movil");
        } else {
            return Utils.mensajeError("No se proporcionaron los paramatros necesarios.");
        }
    }
    
    public String actualizar(String[] params) {
        
        if (params.length == 4) {
            dmovil.setId(Integer.parseInt(params[0]));
            dmovil.setDescripcion(params[1]);
            dmovil.setIdchofer(Integer.parseInt(params[2]));
            dmovil.setIdparada(Integer.parseInt(params[3]));
            dmovil.actualizar();
            return Utils.mensajeCorrecto("Se actualizo correctamente el movil");
        } else {
            return Utils.mensajeError("No se proporcionaron los paramatros necesarios o existen algunos por demas.");
        }
    }
    
    public String eliminar(String[] params) {
        
        if (params.length == 1) {
            dmovil.setId(Integer.parseInt(params[0]));
            dmovil.eliminar();
            return Utils.mensajeCorrecto("Se elimino correctamente el movil");
        } else {
            return Utils.mensajeError("No se proporcionaron los paramatros necesarios o existen algunos por demas.");
        }
    }
    
}
