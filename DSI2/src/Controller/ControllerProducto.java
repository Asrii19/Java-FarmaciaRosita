/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import ClasesBasicas.PRODUCTO;
import ClasesBasicas.PROVEEDOR;
import DAO.PRODUCTODAO;
import DAO.PROVEEDORDAO;
import Frames.Producto;
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
public class ControllerProducto {
    private Producto vista;
    private PRODUCTODAO prod_dao = new PRODUCTODAO();
    private PROVEEDORDAO pro_dao = new PROVEEDORDAO();
    private ControllerMetodos cmet=new ControllerMetodos();
    public ControllerProducto() {
        vista = new Producto();
        ControllerLista_Producto clist = new ControllerLista_Producto(vista);
        clist.run();
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
    public ControllerProducto(Producto c) {
        vista = c;
    }
    
    public void run() {
        vista.setVisible(true); //hacer visible
        vista.panelCreate.setVisible(false);
        vista.panelRead.setVisible(false);
        vista.panelUpdate.setVisible(false);
        vista.panelDelete.setVisible(false);
        vista.panelCreate1.setVisible(false);
        vista.panelRead1.setVisible(false);
        vista.panelUpdate1.setVisible(false);
        vista.panelDelete1.setVisible(false);
    }
    
    //Método que captura la información del Producto
    public void agregar(){
        String codprod = String.valueOf(cmet.mayor_codprod()+1);
        String nombre = vista.txtNombre.getText();
        String descripcion = vista.txtDescripcion.getText();
        
        PRODUCTO prod = new PRODUCTO();
        prod.setCODPRODUCTO(Integer.parseInt(codprod));
        prod.setNOMBRE(nombre);
        prod.setDESCRIPCION(descripcion);
        prod_dao.InsertPRODUCTO(prod); //Añadimos a la base de datos (Producto)
        JOptionPane.showMessageDialog(null, "Producto registrado!!");
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
    //Método para obtiene los datos de los empleado y muestra en una tabla
    public void listar(){
        List<PRODUCTO> lista_prod = prod_dao.ListPRODUCTO();
        
        vista.modelo = (DefaultTableModel)vista.tabla.getModel();
        vista.sorter = new TableRowSorter<> (vista.modelo);
        vista.tabla.setRowSorter(vista.sorter);
        
        Object[] ob = new Object[7]; 
        
        for(int i=0;i<lista_prod.size();i++){
            ob[0]=lista_prod.get(i).getCODPRODUCTO();
            ob[1]=lista_prod.get(i).getNOMBRE();
            ob[2]=lista_prod.get(i).getDESCRIPCION();
            ob[3]=lista_prod.get(i).getCANTIDAD();
            vista.modelo.addRow(ob);
        }
        
        vista.tabla.setModel(vista.modelo);
    }
    
    public void listar_busqueda(String consulta){
        List<PRODUCTO> lista_prod = prod_dao.ListPRODUCTO();
        vista.modelo = (DefaultTableModel)vista.tabla.getModel();
        vista.sorter = new TableRowSorter<> (vista.modelo);
        vista.tabla.setRowSorter(vista.sorter);
        
        Object[] ob = new Object[7]; 
        
        for(int i=0;i<lista_prod.size();i++){
            ob[0]=lista_prod.get(i).getCODPRODUCTO();
            ob[1]=lista_prod.get(i).getNOMBRE();
            ob[2]=lista_prod.get(i).getDESCRIPCION();
            ob[3]=lista_prod.get(i).getCANTIDAD();
            if(lista_prod.get(i).getNOMBRE().substring(0,consulta.length()).equalsIgnoreCase(consulta)){
                vista.modelo.addRow(ob);
            }
        }
        vista.tabla.setModel(vista.modelo);
    }
    public PRODUCTO listar_busquedaUpdate(String consulta){
        List<PRODUCTO> lista_prod = prod_dao.ListPRODUCTO();
        PRODUCTO prod = new PRODUCTO();
        
        for(int i=0;i<lista_prod.size();i++){
            if(Integer.toString(lista_prod.get(i).getCODPRODUCTO()).substring(0,consulta.length()).equals(consulta)){
                vista.boxCod.setSelectedIndex(i);
                prod = lista_prod.get(i);
                return prod;
            }
        }
        return prod;
    }
    public PRODUCTO listar_busquedaDelete(String consulta){
        List<PRODUCTO> lista_prod = prod_dao.ListPRODUCTO();
        PRODUCTO prod = new PRODUCTO();
        
        for(int i=0;i<lista_prod.size();i++){
            if(Integer.toString(lista_prod.get(i).getCODPRODUCTO()).substring(0,consulta.length()).equals(consulta)){
                vista.boxCod2.setSelectedIndex(i);
                prod = lista_prod.get(i);
                return prod;
            }
        }
        return prod;
    }
    //Método que captura la información del Producto que se desea actualizar
    public void actualizar(){
        String codprod = (String) vista.boxCod.getSelectedItem();
        String nombre = vista.txtNombre1.getText();
        String descripcion = vista.txtDescripcion1.getText();
        
        PRODUCTO prod = new PRODUCTO();
        prod.setCODPRODUCTO(Integer.parseInt(codprod));
        prod.setNOMBRE(nombre);
        prod.setDESCRIPCION(descripcion);
        prod_dao.ModPRODUCTO(prod); //Añadimos a la base de datos (Producto)
        JOptionPane.showMessageDialog(null, "Producto actualizado!!");
    }
    //Método que elimina un Producto seleccionado 
    public boolean eliminar(){
        int opcion = JOptionPane.showConfirmDialog(null, "¿Quieres eliminar al Producto?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            PRODUCTO prod = new PRODUCTO();
            prod.setCODPRODUCTO(Integer.parseInt(vista.boxCod2.getSelectedItem().toString()));
            prod_dao.eliPRODUCTO(prod);
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
        List<PRODUCTO> list_prod=prod_dao.ListPRODUCTO();
        for(int i=0;i<list_prod.size();i++){
            vista.boxCod.addItem(Integer.toString(list_prod.get(i).getCODPRODUCTO()));
        }

        vista.boxCod.setSelectedIndex(-1);
    }
    public void listar_combobox2(){
        List<PRODUCTO> list_prod=prod_dao.ListPRODUCTO();
        for(int i=0;i<list_prod.size();i++){
            vista.boxCod2.addItem(Integer.toString(list_prod.get(i).getCODPRODUCTO()));
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
                if (vista.txtBuscador.getText().isEmpty() || vista.txtBuscador.getText().equalsIgnoreCase("Ingrese nombre del Producto")) {
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
                vista.txtBuscador.setText("Ingrese nombre del Producto");
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
                if (vista.txtBuscador1.getText().isEmpty() || vista.txtBuscador1.getText().equalsIgnoreCase("Ingrese código del Producto")) {
                    JOptionPane.showMessageDialog(null, "Digite el código a buscar");
                }else{
                    PRODUCTO prod = new PRODUCTO();
                    
                    //MOSTRAR CODIGO
                    prod=listar_busquedaUpdate(vista.txtBuscador1.getText());
                    
                    //rellenar espacios
                    if(prod.getCODPRODUCTO()!=0){
                        rellenar_espaciosUpdate(prod);
                    }else{
                        JOptionPane.showMessageDialog(null, "No se encontró al Producto!");
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
                vista.txtBuscador1.setText("Ingrese código del Producto");
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
                PRODUCTO prod = new PRODUCTO();
                // Acciones a realizar con el elemento seleccionado
                prod=listar_busquedaUpdate(itemSeleccionado);
                //rellenar espacios
                if(prod.getCODPRODUCTO()!=0){
                    rellenar_espaciosUpdate(prod);
                }else{
                    JOptionPane.showMessageDialog(null, "No se encontró al Producto!");
                }
                //DESBLOQUEAR CAMPOS
                desbloquear_camposUpdate();
            }
        }
    });}
    public void rellenar_espaciosUpdate(PRODUCTO prod){
        vista.txtNombre1.setText(prod.getNOMBRE());
        vista.txtDescripcion1.setText(prod.getDESCRIPCION());
    }
    public void bloquear_camposUpdate(){
        vista.txtNombre1.setEditable(false);
        vista.txtDescripcion1.setEditable(false);
    }
    public void desbloquear_camposUpdate(){
        vista.txtNombre1.setEditable(true);
        vista.txtDescripcion1.setEditable(true);
    }
    //DELETE
    private void inicializar_botonesDelete(){
        vista.btnLupa2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (vista.txtBuscador2.getText().isEmpty() || vista.txtBuscador2.getText().equalsIgnoreCase("Ingrese código del Producto")) {
                    JOptionPane.showMessageDialog(null, "Digite el código a buscar");
                }else{
                    PRODUCTO prod = new PRODUCTO();
                    
                    //MOSTRAR CODIGO
                    prod=listar_busquedaDelete(vista.txtBuscador2.getText());
                    //rellenar espacios
                    if(prod.getCODPRODUCTO()!=0){
                        rellenar_espaciosDelete(prod);
                    }else{
                        JOptionPane.showMessageDialog(null, "No se encontró al Producto!");
                    }
                }
            }
        });
        //BOTON DE CANCELAR BUSQUEDA
        vista.btnActualizar2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                vista.txtBuscador2.getCaret().setVisible(false);
                vista.txtBuscador2.setText("Ingrese código del Producto");
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
                PRODUCTO prod = new PRODUCTO();
                // Acciones a realizar con el elemento seleccionado
                prod=listar_busquedaDelete(itemSeleccionado);
                //rellenar espacios
                if(prod.getCODPRODUCTO()!=0){
                    rellenar_espaciosDelete(prod);
                }else{
                    JOptionPane.showMessageDialog(null, "No se encontró al Producto!");
                }
            }
        }
    });}
    public void rellenar_espaciosDelete(PRODUCTO prod){
        vista.txtNombre2.setText(prod.getNOMBRE());
        vista.txtDescripcion2.setText(prod.getDESCRIPCION());
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
        vista.txtBuscador.setText("Ingrese nombre del Producto");
        vista.txtBuscador1.setText("Ingrese código del Producto");
        vista.txtBuscador2.setText("Ingrese código del Producto");
        vista.txtBuscador.setForeground(Color.gray);
        vista.txtBuscador1.setForeground(Color.gray);
        vista.txtBuscador2.setForeground(Color.gray);
        
        vista.txtNombre.setText("");
        vista.txtDescripcion.setText("");
        vista.txtDescripcion.setText("");
        
        vista.txtNombre1.setText("");
        vista.txtDescripcion1.setText("");
        
        vista.txtNombre2.setText("");
        vista.txtDescripcion2.setText("");
    }
    
    public Producto getVista() {
        return vista;
    }

    public void setVista(Producto vista) {
        this.vista = vista;
    }
    
}
