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
public class DParada {
    private Conexion m_Conexion;
    private Connection m_con;
    private Connection con;
    
    private int id;
    private String nombre;
    private String descripcion;
    private String direccion;
    
    public DParada() {
        this.m_Conexion = Conexion.getInstancia();
        this.m_con = m_Conexion.getConexion();
        this.id = 0;
        this.nombre = "";
        this.descripcion = "";
        this.direccion = "";
    }

    public DParada(int id, String nombre, String descripcion, String direccion) {
        this.m_Conexion = Conexion.getInstancia();
        this.m_con = m_Conexion.getConexion();
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.direccion = direccion;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public DefaultTableModel listar() {
        Statement st;
        
        DefaultTableModel table = new DefaultTableModel();
        table.setColumnIdentifiers(new Object[]{
            "id", "nombre", "descripcion", "direccion"
        });
        
        try {
            st=m_con.createStatement();
            String s_sql="";
            s_sql="select * from paradas";
            ResultSet r_res = st.executeQuery(s_sql);
            
            while (r_res.next()) {
                table.addRow(new Object[]{
                    r_res.getInt("id"),
                    r_res.getString("name"),
                    r_res.getString("address"),
                    r_res.getString("description")
                });
            }
            return table;
        } catch (SQLException ex) {
           Logger.getLogger(DParada.class.getName()).log(Level.SEVERE, null, ex);
           return table;
        }
    }
    
    public DefaultTableModel getParada() {
        Statement st;
        
        DefaultTableModel table = new DefaultTableModel();
        table.setColumnIdentifiers(new Object[]{
            "id", "nombre", "descripcion", "direccion"
        });
        
        try {
            st=m_con.createStatement();
            String s_sql="";
            s_sql="select * from parada where id = " + getId();
            ResultSet r_res = st.executeQuery(s_sql);
            
            while (r_res.next()) {
                table.addRow(new Object[]{
                    r_res.getInt("id"),
                    r_res.getString("nombre"),
                    r_res.getString("descripcion"),
                    r_res.getString("direccion")
                });
            }
            return table;
        } catch (SQLException ex) {
           Logger.getLogger(DParada.class.getName()).log(Level.SEVERE, null, ex);
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
            
            String s_sql = "insert into parada (nombre, descripcion, direccion \n)"
                    + " values ( '" + getNombre()+ "','" + getDescripcion()+ "','" + getDireccion()+ "')";
            st.execute(s_sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DParada.class.getName()).log(Level.SEVERE, null, ex);
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
            
            String s_sql = "update parada set nombre = '" + getNombre()
                        + "', descripcion = '" + getDescripcion()+ "', direccion = '" + getDireccion()+ "' where id = " + getId();
            int c = st.executeUpdate(s_sql);
            if (c > 0) {
                System.out.println("Parada actualizado correctamente");
            } else {
                System.out.println("Parada no actualizada correctamente");
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
            
            String s_sql = "delete from parada where id = " + getId();
            
            st.execute(s_sql);
           
        } catch (SQLException ex) {
            System.out.println("Error al eliminar la parada");
            Logger.getLogger(DMovil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
