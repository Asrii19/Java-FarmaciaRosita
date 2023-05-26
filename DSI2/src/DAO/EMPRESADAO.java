/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ClasesBasicas.*;
import Conexion.*;
import java.util.ArrayList;
import java.sql.*;

public class EMPRESADAO {
    Coneccion cn = new Coneccion();
    public ArrayList<EMPRESA> ListEMPRESA() {
        ArrayList<EMPRESA> EMPRESA = new ArrayList();
        try {
            Connection conex = cn.getConnection();
            Statement st = conex.createStatement();
            ResultSet rs = st.executeQuery("SELECT * "
                    + "  FROM EMPRESA_VTA ORDER BY 2");
            while (rs.next()) {
                EMPRESA P1 = new EMPRESA();
                P1.setCODCIA(rs.getInt("CODCIA"));
                P1.setCODEMPRESA(rs.getInt("CODEMPRESA"));
                P1.setNRORUC(rs.getString("NRORUC"));
                P1.setFLGEMPCONSORCIO(rs.getString("FLGEMPCONSORCIO"));
                P1.setFECINI(rs.getDate("FECINI"));
                P1.setFECFIN(rs.getDate("FECFIN"));
                P1.setOBSERVAC(rs.getString("OBSERVAC"));
                P1.setVIGENTE(rs.getString("VIGENTE"));
                EMPRESA.add(P1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error en listado");
        }
        return EMPRESA;
    }

    public void InsertEMPRESA(EMPRESA empresa) {
        try {
            Connection conex = cn.getConnection();
            PreparedStatement pst = conex.prepareStatement("INSERT INTO EMPRESA_VTA(CODCIA,CODEMPRESA,NRORUC,FLGEMPCONSORCIO,FECINI,FECFIN,OBSERVAC,VIGENTE)"
                    + " VALUES (?,?,?,?,?,?,?,?)");
            pst.setInt(1, empresa.getCODCIA());
            pst.setInt(2, empresa.getCODEMPRESA());
            pst.setString(3, empresa.getNRORUC());
            pst.setString(4, empresa.getFLGEMPCONSORCIO());
            pst.setDate(5, empresa.getFECINI());
            pst.setDate(6, empresa.getFECFIN());
            pst.setString(7, empresa.getOBSERVAC());
            pst.setString(8, empresa.getVIGENTE());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error en agregado");
        }
    }
    public void ModEMPRESA(EMPRESA empresa){
        try{
        Connection conex = cn.getConnection();
        PreparedStatement pst = conex.prepareStatement("UPDATE EMPRESA_VTA SET "
                + "NRORUC=?,FLGEMPCONSORCIO=?,FECINI=?,FECFIN=?,OBSERVAC=?,VIGENTE=?"
                + " WHERE CODEMPRESA=? ");

            
            pst.setString(1,empresa.getNRORUC());
            pst.setString(2,empresa.getFLGEMPCONSORCIO());
            pst.setDate(3,empresa.getFECINI());
            pst.setDate(4,empresa.getFECFIN());
            pst.setString(5,empresa.getOBSERVAC());
            pst.setString(6,empresa.getVIGENTE());
            pst.setInt(7,empresa.getCODEMPRESA());
            
            pst.executeUpdate();
        }catch(SQLException ex){
             System.out.print(ex.getMessage());
        }
    }
    public void eliEMPRESA(EMPRESA empresa){
        try{
        Connection conex = cn.getConnection();
        PreparedStatement pst = conex.prepareStatement("DELETE FROM EMPRESA_VTA WHERE CODEMPRESA=?");
        pst.setString(1, String.valueOf(empresa.getCODEMPRESA()));
        pst.executeUpdate();
        }catch(SQLException ex){
            System.out.print(ex.getMessage());
        }
    }  
}
