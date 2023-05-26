/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesBasicas;
import java.sql.Date;
/**
 *
 * @author MIGUEL LA ROSA
 */
public class EMPLEADO {
    int     CODEMPLEADO;
    String  NOMBRE;
    String  APELLIDO;
    String  DNI;
    String  CELULAR;
    Date    FECNAC;
    String  CODCARGO;
    String  USUARIO;
    String  CONTRASENA;

    public EMPLEADO() {
        this.CODEMPLEADO=0;
    }

    public EMPLEADO(int CODEMPLEADO, String NOMBRE, String APELLIDO, String DNI, String CELULAR, Date FECNAC, String CODCARGO, String USUARIO, String CONTRASENA) {
        this.CODEMPLEADO = CODEMPLEADO;
        this.NOMBRE = NOMBRE;
        this.APELLIDO = APELLIDO;
        this.DNI = DNI;
        this.CELULAR = CELULAR;
        this.FECNAC = FECNAC;
        this.CODCARGO = CODCARGO;
        this.USUARIO = USUARIO;
        this.CONTRASENA = CONTRASENA;
    }

    public int getCODEMPLEADO() {
        return CODEMPLEADO;
    }

    public void setCODEMPLEADO(int CODEMPLEADO) {
        this.CODEMPLEADO = CODEMPLEADO;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getAPELLIDO() {
        return APELLIDO;
    }

    public void setAPELLIDO(String APELLIDO) {
        this.APELLIDO = APELLIDO;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getCELULAR() {
        return CELULAR;
    }

    public void setCELULAR(String CELULAR) {
        this.CELULAR = CELULAR;
    }

    public Date getFECNAC() {
        return FECNAC;
    }

    public void setFECNAC(Date FECNAC) {
        this.FECNAC = FECNAC;
    }

    public String getCODCARGO() {
        return CODCARGO;
    }

    public void setCODCARGO(String CODCARGO) {
        this.CODCARGO = CODCARGO;
    }

    public String getUSUARIO() {
        return USUARIO;
    }

    public void setUSUARIO(String USUARIO) {
        this.USUARIO = USUARIO;
    }

    public String getCONTRASENA() {
        return CONTRASENA;
    }

    public void setCONTRASENA(String CONTRASENA) {
        this.CONTRASENA = CONTRASENA;
    }

    
    
}
