/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DPermiso;
import Presentacion.Utils;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author grupo12sa
 */
public class NPermiso {
    
    private DPermiso dpermiso;
    
    public NPermiso() {
        this.dpermiso = new DPermiso();
    }
    
    public String listar(String[] params) {
        
       if (params.length > 0) {
           if (params[0].length() > 0) {
            int id = Integer.parseInt(params[0]);
            dpermiso.setId(id);
            DefaultTableModel lista = dpermiso.getPermiso();
            return Utils.dibujarTablawithHTML(lista);
           } else {
                DefaultTableModel lista = dpermiso.listar();
                return Utils.dibujarTablawithHTML(lista);
           }
           
        } else {
           DefaultTableModel lista = dpermiso.listar();
           return Utils.dibujarTablawithHTML(lista);
        }
        
    }
    
    public String registrar(String[] params) {
        
        if (params.length == 5) {
            dpermiso.setMotivo(params[0]);
            dpermiso.setFecha(params[1]);
            dpermiso.setFecha_inicio(params[2]);
            dpermiso.setFecha_fin(params[3]);
            dpermiso.setIdchofer(Integer.parseInt(params[4]));
            dpermiso.registrar();
            return Utils.mensajeCorrecto("Se registro correctamente la tarifa");
        } else {
            return Utils.mensajeError("No se proporcionaron los paramatros necesarios.");
        }
        
    }
    
    public String actualizar(String[] params) {
        
       if (params.length == 5) {
           dpermiso.setId(Integer.parseInt(params[0]));
           dpermiso.setMotivo(params[1]);
           dpermiso.setFecha(params[2]);
           dpermiso.setFecha_inicio(params[3]);
           dpermiso.setFecha_fin(params[4]);
           dpermiso.actualizar();
           return Utils.mensajeCorrecto("Se actualizo correctamente la tarifa");
       } else {
          return Utils.mensajeError("No se proporcionaron los paramatros necesarios o existen paramatros por demas.");
       }
    }
    
    public String eliminar(String[] params) {
        
        if (params.length == 1) {
            dpermiso.setId(Integer.parseInt(params[0]));
            dpermiso.eliminar();
            return Utils.mensajeCorrecto("Se eliminó correctamente el permiso"); 
        } else {
            return Utils.mensajeError("No se proporcionaron los paramatros necesarios o existen paramatros por demas.");
        }
        
    }
    
    public String estadisticaPorMes(String[] params) {
        
        return dibujarBarrasHtml(dpermiso.getPermisosPorMes());
        
    }
    
    public String dibujarBarrasHtml(ArrayList<Integer> list) {
        
        ArrayList<Integer> porcentajes = getPorcentajes(list);
        
        if (porcentajes.isEmpty()) {
            return Utils.mensajeCorrecto("No existen datos para mostrar el diagrama de barras.");
        }
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Estadistica</title>\n" +
                "    <style>\n" +
                "        .barra {\n" +
                "            height: 30px;\n" +
                "            text-align: center;\n" +
                "            line-height: 30px;\n" +
                "            margin: 20px;\n" +
                "            color: black;\n" +
                "        }\n" +
                "\n" +
                "        .enero {\n" +
                "            width: " + porcentajes.get(0) + "px;\n" +
                "            background-color: red;\n" +
                "        }\n" +
                "\n" +
                "        .febrero {\n" +
                "            width: " + porcentajes.get(1) + "px;\n" +
                "            background-color: blue;\n" +
                "        }\n" +
                "\n" +
                "        .marzo {\n" +
                "            width: " + porcentajes.get(2) + "px;\n" +
                "            background-color: orange;\n" +
                "        }\n" +
                "        .abril {\n" +
                "            width: " + porcentajes.get(3) + "px;\n" +
                "            background-color: olivedrab;\n" +
                "        }\n" +
                "        .mayo {\n" +
                "            width: " + porcentajes.get(4) + "px;\n" +
                "            background-color: gray;\n" +
                "        }\n" +
                "        .junio {\n" +
                "            width: " + porcentajes.get(5) + "px;\n" +
                "            background-color: yellow;\n" +
                "        }\n" +
                "        .julio {\n" +
                "            width: " + porcentajes.get(6) + "px;\n" +
                "            background-color: black;\n" +
                "        }\n" +
                "        .agosto {\n" +
                "            width: " + porcentajes.get(7) + "px;\n" +
                "            background-color: green;\n" +
                "        }\n" +
                "        .septiembre {\n" +
                "            width: " + porcentajes.get(8) + "px;\n" +
                "            background-color: goldenrod;\n" +
                "        }\n" +
                "        .octubre {\n" +
                "            width: " + porcentajes.get(9) + "px;\n" +
                "            background-color: orchid;\n" +
                "        }\n" +
                "        .noviembre {\n" +
                "            width: " + porcentajes.get(10) + "px;\n" +
                "            background-color: purple;\n" +
                "        }\n" +
                "        .diciembre {\n" +
                "            width: " + porcentajes.get(11) + "px;\n" +
                "            background-color: saddlebrown;\n" +
                "        }\n" +
                "        \n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div>\n" +
                "        <div class=\"barra enero\">\n" +
                "            Enero\n" +
                "        </div>\n" +
                "        <div class=\"barra febrero\">\n" +
                "            Febrero\n" +
                "        </div>\n" +
                "        <div class=\"barra marzo\">\n" +
                "            Marzo\n" +
                "        </div>\n" +
                "        <div class=\"barra abril\">\n" +
                "            Abril\n" +
                "        </div>\n" +
                "        <div class=\"barra mayo\">\n" +
                "            Mayo\n" +
                "        </div>\n" +
                "        <div class=\"barra junio\">\n" +
                "            Junio\n" +
                "        </div>\n" +
                "        <div class=\"barra julio\">\n" +
                "            Julio\n" +
                "        </div>\n" +
                "        <div class=\"barra agosto\">\n" +
                "            Agosto\n" +
                "        </div>\n" +
                "        <div class=\"barra septiembre\">\n" +
                "            Septiembre\n" +
                "        </div>\n" +
                "        <div class=\"barra octubre\">\n" +
                "            Octubre\n" +
                "        </div>\n" +
                "        <div class=\"barra noviembre\">\n" +
                "            Noviembre\n" +
                "        </div>\n" +
                "        <div class=\"barra diciembre\">\n" +
                "            Diciembre\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>";
        
    }
    
    public int mayor(ArrayList<Integer> list) {
        
        int my = 0;
        for(int i = 0; i < list.size(); i++) {
            if (list.get(i) > my) {
                my = list.get(i);
            }
        }
        return my;
    }
    
    public ArrayList<Integer> getPorcentajes(ArrayList<Integer> list) {
        
        int s = 0;
        ArrayList<Integer> array = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            s = s + list.get(i);
        }
        if (s > 0) {
            for (int i = 0; i < list.size(); i++) {
                array.add(valueInPixel(Math.round((list.get(i) * 100) / s)));
            }
        }
        
        return array;
        
    }
    
    public int valueInPixel(int porcentaje) {
        return Math.round((porcentaje * 400) / 100);
    }
    
    
}
