/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Conexion.Coneccion;
import ClasesBasicas.*;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author MIGUEL LA ROSA
 */
public class PERSONADAO {
    Coneccion cn = new Coneccion();
    public ArrayList<PERSONA> ListPERSONA(){
        ArrayList<PERSONA> PERSONAS = new ArrayList();
        try{
        Connection conex = cn.getConnection();
        Statement st = conex.createStatement();
        ResultSet rs = st.executeQuery("SELECT * "
                + "  FROM PERSONA ORDER BY 2");
            while(rs.next()){
            PERSONA P1 = new PERSONA();
            P1.setCODCIA(rs.getInt("CODCIA"));
            P1.setCODPERSONA(rs.getInt("CODPERSONA"));
            P1.setTIPPERSONA(rs.getString("TIPOPERSONA"));
            P1.setDESPERSONA(rs.getString("DESPERSONA"));
            P1.setDESCORTA(rs.getString("DESCORTA"));
            P1.setDESCALTERNA(rs.getString("DESCALTERA"));
            P1.setDESCORTAALT(rs.getString("DESCORTALT"));
            P1.setVIGENTE(rs.getString("VIGENTE"));
            PERSONAS.add(P1);
            }
        }catch(SQLException ex){
            System.out.println("HOLAPERSONA");
            System.out.println(ex.getMessage());
            System.out.println("Error en listado");}
        return PERSONAS;
        }
    public void InsertPersonas(PERSONA persona){
        try{
        Connection conex = cn.getConnection();
        PreparedStatement pst = conex.prepareStatement("INSERT INTO PERSONA(CODCIA,CODPERSONA,TIPOPERSONA,DESPERSONA,DESCORTA,DESCALTERA,DESCORTALT,VIGENTE)"
                    +" VALUES (?,?,?,?,?,?,?,?)");
        pst.setInt(1, persona.getCODCIA());
        pst.setInt(2, persona.getCODPERSONA());
        pst.setString(3,persona.getTIPPERSONA());
        pst.setString(4,persona.getDESPERSONA());
        pst.setString(5,persona.getDESCORTA());
        pst.setString(6,persona.getDESCALTERNA());
        pst.setString(7,persona.getDESCORTAALT());
        pst.setString(8,persona.getVIGENTE());
        pst.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Error en agregado1");}
        }
    public void ModPERSONA(PERSONA persona){
        try{
        Connection conex = cn.getConnection();
        PreparedStatement pst = conex.prepareStatement("UPDATE PERSONA SET TIPOPERSONA=? ,DESPERSONA=? ,DESCORTA=? ,DESCALTERA=? ,DESCORTALT=?,VIGENTE=? "
                    +" WHERE CODPERSONA=? ");

        pst.setString(1,persona.getTIPPERSONA());
        pst.setString(2,persona.getDESPERSONA());
        pst.setString(3,persona.getDESCORTA());
        pst.setString(4,persona.getDESCALTERNA());
        pst.setString(5,persona.getDESCORTAALT());
        pst.setString(6,persona.getVIGENTE());
        pst.setInt(7, persona.getCODPERSONA());
        pst.executeUpdate();
        }catch(SQLException ex){
             System.out.print(ex.getMessage());
        }
    }
    public void eliPERSONA(PERSONA persona){
        try{
        Connection conex = cn.getConnection();
        PreparedStatement pst = conex.prepareStatement("DELETE FROM PERSONA WHERE CODPERSONA=?");
        pst.setInt(1, persona.getCODPERSONA());
        pst.executeUpdate();
        }catch(SQLException ex){
            System.out.print(ex.getMessage());
        }
    }    
}
