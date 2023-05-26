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
public class ControllerEmpleado {
    private Empleado vista;
    private EMPLEADODAO emp_dao = new EMPLEADODAO();
    private ControllerMetodos cmet=new ControllerMetodos();
    
    public ControllerEmpleado() {
        vista = new Empleado();
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
    public ControllerEmpleado(Empleado e) {
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
        String codemp = String.valueOf(cmet.mayor_codemp()+1);
        String nombre = vista.txtNombre.getText();
        String apellido = vista.txtApellido.getText();
        String dni = vista.txtDNI.getText();
        String celular = vista.txtCelular.getText();
        java.sql.Date fecnac = new java.sql.Date(vista.dateFECNAC.getDate().getTime());;
        //CODCARGO 1, 2 o 3 
        String codcargo="";
        if(vista.boxCargo.getSelectedItem().toString().equals("Gerente")){
            codcargo = "1";
        }else if(vista.boxCargo.getSelectedItem().toString().equals("Quimico")){
            codcargo= "2";
        }else if(vista.boxCargo.getSelectedItem().toString().equals("Jefe de almacen")){
            codcargo="3";    
        }
        String usuario = vista.txtUsuario.getText();
        String contrasena = vista.txtContrasena.getText();
        EMPLEADO emp = new EMPLEADO();
        emp.setCODEMPLEADO(Integer.parseInt(codemp));
        emp.setNOMBRE(nombre);
        emp.setAPELLIDO(apellido);
        emp.setDNI(dni);
        emp.setCELULAR(celular);
        emp.setFECNAC(fecnac);
        emp.setCODCARGO(codcargo);
        emp.setUSUARIO(usuario);
        emp.setCONTRASENA(contrasena);
        emp_dao.InsertEMPLEADO(emp); //Añadimos a la base de datos (cliente)
        JOptionPane.showMessageDialog(null, "Empleado registrado!!");
    }
    //Método para obtiene los datos de los empleado y muestra en una tabla
    public void listar(){
        List<EMPLEADO> lista_emp = emp_dao.ListEMPLEADO();
        
        vista.modelo = (DefaultTableModel)vista.tabla.getModel();
        vista.sorter = new TableRowSorter<> (vista.modelo);
        vista.tabla.setRowSorter(vista.sorter);
        
        Object[] ob = new Object[7]; 
        
        for(int i=0;i<lista_emp.size();i++){
            ob[0]=lista_emp.get(i).getCODEMPLEADO();
            ob[1]=lista_emp.get(i).getNOMBRE();
            ob[2]=lista_emp.get(i).getAPELLIDO();
            ob[3]=lista_emp.get(i).getDNI();
            ob[4]=lista_emp.get(i).getCELULAR();
            ob[5]=lista_emp.get(i).getFECNAC();
            ob[6]=lista_emp.get(i).getCODCARGO();
            if(ob[6].equals("1")){
                ob[6]="Gerente";
            }else if(ob[6].equals("2")){
                ob[6]="Químico";
            }else if(ob[6].equals("3")){
                ob[6]="Jefe de almacén";
            }else{
                ob[6]="";
            }
            vista.modelo.addRow(ob);
        }
        
        vista.tabla.setModel(vista.modelo);
    }
    public void listar_busqueda(String consulta){
        List<EMPLEADO> lista_emp = emp_dao.ListEMPLEADO();
        vista.modelo = (DefaultTableModel)vista.tabla.getModel();
        vista.sorter = new TableRowSorter<> (vista.modelo);
        vista.tabla.setRowSorter(vista.sorter);
        
        Object[] ob = new Object[7]; 
        
        for(int i=0;i<lista_emp.size();i++){
            ob[0]=lista_emp.get(i).getCODEMPLEADO();
            ob[1]=lista_emp.get(i).getNOMBRE();
            ob[2]=lista_emp.get(i).getAPELLIDO();
            ob[3]=lista_emp.get(i).getDNI();
            ob[4]=lista_emp.get(i).getCELULAR();
            ob[5]=lista_emp.get(i).getFECNAC();
            ob[6]=lista_emp.get(i).getCODCARGO();
            if(ob[6].equals("1")){
                ob[6]="Gerente";
            }else if(ob[6].equals("2")){
                ob[6]="Químico";
            }else if(ob[6].equals("3")){
                ob[6]="Jefe de almacén";
            }else{
                ob[6]="";
            }
            if(lista_emp.get(i).getNOMBRE().substring(0,consulta.length()).equalsIgnoreCase(consulta)){
                vista.modelo.addRow(ob);
            }
        }
        vista.tabla.setModel(vista.modelo);
    }
    public EMPLEADO listar_busquedaUpdate(String consulta){
        List<EMPLEADO> lista_emp = emp_dao.ListEMPLEADO();
        EMPLEADO emp = new EMPLEADO();
        
        for(int i=0;i<lista_emp.size();i++){
            if(Integer.toString(lista_emp.get(i).getCODEMPLEADO()).substring(0,consulta.length()).equals(consulta)){
                vista.boxCod.setSelectedIndex(i);
                emp = lista_emp.get(i);
                return emp;
            }
        }
        return emp;
    }
    public EMPLEADO listar_busquedaDelete(String consulta){
        List<EMPLEADO> lista_emp = emp_dao.ListEMPLEADO();
        EMPLEADO emp = new EMPLEADO();
        
        for(int i=0;i<lista_emp.size();i++){
            if(Integer.toString(lista_emp.get(i).getCODEMPLEADO()).substring(0,consulta.length()).equals(consulta)){
                vista.boxCod2.setSelectedIndex(i);
                emp = lista_emp.get(i);
                return emp;
            }
        }
        return emp;
    }
    //Método que captura la información del cliente que se desea actualizar
    public void actualizar(){
        String codemp = (String) vista.boxCod.getSelectedItem();
        String nombre = vista.txtNombre1.getText();
        String apellido = vista.txtApellido1.getText();
        String dni = vista.txtDNI1.getText();
        String celular = vista.txtCelular1.getText();
        java.sql.Date fecnac = new java.sql.Date(vista.dateFECNAC1.getDate().getTime());;
        //CODCARGO 1, 2 o 3 
        String codcargo="";
        if(vista.boxCargo1.getSelectedItem().toString().equals("Gerente")){
            codcargo = "1";
        }else if(vista.boxCargo1.getSelectedItem().toString().equals("Quimico")){
            codcargo= "2";
        }else if(vista.boxCargo1.getSelectedItem().toString().equals("Jefe de almacen")){
            codcargo="3";    
        }
        EMPLEADO emp = new EMPLEADO();
        emp.setCODEMPLEADO(Integer.parseInt(codemp));
        emp.setNOMBRE(nombre);
        emp.setAPELLIDO(apellido);
        emp.setDNI(dni);
        emp.setCELULAR(celular);
        emp.setFECNAC(fecnac);
        emp.setCODCARGO(codcargo);
        emp_dao.ModEMPLEADO(emp); //Añadimos a la base de datos (cliente)
        JOptionPane.showMessageDialog(null, "Empleado actualizado!!");
    }
    //Método que elimina un cliente seleccionado 
    public boolean eliminar(){
        int opcion = JOptionPane.showConfirmDialog(null, "¿Quieres eliminar al empleado?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            EMPLEADO emp = new EMPLEADO();
            emp.setCODEMPLEADO(Integer.parseInt(vista.boxCod2.getSelectedItem().toString()));
            emp_dao.eliEMPLEADO(emp);
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
        List<EMPLEADO> list_emp=emp_dao.ListEMPLEADO();
        for(int i=0;i<list_emp.size();i++){
            vista.boxCod.addItem(Integer.toString(list_emp.get(i).getCODEMPLEADO()));
        }
        vista.boxCod.setSelectedIndex(-1);
    }
    public void listar_combobox2(){
        List<EMPLEADO> list_emp=emp_dao.ListEMPLEADO();
        for(int i=0;i<list_emp.size();i++){
            vista.boxCod2.addItem(Integer.toString(list_emp.get(i).getCODEMPLEADO()));
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
                if (vista.txtBuscador.getText().isEmpty() || vista.txtBuscador.getText().equalsIgnoreCase("Ingrese nombre del empleado")) {
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
                vista.txtBuscador.setText("Ingrese nombre del empleado");
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
                if (vista.txtBuscador1.getText().isEmpty() || vista.txtBuscador1.getText().equalsIgnoreCase("Ingrese código del empleado")) {
                    JOptionPane.showMessageDialog(null, "Digite el código a buscar");
                }else{
                    EMPLEADO emp = new EMPLEADO();
                    
                    //MOSTRAR CODIGO
                    emp=listar_busquedaUpdate(vista.txtBuscador1.getText());
                    
                    //rellenar espacios
                    if(emp.getCODEMPLEADO()!=0){
                        rellenar_espaciosUpdate(emp);
                    }else{
                        JOptionPane.showMessageDialog(null, "No se encontró al empleado!");
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
                vista.txtBuscador1.setText("Ingrese código del empleado");
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
                EMPLEADO emp = new EMPLEADO();
                // Acciones a realizar con el elemento seleccionado
                emp=listar_busquedaUpdate(itemSeleccionado);
                //rellenar espacios
                if(emp.getCODEMPLEADO()!=0){
                    rellenar_espaciosUpdate(emp);
                }else{
                    JOptionPane.showMessageDialog(null, "No se encontró al empleado!");
                }
                //DESBLOQUEAR CAMPOS
                desbloquear_camposUpdate();
            }
        }
    });}
    public void rellenar_espaciosUpdate(EMPLEADO emp){
        vista.txtNombre1.setText(emp.getNOMBRE());
        vista.txtApellido1.setText(emp.getAPELLIDO());
        vista.txtDNI1.setText(emp.getDNI());
        vista.txtCelular1.setText(emp.getCELULAR());
        vista.dateFECNAC1.setDate(emp.getFECNAC());
        vista.boxCargo1.setSelectedIndex(Integer.valueOf(emp.getCODCARGO())-1);
    }
    public void bloquear_camposUpdate(){
        vista.txtNombre1.setEditable(false);
        vista.txtApellido1.setEditable(false);
        vista.txtDNI1.setEditable(false);
        vista.txtCelular1.setEditable(false);
        vista.dateFECNAC1.setEnabled(false);
        vista.boxCargo1.setEnabled(false);
    }
    public void desbloquear_camposUpdate(){
        vista.txtNombre1.setEditable(true);
        vista.txtApellido1.setEditable(true);
        vista.txtDNI1.setEditable(true);
        vista.txtCelular1.setEditable(true);
        vista.dateFECNAC1.setEnabled(true);
        vista.boxCargo1.setEnabled(true);
    }
    //DELETE
    private void inicializar_botonesDelete(){
        vista.btnLupa2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (vista.txtBuscador2.getText().isEmpty() || vista.txtBuscador2.getText().equalsIgnoreCase("Ingrese código del empleado")) {
                    JOptionPane.showMessageDialog(null, "Digite el código a buscar");
                }else{
                    EMPLEADO emp = new EMPLEADO();
                    
                    //MOSTRAR CODIGO
                    emp=listar_busquedaDelete(vista.txtBuscador2.getText());
                    //rellenar espacios
                    if(emp.getCODEMPLEADO()!=0){
                        rellenar_espaciosDelete(emp);
                    }else{
                        JOptionPane.showMessageDialog(null, "No se encontró al empleado!");
                    }
                }
            }
        });
        //BOTON DE CANCELAR BUSQUEDA
        vista.btnActualizar2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                vista.txtBuscador2.getCaret().setVisible(false);
                vista.txtBuscador2.setText("Ingrese código del empleado");
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
                EMPLEADO emp = new EMPLEADO();
                // Acciones a realizar con el elemento seleccionado
                emp=listar_busquedaDelete(itemSeleccionado);
                //rellenar espacios
                if(emp.getCODEMPLEADO()!=0){
                    rellenar_espaciosDelete(emp);
                }else{
                    JOptionPane.showMessageDialog(null, "No se encontró al empleado!");
                }
            }
        }
    });}
    public void rellenar_espaciosDelete(EMPLEADO emp){
        vista.txtNombre2.setText(emp.getNOMBRE());
        vista.txtApellido2.setText(emp.getAPELLIDO());
        vista.txtDNI2.setText(emp.getDNI());
        vista.txtCelular2.setText(emp.getCELULAR());
        vista.dateFECNAC2.setDate(emp.getFECNAC());
        vista.boxCargo2.setSelectedIndex(Integer.valueOf(emp.getCODCARGO())-1);
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
        vista.txtBuscador.setText("Ingrese nombre del empleado");
        vista.txtBuscador1.setText("Ingrese código del empleado");
        vista.txtBuscador2.setText("Ingrese código del empleado");
        vista.txtBuscador.setForeground(Color.gray);
        vista.txtBuscador1.setForeground(Color.gray);
        vista.txtBuscador2.setForeground(Color.gray);
        
        vista.txtNombre.setText("");
        vista.txtApellido.setText("");
        vista.txtCelular.setText("");
        vista.txtDNI.setText("");
        vista.txtUsuario.setText("");
        vista.txtContrasena.setText("");
        vista.boxCargo.setSelectedIndex(-1);
        vista.dateFECNAC.setDate(null);
        
        vista.txtNombre1.setText("");
        vista.txtApellido1.setText("");
        vista.txtCelular1.setText("");
        vista.txtDNI1.setText("");
        vista.boxCargo1.setSelectedIndex(-1);
        vista.dateFECNAC1.setDate(null);
        
        vista.txtNombre2.setText("");
        vista.txtApellido2.setText("");
        vista.txtCelular2.setText("");
        vista.txtDNI2.setText("");
        vista.boxCargo2.setSelectedIndex(-1);
        vista.dateFECNAC2.setDate(null);
    }
    //GETTERS Y SETTERS
    public Empleado getVista() {
        return vista;
    }

    public void setVista(Empleado vista) {
        this.vista = vista;
    }
    
}
