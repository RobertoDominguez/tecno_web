/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DCliente;
import Presentacion.Utils;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author grupo12sa
 */
public class NCliente {
    
    private DCliente dcliente;
    
    public NCliente() {
        dcliente = new DCliente();
    }
    
    public String listar(String[] params) {
        
        if (params.length > 0) {
            if (params[0].length() > 0) {
                int id = Integer.parseInt(params[0]);
                dcliente.setId(id);
                DefaultTableModel lista = dcliente.getCliente();
                return Utils.dibujarTablawithHTML(lista);
            } else {
                DefaultTableModel lista = dcliente.listar();
                return Utils.dibujarTablawithHTML(lista);
            }
           
        } else {
           DefaultTableModel lista = dcliente.listar();
           return Utils.dibujarTablawithHTML(lista);
        }
        
    }
    
    public String registrar(String[] params) {
        
        if (params.length == 5) {
            dcliente.setCi(params[0]);
            dcliente.setNombre(params[1]);
            dcliente.setApellido(params[2]);
            dcliente.setCelular(params[3]);
            dcliente.setDireccion(params[4]);
            dcliente.registrar();
            return Utils.mensajeCorrecto("Se registro correctamente el cliente");
        } else {
            return Utils.mensajeError("No se proporcionaron los paramatros necesarios.");
        }
    }
    
    public String actualizar(String[] params) {
        
       if (params.length == 3) {
           dcliente.setId(Integer.parseInt(params[0]));
           dcliente.setCelular(params[1]);
           dcliente.setDireccion(params[2]);
           dcliente.actualizar();
           return Utils.mensajeCorrecto("Se actualizo correctamente el cliente");
       } else {
          return Utils.mensajeError("No se proporcionaron los paramatros necesarios o existen paramatros por demas.");
       }
    }
    
    public String eliminar(String[] params) {
        
        if (params.length == 1) {
            dcliente.setId(Integer.parseInt(params[0]));
            dcliente.eliminar();
            return Utils.mensajeCorrecto("Se eliminó correctamente el cliente"); 
        } else {
            return Utils.mensajeError("No se proporcionaron los paramatros necesarios o existen paramatros por demas.");
        }
        
    }
    
    private boolean validarParaListClientes(String[] prt_parametros) {
        if (prt_parametros.length!=1) {
            return false;
        }
        if (!Utils.esNumero(prt_parametros[0])) {
            return false;
        }
        return true;
    }
}
