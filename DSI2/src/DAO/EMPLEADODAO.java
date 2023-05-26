/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ClasesBasicas.*;
import Conexion.*;
import java.util.ArrayList;
import java.sql.*;

public class EMPLEADODAO {
    Coneccion cn = new Coneccion();
    public ArrayList<EMPLEADO> ListEMPLEADO() {
        ArrayList<EMPLEADO> EMPLEADOS = new ArrayList();
        try {
            Connection conex = cn.getConnection();
            Statement st = conex.createStatement();
            ResultSet rs = st.executeQuery("SELECT * "
                    + "  FROM EMPLEADO");
            while (rs.next()) {
                EMPLEADO P1 = new EMPLEADO();
                P1.setCODEMPLEADO(rs.getInt("CODEMPLEADO"));
                P1.setNOMBRE(rs.getString("NOMBRE"));
                P1.setAPELLIDO(rs.getString("APELLIDO"));
                P1.setDNI(rs.getString("DNI"));
                P1.setCELULAR(rs.getString("CELULAR"));
                P1.setFECNAC(rs.getDate("FECNAC"));
                P1.setCODCARGO(rs.getString("CODCARGO"));
                P1.setUSUARIO(rs.getString("USUARIO"));
                P1.setCONTRASENA(rs.getString("CONTRASENA"));
                EMPLEADOS.add(P1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error en listado");
        }
        return EMPLEADOS;
    }

    public void InsertEMPLEADO(EMPLEADO empleado) {
        try {
            Connection conex = cn.getConnection();
            PreparedStatement pst = conex.prepareStatement("INSERT INTO EMPLEADO(CODEMPLEADO,NOMBRE,APELLIDO,DNI,CELULAR,FECNAC,CODCARGO,USUARIO,CONTRASENA)"
                    + " VALUES (?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, empleado.getCODEMPLEADO());
            pst.setString(2, empleado.getNOMBRE());
            pst.setString(3, empleado.getAPELLIDO());
            pst.setString(4, empleado.getDNI());
            pst.setString(5, empleado.getCELULAR());
            pst.setDate(6, empleado.getFECNAC());
            pst.setString(7, empleado.getCODCARGO());
            pst.setString(8, empleado.getUSUARIO());
            pst.setString(9, empleado.getCONTRASENA());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error en agregado");
        }
    }
    public void ModEMPLEADO(EMPLEADO empleado){
        try{
        Connection conex = cn.getConnection();
        PreparedStatement pst = conex.prepareStatement("UPDATE EMPLEADO SET "
                + "NOMBRE=?,APELLIDO=?,DNI=?,CELULAR=?,FECNAC=?,CODCARGO=?"
                + " WHERE CODEMPLEADO=? ");

            pst.setString(1, empleado.getNOMBRE());
            pst.setString(2, empleado.getAPELLIDO());
            pst.setString(3, empleado.getDNI());
            pst.setString(4, empleado.getCELULAR());
            pst.setDate(5, empleado.getFECNAC());
            pst.setString(6, empleado.getCODCARGO());
            pst.setInt(7, empleado.getCODEMPLEADO());
            
            pst.executeUpdate();
        }catch(SQLException ex){
             System.out.print(ex.getMessage());
        }
    }
    public void eliEMPLEADO(EMPLEADO empleado){
        try{
        Connection conex = cn.getConnection();
        PreparedStatement pst = conex.prepareStatement("DELETE FROM EMPLEADO WHERE CODEMPLEADO=?");
        pst.setString(1, String.valueOf(empleado.getCODEMPLEADO()));
        pst.executeUpdate();
        }catch(SQLException ex){
            System.out.print(ex.getMessage());
        }
    }  
    
}
