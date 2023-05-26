/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Frames.Principal;

/**
 *
 * @author arnol
 */
public class ControllerPrincipal {
    private Principal vista;
    public ControllerPrincipal() {
        vista = new Principal();
    }

    public ControllerPrincipal(Principal vista) {
        this.vista = vista;
    }
    
    public void run(String usuario, String nombre) {
        String rol="";
        vista.setVisible(true); //hacer visible
        vista.setLocationRelativeTo(null); //centrar
        vista.panelOpciones1.setVisible(false);
        vista.panelOpciones2.setVisible(false);
        vista.panelCliente.setVisible(false);
        vista.panelPedido.setVisible(false);
        vista.panelEmpleado.setVisible(false);
        vista.panelProveedor.setVisible(false);
        if(usuario.equals("Q")){
            rol="Químico";
            visible_QOpcion(nombre,rol);
        }else if(usuario.equals("JA")){
            rol="Jefe de almacén";
            visible_JAOpcion(nombre,rol);
        }else if(usuario.equals("G")){
            rol="Gerente";
            visible_GOpcion(nombre,rol);
        }
    }
    public void visible_QOpcion(String nombre,String rol){
        vista.panelOpciones1.setVisible(true);
        vista.panelCliente.setVisible(true);
        vista.panelPedido.setVisible(true);
        //DATOS DEL USUARIO
        vista.txtRol.setText(rol);
        vista.txtNombre.setText(nombre);
        vista.panelOpcionesRol.setVisible(false);
    }
    public void visible_GOpcion(String nombre,String rol){
        visible_QOpcion(nombre,rol);
        vista.panelEmpleado.setVisible(true);
        vista.panelProveedor.setVisible(true);
        
        vista.panelOpcionesRol.setVisible(true);
        vista.txtAtras.setVisible(false);
    }
    public void visible_JAOpcion(String nombre,String rol){
        vista.panelOpciones2.setVisible(true);
        //DATOS DEL USUARIO
        vista.txtRol.setText(rol);
        vista.txtNombre.setText(nombre);
        vista.panelOpcionesRol.setVisible(false);
    }
    
}
