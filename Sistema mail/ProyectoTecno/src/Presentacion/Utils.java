/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import javax.swing.table.DefaultTableModel;

public class Utils {
 
    
    public static String mensajeError(String p_parametro) {
        return  "<div class='error'><strong>ERROR!!! </strong><p class='texto-error'>"+p_parametro+"</p></div>";
    }

    public static String mensajeCorrecto(String p_parametro) {
        return  "<div class='correcto'><strong>SUCCEFULL!!! </strong><p class='texto-error'>"+p_parametro+"</p></div>";
    }
    
    public static boolean esNumero(String prt_parametro) {
        try {
            Integer.parseInt(prt_parametro);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static String dibujarTablawithHTML(DefaultTableModel tabla) {
        String tableString = "";
        tableString += "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "<style>\n"
                + ".button {\n"
                + "    background-color: #355bad; /* Blue */\n"
                + "    border: none;\n"
                + "    color: white;\n"
                + "    padding: 5px 15px;\n"
                + "    text-align: center;\n"
                + "    text-decoration: none;\n"
                + "    display: inline-block;\n"
                + "    font-size: 16px;\n"
                + "    margin: 4px 2px;\n"
                + "    cursor: pointer;\n"
                + "}\n"
                + "\n"
                + ".button2 {background-color: #008CBA;} /* Blue */\n"
                + ".button3 {background-color: #f44336;} /* Red */ \n"
                + ".button4 {background-color: #e7e7e7; color: black;} /* Gray */ \n"
                + ".button5 {background-color: #355bad;} /* Blue */"
                + "table {\n"
                + "    border-collapse: collapse;\n"
                + "    width: 100%;\n"
                + "}\n"
                + "\n"
                + "th, td {\n"
                + "    text-align: left;\n"
                + "    padding: 8px;\n"
                + "}\n"
                + "\n"
                + "tr:nth-child(even){background-color: #f2f2f2}\n"
                + "\n"
                + "th {\n"
                + "    background-color: green;\n"
                + "    color: white;\n"
                + "}\n"
                + "</style>\n"
                + "</head>\n"
                + "<body>\n"
                + "<div class=\"w3-container\">\n"
                + "\n"
                + "  <table class=\"w3-table-all\">\n"
                + "    <thead>\n"
                + "<tr class=\"w3-red\">\n";
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            tableString += "<th>" + (tabla.getColumnName(i)) + "</th> \n";
        }
        tableString += "</tr> \n"
                + "</thead> \n";

        for (int i = 0; i < tabla.getRowCount(); i++) {
            tableString += "<tr> \n";
            for (int j = 0; j < tabla.getColumnCount(); j++) {
                tableString += "<td>"
                        + (String.valueOf(tabla.getValueAt(i, j)))
                        + "</td> \n";
            }
            //<a href=\"mailto:" + Constants.MAIL_USERMAIL + "?subject=ELIMINAR\"><button class=\"button button3\">ELIMINAR</button></a>
//            tableString += "<td><a href=\"mailto:" + Variables.MAIL_USERMAIL + "?subject=MODIFICAR\"> <button class=\"button button5\">MODIFICAR</button>  "
//                    + "<a href=\"mailto:" + Variables.MAIL_USERMAIL + "?subject=ELIMINAR\"> <button class=\"button button3\">ELIMINAR</button> </td> \n";

            tableString += "</tr> \n";

        }

        if (tabla.getRowCount() < 1) {
            return "(Tabla Vacia)";
        }
        tableString += "</table>\n"
                + "</div>\n"
                + "\n"
                + "</body>\n"
                + "</html> ";

        return tableString;
    }
}
