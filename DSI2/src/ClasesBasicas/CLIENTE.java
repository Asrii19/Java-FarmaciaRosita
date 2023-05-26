
package ClasesBasicas;

/**
 *
 * @author Arnol
 */
public class CLIENTE {
    int     CODCLIENTE;
    String  NOMBRE;
    String  APELLIDO;
    String  DNI;
    String  CELULAR;

    public CLIENTE() {
    }

    public CLIENTE(int CODCLIENTE, String NOMBRE, String APELLIDO, String DNI, String CELULAR) {
        this.CODCLIENTE = CODCLIENTE;
        this.NOMBRE = NOMBRE;
        this.APELLIDO = APELLIDO;
        this.DNI = DNI;
        this.CELULAR = CELULAR;
    }

    public int getCODCLIENTE() {
        return CODCLIENTE;
    }

    public void setCODCLIENTE(int CODCLIENTE) {
        this.CODCLIENTE = CODCLIENTE;
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
    
}
