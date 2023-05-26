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
public class EMPRESA {
int     CODCIA;
String  NRORUC;
String  FLGEMPCONSORCIO;
Date    FECINI;
Date    FECFIN;
int     CODEMPRESA;
String  OBSERVAC;
String  VIGENTE;

    public EMPRESA() {
    }

    public EMPRESA(int CODCIA,String NRORUC, String FLGEMPCONSORCIO, Date FECINI, Date FECFIN, int CODEMPRESA, String OBSERVAC, String VIGENTE) {
        this.CODCIA = CODCIA;
        this.NRORUC = NRORUC;
        this.FLGEMPCONSORCIO = FLGEMPCONSORCIO;
        this.FECINI = FECINI;
        this.FECFIN = FECFIN;
        this.CODEMPRESA = CODEMPRESA;
        this.OBSERVAC = OBSERVAC;
        this.VIGENTE = VIGENTE;
    }
    
    public int getCODCIA() {
        return CODCIA;
    }

    public void setCODCIA(int CODCIA) {
        this.CODCIA = CODCIA;
    }
    
    public String getNRORUC() {
        return NRORUC;
    }

    public void setNRORUC(String NRORUC) {
        this.NRORUC = NRORUC;
    }

    public String getFLGEMPCONSORCIO() {
        return FLGEMPCONSORCIO;
    }

    public void setFLGEMPCONSORCIO(String FLGEMPCONSORCIO) {
        this.FLGEMPCONSORCIO = FLGEMPCONSORCIO;
    }

    public Date getFECINI() {
        return FECINI;
    }

    public void setFECINI(Date FECINI) {
        this.FECINI = FECINI;
    }

    public Date getFECFIN() {
        return FECFIN;
    }

    public void setFECFIN(Date FECFIN) {
        this.FECFIN = FECFIN;
    }

    public int getCODEMPRESA() {
        return CODEMPRESA;
    }

    public void setCODEMPRESA(int CODEMPRESA) {
        this.CODEMPRESA = CODEMPRESA;
    }

    public String getOBSERVAC() {
        return OBSERVAC;
    }

    public void setOBSERVAC(String OBSERVAC) {
        this.OBSERVAC = OBSERVAC;
    }

    public String getVIGENTE() {
        return VIGENTE;
    }

    public void setVIGENTE(String VIGENTE) {
        this.VIGENTE = VIGENTE;
    }


}
