/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu.packegemetodo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static menu.packageadmin.articulos.articulos.getConection;

/**
 *
 * @author Usuario
 */
public class Factura {
 
int r;

public static final String URL = "jdbc:mysql://localhost:3306/dreamgifts"; //Direccion, puerto y nombre de la Base de Datos
    public static final String USERNAME = "root"; //Usuario de Acceso a MySQL
    public static final String PASSWORD = ""; //Password del usuario
    
    PreparedStatement ps;
    ResultSet rs;

    public static Connection getConection() {
        Connection con = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
           // JOptionPane.showMessageDialog(null, "Conexion exitosa");

        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
}
    
    
  public int RegistrarFactura(compras cd){
        String sql = "INSERT INTO factura_compras (num_factura, fec_factura, proveedores_rut_proveedor) VALUES (?,?,?)";
        
        Connection con = null;
        try {
            con = getConection();
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, cd.getNFacura());
            ps.setString(2, cd.getFFactura());
            ps.setInt(3, cd.getRProveedor());
            ps.execute();
            
        } catch (SQLException e) {
            System.out.println(e.toString());
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return r;
    }
    
}
