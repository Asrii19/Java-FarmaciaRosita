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
public class PEDIDO {
    int    CODPED;
    int    CODCLIENTE;
    int    CODEMPLEADO;
    Date   FECHA;
    String TIPOPAGO;
    String CANTIDAD;

    public PEDIDO() {
    }

    public PEDIDO(int CODPED, int CODCLIENTE, int CODEMPLEADO, Date FECHA, String TIPOPAGO, String CANTIDAD) {
        this.CODPED = CODPED;
        this.CODCLIENTE = CODCLIENTE;
        this.CODEMPLEADO = CODEMPLEADO;
        this.FECHA = FECHA;
        this.TIPOPAGO = TIPOPAGO;
        this.CANTIDAD = CANTIDAD;
    }

    public int getCODPED() {
        return CODPED;
    }

    public void setCODPED(int CODPED) {
        this.CODPED = CODPED;
    }

    public int getCODCLIENTE() {
        return CODCLIENTE;
    }

    public void setCODCLIENTE(int CODCLIENTE) {
        this.CODCLIENTE = CODCLIENTE;
    }

    public int getCODEMPLEADO() {
        return CODEMPLEADO;
    }

    public void setCODEMPLEADO(int CODEMPLEADO) {
        this.CODEMPLEADO = CODEMPLEADO;
    }

    public Date getFECHA() {
        return FECHA;
    }

    public void setFECHA(Date FECHA) {
        this.FECHA = FECHA;
    }

    public String getTIPOPAGO() {
        return TIPOPAGO;
    }

    public void setTIPOPAGO(String TIPOPAGO) {
        this.TIPOPAGO = TIPOPAGO;
    }

    public String getCANTIDAD() {
        return CANTIDAD;
    }

    public void setCANTIDAD(String CANTIDAD) {
        this.CANTIDAD = CANTIDAD;
    }

    
}
