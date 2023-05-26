/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import ClasesBasicas.LISTA_PRODUCTO;
import ClasesBasicas.PRODUCTO;
import ClasesBasicas.PROVEEDOR;
import DAO.LISTA_PRODUCTODAO;
import DAO.PRODUCTODAO;
import DAO.PROVEEDORDAO;
import Frames.FiltrarFV;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author arnol
 */
public class ControllerFiltrarFV {
    private FiltrarFV vista;
    private LISTA_PRODUCTODAO listprod_dao = new LISTA_PRODUCTODAO();
    private PRODUCTODAO prod_dao = new PRODUCTODAO();
    private PROVEEDORDAO pro_dao = new PROVEEDORDAO();
    
    LocalDate fechaActual = LocalDate.now();
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String fechaFormateada = fechaActual.format(formato);
    
    public ControllerFiltrarFV() {
        vista = new FiltrarFV();
    }

    public ControllerFiltrarFV(FiltrarFV vista) {
        this.vista = vista;
    }
    
    public void run() {
        vista.setVisible(true); //hacer visible
        vista.panelMes.setVisible(false);
        vista.panelTrimestre.setVisible(false);
        vista.panelSemestre.setVisible(false);
        vista.panelAnio.setVisible(false);
    }

    public FiltrarFV getVista() {
        return vista;
    }

    public void setVista(FiltrarFV vista) {
        this.vista = vista;
    }
    
    //VISIBLE EL CRUD
    public void visible_mes(){
        //HACER VISIBLE EL PANEL CREATE
        vista.panelMes.setVisible(true);
        //OCULTA LOS OTROS
        vista.panelTrimestre.setVisible(false);
        vista.panelSemestre.setVisible(false);
        vista.panelAnio.setVisible(false);
    }
    public void visible_trimestre(){
        //HACER VISIBLE EL PANEL READ
        vista.panelTrimestre.setVisible(true);
        //OCULTA LOS OTROS
        vista.panelMes.setVisible(false);
        vista.panelSemestre.setVisible(false);
        vista.panelAnio.setVisible(false);
    }
    public void visible_semestre(){
        //HACER VISIBLE EL PANEL UPDATE
        vista.panelSemestre.setVisible(true);
        //OCULTA LOS OTROS
        vista.panelMes.setVisible(false);
        vista.panelTrimestre.setVisible(false);
        vista.panelAnio.setVisible(false);
    }
    public void visible_anio(){
        //HACER VISIBLE EL PANEL DELETE
        vista.panelAnio.setVisible(true);
        //OCULTA LOS OTROS
        vista.panelMes.setVisible(false);
        vista.panelTrimestre.setVisible(false);
        vista.panelSemestre.setVisible(false);
    }
    //metodos
    //Método que remueve datos de la tabla para actualizarla
    public void limpiarTabla(){
        for(int i = 0; i < vista.modelo.getRowCount();i++){
            vista.modelo.removeRow(i);
            i=i-1;
        }
    }

