/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import ClasesBasicas.*;
import DAO.*;
import Frames.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author arnol
 */
public class ControllerProveedor {
    private Proveedor vista;
    private PROVEEDORDAO pro_dao = new PROVEEDORDAO();
    private ControllerMetodos cmet=new ControllerMetodos();
    
    public ControllerProveedor() {
        vista = new Proveedor();
        inicializar_botones();
        try{
            inicializar_botonesUpdate();
            inicializar_botonesDelete();
            inicializar_boxes();
        }catch(Exception e){
            System.out.println(e);
        }
        vista.txtBuscador.getCaret().setVisible(false);
    }
    public ControllerProveedor(Proveedor e) {
        vista = e;
    }
    public void run() {
        vista.setVisible(true); //hacer visible
        vista.panelCreate.setVisible(false);
        vista.panelRead.setVisible(false);
        vista.panelUpdate.setVisible(false);
        vista.panelDelete.setVisible(false);
    }
    
    //Método que captura la información del cliente
    public void agregar(){
        String codpro = String.valueOf(cmet.mayor_codpro()+1);
        String nombre = vista.txtNombre.getText();
        String telefono = vista.txtTelefono.getText();
        String direccion = vista.txtDireccion.getText();
        
        PROVEEDOR pro = new PROVEEDOR();
        pro.setCODPROVEEDOR(Integer.parseInt(codpro));
        pro.setNOMBRE(nombre);
        pro.setDIRECCION(direccion);
        pro.setTELEFONO(telefono);
        pro_dao.InsertPROVEEDOR(pro); //Añadimos a la base de datos (cliente)
        JOptionPane.showMessageDialog(null, "Proveedor registrado!!");
    }
    //Método para obtiene los datos de los empleado y muestra en una tabla
    public void listar(){
        List<PROVEEDOR> lista_pro = pro_dao.ListPROVEEDOR();
        
        vista.modelo = (DefaultTableModel)vista.tabla.getModel();
        vista.sorter = new TableRowSorter<> (vista.modelo);
        vista.tabla.setRowSorter(vista.sorter);
        
        Object[] ob = new Object[4]; 
        
        for(int i=0;i<lista_pro.size();i++){
            ob[0]=lista_pro.get(i).getCODPROVEEDOR();
            ob[1]=lista_pro.get(i).getNOMBRE();
            ob[2]=lista_pro.get(i).getDIRECCION();
            ob[3]=lista_pro.get(i).getTELEFONO();
            vista.modelo.addRow(ob);
        }
        vista.tabla.setModel(vista.modelo);
    }
    public void listar_busqueda(String consulta){
        List<PROVEEDOR> lista_pro = pro_dao.ListPROVEEDOR();
        vista.modelo = (DefaultTableModel)vista.tabla.getModel();
        vista.sorter = new TableRowSorter<> (vista.modelo);
        vista.tabla.setRowSorter(vista.sorter);
        
        Object[] ob = new Object[7]; 
        
        for(int i=0;i<lista_pro.size();i++){
            ob[0]=lista_pro.get(i).getCODPROVEEDOR();
            ob[1]=lista_pro.get(i).getNOMBRE();
            ob[2]=lista_pro.get(i).getDIRECCION();
            ob[3]=lista_pro.get(i).getTELEFONO();
            if(lista_pro.get(i).getNOMBRE().substring(0,consulta.length()).equalsIgnoreCase(consulta)){
                vista.modelo.addRow(ob);
            }
        }
        vista.tabla.setModel(vista.modelo);
    }
    public PROVEEDOR listar_busquedaUpdate(String consulta){
        List<PROVEEDOR> lista_pro = pro_dao.ListPROVEEDOR();
        PROVEEDOR pro = new PROVEEDOR();
        
        for(int i=0;i<lista_pro.size();i++){
            if(Integer.toString(lista_pro.get(i).getCODPROVEEDOR()).substring(0,consulta.length()).equals(consulta)){
                vista.boxCod.setSelectedIndex(i);
                pro = lista_pro.get(i);
                return pro;
            }
        }
        return pro;
    }
    public PROVEEDOR listar_busquedaDelete(String consulta){
        List<PROVEEDOR> lista_pro = pro_dao.ListPROVEEDOR();
        PROVEEDOR pro = new PROVEEDOR();
        
        for(int i=0;i<lista_pro.size();i++){
            if(Integer.toString(lista_pro.get(i).getCODPROVEEDOR()).substring(0,consulta.length()).equals(consulta)){
                vista.boxCod2.setSelectedIndex(i);
                pro = lista_pro.get(i);
                return pro;
            }
        }
        return pro;
    }
    //Método que captura la información del cliente que se desea actualizar
    public void actualizar(){
        String codproveedor = (String) vista.boxCod.getSelectedItem();
        String nombre = vista.txtNombre1.getText();
        String telefono = vista.txtTelefono1.getText();
        String direccion = vista.txtDireccion1.getText();
        
        PROVEEDOR pro = new PROVEEDOR();
        pro.setCODPROVEEDOR(Integer.parseInt(codproveedor));
        pro.setNOMBRE(nombre);
        pro.setTELEFONO(telefono);
        pro.setDIRECCION(direccion);
        pro_dao.ModPROVEEDOR(pro); //Añadimos a la base de datos (cliente)
        JOptionPane.showMessageDialog(null, "Proveedor actualizado!!");
    }
    //Método que elimina un cliente seleccionado 
    public boolean eliminar(){
        int opcion = JOptionPane.showConfirmDialog(null, "¿Quieres eliminar al proveedor?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            PROVEEDOR pro = new PROVEEDOR();
            pro.setCODPROVEEDOR(Integer.parseInt(vista.boxCod2.getSelectedItem().toString()));
            pro_dao.eliPROVEEDOR(pro);
            return true;
        }else{
            return false;
        }
    }
    //Método que remueve datos de la tabla para actualizarla
    public void limpiarTabla(){
        for(int i = 0; i < vista.modelo.getRowCount();i++){
            vista.modelo.removeRow(i);
            i=i-1;
        }
    }
    //Listar opciones comboboxes
    public void listar_combobox(){
        List<PROVEEDOR> list_pro=pro_dao.ListPROVEEDOR();
        for(int i=0;i<list_pro.size();i++){
            vista.boxCod.addItem(Integer.toString(list_pro.get(i).getCODPROVEEDOR()));
        }
        vista.boxCod.setSelectedIndex(-1);
    }
    public void listar_combobox2(){
        List<PROVEEDOR> list_pro=pro_dao.ListPROVEEDOR();
        for(int i=0;i<list_pro.size();i++){
            vista.boxCod2.addItem(Integer.toString(list_pro.get(i).getCODPROVEEDOR()));
        }
        vista.boxCod2.setSelectedIndex(-1);
    }
    //limpiar comboboxes
    public void limpiar_combobox(){
        vista.boxCod.removeAllItems();
        vista.boxCod2.removeAllItems();
    }
    
