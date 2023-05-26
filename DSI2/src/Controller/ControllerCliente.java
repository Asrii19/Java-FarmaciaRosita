/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import ClasesBasicas.CLIENTE;
import DAO.CLIENTEDAO;
import Frames.Cliente;
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
public class ControllerCliente {
    private Cliente vista;
    private CLIENTEDAO cli_dao = new CLIENTEDAO();
    private ControllerMetodos cmet=new ControllerMetodos();
    public ControllerCliente() {
        vista = new Cliente();
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
    public ControllerCliente(Cliente c) {
        vista = c;
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
        String codcli = String.valueOf(cmet.mayor_codcli()+1);
        String nombre = vista.txtNombre.getText();
        String apellido = vista.txtApellido.getText();
        String dni = vista.txtDNI.getText();
        String celular = vista.txtCelular.getText();
        
        CLIENTE cli = new CLIENTE();
        cli.setCODCLIENTE(Integer.parseInt(codcli));
        cli.setNOMBRE(nombre);
        cli.setAPELLIDO(apellido);
        cli.setDNI(dni);
        cli.setCELULAR(celular);
        cli_dao.InsertCLIENTE(cli); //Añadimos a la base de datos (cliente)
        JOptionPane.showMessageDialog(null, "Cliente registrado!!");
    }
    //Método para obtiene los datos de los empleado y muestra en una tabla
    public void listar(){
        List<CLIENTE> lista_cli = cli_dao.ListCLIENTE();
        
        vista.modelo = (DefaultTableModel)vista.tabla.getModel();
        vista.sorter = new TableRowSorter<> (vista.modelo);
        vista.tabla.setRowSorter(vista.sorter);
        
        Object[] ob = new Object[7]; 
        
        for(int i=0;i<lista_cli.size();i++){
            ob[0]=lista_cli.get(i).getCODCLIENTE();
            ob[1]=lista_cli.get(i).getNOMBRE();
            ob[2]=lista_cli.get(i).getAPELLIDO();
            ob[3]=lista_cli.get(i).getDNI();
            ob[4]=lista_cli.get(i).getCELULAR();
            vista.modelo.addRow(ob);
        }
        
        vista.tabla.setModel(vista.modelo);
    }
    public void listar_busqueda(String consulta){
        List<CLIENTE> lista_cli = cli_dao.ListCLIENTE();
        vista.modelo = (DefaultTableModel)vista.tabla.getModel();
        vista.sorter = new TableRowSorter<> (vista.modelo);
        vista.tabla.setRowSorter(vista.sorter);
        
        Object[] ob = new Object[7]; 
        
        for(int i=0;i<lista_cli.size();i++){
            ob[0]=lista_cli.get(i).getCODCLIENTE();
            ob[1]=lista_cli.get(i).getNOMBRE();
            ob[2]=lista_cli.get(i).getAPELLIDO();
            ob[3]=lista_cli.get(i).getDNI();
            ob[4]=lista_cli.get(i).getCELULAR();
            if(lista_cli.get(i).getNOMBRE().substring(0,consulta.length()).equalsIgnoreCase(consulta)){
                vista.modelo.addRow(ob);
            }
        }
        vista.tabla.setModel(vista.modelo);
    }
    public CLIENTE listar_busquedaUpdate(String consulta){
        List<CLIENTE> lista_cli = cli_dao.ListCLIENTE();
        CLIENTE cli = new CLIENTE();
        
        for(int i=0;i<lista_cli.size();i++){
            if(Integer.toString(lista_cli.get(i).getCODCLIENTE()).substring(0,consulta.length()).equals(consulta)){
                vista.boxCod.setSelectedIndex(i);
                cli = lista_cli.get(i);
                return cli;
            }
        }
        return cli;
    }
    public CLIENTE listar_busquedaDelete(String consulta){
        List<CLIENTE> lista_cli = cli_dao.ListCLIENTE();
        CLIENTE cli = new CLIENTE();
        
        for(int i=0;i<lista_cli.size();i++){
            if(Integer.toString(lista_cli.get(i).getCODCLIENTE()).substring(0,consulta.length()).equals(consulta)){
                vista.boxCod2.setSelectedIndex(i);
                cli = lista_cli.get(i);
                return cli;
            }
        }
        return cli;
    }
    //Método que captura la información del cliente que se desea actualizar
    public void actualizar(){
        String codcli = (String) vista.boxCod.getSelectedItem();
        String nombre = vista.txtNombre1.getText();
        String apellido = vista.txtApellido1.getText();
        String dni = vista.txtDNI1.getText();
        String celular = vista.txtCelular1.getText();
        
        CLIENTE cli = new CLIENTE();
        cli.setCODCLIENTE(Integer.parseInt(codcli));
        cli.setNOMBRE(nombre);
        cli.setAPELLIDO(apellido);
        cli.setDNI(dni);
        cli.setCELULAR(celular);
        cli_dao.ModCLIENTE(cli); //Añadimos a la base de datos (cliente)
        JOptionPane.showMessageDialog(null, "Cliente actualizado!!");
    }
    //Método que elimina un cliente seleccionado 
    public boolean eliminar(){
        int opcion = JOptionPane.showConfirmDialog(null, "¿Quieres eliminar al cliente?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            CLIENTE cli = new CLIENTE();
            cli.setCODCLIENTE(Integer.parseInt(vista.boxCod2.getSelectedItem().toString()));
            cli_dao.eliCLIENTE(cli);
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
        List<CLIENTE> list_cli=cli_dao.ListCLIENTE();
        for(int i=0;i<list_cli.size();i++){
            vista.boxCod.addItem(Integer.toString(list_cli.get(i).getCODCLIENTE()));
        }
        vista.boxCod.setSelectedIndex(-1);
    }
    public void listar_combobox2(){
        List<CLIENTE> list_cli=cli_dao.ListCLIENTE();
        for(int i=0;i<list_cli.size();i++){
            vista.boxCod2.addItem(Integer.toString(list_cli.get(i).getCODCLIENTE()));
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
                if (vista.txtBuscador.getText().isEmpty() || vista.txtBuscador.getText().equalsIgnoreCase("Ingrese nombre del cliente")) {
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
                vista.txtBuscador.setText("Ingrese nombre del cliente");
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
                if (vista.txtBuscador1.getText().isEmpty() || vista.txtBuscador1.getText().equalsIgnoreCase("Ingrese código del cliente")) {
                    JOptionPane.showMessageDialog(null, "Digite el código a buscar");
                }else{
                    CLIENTE cli = new CLIENTE();
                    
                    //MOSTRAR CODIGO
                    cli=listar_busquedaUpdate(vista.txtBuscador1.getText());
                    
                    //rellenar espacios
                    if(cli.getCODCLIENTE()!=0){
                        rellenar_espaciosUpdate(cli);
                    }else{
                        JOptionPane.showMessageDialog(null, "No se encontró al cliente!");
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
                vista.txtBuscador1.setText("Ingrese código del cliente");
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
                CLIENTE cli = new CLIENTE();
                // Acciones a realizar con el elemento seleccionado
                cli=listar_busquedaUpdate(itemSeleccionado);
                //rellenar espacios
                if(cli.getCODCLIENTE()!=0){
                    rellenar_espaciosUpdate(cli);
                }else{
                    JOptionPane.showMessageDialog(null, "No se encontró al cliente!");
                }
                //DESBLOQUEAR CAMPOS
                desbloquear_camposUpdate();
            }
        }
    });}
    public void rellenar_espaciosUpdate(CLIENTE cli){
        vista.txtNombre1.setText(cli.getNOMBRE());
        vista.txtApellido1.setText(cli.getAPELLIDO());
        vista.txtDNI1.setText(cli.getDNI());
        vista.txtCelular1.setText(cli.getCELULAR());
    }
    public void bloquear_camposUpdate(){
        vista.txtNombre1.setEditable(false);
        vista.txtApellido1.setEditable(false);
        vista.txtDNI1.setEditable(false);
        vista.txtCelular1.setEditable(false);
    }
    public void desbloquear_camposUpdate(){
        vista.txtNombre1.setEditable(true);
        vista.txtApellido1.setEditable(true);
        vista.txtDNI1.setEditable(true);
        vista.txtCelular1.setEditable(true);
    }
    //DELETE
    private void inicializar_botonesDelete(){
        vista.btnLupa2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (vista.txtBuscador2.getText().isEmpty() || vista.txtBuscador2.getText().equalsIgnoreCase("Ingrese código del cliente")) {
                    JOptionPane.showMessageDialog(null, "Digite el código a buscar");
                }else{
                    CLIENTE cli = new CLIENTE();
                    
                    //MOSTRAR CODIGO
                    cli=listar_busquedaDelete(vista.txtBuscador2.getText());
                    //rellenar espacios
                    if(cli.getCODCLIENTE()!=0){
                        rellenar_espaciosDelete(cli);
                    }else{
                        JOptionPane.showMessageDialog(null, "No se encontró al cliente!");
                    }
                }
            }
        });
        //BOTON DE CANCELAR BUSQUEDA
        vista.btnActualizar2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                vista.txtBuscador2.getCaret().setVisible(false);
                vista.txtBuscador2.setText("Ingrese código del cliente");
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
                CLIENTE cli = new CLIENTE();
                // Acciones a realizar con el elemento seleccionado
                cli=listar_busquedaDelete(itemSeleccionado);
                //rellenar espacios
                if(cli.getCODCLIENTE()!=0){
                    rellenar_espaciosDelete(cli);
                }else{
                    JOptionPane.showMessageDialog(null, "No se encontró al cliente!");
                }
            }
        }
    });}
    public void rellenar_espaciosDelete(CLIENTE cli){
        vista.txtNombre2.setText(cli.getNOMBRE());
        vista.txtApellido2.setText(cli.getAPELLIDO());
        vista.txtDNI2.setText(cli.getDNI());
        vista.txtCelular2.setText(cli.getCELULAR());
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
        vista.txtBuscador.setText("Ingrese nombre del cliente");
        vista.txtBuscador1.setText("Ingrese código del cliente");
        vista.txtBuscador2.setText("Ingrese código del cliente");
        vista.txtBuscador.setForeground(Color.gray);
        vista.txtBuscador1.setForeground(Color.gray);
        vista.txtBuscador2.setForeground(Color.gray);
        
        vista.txtNombre.setText("");
        vista.txtApellido.setText("");
        vista.txtCelular.setText("");
        vista.txtDNI.setText("");
        
        vista.txtNombre1.setText("");
        vista.txtApellido1.setText("");
        vista.txtCelular1.setText("");
        vista.txtDNI1.setText("");
        
        vista.txtNombre2.setText("");
        vista.txtApellido2.setText("");
        vista.txtCelular2.setText("");
        vista.txtDNI2.setText("");
    }
    
    public Cliente getVista() {
        return vista;
    }

    public void setVista(Cliente vista) {
        this.vista = vista;
    }
    
}
