/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesBasicas;

/**
 *
 * @author arnol
 */
public class PERSONA {
    int     CODCIA;
    int     CODPERSONA;
    String  TIPPERSONA;
    String  DESPERSONA;
    String  DESCORTA;
    String  DESCALTERNA;
    String  DESCORTAALT;
    String VIGENTE;
    public PERSONA() {
    }

    public PERSONA(int CODCIA, int CODPERSONA, String TIPPERSONA, String DESPERSONA, String DESCORTA, String DESCALTERNA, String DESCORTAALT) {
        this.CODCIA = CODCIA;
        this.CODPERSONA = CODPERSONA;
        this.TIPPERSONA = TIPPERSONA;
        this.DESPERSONA = DESPERSONA;
        this.DESCORTA = DESCORTA;
        this.DESCALTERNA = DESCALTERNA;
        this.DESCORTAALT = DESCORTAALT;
    }

    public int getCODCIA() {
        return CODCIA;
    }

    public void setCODCIA(int CODCIA) {
        this.CODCIA = CODCIA;
    }

    public int getCODPERSONA() {
        return CODPERSONA;
    }

    public void setCODPERSONA(int CODPERSONA) {
        this.CODPERSONA = CODPERSONA;
    }

    public String getTIPPERSONA() {
        return TIPPERSONA;
    }

    public void setTIPPERSONA(String TIPPERSONA) {
        this.TIPPERSONA = TIPPERSONA;
    }

    public String getDESPERSONA() {
        return DESPERSONA;
    }

    public void setDESPERSONA(String DESPERSONA) {
        this.DESPERSONA = DESPERSONA;
    }

    public String getDESCORTA() {
        return DESCORTA;
    }

    public void setDESCORTA(String DESCORTA) {
        this.DESCORTA = DESCORTA;
    }

    public String getDESCALTERNA() {
        return DESCALTERNA;
    }

    public void setDESCALTERNA(String DESCALTERNA) {
        this.DESCALTERNA = DESCALTERNA;
    }

    public String getDESCORTAALT() {
        return DESCORTAALT;
    }

    public void setDESCORTAALT(String DESCORTAALT) {
        this.DESCORTAALT = DESCORTAALT;
    }

    public String getVIGENTE() {
        return VIGENTE;
    }

    public void setVIGENTE(String VIGENTE) {
        this.VIGENTE = VIGENTE;
    }

    
}
