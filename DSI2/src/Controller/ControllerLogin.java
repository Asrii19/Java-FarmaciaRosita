
package Controller;
import ClasesBasicas.EMPLEADO;
import DAO.*;
import Frames.Login;
import java.util.List;

public class ControllerLogin {
    public static int codemp;
    private Login vista;
    private EMPLEADODAO emp_dao=new EMPLEADODAO();
    public ControllerLogin(){
        this.vista=new Login();
    }
    public ControllerLogin(Login l) {
        vista = l;
    }
    public void run(){
        this.vista.setVisible(true);
        this.vista.setLocationRelativeTo(null);
    }
    public Object[] comprobar_usuario(String usuario,String contrasena){
        Object[] ob_aux=new Object[3]; //posicion 1 bandera del login, posicion 2 el cargo del emp
        //SE LISTAN LOS EMPLEADOS Y SE GUARDAN EN UNA VARIABLE
        List<EMPLEADO> lista = emp_dao.ListEMPLEADO();
        for(int i=0; i < lista.size(); i++){ //se corre toda la lista y se compara
            if(lista.get(i).getUSUARIO().equals(usuario)&&lista.get(i).getCONTRASENA().equals(contrasena)){ //si es igual a lo digitado
                setCodemp(lista.get(i).getCODEMPLEADO());
                ob_aux[0]=true;
                ob_aux[1]=obtener_cargo(lista.get(i).getCODCARGO());
                ob_aux[2]=lista.get(i).getNOMBRE();
                return ob_aux;
            }
        }
        ob_aux[0]=false;
        ob_aux[1]="";
        ob_aux[2]="";
        return ob_aux;
    }
    public String obtener_cargo(){
        String cargo="";
        return cargo;
    }
    public String obtener_cargo(String cargo){
        switch(cargo){
            case "1":
                return "G";
            case "2":
                return "Q";
            case "3":
                return "JA";
            default:
                return "";
        }
    }
    public void setCodemp(int e){
        this.codemp = e;
    }
}
