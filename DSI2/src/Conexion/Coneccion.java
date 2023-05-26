/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;
import java.sql.*;
import javax.swing.JOptionPane;
public class Coneccion {
    //Atributos para generar conexión con la BD
    public Connection con;
    String url = "jdbc:oracle:thin:@//localhost:1521/orcl";
    public String User="DSI1";
    public String Pass="12345";
    
    //Método para realizar la conexión con la BD
    
    public Connection getConnection() {
        try {
            String url = "jdbc:oracle:thin:@localhost:1521:orcl";
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            con = DriverManager.getConnection(url,User,Pass);
            System.out.println("Conexion Realizada");
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            System.out.println("Error de conexion");
        }
        return con;
    }
}
