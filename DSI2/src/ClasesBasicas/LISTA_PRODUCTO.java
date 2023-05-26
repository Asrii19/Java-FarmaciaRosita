/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesBasicas;

import java.sql.Date;

/**
 *
 * @author arnol
 */
public class LISTA_PRODUCTO {
    int     CODLISTAPRODUCTO;
    int     CODPRODUCTO;
    Date    FECVENC;
    int     CODPROVEEDOR;
    String  CANTIDAD;

    public LISTA_PRODUCTO() {
    }

    public LISTA_PRODUCTO(int CODLISTAPRODUCTO, int CODPRODUCTO, Date FECVENC, int CODPROVEEDOR, String CANTIDAD) {
        this.CODLISTAPRODUCTO = CODLISTAPRODUCTO;
        this.CODPRODUCTO = CODPRODUCTO;
        this.FECVENC = FECVENC;
        this.CODPROVEEDOR = CODPROVEEDOR;
        this.CANTIDAD = CANTIDAD;
    }

    public int getCODLISTAPRODUCTO() {
        return CODLISTAPRODUCTO;
    }

    public void setCODLISTAPRODUCTO(int CODLISTAPRODUCTO) {
        this.CODLISTAPRODUCTO = CODLISTAPRODUCTO;
    }

    public int getCODPRODUCTO() {
        return CODPRODUCTO;
    }

    public void setCODPRODUCTO(int CODPRODUCTO) {
        this.CODPRODUCTO = CODPRODUCTO;
    }

    public Date getFECVENC() {
        return FECVENC;
    }

    public void setFECVENC(Date FECVENC) {
        this.FECVENC = FECVENC;
    }

    public int getCODPROVEEDOR() {
        return CODPROVEEDOR;
    }

    public void setCODPROVEEDOR(int CODPROVEEDOR) {
        this.CODPROVEEDOR = CODPROVEEDOR;
    }

    public String getCANTIDAD() {
        return CANTIDAD;
    }

    public void setCANTIDAD(String CANTIDAD) {
        this.CANTIDAD = CANTIDAD;
    }
    
}
