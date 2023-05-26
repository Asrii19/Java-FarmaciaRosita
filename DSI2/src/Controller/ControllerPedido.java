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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author arnol
 */
public class ControllerPedido {
    private Pedido vista;
    public boolean bandera_lupa=false, bandera_init=false;
    public boolean bandera_lupa3=false, bandera_init3=false;
    public int numero=0;
    private PRODUCTODAO pro_dao = new PRODUCTODAO();
    private PROVEEDORDAO prov_dao = new PROVEEDORDAO();
    private LISTA_PRODUCTODAO listpro_dao = new LISTA_PRODUCTODAO();
    private ControllerMetodos cmet=new ControllerMetodos();
    public static ArrayList<Object[]> productos = new ArrayList<Object[]>();
    
    public ControllerPedido() {
        vista = new Pedido();
        bandera_init=true;
        bandera_init3=true;
        inicializar_botones();
        try{
            inicializar_botonesAdd();
            inicializar_botonesUpdate();
            inicializar_boxes();
        }catch(Exception e){
            System.out.println(e);
        }
        vista.txtBuscador2.getCaret().setVisible(false);
    }
    public ControllerPedido(Pedido e) {
        vista = e;
    }
    public void run() {
        vista.setVisible(true); //hacer visible
        vista.panelCreate.setVisible(false);
        vista.panelRead.setVisible(false);
        vista.panelUpdate.setVisible(false);
    }
    
    //Método que captura la información del cliente
    public void agregar(){
        String codped = String.valueOf(nuevo_producto());
        String codlistprod = vista.boxCodprod1.getSelectedItem().toString();
        String nombre = vista.txtNombre.getText();
        String descripcion = vista.txtDescripcion.getText();
        String proveedor = vista.boxCodprov1.getSelectedItem().toString();
        String cantidad = vista.txtCantidad1.getText();
        
        Object[] producto = new Object[7];
        producto[0]=codped;
        producto[1]=codlistprod;
        producto[2]=nombre;
        producto[3]=descripcion;
        producto[4]=proveedor;
        producto[5]=cantidad;
        
        
        
        
        productos.add(producto);
        
        JOptionPane.showMessageDialog(null, "Producto registrado en el pedido!!");
    }
    public boolean verificarStock(String cod, String cantidad){
        if(buscarCantidadProducto(Integer.parseInt(cod))>=Integer.parseInt(cantidad)){
            return true;
        }else{
            return false;
        }
    }
    public int buscarCantidadProducto(int cod){
        List<LISTA_PRODUCTO> list_pro=listpro_dao.ListLISTA_PRODUCTO();
        for(int i=0;i<list_pro.size();i++){
            if(list_pro.get(i).getCODLISTAPRODUCTO()==cod){
                return Integer.parseInt(list_pro.get(i).getCANTIDAD());
            }
        }
        return 0;
    }
    public String nuevo_producto(){
        numero++;
        return Integer.toString(numero);
    }
    //Método para obtiene los datos de los empleado y muestra en una tabla
    public void listar(){
        vista.modelo = (DefaultTableModel)vista.tabla.getModel();
        vista.sorter = new TableRowSorter<> (vista.modelo);
        vista.tabla.setRowSorter(vista.sorter);
        
        Object[] producto = new Object[7]; 
        Object[] ob = new Object[7]; 
        for(int i=0;i<productos.size();i++){
            producto=productos.get(i);
            ob[0]=producto[0];
            ob[1]=producto[2];
            ob[2]=producto[3];
            ob[3]=producto[4];
            ob[4]=producto[5];
            vista.modelo.addRow(ob);
        }
        vista.tabla.setModel(vista.modelo);
    }
    public void listar_busqueda(String consulta){ //por nombre
        vista.modelo = (DefaultTableModel)vista.tabla.getModel();
        vista.sorter = new TableRowSorter<> (vista.modelo);
        vista.tabla.setRowSorter(vista.sorter);
        
        Object[] producto = new Object[7]; 
        Object[] ob = new Object[7];  
        System.out.println("Consulta: "+consulta);
        for(int i=0;i<productos.size();i++){
            producto=productos.get(i);
            ob[0]=producto[0];
            ob[1]=producto[2];
            ob[2]=producto[3];
            ob[3]=producto[4];
            ob[4]=producto[5];
            if(ob[1].toString().substring(0,consulta.length()).equalsIgnoreCase(consulta)){
                vista.modelo.addRow(ob);
            }
        }
        vista.tabla.setModel(vista.modelo);
    }
    
