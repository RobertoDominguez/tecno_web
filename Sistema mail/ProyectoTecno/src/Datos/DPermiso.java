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
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author grupo12sa
 */
public class DPermiso {
    private Conexion m_Conexion;
    private Connection m_con;
    private Connection con;
    
    private int id;
    private String motivo;
    private String fecha;
    private String fecha_inicio;
    private String fecha_fin;
    private int idchofer;
    
    public DPermiso() {
        this.m_Conexion = Conexion.getInstancia();
        this.m_con = m_Conexion.getConexion();
        this.id = 0;
        this.motivo = "";
        this.fecha = "";
        this.fecha_inicio = "";
        this.fecha_fin = "";
        this.idchofer = 0;
    }

    public DPermiso(int id, String motivo, String fecha, String fecha_inicio, String fecha_fin, int idchofer) {
        this.m_Conexion = Conexion.getInstancia();
        this.m_con = m_Conexion.getConexion();
        this.id = id;
        this.motivo = motivo;
        this.fecha = fecha;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.idchofer = idchofer;
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

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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

    public int getIdchofer() {
        return idchofer;
    }

    public void setIdchofer(int idchofer) {
        this.idchofer = idchofer;
    }
    
    public DefaultTableModel listar() {
        
       Statement st;
        
        DefaultTableModel table = new DefaultTableModel();
        table.setColumnIdentifiers(new Object[]{
            "id", "motivo", "fecha", "fecha_inicio", "fecha_fin", "chofer"
        });
        
        try {
            st=m_con.createStatement();
            String s_sql = "";
            s_sql = "select p.*, c.nombre as chofern, c.apellido as chofera\n" +
                    "from permiso p, chofer c\n" +
                    "where p.idchofer = c.id";
            ResultSet r_res = st.executeQuery(s_sql);
            
            while (r_res.next()) {
                table.addRow(new Object[]{
                    r_res.getInt("id"),
                    r_res.getString("motivo"),
                    r_res.getString("fecha"),
                    r_res.getString("fecha_inicio"),
                    r_res.getString("fecha_fin"),
                    r_res.getString("chofern") + " " + r_res.getString("chofera")
                });
            }
            return table;
        } catch (SQLException ex) {
           Logger.getLogger(DMovil.class.getName()).log(Level.SEVERE, null, ex);
           return table;
        } 
        
    }
    
    public DefaultTableModel getPermiso() {
        
       Statement st;
        
        DefaultTableModel table = new DefaultTableModel();
        table.setColumnIdentifiers(new Object[]{
            "id", "motivo", "fecha", "fecha_inicio", "fecha_fin", "chofer"
        });
        
        try {
            st=m_con.createStatement();
            String s_sql = "select p.*, c.nombre as chofern, c.apellido as chofera\n" +
                    "from permiso p, chofer c\n" +
                    "where p.idchofer = c.id and p.id = " + getId();
            ResultSet r_res = st.executeQuery(s_sql);
            
            while (r_res.next()) {
                table.addRow(new Object[]{
                    r_res.getInt("id"),
                    r_res.getString("nombre"),
                    r_res.getString("fecha"),
                    r_res.getString("fecha_inicio"),
                    r_res.getString("fecha_fin"),
                    r_res.getString("chofern") + " " + r_res.getString("chofera")
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
            
            String s_sql = "insert into permiso (motivo, fecha, fecha_inicio, fecha_fin, idchofer \n)"
                    + " values ( '" + getMotivo()+ "','" + getFecha()+ "','" + getFecha_inicio()+ "','" + getFecha_fin() + "'," + getIdchofer() + ")";
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
            
            String s_sql = "update permiso set motivo = '" + getMotivo() + "', fecha = '" + getFecha()+ 
                           "', fecha_inicio = '" + getFecha_inicio()+ "', fecha_fin = '" + getFecha_fin()+ "' where id = " + getId();
            System.out.println("QUERY => " + s_sql);
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
            
            String s_sql = "delete from permiso where id = " + getId();
            
            st.execute(s_sql);
           
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el permiso");
            Logger.getLogger(DCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Integer> getPermisosPorMes() {
        
        Statement st;
        ArrayList<Integer> list = new ArrayList();
        
        try {
           st = m_con.createStatement();
          Calendar c = new GregorianCalendar();
            int mcurrent = c.get(Calendar.MONTH);
            int yearpiv = c.get(Calendar.YEAR);
            int i = 0;
            while (i < 12) {
                if (i > mcurrent && mcurrent != -1) {
                    mcurrent = -1;
                    yearpiv = yearpiv - 1;
                }
                String f1 = getDateString(yearpiv, i + 1, 1);
                String f2;
                if (i == 11) {
                    f2 = getDateString(yearpiv + 1, 1, 1);
                } else {
                    f2 = getDateString(yearpiv, i + 2, 1);
                }

                String sql = "select count(*)\n" +
                            "from permiso\n" +
                            "where fecha >= '" + f1 + "' and fecha < '" + f2 + "'";
                System.out.println(sql);
                ResultSet r = st.executeQuery(sql);
                int count = 0;
                while (r.next()) {
                    count = r.getInt(1);
                }
                
                list.add(count);
                i++;
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el cliente");
            Logger.getLogger(DCliente.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList();
        }
        
    }
    
    public String getDateString(int year, int mount, int day) {
        
        String m = mount + "";
        if (mount < 10) {
            m = "0" + m;
        }
        return year + "-" + m + "-0" + day;
    }
    
}
