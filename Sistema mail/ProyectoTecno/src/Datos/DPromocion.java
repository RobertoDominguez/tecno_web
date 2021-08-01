/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author grupo12sa
 */
public class DPromocion {
    
    private Conexion m_Conexion;
    private Connection m_con;
    private Connection con;
    
    private int id;
    private String nombre;
    private String descripcion;
    private String fecha_inicio;
    private String fecha_fin;
    
    public DPromocion() {
        this.m_Conexion = Conexion.getInstancia();
        this.m_con = m_Conexion.getConexion();
        this.id = 0;
        this.nombre = "";
        this.descripcion = "";
        this.fecha_inicio = "";
        this.fecha_fin = "";
    }

    public DPromocion(int id, String nombre, String descripcion, String fecha_inicio, String fecha_fin) {
        this.m_Conexion = Conexion.getInstancia();
        this.m_con = m_Conexion.getConexion();
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    public Conexion getM_Conexion() {
        return m_Conexion;
    }

    public void setM_Conexion(Conexion m_Conexion) {
        this.m_Conexion = m_Conexion;
    }

    public Connection getM_con() {
        return m_con;
    }

    public void setM_con(Connection m_con) {
        this.m_con = m_con;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
    
    public DefaultTableModel listar() {
        Statement st;
        
        DefaultTableModel table = new DefaultTableModel();
        table.setColumnIdentifiers(new Object[]{
            "id", "nombre", "descripcion", "fecha_inicio", "fecha_fin"
        });
        
        try {
            st=m_con.createStatement();
            String s_sql = "";
            s_sql = "select * from promocion";
            ResultSet r_res = st.executeQuery(s_sql);
            
            while (r_res.next()) {
                table.addRow(new Object[]{
                    r_res.getInt("id"),
                    r_res.getString("nombre"),
                    r_res.getString("descripcion"),
                    r_res.getString("fecha_inicio"),
                    r_res.getString("fecha_fin")
                });
            }
            return table;
        } catch (SQLException ex) {
           Logger.getLogger(DMovil.class.getName()).log(Level.SEVERE, null, ex);
           return table;
        }
    }
    
    public DefaultTableModel getPromocion() {
        Statement st;
        
        DefaultTableModel table = new DefaultTableModel();
        table.setColumnIdentifiers(new Object[]{
            "id", "nombre", "descripcion", "fecha_inicio", "fecha_fin"
        });
        
        try {
            st=m_con.createStatement();
            String s_sql = "";
            s_sql = "select * from promocion where id = " + getId();
            ResultSet r_res = st.executeQuery(s_sql);
            
            while (r_res.next()) {
                table.addRow(new Object[]{
                    r_res.getInt("id"),
                    r_res.getString("nombre"),
                    r_res.getString("descripcion"),
                    r_res.getString("fecha_inicio"),
                    r_res.getString("fecha_fin")
                });
            }
            return table;
        } catch (SQLException ex) {
           Logger.getLogger(DMovil.class.getName()).log(Level.SEVERE, null, ex);
           return table;
        }
    }
    
    public boolean registrar(String[] params) {
        
        Statement st;
        Statement stmt;
        ResultSet rs;
        String id;
       
        try {
            
            st = m_con.createStatement();
            stmt = m_con.createStatement();
            
            String s_sql = "insert into promocion (nombre, descripcion, fecha_inicio, fecha_fin \n)"
                    + " values ( '" + getNombre()+ "','" + getDescripcion()+ "','" + getFecha_inicio() + "','" + getFecha_fin()+  "')";
            st.execute(s_sql);
            
            s_sql = "select \"id\" \n" +
                    "from promocion \n" +
                    "order by \"id\" desc\n" +
                    "limit 1";
            
            ResultSet r = st.executeQuery(s_sql);
            int id1 = 0;
            while (r.next()) {
                id1 = r.getInt(1);
            }
            
            int i = 0;
            while ((i+2) < params.length) {
                s_sql = "insert into tarifa_promocion(descuento, nota, idtarifa, idpromocion) values (" 
                        + Integer.parseInt(params[i]) + ",'" + params[i+1] + "'," + Integer.parseInt(params[i+2]) + "," + id1 +")";
                st.execute(s_sql);
                i = i + 3;
            }
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DMovil.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean actualizar(String[] params) {
        Statement st;
        try {
            
            st = m_con.createStatement();
            
            String s_sql = "update promocion set nombre = '" + getNombre()+ "', descripcion = '" + getDescripcion() + 
                           "' where id = " + getId();
            
            st.executeUpdate(s_sql);
            
            if (params.length > 0) {
                s_sql = "delete from tarifa_promocion where idpromocion = " + getId();
                st.execute(s_sql);
                int i = 0;
                //System.out.println("LENGTH PARMAS => " + params.length);
                while ((i+2) < params.length) {
                    s_sql = "insert into tarifa_promocion(descuento, nota, idtarifa, idpromocion) values (" 
                            + Integer.parseInt(params[i]) + ",'" + params[i+1] + "'," + Integer.parseInt(params[i+2]) + "," + getId() + ")";
                    st.execute(s_sql);
                    i = i + 3;
                }
            }
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al actualizar la promocion");
            Logger.getLogger(DCliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public void eliminar() {
        Statement st;
        try {
            
            st = m_con.createStatement();
            
            String s_sql = "delete from tarifa_promocion where idpromocion = " + getId();
            st.execute(s_sql);
            
            s_sql = "delete from promocion where id = " + getId();
            
            st.execute(s_sql);
           
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el cliente");
            Logger.getLogger(DCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public DefaultTableModel reportePromocion(String f1, String f2) {
        Statement st;
        
        DefaultTableModel table = new DefaultTableModel();
        table.setColumnIdentifiers(new Object[]{
            "id", "nombre", "descripcion", "fecha_inicio", "fecha_fin"
        });
        
        try {
            st=m_con.createStatement();
            String s_sql = "";
            s_sql = "select *\n" +
                    "from promocion\n" +
                    "where fecha_inicio > '" + f1 + "' and fecha_fin < '" + f2 + "'";
            ResultSet r_res = st.executeQuery(s_sql);
            
            while (r_res.next()) {
                table.addRow(new Object[]{
                    r_res.getInt("id"),
                    r_res.getString("nombre"),
                    r_res.getString("descripcion"),
                    r_res.getString("fecha_inicio"),
                    r_res.getString("fecha_fin")
                });
            }
            return table;
        } catch (SQLException ex) {
           Logger.getLogger(DMovil.class.getName()).log(Level.SEVERE, null, ex);
           return table;
        }
    }
    
}