    //Método que captura la información del cliente que se desea actualizar
    public void actualizar(){
        String codped = vista.boxCodprod3.getSelectedItem().toString();
        String codlistprod;
        String nombre = vista.txtNombre3.getText();
        String descripcion = vista.txtDescripcion3.getText();
        String proveedor = vista.boxCodprov3.getSelectedItem().toString();
        String cantidad= vista.txtCantidad3.getText();

        Object[] producto = new Object[7];
        Object[] ob = new Object[7];
        producto[0]=codped;
        
        producto[2]=nombre;
        producto[3]=descripcion;
        producto[4]=proveedor;
        producto[5]=cantidad;
        
        for(int i=0;i<productos.size();i++){
            ob=productos.get(i);
            producto[1]=ob[1];
            if(producto[0].equals(ob[0])){ //si se encuentra se actualiza                
                productos.set(i, producto);
                break;
            }
        }
        
        JOptionPane.showMessageDialog(null, "Producto actualizado!!");
    }
    public boolean eliminar_producto(){
        int opcion = JOptionPane.showConfirmDialog(null, "¿Quieres eliminar el ACTUAL producto de la lista del pedido?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            productos.remove(Integer.parseInt(vista.boxCodprod3.getSelectedItem().toString())-1);
            return true;
        }
        return false;
    }
    //Método que elimina un cliente seleccionado 
    public boolean eliminar(){
        int opcion = JOptionPane.showConfirmDialog(null, "¿Quieres eliminar TODOS los productos de la lista del pedido?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            productos.clear();
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
    public void listar_combobox1(){
        List<LISTA_PRODUCTO> list_pro=listpro_dao.ListLISTA_PRODUCTO();
        for(int i=0;i<list_pro.size();i++){
            vista.boxCodprod1.addItem(Integer.toString(list_pro.get(i).getCODLISTAPRODUCTO()));
            vista.boxCodprov1.addItem(obtener_ProveedorNombre(list_pro.get(i).getCODPROVEEDOR()));
        }
        vista.boxCodprod1.setSelectedIndex(-1);
        vista.boxCodprov1.setSelectedIndex(-1);
    }
    public void listar_combobox3(){
        List<LISTA_PRODUCTO> list_pro=listpro_dao.ListLISTA_PRODUCTO();
        Object[] ob=new Object[7];
        for(int i=0;i<productos.size();i++){
            ob=productos.get(i);
            vista.boxCodprod3.addItem(ob[0].toString());
        }
        for(int i=0;i<list_pro.size();i++){
            vista.boxCodprov3.addItem(obtener_ProveedorNombre(list_pro.get(i).getCODPROVEEDOR()));
        }
        vista.boxCodprod3.setSelectedIndex(-1);
        vista.boxCodprov3.setSelectedIndex(-1);
    }
    //limpiar comboboxes
    public void limpiar_combobox(){
        vista.boxCodprod1.removeAllItems();
        vista.boxCodprod3.removeAllItems();
        vista.boxCodprov1.removeAllItems();
        vista.boxCodprov3.removeAllItems();
    }
    
    //BOTON BUSQUEDA Y ACTUALIZAR
    //BOTON DE LUPA (BUSCAR)
    //READ
    private void inicializar_botones(){
        vista.btnLupa2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (vista.txtBuscador2.getText().isEmpty() || vista.txtBuscador2.getText().equalsIgnoreCase("Ingrese nombre del producto")) {
                    JOptionPane.showMessageDialog(null, "Digite el nombre a buscar");
                }else{
                    limpiarTabla();
                    listar_busqueda(vista.txtBuscador2.getText());
                }
            }
        });
        //BOTON DE CANCELAR BUSQUEDA
        vista.btnActualizar2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                vista.txtBuscador2.getCaret().setVisible(false);
                vista.txtBuscador2.setText("Ingrese nombre del producto");
                vista.txtBuscador2.setForeground(Color.gray);
                limpiarTabla();
                listar();
            }
        });
    }
    //UPDATE
    private void inicializar_botonesUpdate(){
        vista.btnLupa3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (vista.txtBuscador3.getText().isEmpty() || vista.txtBuscador3.getText().equalsIgnoreCase("Ingrese código del producto")) {
                    JOptionPane.showMessageDialog(null, "Digite el código a buscar");
                }else{
                    //MOSTRAR CODIGO
                    bandera_lupa3=true;
                    boolean bandera=listar_busquedaUpdate(vista.txtBuscador3.getText());
                    if(bandera){
                        desbloquear_camposUpdate();
                    }
                }
            }
        });
        //BOTON DE CANCELAR BUSQUEDA
        vista.btnActualizar3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                bandera_lupa3=true;
                vista.txtBuscador3.getCaret().setVisible(false);
                vista.txtBuscador3.setText("Ingrese código del producto");
                vista.txtBuscador3.setForeground(Color.gray);
                vista.boxCodprod3.setSelectedIndex(-1);
                limpiar_campos();
                bloquear_camposUpdate();
            }
        });
    }
    public void rellenar_datosUpdate(){
        vista.boxCodprod3.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if(!(bandera_init3&&bandera_lupa3)&&!(vista.boxCodprod3.getSelectedItem()==null)){
                //MOSTRAR CODIGO
                listar_busquedaUpdate(vista.boxCodprod3.getSelectedItem().toString());
                desbloquear_camposUpdate();
            }
            bandera_init3=false;
            bandera_lupa3=false;
        }
    });}
    public boolean listar_busquedaUpdate(String consulta){ //por cod listaprod
        //LISTAR EL PRODUCTO Y LA LISTA PRODUCTO EN VARIABLES 
        Object[] ob = new Object[7]; 
        for(int i=0;i<productos.size();i++){
            ob=productos.get(i);
            if(ob[0].equals(consulta)){ //si se encuenta se lista
                vista.boxCodprod3.setSelectedIndex(i);
                vista.txtNombre3.setText(ob[2].toString());
                vista.txtDescripcion3.setText(ob[3].toString());
                vista.boxCodprov3.setSelectedItem(ob[4]);
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "No se encontró al producto!");
        return false;
    }
    
    public void bloquear_camposUpdate(){
        vista.txtNombre3.setEditable(false);
        vista.txtDescripcion3.setEditable(false);
        vista.boxCodprov3.setEnabled(false);
        vista.txtCantidad3.setEditable(false);
        vista.eliminarproducto.setVisible(false);
    }
    public void desbloquear_camposUpdate(){
        vista.txtCantidad3.setEditable(true);
        vista.eliminarproducto.setVisible(true);
    }
    //CREATE
    private void inicializar_botonesAdd(){ //LUPA
        vista.btnLupa1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (vista.txtBuscador1.getText().isEmpty() || vista.txtBuscador1.getText().equalsIgnoreCase("Ingrese código del producto")) {
                    JOptionPane.showMessageDialog(null, "Digite el código a buscar");
                }else{
                    bandera_lupa=true;
                    //rellenar espacios
                    listar_busquedaAddLupa(vista.txtBuscador1.getText());
                }
            }
        });
        //BOTON DE CANCELAR BUSQUEDA
        vista.btnActualizar1.addMouseListener(new MouseAdapter() { //ACTUALIZAR
            @Override
            public void mouseClicked(MouseEvent e) {
                bandera_lupa=true;
                vista.txtBuscador1.getCaret().setVisible(false);
                vista.txtBuscador1.setText("Ingrese código del producto");
                vista.txtBuscador1.setForeground(Color.gray);
                vista.boxCodprod1.setSelectedIndex(-1);
                limpiar_campos();
            }
        });
    }
    public void rellenar_datosAdd(){
        vista.boxCodprod1.addActionListener(new ActionListener() { //CLICK
        public void actionPerformed(ActionEvent e) {
            //System.out.println("CLICK");
            //System.out.println(bandera_init+" "+bandera_lupa+" "+(vista.boxCodprod1.getSelectedItem()==null));
            if(!(bandera_init&&bandera_lupa)&&!(vista.boxCodprod1.getSelectedItem()==null)){
                //MOSTRAR CODIGO
                listar_busquedaAddClick(vista.boxCodprod1.getSelectedItem().toString());
            }
            bandera_init=false;
            bandera_lupa=false;
        }
    });}
    public void listar_busquedaAddLupa(String consulta){
        //LISTAR EL PRODUCTO Y LA LISTA PRODUCTO EN VARIABLES 
        List<PRODUCTO> pro= pro_dao.ListPRODUCTO();
        List<LISTA_PRODUCTO> lpro= listpro_dao.ListLISTA_PRODUCTO();
        for(int i=0;i<lpro.size();i++){
            if(consulta.equals(Integer.toString(lpro.get(i).getCODLISTAPRODUCTO()))){ //se llena acorde al id producto
                vista.boxCodprod1.setSelectedIndex(i);
                vista.boxCodprov1.setSelectedItem(obtener_ProveedorNombre(lpro.get(i).getCODPROVEEDOR()));
                for(int j=0;j<pro.size();j++){
                    if(lpro.get(i).getCODPRODUCTO()==pro.get(j).getCODPRODUCTO()){
                        vista.txtNombre.setText(pro.get(j).getNOMBRE());
                        vista.txtDescripcion.setText(pro.get(j).getDESCRIPCION());
                        return;
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(null, "No se encontró al producto!");
    }
    public void listar_busquedaAddClick(String consulta){
        List<PRODUCTO> pro= pro_dao.ListPRODUCTO();
        List<LISTA_PRODUCTO> lpro= listpro_dao.ListLISTA_PRODUCTO();
        for(int i=0;i<lpro.size();i++){
            if(consulta.equals(Integer.toString(lpro.get(i).getCODLISTAPRODUCTO()))){ //se llena acorde al id producto
                vista.boxCodprod1.setSelectedIndex(i);
                vista.boxCodprov1.setSelectedItem(obtener_ProveedorNombre(lpro.get(i).getCODPROVEEDOR()));
                for(int j=0;j<pro.size();j++){
                    if(lpro.get(i).getCODPRODUCTO()==pro.get(j).getCODPRODUCTO()){
                        vista.txtNombre.setText(pro.get(j).getNOMBRE());
                        vista.txtDescripcion.setText(pro.get(j).getDESCRIPCION());
                        return;
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(null, "No se encontró al producto!");
    }
    public String obtener_ProveedorCod(String nom){
        String id="";
        List<PROVEEDOR> lista=prov_dao.ListPROVEEDOR();
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
        
        List<PROVEEDOR> lista=prov_dao.ListPROVEEDOR();
        for(int i=0;i<lista.size();i++){
            if(cod==lista.get(i).getCODPROVEEDOR()){
                nombre=lista.get(i).getNOMBRE();
                break;
            }
        }
        
        return nombre;
    }
    //INICIALIZAR
    private void inicializar_boxes(){
        rellenar_datosUpdate();
        rellenar_datosAdd();
    }
    //VISIBLE EL CRUD
    public void visible_create(){
        //HACER VISIBLE EL PANEL CREATE
        vista.panelCreate.setVisible(true);
        //OCULTA LOS OTROS
        vista.panelRead.setVisible(false);
        vista.panelUpdate.setVisible(false);
    }
    public void visible_read(){
        //HACER VISIBLE EL PANEL READ
        vista.panelRead.setVisible(true);
        //OCULTA LOS OTROS
        vista.panelUpdate.setVisible(false);
        vista.panelCreate.setVisible(false);
    }
    public void visible_update(){
        //HACER VISIBLE EL PANEL UPDATE
        vista.panelUpdate.setVisible(true);
        //OCULTA LOS OTROS
        vista.panelRead.setVisible(false);
        vista.panelCreate.setVisible(false);
    }
    //LIMPIAR CAMPOS
    public void limpiar_campos(){
        //BARRAS DE BUSQUEDA
        vista.txtBuscador2.setText("Ingrese nombre del producto");
        vista.txtBuscador3.setText("Ingrese código del producto");
        vista.txtBuscador1.setText("Ingrese código del producto");
        vista.txtBuscador2.setForeground(Color.gray);
        vista.txtBuscador3.setForeground(Color.gray);
        vista.txtBuscador1.setForeground(Color.gray);
        
        vista.txtNombre.setText("");
        vista.txtDescripcion.setText("");
        vista.boxCodprov1.setSelectedIndex(-1);
        vista.txtCantidad1.setText("");
        
        vista.txtNombre3.setText("");
        vista.txtDescripcion3.setText("");
        vista.boxCodprov3.setSelectedIndex(-1);
        vista.txtCantidad3.setText("");
    }
    //GETTERS Y SETTERS
    public Pedido getVista() {
        return vista;
    }

    public void setVista(Pedido vista) {
        this.vista = vista;
    }
    
}
