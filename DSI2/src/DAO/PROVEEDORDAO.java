/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ClasesBasicas.PROVEEDOR;
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
public class PROVEEDORDAO {
    Coneccion cn = new Coneccion();
    public ArrayList<PROVEEDOR> ListPROVEEDOR(){
        ArrayList<PROVEEDOR> PROVEEDOR = new ArrayList();
        try{
            Connection conex = cn.getConnection();
            Statement st = conex.createStatement();
            ResultSet rs = st.executeQuery("SELECT * "
                    + "  FROM PROVEEDOR");
            while(rs.next()){
                PROVEEDOR P1 = new PROVEEDOR();
                P1.setCODPROVEEDOR(rs.getInt("CODPROVEEDOR"));
                P1.setNOMBRE(rs.getString("NOMBRE"));
                P1.setDIRECCION(rs.getString("DIRECCION"));
                P1.setTELEFONO(rs.getString("TELEFONO"));
                PROVEEDOR.add(P1);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Error en listado");
        }
        return PROVEEDOR;
    }
    public void InsertPROVEEDOR(PROVEEDOR proveedor){
        try{
        Connection conex = cn.getConnection();
        PreparedStatement pst = conex.prepareStatement("INSERT INTO PROVEEDOR(CODPROVEEDOR,NOMBRE,DIRECCION,TELEFONO)"
                    +" VALUES (?,?,?,?)");
        pst.setInt(1, proveedor.getCODPROVEEDOR());
        pst.setString(2, proveedor.getNOMBRE());
        pst.setString(3,proveedor.getDIRECCION());
        pst.setString(4,proveedor.getTELEFONO());
        pst.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Error en agregado!");}
        }
    public void ModPROVEEDOR(PROVEEDOR proveedor){
        try{
        Connection conex = cn.getConnection();
        PreparedStatement pst = conex.prepareStatement("UPDATE PROVEEDOR SET NOMBRE=?,DIRECCION=?,TELEFONO=? WHERE CODPROVEEDOR=? ");

        pst.setString(1,proveedor.getNOMBRE());
        pst.setString(2,proveedor.getDIRECCION());
        pst.setString(3,proveedor.getTELEFONO());
        pst.setString(4,String.valueOf(proveedor.getCODPROVEEDOR()));
        pst.executeUpdate();
        }catch(SQLException ex){
             System.out.print(ex.getMessage());
             System.out.println("Error en modificar!");
        }
    }
    public void eliPROVEEDOR(PROVEEDOR proveedor){
        try{
        Connection conex = cn.getConnection();
        PreparedStatement pst = conex.prepareStatement("DELETE FROM PROVEEDOR WHERE CODPROVEEDOR=?");
        pst.setString(1, String.valueOf(proveedor.getCODPROVEEDOR()));
        pst.executeUpdate();
        }catch(SQLException ex){
            System.out.print(ex.getMessage());
            System.out.println("Error en eliminar!");
        }
    }  
}
