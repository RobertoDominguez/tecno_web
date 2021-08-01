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
public class DMovil {
    
    private Conexion m_Conexion;
    private Connection m_con;
    private Connection con;
    
    private int id;
    private String placa;
    private String modelo;
    private int anio;
    private String descripcion;
    private int idchofer;
    private int idparada;
    
    public DMovil() {
        this.m_Conexion = Conexion.getInstancia();
        this.m_con = m_Conexion.getConexion();
        this.id = 0;
        this.placa = "";
        this.modelo = "";
        this.anio = 0;
        this.descripcion = "";
        this.idchofer = 0;
        this.idparada = 0;
    }

    public DMovil(int id, String placa, String modelo, int anio, String descripcion, int idchofer, int idparada) {
        this.m_Conexion = Conexion.getInstancia();
        this.m_con = m_Conexion.getConexion();
        this.id = id;
        this.placa = placa;
        this.modelo = modelo;
        this.anio = anio;
        this.descripcion = descripcion;
        this.idchofer = idchofer;
        this.idparada = idparada;
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

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdchofer() {
        return idchofer;
    }

    public void setIdchofer(int idchofer) {
        this.idchofer = idchofer;
    }

    public int getIdparada() {
        return idparada;
    }

    public void setIdparada(int idparada) {
        this.idparada = idparada;
    }
    
    public DefaultTableModel listar() {
        Statement st;
        
        DefaultTableModel table = new DefaultTableModel();
        table.setColumnIdentifiers(new Object[]{
            "id", "placa","modelo", "anio", "descripcion", "chofer", "parada"
        });
        
        try {
            st=m_con.createStatement();
            String s_sql="";
            s_sql="select m.*, p.nombre as parada, c.nombre chofern, c.apellido chofera\n" +
                    "from movil m, chofer c, parada p\n" +
                    "where m.idchofer = c.id and m.idparada = p.id";
            ResultSet r_res = st.executeQuery(s_sql);
            
            while (r_res.next()) {
                table.addRow(new Object[]{
                    r_res.getInt("id"),
                    r_res.getString("placa"),
                    r_res.getString("modelo"),
                    r_res.getString("anio"),
                    r_res.getString("descripcion"),
                    r_res.getString("chofern") + " " + r_res.getString("chofera"),
                    r_res.getString("parada")
                });
            }
            return table;
        } catch (SQLException ex) {
           Logger.getLogger(DMovil.class.getName()).log(Level.SEVERE, null, ex);
           return table;
        }
    }
    
    public DefaultTableModel getMovil() {
        Statement st;
        
        DefaultTableModel table = new DefaultTableModel();
        table.setColumnIdentifiers(new Object[]{
            "id", "placa","modelo", "anio", "descripcion", "chofer", "parada"
        });
        
        try {
            st=m_con.createStatement();
            String s_sql="";
            s_sql="select m.*, p.nombre as parada, c.nombre chofern, c.apellido chofera\n" +
                    "from movil m, chofer c, parada p\n" +
                    "where m.idchofer = c.id and m.idparada = p.id and m.id = " + getId();
            ResultSet r_res = st.executeQuery(s_sql);
            
            while (r_res.next()) {
                table.addRow(new Object[]{
                    r_res.getInt("id"),
                    r_res.getString("placa"),
                    r_res.getString("modelo"),
                    r_res.getString("anio"),
                    r_res.getString("descripcion"),
                    r_res.getString("chofern") + " " + r_res.getString("chofera"),
                    r_res.getString("parada")
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
            
            String s_sql = "insert into movil (placa, modelo, anio, descripcion, idchofer, idparada \n)"
                    + " values ( '" + getPlaca()+ "','" + getModelo()+ "'," + getAnio() + ",'" + getDescripcion() + "'," + getIdchofer()+ "," + getIdparada() + ")";
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
            
            String s_sql = "update movil set descripcion = '" + getDescripcion() 
                        + "', idchofer = " + getIdchofer() + ", idparada = " + getIdparada() + " where id = " + getId();
            int c = st.executeUpdate(s_sql);
            if (c > 0) {
                System.out.println("movil actualizado correctamente");
            } else {
                System.out.println("movil no actualizado correctamente");
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
            
            String s_sql = "delete from movil where id = " + getId();
            
            st.execute(s_sql);
           
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el movil");
            Logger.getLogger(DMovil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
