/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ClasesBasicas.PEDIDO;
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
public class PEDIDODAO {
    Coneccion cn = new Coneccion();
    public ArrayList<PEDIDO> ListPEDIDO(){
        ArrayList<PEDIDO> PEDIDO = new ArrayList();
        try{
            Connection conex = cn.getConnection();
            Statement st = conex.createStatement();
            ResultSet rs = st.executeQuery("SELECT * "
                    + "  FROM PEDIDO");
            while(rs.next()){
                PEDIDO P1 = new PEDIDO();
                P1.setCODPED(rs.getInt("CODPEDIDO"));
                P1.setCODCLIENTE(rs.getInt("CODCLIENTE"));
                P1.setCODEMPLEADO(rs.getInt("CODEMPLEADO"));
                P1.setFECHA(rs.getDate("FECHA_ACTUAL"));
                P1.setTIPOPAGO(rs.getString("TIPO_PAGO"));
                P1.setCANTIDAD(rs.getString("TOTAL"));
                PEDIDO.add(P1);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Error en listado1");
        }
        return PEDIDO;
        }
    public void InsertPEDIDO(PEDIDO producto){
        try{
        Connection conex = cn.getConnection();
        PreparedStatement pst = conex.prepareStatement("INSERT INTO PEDIDO(CODPEDIDO,CODCLIENTE,CODEMPLEADO,TIPO_PAGO,TOTAL)"
                    +" VALUES (?,?,?,?,?)");
        pst.setInt(1, producto.getCODPED());
        pst.setInt(2, producto.getCODCLIENTE());
        pst.setInt(3, producto.getCODEMPLEADO());
        pst.setString(4, producto.getTIPOPAGO());
        pst.setString(5, producto.getCANTIDAD());
        pst.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Error en agregado!");}
        }

    public void eliPRODUCTO(PEDIDO producto){
        try{
        Connection conex = cn.getConnection();
        PreparedStatement pst = conex.prepareStatement("DELETE FROM PRODUCTO WHERE CODPED=?");
        pst.setString(1, String.valueOf(producto.getCODPED()));
        pst.executeUpdate();
        }catch(SQLException ex){
            System.out.print(ex.getMessage());
        }
    }  
}