    //BOTON BUSQUEDA Y ACTUALIZAR
    //BOTON DE LUPA (BUSCAR)
    private void inicializar_botones(){
        vista.btnLupa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (vista.txtBuscador.getText().isEmpty() || vista.txtBuscador.getText().equalsIgnoreCase("Ingrese nombre del proveedor")) {
                    JOptionPane.showMessageDialog(null, "Digite el nombre a buscar");
                }else{
                    limpiarTabla();
                    listar_busqueda(vista.txtBuscador.getText());
                }
            }
        });
        //BOTON DE CANCELAR BUSQUEDA
        vista.btnActualizar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                vista.txtBuscador.getCaret().setVisible(false);
                vista.txtBuscador.setText("Ingrese nombre del proveedor");
                vista.txtBuscador.setForeground(Color.gray);
                limpiarTabla();
                listar();
            }
        });
    }
    //UPDATE
    private void inicializar_botonesUpdate(){
        vista.btnLupa1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (vista.txtBuscador1.getText().isEmpty() || vista.txtBuscador1.getText().equalsIgnoreCase("Ingrese código del proveedor")) {
                    JOptionPane.showMessageDialog(null, "Digite el código a buscar");
                }else{
                    PROVEEDOR pro = new PROVEEDOR();
                    
                    //MOSTRAR CODIGO
                    pro=listar_busquedaUpdate(vista.txtBuscador1.getText());
                    
                    //rellenar espacios
                    if(pro.getCODPROVEEDOR()!=0){
                        rellenar_espaciosUpdate(pro);
                    }else{
                        JOptionPane.showMessageDialog(null, "No se encontró al proveedor!");
                    }
                    //desbloquear
                    desbloquear_camposUpdate();
                }
            }
        });
        //BOTON DE CANCELAR BUSQUEDA
        vista.btnActualizar1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                vista.txtBuscador1.getCaret().setVisible(false);
                vista.txtBuscador1.setText("Ingrese código del proveedor");
                vista.txtBuscador1.setForeground(Color.gray);
                vista.boxCod.setSelectedIndex(-1);
                limpiar_campos();
                bloquear_camposUpdate();
            }
        });
    }
    public void rellenar_datosUpdate(){
        vista.boxCod.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if(!(vista.boxCod.getSelectedIndex()==-1)){
                String itemSeleccionado = (String) vista.boxCod.getSelectedItem();
                PROVEEDOR pro = new PROVEEDOR();
                // Acciones a realizar con el elemento seleccionado
                pro=listar_busquedaUpdate(itemSeleccionado);
                //rellenar espacios
                if(pro.getCODPROVEEDOR()!=0){
                    rellenar_espaciosUpdate(pro);
                }else{
                    JOptionPane.showMessageDialog(null, "No se encontró al proveedor!");
                }
                //DESBLOQUEAR CAMPOS
                desbloquear_camposUpdate();
            }
        }
    });}
    public void rellenar_espaciosUpdate(PROVEEDOR pro){
        vista.txtNombre1.setText(pro.getNOMBRE());
        vista.txtTelefono1.setText(pro.getTELEFONO());
        vista.txtDireccion1.setText(pro.getDIRECCION());
    }
    public void bloquear_camposUpdate(){
        vista.txtNombre1.setEditable(false);
        vista.txtTelefono1.setEditable(false);
        vista.txtDireccion1.setEditable(false);
    }
    public void desbloquear_camposUpdate(){
        vista.txtNombre1.setEditable(true);
        vista.txtTelefono1.setEditable(true);
        vista.txtDireccion1.setEditable(true);
    }
    //DELETE
    private void inicializar_botonesDelete(){
        vista.btnLupa2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (vista.txtBuscador2.getText().isEmpty() || vista.txtBuscador2.getText().equalsIgnoreCase("Ingrese código del proveedor")) {
                    JOptionPane.showMessageDialog(null, "Digite el código a buscar");
                }else{
                    PROVEEDOR pro = new PROVEEDOR();
                    
                    //MOSTRAR CODIGO
                    pro=listar_busquedaDelete(vista.txtBuscador2.getText());
                    //rellenar espacios
                    if(pro.getCODPROVEEDOR()!=0){
                        rellenar_espaciosDelete(pro);
                    }else{
                        JOptionPane.showMessageDialog(null, "No se encontró al proveedor!");
                    }
                }
            }
        });
        //BOTON DE CANCELAR BUSQUEDA
        vista.btnActualizar2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                vista.txtBuscador2.getCaret().setVisible(false);
                vista.txtBuscador2.setText("Ingrese código del proveedor");
                vista.txtBuscador2.setForeground(Color.gray);
                vista.boxCod2.setSelectedIndex(-1);
                limpiar_campos();
            }
        });
    }
    public void rellenar_datosDelete(){
        vista.boxCod2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if(!(vista.boxCod2.getSelectedIndex()==-1)){
                String itemSeleccionado = (String) vista.boxCod2.getSelectedItem();
                PROVEEDOR pro = new PROVEEDOR();
                // Acciones a realizar con el elemento seleccionado
                pro=listar_busquedaDelete(itemSeleccionado);
                //rellenar espacios
                if(pro.getCODPROVEEDOR()!=0){
                    rellenar_espaciosDelete(pro);
                }else{
                    JOptionPane.showMessageDialog(null, "No se encontró al proveedor!");
                }
            }
        }
    });}
    public void rellenar_espaciosDelete(PROVEEDOR pro){
        vista.txtNombre2.setText(pro.getNOMBRE());
        vista.txtTelefono2.setText(pro.getTELEFONO());
        vista.txtDireccion2.setText(pro.getDIRECCION());
    }
    //INICIALIZAR
    private void inicializar_boxes(){
        rellenar_datosUpdate();
        rellenar_datosDelete();
    }
    //VISIBLE EL CRUD
    public void visible_create(){
        //HACER VISIBLE EL PANEL CREATE
        vista.panelCreate.setVisible(true);
        //OCULTA LOS OTROS
        vista.panelRead.setVisible(false);
        vista.panelUpdate.setVisible(false);
        vista.panelDelete.setVisible(false);
    }
    public void visible_read(){
        //HACER VISIBLE EL PANEL READ
        vista.panelRead.setVisible(true);
        //OCULTA LOS OTROS
        vista.panelUpdate.setVisible(false);
        vista.panelCreate.setVisible(false);
        vista.panelDelete.setVisible(false);
    }
    public void visible_update(){
        //HACER VISIBLE EL PANEL UPDATE
        vista.panelUpdate.setVisible(true);
        //OCULTA LOS OTROS
        vista.panelRead.setVisible(false);
        vista.panelCreate.setVisible(false);
        vista.panelDelete.setVisible(false);
    }
    public void visible_delete(){
        //HACER VISIBLE EL PANEL DELETE
        vista.panelDelete.setVisible(true);
        //OCULTA LOS OTROS
        vista.panelUpdate.setVisible(false);
        vista.panelCreate.setVisible(false);
        vista.panelRead.setVisible(false);
    }
    //LIMPIAR CAMPOS
    public void limpiar_campos(){
        //BARRAS DE BUSQUEDA
        vista.txtBuscador.setText("Ingrese nombre del proveedor");
        vista.txtBuscador1.setText("Ingrese código del proveedor");
        vista.txtBuscador2.setText("Ingrese código del proveedor");
        vista.txtBuscador.setForeground(Color.gray);
        vista.txtBuscador1.setForeground(Color.gray);
        vista.txtBuscador2.setForeground(Color.gray);
        
        vista.txtNombre.setText("");
        vista.txtDireccion.setText("");
        vista.txtTelefono.setText("");
        
        vista.txtNombre1.setText("");
        vista.txtTelefono1.setText("");
        vista.txtDireccion1.setText("");
        
        vista.txtNombre2.setText("");
        vista.txtTelefono2.setText("");
        vista.txtDireccion2.setText("");
    }
    //GETTERS Y SETTERS
    public Proveedor getVista() {
        return vista;
    }

    public void setVista(Proveedor vista) {
        this.vista = vista;
    }
    
}
