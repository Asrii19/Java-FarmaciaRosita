/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import ClasesBasicas.*;
import DAO.*;
import java.awt.Image;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author arnol
 */
public class ControllerMetodos {
    
    EMPLEADODAO emp_dao =new EMPLEADODAO();
    PROVEEDORDAO pro_dao = new PROVEEDORDAO();
    CLIENTEDAO cli_dao = new CLIENTEDAO();
    PRODUCTODAO prod_dao = new PRODUCTODAO();
    PEDIDODAO ped_dao = new PEDIDODAO();
    LISTA_PRODUCTODAO prodlista_dao = new LISTA_PRODUCTODAO();
    
    public void TamanoDinamico(String direccion, javax.swing.JLabel Borde,JPanel jp){
        ImageIcon imagen = new ImageIcon(getClass().getResource(direccion));
        Icon fondo1=new ImageIcon((imagen.getImage().getScaledInstance(Borde.getWidth(), Borde.getHeight(), Image.SCALE_DEFAULT)));
        Borde.setIcon(fondo1);
        jp.repaint();
    }
    public int mayor_codemp(){
        int mayor=0;
        List<EMPLEADO> lista = emp_dao.ListEMPLEADO();
        Object ob; 
        for(int i=0; i < lista.size(); i++){
            ob = lista.get(i).getCODEMPLEADO();
            if((int)ob>mayor){
                mayor=(int)ob;
            }
        }
        return mayor;
    }
    public int mayor_codpro(){
        int mayor=0;
        List<PROVEEDOR> lista = pro_dao.ListPROVEEDOR();
        Object ob; 
        for(int i=0; i < lista.size(); i++){
            ob = lista.get(i).getCODPROVEEDOR();
            if((int)ob>mayor){
                mayor=(int)ob;
            }
        }
        return mayor;
    }
    public int mayor_codcli(){
        int mayor=0;
        List<CLIENTE> lista = cli_dao.ListCLIENTE();
        Object ob; 
        for(int i=0; i < lista.size(); i++){
            ob = lista.get(i).getCODCLIENTE();
            if((int)ob>mayor){
                mayor=(int)ob;
            }
        }
        return mayor;
    }
    public int mayor_codprod(){
        int mayor=0;
        List<PRODUCTO> lista = prod_dao.ListPRODUCTO();
        Object ob; 
        for(int i=0; i < lista.size(); i++){
            ob = lista.get(i).getCODPRODUCTO();
            if((int)ob>mayor){
                mayor=(int)ob;
            }
        }
        return mayor;
    }
    public int mayor_codlistaprod(){
        int mayor=0;
        List<LISTA_PRODUCTO> lista = prodlista_dao.ListLISTA_PRODUCTO();
        Object ob; 
        for(int i=0; i < lista.size(); i++){
            ob = lista.get(i).getCODLISTAPRODUCTO();
            if((int)ob>mayor){
                mayor=(int)ob;
            }
        }
        return mayor;
    }
    public int mayor_codped(){
        int mayor=0;
        List<PEDIDO> lista = ped_dao.ListPEDIDO();
        Object ob; 
        for(int i=0; i < lista.size(); i++){
            ob = lista.get(i).getCODPED();
            if((int)ob>mayor){
                mayor=(int)ob;
            }
        }
        return mayor;
    }
}
