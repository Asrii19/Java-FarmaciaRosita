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
public class ControllerLista_Producto {
    private Producto vista;
    private LISTA_PRODUCTODAO listprod_dao = new LISTA_PRODUCTODAO();
    private PRODUCTODAO prod_dao = new PRODUCTODAO();
    private PROVEEDORDAO pro_dao = new PROVEEDORDAO();
    private ControllerMetodos cmet=new ControllerMetodos();
    public ControllerLista_Producto() {
        vista = new Producto();
    }
    
    public ControllerLista_Producto(Producto c) {
        vista = c;
        System.out.println("");
    }
    
    public void run() {
        inicializar_botones();
        try{
            inicializar_botonesUpdate();
            inicializar_botonesDelete();
            inicializar_boxes();
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    //Método que captura la información del Producto
    public void agregar(){
        String codlistaprod = String.valueOf(cmet.mayor_codlistaprod()+1);
        String codproducto = obtener_ProductoCod(vista.txtCodprod10.getSelectedItem().toString());
        java.sql.Date fecvenc = new java.sql.Date(vista.txtFecvenc10.getDate().getTime());
        String codproveedor = obtener_ProveedorCod(vista.txtDist10.getSelectedItem().toString());
        String cantidad = vista.txtCantidad10.getText();
        
        LISTA_PRODUCTO prod = new LISTA_PRODUCTO();
        prod.setCODLISTAPRODUCTO(Integer.parseInt(codlistaprod));
        prod.setCODPRODUCTO(Integer.parseInt(codproducto));
        prod.setFECVENC(fecvenc);
        prod.setCODPROVEEDOR(Integer.parseInt(codproveedor));
        prod.setCANTIDAD(cantidad);
        listprod_dao.InsertPRODUCTO(prod); //Añadimos a la base de datos (Producto)
        //SE AUMENTA LA CANTIDAD EN EL PRODUCTO
        aumentarCantidad(codproducto,Integer.parseInt(cantidad));
        
        JOptionPane.showMessageDialog(null, "Producto registrado!!");
    }
    public void aumentarCantidad(String cod,int cantidad){
        List<PRODUCTO> lista=prod_dao.ListPRODUCTO();
        for(int i=0;i<lista.size();i++){
            if(cod.equals(Integer.toString(lista.get(i).getCODPRODUCTO()))){
                lista.get(i).setCANTIDAD(Integer.toString(Integer.parseInt(lista.get(i).getCANTIDAD())+cantidad));
                prod_dao.ModificarCantidad(lista.get(i));
                break;
            }
        }
    }
    public void disminuirCantidad(String cod,int cantidad){
        List<PRODUCTO> lista=prod_dao.ListPRODUCTO();
        for(int i=0;i<lista.size();i++){
            if(cod.equals(Integer.toString(lista.get(i).getCODPRODUCTO()))){
                lista.get(i).setCANTIDAD(Integer.toString(Integer.parseInt(lista.get(i).getCANTIDAD())-cantidad));
                prod_dao.ModificarCantidad(lista.get(i));
                break;
            }
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
    //Método para obtiene los datos de los empleado y muestra en una tabla
    public void listar(){
        List<LISTA_PRODUCTO> lista_prod = listprod_dao.ListLISTA_PRODUCTO();
        
        vista.modelo = (DefaultTableModel)vista.tabla11.getModel();
        vista.sorter = new TableRowSorter<> (vista.modelo);
        vista.tabla11.setRowSorter(vista.sorter);
        
        Object[] ob = new Object[7]; 
        
        for(int i=0;i<lista_prod.size();i++){
            ob[0]=lista_prod.get(i).getCODLISTAPRODUCTO();
            ob[1]=obtener_ProductoNombre(lista_prod.get(i).getCODPRODUCTO());
            ob[2]=lista_prod.get(i).getFECVENC();
            ob[3]=obtener_ProveedorNombre(lista_prod.get(i).getCODPROVEEDOR());
            ob[4]=lista_prod.get(i).getCANTIDAD();
            vista.modelo.addRow(ob);
        }
        
        vista.tabla11.setModel(vista.modelo);
    }
    
    public void listar_busqueda(String consulta){
        List<LISTA_PRODUCTO> lista_prod = listprod_dao.ListLISTA_PRODUCTO();
        vista.modelo = (DefaultTableModel)vista.tabla11.getModel();
        vista.sorter = new TableRowSorter<> (vista.modelo);
        vista.tabla11.setRowSorter(vista.sorter);
        
        Object[] ob = new Object[7]; 
        
        for(int i=0;i<lista_prod.size();i++){
            ob[0]=lista_prod.get(i).getCODLISTAPRODUCTO();
            ob[1]=obtener_ProductoNombre(lista_prod.get(i).getCODPRODUCTO());
            ob[2]=lista_prod.get(i).getFECVENC();
            ob[3]=obtener_ProveedorNombre(lista_prod.get(i).getCODPROVEEDOR());
            ob[4]=lista_prod.get(i).getCANTIDAD();
            if(ob[1].toString().substring(0,consulta.length()).equalsIgnoreCase(consulta)){
                vista.modelo.addRow(ob);
            }
        }
        vista.tabla11.setModel(vista.modelo);
    }
    public LISTA_PRODUCTO listar_busquedaUpdate(String consulta){
        List<LISTA_PRODUCTO> lista_prod = listprod_dao.ListLISTA_PRODUCTO();
        LISTA_PRODUCTO prod = new LISTA_PRODUCTO();
        
        for(int i=0;i<lista_prod.size();i++){
            if(Integer.toString(lista_prod.get(i).getCODLISTAPRODUCTO()).substring(0,consulta.length()).equals(consulta)){
                vista.boxCod12.setSelectedIndex(i);
                prod = lista_prod.get(i);
                return prod;
            }
        }
        return prod;
    }
    public LISTA_PRODUCTO listar_busquedaDelete(String consulta){
        List<LISTA_PRODUCTO> lista_prod = listprod_dao.ListLISTA_PRODUCTO();
        LISTA_PRODUCTO prod = new LISTA_PRODUCTO();
        
        for(int i=0;i<lista_prod.size();i++){
            if(Integer.toString(lista_prod.get(i).getCODLISTAPRODUCTO()).substring(0,consulta.length()).equals(consulta)){
                vista.boxCod13.setSelectedIndex(i);
                prod = lista_prod.get(i);
                return prod;
            }
        }
        return prod;
    }
    //Método que captura la información del Producto que se desea actualizar
    public void actualizar(){
        String codlistprod = (String) vista.boxCod12.getSelectedItem();
        String codprod = obtener_ProductoCod(vista.txtCodproducto12.getSelectedItem().toString());
        java.sql.Date fecvenc = new java.sql.Date(vista.txtFecvenc12.getDate().getTime());
        String codprov = obtener_ProveedorCod(vista.txtDist12.getSelectedItem().toString());
        String cantidad = vista.txtCantidad12.getText();
        
        LISTA_PRODUCTO prod = new LISTA_PRODUCTO();
        prod.setCODLISTAPRODUCTO(Integer.parseInt(codlistprod));
        prod.setCODPRODUCTO(Integer.parseInt(codprod));
        prod.setFECVENC(fecvenc);
        prod.setCODPROVEEDOR(Integer.parseInt(codprov));
        prod.setCANTIDAD(cantidad);
        
        //se modifica la canridad en producto
        LISTA_PRODUCTO listpro=new LISTA_PRODUCTO();
        listpro=buscarProductoLista(Integer.parseInt(codlistprod));
        if(Integer.parseInt(cantidad)>Integer.parseInt(listpro.getCANTIDAD())){ //si la cantidad ingresada es mayor que la que teniamos (AUMENTA)
            aumentarCantidad(Integer.toString(listpro.getCODPRODUCTO()),Integer.parseInt(cantidad)-Integer.parseInt(listpro.getCANTIDAD()));
        }else if(Integer.parseInt(cantidad)<Integer.parseInt(listpro.getCANTIDAD())){
            disminuirCantidad(Integer.toString(listpro.getCODPRODUCTO()),Integer.parseInt(listpro.getCANTIDAD())-Integer.parseInt(cantidad));
        }
        
        listprod_dao.ModPRODUCTO(prod); //Añadimos a la base de datos (Producto)
        JOptionPane.showMessageDialog(null, "Producto actualizado!!");
    }
    //Método que elimina un Producto seleccionado 
    public boolean eliminar(){
        int opcion = JOptionPane.showConfirmDialog(null, "¿Quieres eliminar al Producto?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            LISTA_PRODUCTO prod = new LISTA_PRODUCTO();
            prod.setCODLISTAPRODUCTO(Integer.parseInt(vista.boxCod13.getSelectedItem().toString()));
            //DISMINUYE LA CANTIDAD
            prod = buscarProductoLista(prod.getCODLISTAPRODUCTO());
            disminuirCantidad(Integer.toString(prod.getCODPRODUCTO()),Integer.parseInt(prod.getCANTIDAD()));
            listprod_dao.eliPRODUCTO(prod);
            return true;
        }else{
            return false;
        }
    }
    public LISTA_PRODUCTO buscarProductoLista(int id){
        List<LISTA_PRODUCTO> lista=listprod_dao.ListLISTA_PRODUCTO();
        LISTA_PRODUCTO lp = new LISTA_PRODUCTO();
        for(int i=0;i<lista.size();i++){
            if(lista.get(i).getCODLISTAPRODUCTO()==id){
                lp=lista.get(i);
                break;
            }
        }
        return lp;
    }
    //Método que remueve datos de la tabla para actualizarla
    public void limpiarTabla(){
        for(int i = 0; i < vista.modelo.getRowCount();i++){
            vista.modelo.removeRow(i);
            i=i-1;
        }
    }
    //Listar opciones comboboxes
    
    public void listar_combobox10(){
        List<PRODUCTO> list_prod=prod_dao.ListPRODUCTO();
        for(int i=0;i<list_prod.size();i++){
            vista.txtCodprod10.addItem(obtener_ProductoNombre(list_prod.get(i).getCODPRODUCTO()));
        }
        vista.txtCodprod10.setSelectedIndex(-1);
        
        List<PROVEEDOR> list_pro=pro_dao.ListPROVEEDOR();
        for(int i=0;i<list_pro.size();i++){
            vista.txtDist10.addItem(obtener_ProveedorNombre(list_pro.get(i).getCODPROVEEDOR()));
        }
        vista.txtDist10.setSelectedIndex(-1);
    }
    public void listar_combobox12(){
        List<PRODUCTO> list_prod=prod_dao.ListPRODUCTO();
        for(int i=0;i<list_prod.size();i++){
            vista.txtCodproducto12.addItem(obtener_ProductoNombre(list_prod.get(i).getCODPRODUCTO()));
        }
        vista.txtCodproducto12.setSelectedIndex(-1);
        
        List<PROVEEDOR> list_pro=pro_dao.ListPROVEEDOR();
        for(int i=0;i<list_pro.size();i++){
            vista.txtDist12.addItem((obtener_ProveedorNombre(list_pro.get(i).getCODPROVEEDOR())));
        }
        vista.txtDist12.setSelectedIndex(-1);
        
        List<LISTA_PRODUCTO> list_listpro=listprod_dao.ListLISTA_PRODUCTO();
        for(int i=0;i<list_listpro.size();i++){
            vista.boxCod12.addItem(Integer.toString(list_listpro.get(i).getCODLISTAPRODUCTO()));
        }
        vista.boxCod12.setSelectedIndex(-1);
    }
    public void listar_combobox13(){
        List<PRODUCTO> list_prod=prod_dao.ListPRODUCTO();
        for(int i=0;i<list_prod.size();i++){
            vista.txtCodproducto13.addItem(obtener_ProductoNombre(list_prod.get(i).getCODPRODUCTO()));
        }
        vista.txtCodproducto13.setSelectedIndex(-1);
        
        List<PROVEEDOR> list_pro=pro_dao.ListPROVEEDOR();
        for(int i=0;i<list_pro.size();i++){
            vista.txtDist13.addItem(obtener_ProveedorNombre(list_pro.get(i).getCODPROVEEDOR()));
        }
        vista.txtDist13.setSelectedIndex(-1);
        
        List<LISTA_PRODUCTO> list_listpro=listprod_dao.ListLISTA_PRODUCTO();
        for(int i=0;i<list_listpro.size();i++){
            vista.boxCod13.addItem(Integer.toString(list_listpro.get(i).getCODLISTAPRODUCTO()));
        }
        vista.boxCod13.setSelectedIndex(-1);
    }
    //limpiar comboboxes
    public void limpiar_combobox(){
        vista.boxCod12.removeAllItems();
        vista.boxCod13.removeAllItems();
        vista.txtCodprod10.removeAllItems();
        vista.txtCodproducto12.removeAllItems();
        vista.txtCodproducto13.removeAllItems();
        vista.txtDist10.removeAllItems();
        vista.txtDist12.removeAllItems();
        vista.txtDist13.removeAllItems();
    }
    
    //BOTON BUSQUEDA Y ACTUALIZAR
    //BOTON DE LUPA (BUSCAR)
    private void inicializar_botones(){
        vista.btnLupa11.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (vista.txtBuscador11.getText().isEmpty() || vista.txtBuscador11.getText().equalsIgnoreCase("Ingrese nombre del Producto")) {
                    JOptionPane.showMessageDialog(null, "Digite el nombre a buscar");
                }else{
                    limpiarTabla();
                    listar_busqueda(vista.txtBuscador11.getText());
                }
            }
        });
        //BOTON DE CANCELAR BUSQUEDA
        vista.btnActualizar11.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                vista.txtBuscador11.getCaret().setVisible(false);
                vista.txtBuscador11.setText("Ingrese nombre del Producto");
                vista.txtBuscador11.setForeground(Color.gray);
                limpiarTabla();
                listar();
            }
        });
    }
    //UPDATE
    private void inicializar_botonesUpdate(){
        vista.btnLupa12.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (vista.txtBuscador12.getText().isEmpty() || vista.txtBuscador12.getText().equalsIgnoreCase("Ingrese código del Producto")) {
                    JOptionPane.showMessageDialog(null, "Digite el código a buscar");
                }else{
                    LISTA_PRODUCTO prod = new LISTA_PRODUCTO();
                    
                    //MOSTRAR CODIGO
                    prod=listar_busquedaUpdate(vista.txtBuscador12.getText());
                    
                    //rellenar espacios
                    if(prod.getCODLISTAPRODUCTO()!=0){
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
        vista.btnActualizar12.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                vista.txtBuscador12.getCaret().setVisible(false);
                vista.txtBuscador12.setText("Ingrese código del Producto");
                vista.txtBuscador12.setForeground(Color.gray);
                vista.boxCod12.setSelectedIndex(-1);
                limpiar_campos();
                bloquear_camposUpdate();
            }
        });
    }
    public void rellenar_datosUpdate(){
        vista.boxCod12.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if(!(vista.boxCod12.getSelectedIndex()==-1)){
                String itemSeleccionado = (String) vista.boxCod12.getSelectedItem();
                LISTA_PRODUCTO prod = new LISTA_PRODUCTO();
                // Acciones a realizar con el elemento seleccionado
                prod=listar_busquedaUpdate(itemSeleccionado);
                //rellenar espacios
                if(prod.getCODLISTAPRODUCTO()!=0){
                    rellenar_espaciosUpdate(prod);
                }else{
                    JOptionPane.showMessageDialog(null, "No se encontró al Producto!");
                }
                //DESBLOQUEAR CAMPOS
                desbloquear_camposUpdate();
            }
        }
    });}
    public void rellenar_espaciosUpdate(LISTA_PRODUCTO prod){
        vista.txtCodproducto12.setSelectedItem(obtener_ProductoNombre(prod.getCODPRODUCTO()));
        vista.txtFecvenc12.setDate(prod.getFECVENC());
        vista.txtDist12.setSelectedItem(obtener_ProveedorNombre(prod.getCODPROVEEDOR()));
        vista.txtCantidad12.setText(prod.getCANTIDAD());
    }
    public void bloquear_camposUpdate(){
        vista.txtCodproducto12.setEnabled(false);
        vista.txtFecvenc12.setEnabled(false);
        vista.txtDist12.setEnabled(false);
        vista.txtCantidad12.setEditable(false);
    }
    public void desbloquear_camposUpdate(){
        vista.txtCodproducto12.setEnabled(true);
        vista.txtFecvenc12.setEnabled(true);
        vista.txtDist12.setEnabled(true);
        vista.txtCantidad12.setEditable(true);
    }
    //DELETE
    private void inicializar_botonesDelete(){
        vista.btnLupa13.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (vista.txtBuscador13.getText().isEmpty() || vista.txtBuscador13.getText().equalsIgnoreCase("Ingrese código del Producto")) {
                    JOptionPane.showMessageDialog(null, "Digite el código a buscar");
                }else{
                    LISTA_PRODUCTO prod = new LISTA_PRODUCTO();
                    
                    //MOSTRAR CODIGO
                    prod=listar_busquedaDelete(vista.txtBuscador13.getText());
                    //rellenar espacios
                    if(prod.getCODLISTAPRODUCTO()!=0){
                        rellenar_espaciosDelete(prod);
                    }else{
                        JOptionPane.showMessageDialog(null, "No se encontró al Producto!");
                    }
                }
            }
        });
        //BOTON DE CANCELAR BUSQUEDA
        vista.btnActualizar13.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                vista.txtBuscador13.getCaret().setVisible(false);
                vista.txtBuscador13.setText("Ingrese código del Producto");
                vista.txtBuscador13.setForeground(Color.gray);
                vista.boxCod13.setSelectedIndex(-1);
                limpiar_campos();
            }
        });
    }
    public void rellenar_datosDelete(){
        vista.boxCod13.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if(!(vista.boxCod13.getSelectedIndex()==-1)){
                String itemSeleccionado = (String) vista.boxCod13.getSelectedItem();
                LISTA_PRODUCTO prod = new LISTA_PRODUCTO();
                // Acciones a realizar con el elemento seleccionado
                prod=listar_busquedaDelete(itemSeleccionado);
                //rellenar espacios
                if(prod.getCODLISTAPRODUCTO()!=0){
                    rellenar_espaciosDelete(prod);
                }else{
                    JOptionPane.showMessageDialog(null, "No se encontró al Producto!");
                }
            }
        }
    });}
    public void rellenar_espaciosDelete(LISTA_PRODUCTO prod){
        vista.txtCodproducto13.setSelectedItem(obtener_ProductoNombre(prod.getCODPRODUCTO()));
        vista.txtFecvenc13.setDate(prod.getFECVENC());
        vista.txtDist13.setSelectedItem(obtener_ProveedorNombre(prod.getCODPROVEEDOR()));
        vista.txtCantidad13.setText(prod.getCANTIDAD());
    }
    //INICIALIZAR
    private void inicializar_boxes(){
        rellenar_datosUpdate();
        rellenar_datosDelete();
    }
    //VISIBLE EL CRUD
    public void visible_create(){
        //HACER VISIBLE EL PANEL CREATE
        vista.panelCreate1.setVisible(true);
        //OCULTA LOS OTROS
        vista.panelRead1.setVisible(false);
        vista.panelUpdate1.setVisible(false);
        vista.panelDelete1.setVisible(false);
    }
    public void visible_read(){
        //HACER VISIBLE EL PANEL READ
        vista.panelRead1.setVisible(true);
        //OCULTA LOS OTROS
        vista.panelUpdate1.setVisible(false);
        vista.panelCreate1.setVisible(false);
        vista.panelDelete1.setVisible(false);
    }
    public void visible_update(){
        //HACER VISIBLE EL PANEL UPDATE
        vista.panelUpdate1.setVisible(true);
        //OCULTA LOS OTROS
        vista.panelRead1.setVisible(false);
        vista.panelCreate1.setVisible(false);
        vista.panelDelete1.setVisible(false);
    }
    public void visible_delete(){
        //HACER VISIBLE EL PANEL DELETE
        vista.panelDelete1.setVisible(true);
        //OCULTA LOS OTROS
        vista.panelUpdate1.setVisible(false);
        vista.panelCreate1.setVisible(false);
        vista.panelRead1.setVisible(false);
    }
    //LIMPIAR CAMPOS
    public void limpiar_campos(){
        //BARRAS DE BUSQUEDA
        vista.txtBuscador11.setText("Ingrese nombre del Producto");
        vista.txtBuscador12.setText("Ingrese código del Producto");
        vista.txtBuscador13.setText("Ingrese código del Producto");
        vista.txtBuscador11.setForeground(Color.gray);
        vista.txtBuscador12.setForeground(Color.gray);
        vista.txtBuscador13.setForeground(Color.gray);
        
        vista.txtCodprod10.setSelectedIndex(-1);
        vista.txtFecvenc10.setDate(null);
        vista.txtDist10.setSelectedIndex(-1);
        vista.txtCantidad10.setText("");
        
        vista.txtCodproducto12.setSelectedIndex(-1);
        vista.txtFecvenc12.setDate(null);
        vista.txtDist12.setSelectedIndex(-1);
        vista.txtCantidad12.setText("");
        
        vista.txtCodproducto13.setSelectedIndex(-1);
        vista.txtFecvenc13.setDate(null);
        vista.txtDist13.setSelectedIndex(-1);
        vista.txtCantidad13.setText("");
    }
    
    public Producto getVista() {
        return vista;
    }

    public void setVista(Producto vista) {
        this.vista = vista;
    }
    
}
