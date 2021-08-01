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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author grupo12sa
 */
public class DServicio {
    
    private Conexion m_Conexion;
    private Connection m_con;
    private Connection con;
    
    private int id;
    private String nombre;
    private String descripcion;
    
    public DServicio() {
        this.m_Conexion = Conexion.getInstancia();
        this.m_con = m_Conexion.getConexion();
        this.id = 0;
        this.nombre = "";
        this.descripcion = "";
    }

    public DServicio(int id, String nombre, String descripcion) {
        this.m_Conexion = Conexion.getInstancia();
        this.m_con = m_Conexion.getConexion();
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
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
    
    public DefaultTableModel listar() {
        Statement st;
        
        DefaultTableModel table = new DefaultTableModel();
        table.setColumnIdentifiers(new Object[]{
            "id", "nombre","descripcion"
        });
        
        try {
            st=m_con.createStatement();
            String s_sql="";
            s_sql = "select * from servicio";
            ResultSet r_res = st.executeQuery(s_sql);
            
            while (r_res.next()) {
                table.addRow(new Object[]{
                    r_res.getInt("id"),
                    r_res.getString("nombre"),
                    r_res.getString("descripcion")
                });
            }
            return table;
        } catch (SQLException ex) {
           Logger.getLogger(DMovil.class.getName()).log(Level.SEVERE, null, ex);
           return table;
        }
    }
    
    public DefaultTableModel getServicio() {
        Statement st;
        
        DefaultTableModel table = new DefaultTableModel();
        table.setColumnIdentifiers(new Object[]{
            "id", "nombre","descripcion"
        });
        
        try {
            st=m_con.createStatement();
            String s_sql="";
            s_sql = "select * from servicio where id = " + getId();
            ResultSet r_res = st.executeQuery(s_sql);
            
            while (r_res.next()) {
                table.addRow(new Object[]{
                    r_res.getInt("id"),
                    r_res.getString("nombre"),
                    r_res.getString("descripcion")
                });
            }
            return table;
        } catch (SQLException ex) {
           Logger.getLogger(DMovil.class.getName()).log(Level.SEVERE, null, ex);
           return table;
        }
    }
    
    public boolean registrar() {
        
        Statement st;
        Statement stmt;
        ResultSet rs;
        String id;
       
        try {
            
            st = m_con.createStatement();
            stmt = m_con.createStatement();
            
            String s_sql = "insert into servicio (nombre, descripcion \n)"
                    + " values ( '" + getNombre()+ "','" + getDescripcion()+ "')";
            st.execute(s_sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DMovil.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean actualizar() {
        
        Statement st;
        Statement stmt;
        ResultSet rs;
        String id;
       
        try {
            
            st = m_con.createStatement();
            stmt = m_con.createStatement();
            
            String s_sql = "update servicio set nombre = '" + getNombre() + "', descripcion = '" + getDescripcion() + 
                    "' where id = " + getId();
            int c = st.executeUpdate(s_sql);
            if (c > 0) {
                System.out.println("servicio actualizado correctamente");
            } else {
                System.out.println("servicio no actualizado correctamente");
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DMovil.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public void eliminar() {
        Statement st;
        try {
            
            st = m_con.createStatement();
            
            String s_sql = "delete from servicio where id = " + getId();
            
            st.execute(s_sql);
           
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el servicio");
            Logger.getLogger(DMovil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
