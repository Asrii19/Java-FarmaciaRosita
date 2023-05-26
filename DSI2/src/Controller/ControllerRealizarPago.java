/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import ClasesBasicas.CLIENTE;
import ClasesBasicas.PEDIDO;
import DAO.CLIENTEDAO;
import DAO.LISTA_PRODUCTODAO;
import DAO.PEDIDODAO;
import Frames.RealizarPago;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author arnol
 */
public class ControllerRealizarPago {
    private RealizarPago vista;
    public ControllerPedido cped;
    private LISTA_PRODUCTODAO listprod_dao = new LISTA_PRODUCTODAO();
    private PEDIDODAO ped_dao=new PEDIDODAO();
    private CLIENTEDAO cli_dao = new CLIENTEDAO();
    private ControllerMetodos cmet=new ControllerMetodos();
    
    public static boolean pagar=false;
    
    
    
    public ControllerRealizarPago() {
        vista = new RealizarPago();
    }
    
    public ControllerRealizarPago(ControllerPedido controller) {
        cped = controller;
        vista = new RealizarPago();
    }

    public ControllerRealizarPago(RealizarPago vista) {
        this.vista = vista;
    }
    
    public void run() {
        vista.setVisible(true); //hacer visible
        vista.setLocationRelativeTo(null);
        vista.crp = this;
        listar_combobox();
    }

    public void pagar(){
        int codped = cmet.mayor_codped()+1;
        int codcliente = Integer.parseInt(vista.boxCod.getSelectedItem().toString());
        int codempleado = ControllerLogin.codemp;
        String tipopago="";
        
        if(vista.boxTipoPago.getSelectedItem().toString().equals("Efectivo")){
            tipopago="0";
        }else if(vista.boxTipoPago.getSelectedItem().toString().equals("Tarjeta")){
            tipopago="1";
        }
        String total = vista.txtTotal.getText();
        
        PEDIDO ped = new PEDIDO();
        ped.setCODPED(codped);
        ped.setCODCLIENTE(codcliente);
        ped.setCODEMPLEADO(codempleado);
        ped.setTIPOPAGO(tipopago);
        ped.setCANTIDAD(total);
        ped_dao.InsertPEDIDO(ped); //Añadimos a la base de datos (cliente)
        JOptionPane.showMessageDialog(null, "Pedido registrado!!");
    }
    //LISTARCOMBOBOX
    public void listar_combobox(){
        List<CLIENTE> list_cli=cli_dao.ListCLIENTE();
        for(int i=0;i<list_cli.size();i++){
            vista.boxCod.addItem(Integer.toString(list_cli.get(i).getCODCLIENTE()));
        }
        vista.boxCod.setSelectedIndex(-1);
    }
    //limpiar comboboxes
    public void limpiar_combobox(){
        vista.boxCod.removeAllItems();
    }
    public RealizarPago getVista() {
        return vista;
    }

    public void setVista(RealizarPago vista) {
        this.vista = vista;
    }
}
