/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ClasesBasicas.CLIENTE;
import Conexion.Coneccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author arnol
 */
public class CLIENTEDAO {
    Coneccion cn = new Coneccion();
    public ArrayList<CLIENTE> ListCLIENTE(){
        ArrayList<CLIENTE> CLIENTE = new ArrayList();
        try{
            Connection conex = cn.getConnection();
            Statement st = conex.createStatement();
            ResultSet rs = st.executeQuery("SELECT * "
                    + "  FROM CLIENTE");
            while(rs.next()){
                CLIENTE P1 = new CLIENTE();
                P1.setCODCLIENTE(rs.getInt("CODCLIENTE"));
                P1.setNOMBRE(rs.getString("NOMBRE"));
                P1.setAPELLIDO(rs.getString("APELLIDO"));
                P1.setDNI(rs.getString("DNI"));
                P1.setCELULAR(rs.getString("CELULAR"));
                CLIENTE.add(P1);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Error en listado");}
        return CLIENTE;
        }
    public void InsertCLIENTE(CLIENTE cliente){
        try{
        Connection conex = cn.getConnection();
        PreparedStatement pst = conex.prepareStatement("INSERT INTO CLIENTE(CODCLIENTE,NOMBRE,APELLIDO,DNI,CELULAR)"
                    +" VALUES (?,?,?,?,?)");
        pst.setInt(1, cliente.getCODCLIENTE());
        pst.setString(2, cliente.getNOMBRE());
        pst.setString(3, cliente.getAPELLIDO());
        pst.setString(4, cliente.getDNI());
        pst.setString(5, cliente.getCELULAR());
        pst.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Error en agregado!");}
        }
    public void ModCLIENTE(CLIENTE cliente){
        try{
        Connection conex = cn.getConnection();
        PreparedStatement pst = conex.prepareStatement("UPDATE CLIENTE SET NOMBRE=?,APELLIDO=?,DNI=?,CELULAR=? "
                + "WHERE CODCLIENTE=?");

        pst.setString(1, cliente.getNOMBRE());
        pst.setString(2, cliente.getAPELLIDO());
        pst.setString(3, cliente.getDNI());
        pst.setString(4, cliente.getCELULAR());
        pst.setString(5,String.valueOf(cliente.getCODCLIENTE()));
        pst.executeUpdate();
        }catch(SQLException ex){
             System.out.print(ex.getMessage());
        }
    }
    public void eliCLIENTE(CLIENTE cliente){
        try{
        Connection conex = cn.getConnection();
        PreparedStatement pst = conex.prepareStatement("DELETE FROM CLIENTE WHERE CODCLIENTE=?");
        pst.setString(1, String.valueOf(cliente.getCODCLIENTE()));
        pst.executeUpdate();
        }catch(SQLException ex){
            System.out.print(ex.getMessage());
        }
    }  
}