    public String obtener_ProductoCod(String nom){
        String id="";
        List<PRODUCTO> lista=prod_dao.ListPRODUCTO();
        for(int i=0;i<lista.size();i++){
            if(nom.equals(lista.get(i).getNOMBRE())){
                id=Integer.toString(lista.get(i).getCODPRODUCTO());
                break;
            }
        }
        return id;
    }
    public String obtener_ProductoNombre(int cod){
        String nombre="";
        
        List<PRODUCTO> lista=prod_dao.ListPRODUCTO();
        for(int i=0;i<lista.size();i++){
            if(cod==lista.get(i).getCODPRODUCTO()){
                nombre=lista.get(i).getNOMBRE();
                break;
            }
        }
        
        return nombre;
    }
    public String obtener_ProveedorCod(String nom){
        String id="";
        List<PROVEEDOR> lista=pro_dao.ListPROVEEDOR();
        for(int i=0;i<lista.size();i++){
            if(nom.equals(lista.get(i).getNOMBRE())){
                id=Integer.toString(lista.get(i).getCODPROVEEDOR());
                break;
            }
        }
        return id;
    }
    public String obtener_ProveedorNombre(int cod){
        String nombre="";
        
        List<PROVEEDOR> lista=pro_dao.ListPROVEEDOR();
        for(int i=0;i<lista.size();i++){
            if(cod==lista.get(i).getCODPROVEEDOR()){
                nombre=lista.get(i).getNOMBRE();
                break;
            }
        }
        
        return nombre;
    }
    //READ
    //Método para obtiene los datos de los empleado y muestra en una tabla
    public void listar(int filtro){
        List<LISTA_PRODUCTO> lista_prod = listprod_dao.ListLISTA_PRODUCTO();
        
        vista.modelo = (DefaultTableModel)vista.tabla.getModel();
        vista.sorter = new TableRowSorter<> (vista.modelo);
        vista.tabla.setRowSorter(vista.sorter);
        
        Object[] ob = new Object[7]; 
        
        for(int i=0;i<lista_prod.size();i++){
            int dia=Integer.parseInt(lista_prod.get(i).getFECVENC().toString().substring(8,10));
            int mes=Integer.parseInt(lista_prod.get(i).getFECVENC().toString().substring(5,7));
            int anio=Integer.parseInt(lista_prod.get(i).getFECVENC().toString().substring(0,4));
            int dia_actual=Integer.parseInt(fechaFormateada.substring(8,10));
            int mes_actual=Integer.parseInt(fechaFormateada.substring(5,7));
            int anio_actual=Integer.parseInt(fechaFormateada.substring(0,4));
            switch(filtro){
                case 1:
                    if(anio>=anio_actual){
                        if(mes-mes_actual==1){
                            ob[0]=lista_prod.get(i).getCODLISTAPRODUCTO();
                            ob[1]=obtener_ProductoNombre(lista_prod.get(i).getCODPRODUCTO());
                            ob[2]=lista_prod.get(i).getFECVENC();
                            ob[3]=obtener_ProveedorNombre(lista_prod.get(i).getCODPROVEEDOR());
                            ob[4]=lista_prod.get(i).getCANTIDAD();
                            vista.modelo.addRow(ob);
                        }else if(mes-mes_actual==0){
                            if(dia-dia_actual<=31&&dia-dia_actual>=0){
                                ob[0]=lista_prod.get(i).getCODLISTAPRODUCTO();
                                ob[1]=obtener_ProductoNombre(lista_prod.get(i).getCODPRODUCTO());
                                ob[2]=lista_prod.get(i).getFECVENC();
                                ob[3]=obtener_ProveedorNombre(lista_prod.get(i).getCODPROVEEDOR());
                                ob[4]=lista_prod.get(i).getCANTIDAD();
                                vista.modelo.addRow(ob);
                            }
                        }
                    }
                    vista.tabla.setModel(vista.modelo);
                    break;
                case 3:
                    if(anio>=anio_actual){
                        if(mes-mes_actual==3){
                            if(dia-dia_actual<=0){
                                ob[0]=lista_prod.get(i).getCODLISTAPRODUCTO();
                                ob[1]=obtener_ProductoNombre(lista_prod.get(i).getCODPRODUCTO());
                                ob[2]=lista_prod.get(i).getFECVENC();
                                ob[3]=obtener_ProveedorNombre(lista_prod.get(i).getCODPROVEEDOR());
                                ob[4]=lista_prod.get(i).getCANTIDAD();
                                vista.modelo.addRow(ob);
                            }
                        }else if(mes-mes_actual<3&&mes-mes_actual>0){
                            ob[0]=lista_prod.get(i).getCODLISTAPRODUCTO();
                            ob[1]=obtener_ProductoNombre(lista_prod.get(i).getCODPRODUCTO());
                            ob[2]=lista_prod.get(i).getFECVENC();
                            ob[3]=obtener_ProveedorNombre(lista_prod.get(i).getCODPROVEEDOR());
                            ob[4]=lista_prod.get(i).getCANTIDAD();
                            vista.modelo.addRow(ob);
                        }else if(mes-mes_actual==0){
                            if(dia-dia_actual<=31&&dia-dia_actual>=0){
                                ob[0]=lista_prod.get(i).getCODLISTAPRODUCTO();
                                ob[1]=obtener_ProductoNombre(lista_prod.get(i).getCODPRODUCTO());
                                ob[2]=lista_prod.get(i).getFECVENC();
                                ob[3]=obtener_ProveedorNombre(lista_prod.get(i).getCODPROVEEDOR());
                                ob[4]=lista_prod.get(i).getCANTIDAD();
                                vista.modelo.addRow(ob);
                            }
                        }
                    }
                    vista.tabla1.setModel(vista.modelo);
                    break;
                case 6:
                    if(anio>=anio_actual){
                        if(mes-mes_actual==6){
                            if(dia-dia_actual<=0){
                                ob[0]=lista_prod.get(i).getCODLISTAPRODUCTO();
                                ob[1]=obtener_ProductoNombre(lista_prod.get(i).getCODPRODUCTO());
                                ob[2]=lista_prod.get(i).getFECVENC();
                                ob[3]=obtener_ProveedorNombre(lista_prod.get(i).getCODPROVEEDOR());
                                ob[4]=lista_prod.get(i).getCANTIDAD();
                                vista.modelo.addRow(ob);
                            }
                        }else if(mes-mes_actual<6&&mes-mes_actual>0){
                            ob[0]=lista_prod.get(i).getCODLISTAPRODUCTO();
                            ob[1]=obtener_ProductoNombre(lista_prod.get(i).getCODPRODUCTO());
                            ob[2]=lista_prod.get(i).getFECVENC();
                            ob[3]=obtener_ProveedorNombre(lista_prod.get(i).getCODPROVEEDOR());
                            ob[4]=lista_prod.get(i).getCANTIDAD();
                            vista.modelo.addRow(ob);
                        }else if(mes-mes_actual==0){
                            if(dia-dia_actual<=31&&dia-dia_actual>=0){
                                ob[0]=lista_prod.get(i).getCODLISTAPRODUCTO();
                                ob[1]=obtener_ProductoNombre(lista_prod.get(i).getCODPRODUCTO());
                                ob[2]=lista_prod.get(i).getFECVENC();
                                ob[3]=obtener_ProveedorNombre(lista_prod.get(i).getCODPROVEEDOR());
                                ob[4]=lista_prod.get(i).getCANTIDAD();
                                vista.modelo.addRow(ob);
                            }
                        }
                    }
                    vista.tabla2.setModel(vista.modelo);
                    break;
                case 12:
                    if(anio>=anio_actual){
                        if(mes-mes_actual==12){
                            if(dia-dia_actual<=0){
                                ob[0]=lista_prod.get(i).getCODLISTAPRODUCTO();
                                ob[1]=obtener_ProductoNombre(lista_prod.get(i).getCODPRODUCTO());
                                ob[2]=lista_prod.get(i).getFECVENC();
                                ob[3]=obtener_ProveedorNombre(lista_prod.get(i).getCODPROVEEDOR());
                                ob[4]=lista_prod.get(i).getCANTIDAD();
                                vista.modelo.addRow(ob);
                            }
                        }else if(mes-mes_actual<12&&mes-mes_actual>0){
                            ob[0]=lista_prod.get(i).getCODLISTAPRODUCTO();
                            ob[1]=obtener_ProductoNombre(lista_prod.get(i).getCODPRODUCTO());
                            ob[2]=lista_prod.get(i).getFECVENC();
                            ob[3]=obtener_ProveedorNombre(lista_prod.get(i).getCODPROVEEDOR());
                            ob[4]=lista_prod.get(i).getCANTIDAD();
                            vista.modelo.addRow(ob);
                        }else if(mes-mes_actual==0){
                            if(dia-dia_actual<=31&&dia-dia_actual>=0){
                                ob[0]=lista_prod.get(i).getCODLISTAPRODUCTO();
                                ob[1]=obtener_ProductoNombre(lista_prod.get(i).getCODPRODUCTO());
                                ob[2]=lista_prod.get(i).getFECVENC();
                                ob[3]=obtener_ProveedorNombre(lista_prod.get(i).getCODPROVEEDOR());
                                ob[4]=lista_prod.get(i).getCANTIDAD();
                                vista.modelo.addRow(ob);
                            }
                        }
                    }
                    vista.tabla3.setModel(vista.modelo);
                    break;
            }
        }
    }
}
