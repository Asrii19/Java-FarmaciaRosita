/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesBasicas;

/**
 *
 * @author arnol
 */
public class PROVEEDOR {
    int     CODPROVEEDOR;
    String  NOMBRE;
    String  DIRECCION;
    String  TELEFONO;

    public PROVEEDOR() {
    }

    public PROVEEDOR(int CODPROVEEDOR, String NOMBRE, String DIRECCION, String TELEFONO) {
        this.CODPROVEEDOR = CODPROVEEDOR;
        this.NOMBRE = NOMBRE;
        this.DIRECCION = DIRECCION;
        this.TELEFONO = TELEFONO;
    }

    public int getCODPROVEEDOR() {
        return CODPROVEEDOR;
    }

    public void setCODPROVEEDOR(int CODPROVEEDOR) {
        this.CODPROVEEDOR = CODPROVEEDOR;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getDIRECCION() {
        return DIRECCION;
    }

    public void setDIRECCION(String DIRECCION) {
        this.DIRECCION = DIRECCION;
    }

    public String getTELEFONO() {
        return TELEFONO;
    }

    public void setTELEFONO(String TELEFONO) {
        this.TELEFONO = TELEFONO;
    }
    
}
