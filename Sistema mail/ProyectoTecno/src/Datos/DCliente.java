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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author grupo12sa
 */
public class DCliente {
    
    private Conexion m_Conexion;
    private Connection m_con;
    private Connection con;       
    //atributos de la tabla cliente 
    private int id;
    private int iduser;
    private String ci;
    private String nombre;
    private String apellido;
    private String celular;
    private String direccion;
    
    public DCliente() {
        this.m_Conexion = Conexion.getInstancia();
        this.m_con = m_Conexion.getConexion();
        this.id = 0;
        this.ci = "";
        this.iduser = 0;
        this.nombre = "";
        this.apellido = "";
        this.celular = "";
        this.direccion = "";
    }
    
    public DCliente(int id, int iduser, String nombre, String apellido, String celular, String direccion) {
        this.m_Conexion = Conexion.getInstancia();
        this.m_con = m_Conexion.getConexion();
        this.id = id;
        this.ci = "";
        this.iduser = iduser;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
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

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }
    
    
    
    public DefaultTableModel listar() {
        Statement st;
        
        DefaultTableModel table = new DefaultTableModel();
        table.setColumnIdentifiers(new Object[]{
            "id", "ci","nombre", "apellido", "celular", "direccion"
        });
        
        try {
            st=m_con.createStatement();
            String s_sql="";
            s_sql="SELECT c.* FROM cliente c, \"user\" u WHERE c.iduser = u.id";
            ResultSet r_res = st.executeQuery(s_sql);
            
            while (r_res.next()) {
                table.addRow(new Object[]{
                    r_res.getInt("id"),
                    r_res.getString("ci"),
                    r_res.getString("nombre"),
                    r_res.getString("apellido"),
                    r_res.getString("celular"),
                    r_res.getString("direccion")
                });
                
            }
            return table;
            
        } catch (SQLException ex) {
           Logger.getLogger(DCliente.class.getName()).log(Level.SEVERE, null, ex);
           return table;
        }
    }
    
    public DefaultTableModel getCliente() {
        Statement st;
        
        DefaultTableModel table = new DefaultTableModel();
        table.setColumnIdentifiers(new Object[]{
            "id", "ci","nombre", "apellido", "celular", "direccion"
        });
        
        try {
            st=m_con.createStatement();
            String s_sql="";
            s_sql="SELECT c.* FROM cliente c, \"user\" u WHERE c.iduser = u.id and c.id = " + getId();
            ResultSet r_res = st.executeQuery(s_sql);
            
            while (r_res.next()) {
                table.addRow(new Object[]{
                    r_res.getInt("id"),
                    r_res.getString("ci"),
                    r_res.getString("nombre"),
                    r_res.getString("apellido"),
                    r_res.getString("celular"),
                    r_res.getString("direccion")
                });
                
            }
            return table;
            
        } catch (SQLException ex) {
           Logger.getLogger(DCliente.class.getName()).log(Level.SEVERE, null, ex);
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
            id="";
            
            String s_sql = "insert into \"user\" (\"user\", pass \n)"
                    + " values ( '" + getCi() + "', '" + getCi() + "')";
            
            st.execute(s_sql);
            
            s_sql = "select \"id\" \n" +
                    "from \"user\"\n" +
                    "order by \"id\" desc\n" +
                    "limit 1";
            
            ResultSet r = st.executeQuery(s_sql);
            int id1 = 0;
            while (r.next()) {
                id1 = r.getInt(1);
            }
            
            s_sql = "insert into cliente (ci, nombre, apellido, celular, direccion, iduser \n)"
                    + " values ( '" + getCi() + "','" + getNombre() + "','" + getApellido() + "' ,'" + getCelular() + "','" + getDireccion() + "'," + id1 +")";
            
            st.execute(s_sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DCliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
   
    }
    
    public void actualizar() {
        Statement st;
       
        System.out.println("CELULAR ==> " + getCelular());
        System.out.println("DIRECCION ==> " + getDireccion());
        System.out.println("ID ==> " + getId());
        try {
            
            st = m_con.createStatement();
            
            String s_sql = "update cliente set celular = '" + getCelular() + "', direccion = '" + getDireccion() + "' where id = " + getId();
            
            int c = st.executeUpdate(s_sql);
            if (c > 0) {
                System.out.println("Cliente actualizado correctamente");
            } else {
                System.out.println("Cliente no actualizado correctamente");
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al actualizar el cliente");
            Logger.getLogger(DCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminar() {
        Statement st;
        try {
            
            st = m_con.createStatement();
            
            String s_sql = "delete from cliente where id = " + getId();
            
            st.execute(s_sql);
           
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el cliente");
            Logger.getLogger(DCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
