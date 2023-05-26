/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ClasesBasicas.LISTA_PRODUCTO;
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
public class LISTA_PRODUCTODAO {
    Coneccion cn = new Coneccion();
    public ArrayList<LISTA_PRODUCTO> ListLISTA_PRODUCTO(){
        ArrayList<LISTA_PRODUCTO> LISTA_PRODUCTO = new ArrayList();
        try{
            Connection conex = cn.getConnection();
            Statement st = conex.createStatement();
            ResultSet rs = st.executeQuery("SELECT * "
                    + "  FROM LISTA_PRODUCTO");
            while(rs.next()){
                LISTA_PRODUCTO P1 = new LISTA_PRODUCTO();
                P1.setCODLISTAPRODUCTO(rs.getInt("CODLISTAPRODUCTO"));
                P1.setCODPRODUCTO(rs.getInt("CODPRODUCTO"));
                P1.setFECVENC(rs.getDate("FECVENC"));
                P1.setCODPROVEEDOR(rs.getInt("CODPROVEEDOR"));
                P1.setCANTIDAD(rs.getString("CANTIDAD"));
                LISTA_PRODUCTO.add(P1);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Error en listado");
        }
        return LISTA_PRODUCTO;
        }
    public void InsertPRODUCTO(LISTA_PRODUCTO lista_producto){
        try{
        Connection conex = cn.getConnection();
        PreparedStatement pst = conex.prepareStatement("INSERT INTO LISTA_PRODUCTO(CODLISTAPRODUCTO,CODPRODUCTO,FECVENC,CODPROVEEDOR,CANTIDAD)"
                    +" VALUES (?,?,?,?,?)");
        pst.setInt(1, lista_producto.getCODLISTAPRODUCTO());
        pst.setInt(2, lista_producto.getCODPRODUCTO());
        pst.setDate(3, lista_producto.getFECVENC());
        pst.setInt(4, lista_producto.getCODPROVEEDOR());
        pst.setString(5, lista_producto.getCANTIDAD());
        
        pst.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Error en agregado!");}
        }
    public void ModPRODUCTO(LISTA_PRODUCTO lista_producto){
        try{
        Connection conex = cn.getConnection();
        PreparedStatement pst = conex.prepareStatement("UPDATE LISTA_PRODUCTO SET CODPRODUCTO=?,FECVENC=?,CODPROVEEDOR=?,CANTIDAD=?"
                + "WHERE CODLISTAPRODUCTO=?");

        pst.setInt(1, lista_producto.getCODPRODUCTO());
        pst.setDate(2, lista_producto.getFECVENC());
        pst.setInt(3, lista_producto.getCODPROVEEDOR());
        pst.setString(4, lista_producto.getCANTIDAD());
        pst.setString(5,String.valueOf(lista_producto.getCODLISTAPRODUCTO()));
        pst.executeUpdate();
        }catch(SQLException ex){
             System.out.print(ex.getMessage());
        }
    }
    public void eliPRODUCTO(LISTA_PRODUCTO lista_producto){
        try{
        Connection conex = cn.getConnection();
        PreparedStatement pst = conex.prepareStatement("DELETE FROM LISTA_PRODUCTO WHERE CODLISTAPRODUCTO=?");
        pst.setString(1, String.valueOf(lista_producto.getCODLISTAPRODUCTO()));
        pst.executeUpdate();
        }catch(SQLException ex){
            System.out.print(ex.getMessage());
        }
    }  
}
