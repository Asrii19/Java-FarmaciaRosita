
package ClasesBasicas;

/**
 *
 * @author Arnol
 */
public class PRODUCTO {
    int     CODPRODUCTO;
    String  NOMBRE;
    String  DESCRIPCION;
    String  CANTIDAD;

    public PRODUCTO() {
    }

    public PRODUCTO(int CODPRODUCTO, String NOMBRE, String DESCRIPCION, int CODDISTRIBUIDORA, String CANTIDAD) {
        this.CODPRODUCTO = CODPRODUCTO;
        this.NOMBRE = NOMBRE;
        this.DESCRIPCION = DESCRIPCION;
        this.CANTIDAD = CANTIDAD;
    }

    public int getCODPRODUCTO() {
        return CODPRODUCTO;
    }

    public void setCODPRODUCTO(int CODPRODUCTO) {
        this.CODPRODUCTO = CODPRODUCTO;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    public String getCANTIDAD() {
        return CANTIDAD;
    }

    public void setCANTIDAD(String CANTIDAD) {
        this.CANTIDAD = CANTIDAD;
    }
    
}
