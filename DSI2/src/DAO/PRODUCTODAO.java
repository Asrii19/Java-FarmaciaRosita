/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ClasesBasicas.PRODUCTO;
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
public class PRODUCTODAO {
    Coneccion cn = new Coneccion();
    public ArrayList<PRODUCTO> ListPRODUCTO(){
        ArrayList<PRODUCTO> PRODUCTO = new ArrayList();
        try{
            Connection conex = cn.getConnection();
            Statement st = conex.createStatement();
            ResultSet rs = st.executeQuery("SELECT * "
                    + "  FROM PRODUCTO");
            while(rs.next()){
                PRODUCTO P1 = new PRODUCTO();
                P1.setCODPRODUCTO(rs.getInt("CODPRODUCTO"));
                P1.setNOMBRE(rs.getString("NOMBRE"));
                P1.setDESCRIPCION(rs.getString("DESCRIPCION"));
                P1.setCANTIDAD(rs.getString("CANTIDAD"));
                PRODUCTO.add(P1);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Error en listado");
        }
        return PRODUCTO;
        }
    public void InsertPRODUCTO(PRODUCTO producto){
        try{
        Connection conex = cn.getConnection();
        PreparedStatement pst = conex.prepareStatement("INSERT INTO PRODUCTO(CODPRODUCTO,NOMBRE,DESCRIPCION)"
                    +" VALUES (?,?,?)");
        pst.setInt(1, producto.getCODPRODUCTO());
        pst.setString(2, producto.getNOMBRE());
        pst.setString(3, producto.getDESCRIPCION());
        pst.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Error en agregado!");}
        }
    public void ModPRODUCTO(PRODUCTO producto){
        try{
        Connection conex = cn.getConnection();
        PreparedStatement pst = conex.prepareStatement("UPDATE PRODUCTO SET NOMBRE=?,DESCRIPCION=?"
                + "WHERE CODPRODUCTO=?");

        pst.setString(1, producto.getNOMBRE());
        pst.setString(2, producto.getDESCRIPCION());
        pst.setString(3,String.valueOf(producto.getCODPRODUCTO()));
        pst.executeUpdate();
        }catch(SQLException ex){
             System.out.print(ex.getMessage());
        }
    }
    public void ModificarCantidad(PRODUCTO producto){
        try{
        Connection conex = cn.getConnection();
        PreparedStatement pst = conex.prepareStatement("UPDATE PRODUCTO SET CANTIDAD=? "
                + "WHERE CODPRODUCTO=?");

        pst.setString(1, producto.getCANTIDAD());
        pst.setString(2,String.valueOf(producto.getCODPRODUCTO()));
        pst.executeUpdate();
        }catch(SQLException ex){
             System.out.print(ex.getMessage());
        }
    }
    public void eliPRODUCTO(PRODUCTO producto){
        try{
        Connection conex = cn.getConnection();
        PreparedStatement pst = conex.prepareStatement("DELETE FROM PRODUCTO WHERE CODPRODUCTO=?");
        pst.setString(1, String.valueOf(producto.getCODPRODUCTO()));
        pst.executeUpdate();
        }catch(SQLException ex){
            System.out.print(ex.getMessage());
        }
    }  
}
