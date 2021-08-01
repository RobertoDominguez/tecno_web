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
public class DTarifa {
    private Conexion m_Conexion;
    private Connection m_con;
    private Connection con;
    
    private int id;
    private String nombre;
    private String tramo;
    private double precio;
    private int idservicio;
    
    public DTarifa() {
        this.m_Conexion = Conexion.getInstancia();
        this.m_con = m_Conexion.getConexion();
        this.id = 0;
        this.nombre = "";
        this.tramo = "";
        this.precio = 0.0;
        this.idservicio = 0;
    }

    public DTarifa(int id, String nombre, String tramo, double precio, int idservicio) {
        this.id = id;
        this.nombre = nombre;
        this.tramo = tramo;
        this.precio = precio;
        this.idservicio = idservicio;
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

    public String getTramo() {
        return tramo;
    }

    public void setTramo(String tramo) {
        this.tramo = tramo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(int idservicio) {
        this.idservicio = idservicio;
    }
    
    public DefaultTableModel listar() {
        
       Statement st;
        
        DefaultTableModel table = new DefaultTableModel();
        table.setColumnIdentifiers(new Object[]{
            "id", "nombre", "tramo", "precio", "idservicio"
        });
        
        try {
            st=m_con.createStatement();
            String s_sql = "";
            s_sql = "select * from tarifa";
            ResultSet r_res = st.executeQuery(s_sql);
            
            while (r_res.next()) {
                table.addRow(new Object[]{
                    r_res.getInt("id"),
                    r_res.getString("nombre"),
                    r_res.getString("tramo"),
                    r_res.getString("precio"),
                    r_res.getString("idservicio")
                });
            }
            return table;
        } catch (SQLException ex) {
           Logger.getLogger(DMovil.class.getName()).log(Level.SEVERE, null, ex);
           return table;
        } 
        
    }
    
    public DefaultTableModel getTarifa() {
        
       Statement st;
        
        DefaultTableModel table = new DefaultTableModel();
        table.setColumnIdentifiers(new Object[]{
            "id", "nombre", "tramo", "precio", "idservicio"
        });
        
        try {
            st=m_con.createStatement();
            String s_sql = "";
            s_sql = "select * from tarifa where id = " + getId();
            ResultSet r_res = st.executeQuery(s_sql);
            
            while (r_res.next()) {
                table.addRow(new Object[]{
                    r_res.getInt("id"),
                    r_res.getString("nombre"),
                    r_res.getString("tramo"),
                    r_res.getString("precio"),
                    r_res.getString("idservicio")
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
            
            String s_sql = "insert into tarifa (nombre, tramo, precio, idservicio \n)"
                    + " values ( '" + getNombre()+ "','" + getTramo()+ "'," + getPrecio()+ "," + getIdservicio()+  ")";
            st.execute(s_sql);
             
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DMovil.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean actualizar() {
        Statement st;
        try {
            
            st = m_con.createStatement();
            
            String s_sql = "update tarifa set nombre = '" + getNombre()+ "', tramo = '" + getTramo() + 
                           "', precio = " + getPrecio() + ", idservicio = " + getIdservicio() + " where id = " + getId();
            
            st.executeUpdate(s_sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al actualizar la tarifa");
            Logger.getLogger(DCliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public void eliminar() {
        Statement st;
        try {
            
            st = m_con.createStatement();
            
            String s_sql = "delete from tarifa where id = " + getId();
            
            st.execute(s_sql);
           
        } catch (SQLException ex) {
            System.out.println("Error al eliminar la tarifa");
            Logger.getLogger(DCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
