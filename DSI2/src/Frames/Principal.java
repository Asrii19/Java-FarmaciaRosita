package Frames;

import Controller.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author GIGABYTE
 */
public class Principal extends javax.swing.JFrame {
    
    int xMouse, yMouse;
    boolean[] opciones1 = {true, true, true, true};
    boolean[] opciones2 = {true, true};
    ControllerPrincipal cpri = new ControllerPrincipal(this);
    
    public Principal() {
        initComponents();
        setIconImage(getIconImage());
    }
    
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("img/logo.png"));
        return retValue;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelIzquierda = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panelOpcionesRol = new javax.swing.JPanel();
        txtAtras = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtSiguiente = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        panelOpciones2 = new javax.swing.JPanel();
        panelProducto = new javax.swing.JPanel();
        txtCliente1 = new javax.swing.JLabel();
        panelFiltrarFV = new javax.swing.JPanel();
        txtCompania1 = new javax.swing.JLabel();
        panelOpciones1 = new javax.swing.JPanel();
        panelCliente = new javax.swing.JPanel();
        txtCliente = new javax.swing.JLabel();
        panelPedido = new javax.swing.JPanel();
        txtCompania = new javax.swing.JLabel();
        panelEmpleado = new javax.swing.JPanel();
        txtEmpleado = new javax.swing.JLabel();
        panelProveedor = new javax.swing.JPanel();
        txtProveedor = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        panelAtras = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelRol = new javax.swing.JPanel();
        txtRol = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        panelSuperior = new javax.swing.JPanel();
        panelMini = new javax.swing.JPanel();
        textMini = new javax.swing.JLabel();
        panelSalir = new javax.swing.JPanel();
        textSalir = new javax.swing.JLabel();
        panelCambiante = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelIzquierda.setBackground(new java.awt.Color(0, 0, 0));
        panelIzquierda.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("GRUPO 1");
        panelIzquierda.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, 190, 40));

        jLabel3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 29)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("DSI");
        panelIzquierda.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 130, 40));

        panelOpcionesRol.setBackground(new java.awt.Color(0, 0, 0));
        panelOpcionesRol.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtAtras.setBackground(new java.awt.Color(153, 153, 153));
        txtAtras.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAtrasMouseClicked(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Atras");

        javax.swing.GroupLayout txtAtrasLayout = new javax.swing.GroupLayout(txtAtras);
        txtAtras.setLayout(txtAtrasLayout);
        txtAtrasLayout.setHorizontalGroup(
            txtAtrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
        );
        txtAtrasLayout.setVerticalGroup(
            txtAtrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        panelOpcionesRol.add(txtAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 30));

        txtSiguiente.setBackground(new java.awt.Color(153, 153, 153));
        txtSiguiente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtSiguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtSiguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSiguienteMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Adelante");

        javax.swing.GroupLayout txtSiguienteLayout = new javax.swing.GroupLayout(txtSiguiente);
        txtSiguiente.setLayout(txtSiguienteLayout);
        txtSiguienteLayout.setHorizontalGroup(
            txtSiguienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
        );
        txtSiguienteLayout.setVerticalGroup(
            txtSiguienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        panelOpcionesRol.add(txtSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 90, 30));

        panelIzquierda.add(panelOpcionesRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 190, 30));

        panelOpciones2.setBackground(new java.awt.Color(0, 0, 0));
        panelOpciones2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelProducto.setBackground(new java.awt.Color(153, 153, 153));
        panelProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelProductoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelProductoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelProductoMouseExited(evt);
            }
        });

        txtCliente1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txtCliente1.setForeground(new java.awt.Color(255, 255, 255));
        txtCliente1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtCliente1.setText("Productos");

        javax.swing.GroupLayout panelProductoLayout = new javax.swing.GroupLayout(panelProducto);
        panelProducto.setLayout(panelProductoLayout);
        panelProductoLayout.setHorizontalGroup(
            panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtCliente1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
        );
        panelProductoLayout.setVerticalGroup(
            panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtCliente1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        panelOpciones2.add(panelProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 60));

        panelFiltrarFV.setBackground(new java.awt.Color(153, 153, 153));
        panelFiltrarFV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelFiltrarFV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelFiltrarFVMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelFiltrarFVMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelFiltrarFVMouseExited(evt);
            }
        });

        txtCompania1.setBackground(new java.awt.Color(204, 204, 204));
        txtCompania1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 17)); // NOI18N
        txtCompania1.setForeground(new java.awt.Color(255, 255, 255));
        txtCompania1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtCompania1.setText("Fecha de vencimiento");

        javax.swing.GroupLayout panelFiltrarFVLayout = new javax.swing.GroupLayout(panelFiltrarFV);
        panelFiltrarFV.setLayout(panelFiltrarFVLayout);
        panelFiltrarFVLayout.setHorizontalGroup(
            panelFiltrarFVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtCompania1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
        );
        panelFiltrarFVLayout.setVerticalGroup(
            panelFiltrarFVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtCompania1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        panelOpciones2.add(panelFiltrarFV, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 190, 60));

        panelIzquierda.add(panelOpciones2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 190, 310));

        panelOpciones1.setBackground(new java.awt.Color(0, 0, 0));
        panelOpciones1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCliente.setBackground(new java.awt.Color(153, 153, 153));
        panelCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelClienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelClienteMouseExited(evt);
            }
        });

        txtCliente.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txtCliente.setForeground(new java.awt.Color(255, 255, 255));
        txtCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtCliente.setText("Cliente");

        javax.swing.GroupLayout panelClienteLayout = new javax.swing.GroupLayout(panelCliente);
        panelCliente.setLayout(panelClienteLayout);
        panelClienteLayout.setHorizontalGroup(
            panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
        );
        panelClienteLayout.setVerticalGroup(
            panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        panelOpciones1.add(panelCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 60));

        panelPedido.setBackground(new java.awt.Color(153, 153, 153));
        panelPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelPedidoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelPedidoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelPedidoMouseExited(evt);
            }
        });

        txtCompania.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txtCompania.setForeground(new java.awt.Color(255, 255, 255));
        txtCompania.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtCompania.setText("Pedido");

        javax.swing.GroupLayout panelPedidoLayout = new javax.swing.GroupLayout(panelPedido);
        panelPedido.setLayout(panelPedidoLayout);
        panelPedidoLayout.setHorizontalGroup(
            panelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtCompania, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
        );
        panelPedidoLayout.setVerticalGroup(
            panelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtCompania, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        panelOpciones1.add(panelPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 190, 60));

        panelEmpleado.setBackground(new java.awt.Color(153, 153, 153));
        panelEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelEmpleadoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelEmpleadoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelEmpleadoMouseExited(evt);
            }
        });

        txtEmpleado.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txtEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        txtEmpleado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtEmpleado.setText("Empleado");

        javax.swing.GroupLayout panelEmpleadoLayout = new javax.swing.GroupLayout(panelEmpleado);
        panelEmpleado.setLayout(panelEmpleadoLayout);
        panelEmpleadoLayout.setHorizontalGroup(
            panelEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtEmpleado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
        );
        panelEmpleadoLayout.setVerticalGroup(
            panelEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        panelOpciones1.add(panelEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 190, 60));

        panelProveedor.setBackground(new java.awt.Color(153, 153, 153));
        panelProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelProveedorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelProveedorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelProveedorMouseExited(evt);
            }
        });

        txtProveedor.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txtProveedor.setForeground(new java.awt.Color(255, 255, 255));
        txtProveedor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtProveedor.setText("Proveedor");

        javax.swing.GroupLayout panelProveedorLayout = new javax.swing.GroupLayout(panelProveedor);
        panelProveedor.setLayout(panelProveedorLayout);
        panelProveedorLayout.setHorizontalGroup(
            panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtProveedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
        );
        panelProveedorLayout.setVerticalGroup(
            panelProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        panelOpciones1.add(panelProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 190, 60));

        panelIzquierda.add(panelOpciones1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 190, 310));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        panelIzquierda.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 130, 20));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        panelIzquierda.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 190, 14));
        panelIzquierda.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, 190, 10));
        panelIzquierda.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 190, 20));

        panelAtras.setBackground(new java.awt.Color(0, 0, 0));
        panelAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelAtrasMouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imgAtras.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout panelAtrasLayout = new javax.swing.GroupLayout(panelAtras);
        panelAtras.setLayout(panelAtrasLayout);
        panelAtrasLayout.setHorizontalGroup(
            panelAtrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelAtrasLayout.setVerticalGroup(
            panelAtrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelIzquierda.add(panelAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 50));

        panelRol.setBackground(new java.awt.Color(153, 153, 153));
        panelRol.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtRol.setEditable(false);
        txtRol.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtRol.setBorder(null);
        panelRol.add(txtRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 110, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Rol:");
        panelRol.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txtNombre.setEditable(false);
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtNombre.setBorder(null);
        panelRol.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 110, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nombre:");
        panelRol.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        panelRol.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 57, 110, -1));

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        panelRol.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 27, 110, -1));

        panelIzquierda.add(panelRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 190, 80));

        jPanel1.add(panelIzquierda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 640));

        panelSuperior.setBackground(new java.awt.Color(0, 0, 0));
        panelSuperior.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelSuperiorMouseDragged(evt);
            }
        });
        panelSuperior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelSuperiorMousePressed(evt);
            }
        });
        panelSuperior.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelMini.setBackground(new java.awt.Color(0, 0, 0));

        textMini.setFont(new java.awt.Font("Eras Medium ITC", 1, 30)); // NOI18N
        textMini.setForeground(new java.awt.Color(255, 255, 255));
        textMini.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textMini.setText("--");
        textMini.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textMiniMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                textMiniMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                textMiniMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelMiniLayout = new javax.swing.GroupLayout(panelMini);
        panelMini.setLayout(panelMiniLayout);
        panelMiniLayout.setHorizontalGroup(
            panelMiniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textMini, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );
        panelMiniLayout.setVerticalGroup(
            panelMiniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMiniLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(textMini, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelSuperior.add(panelMini, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 0, 50, 40));

        panelSalir.setBackground(new java.awt.Color(0, 0, 0));

        textSalir.setBackground(new java.awt.Color(255, 255, 255));
        textSalir.setFont(new java.awt.Font("Dubai", 0, 30)); // NOI18N
        textSalir.setForeground(new java.awt.Color(255, 255, 255));
        textSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textSalir.setText("X");
        textSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textSalirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                textSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                textSalirMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelSalirLayout = new javax.swing.GroupLayout(panelSalir);
        panelSalir.setLayout(panelSalirLayout);
        panelSalirLayout.setHorizontalGroup(
            panelSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSalirLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(textSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelSalirLayout.setVerticalGroup(
            panelSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSalirLayout.createSequentialGroup()
                .addComponent(textSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelSuperior.add(panelSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 0, 50, 40));

        jPanel1.add(panelSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 40));

        panelCambiante.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelCambianteLayout = new javax.swing.GroupLayout(panelCambiante);
        panelCambiante.setLayout(panelCambianteLayout);
        panelCambianteLayout.setHorizontalGroup(
            panelCambianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 950, Short.MAX_VALUE)
        );
        panelCambianteLayout.setVerticalGroup(
            panelCambianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        jPanel1.add(panelCambiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 950, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelPedidoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelPedidoMouseEntered
        if (opciones1[0])
            panelPedido.setBackground(new Color(200,200,200));
    }//GEN-LAST:event_panelPedidoMouseEntered

    private void panelPedidoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelPedidoMouseExited
        if (opciones1[0])
            panelPedido.setBackground(new Color(153,153,153)); //normal
    }//GEN-LAST:event_panelPedidoMouseExited

    private void panelPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelPedidoMouseClicked
        reset(0);
        ControllerPedido controller=new ControllerPedido();
        controller.run();
        controller.getVista().setSize(1000, 1000);
        controller.getVista().setLocation(0, 0);
        panelCambiante.removeAll();
        panelCambiante.add(controller.getVista(), BorderLayout.CENTER);
        panelCambiante.revalidate();
        panelCambiante.repaint();
    }//GEN-LAST:event_panelPedidoMouseClicked

    private void panelClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelClienteMouseEntered
        if (opciones1[1])
            panelCliente.setBackground(new Color(200,200,200));
    }//GEN-LAST:event_panelClienteMouseEntered

    private void panelClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelClienteMouseExited
        if (opciones1[1])
            panelCliente.setBackground(new Color(153,153,153));
    }//GEN-LAST:event_panelClienteMouseExited

    private void panelClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelClienteMouseClicked
        reset(1);
        ControllerCliente controller=new ControllerCliente();
        controller.run();
        controller.getVista().setSize(1000, 1000);
        controller.getVista().setLocation(0, 0);
        panelCambiante.removeAll();
        panelCambiante.add(controller.getVista(), BorderLayout.CENTER);
        panelCambiante.revalidate();
        panelCambiante.repaint();
    }//GEN-LAST:event_panelClienteMouseClicked

    private void panelProveedorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelProveedorMouseEntered
        if (opciones1[3])
            panelProveedor.setBackground(new Color(200,200,200));
    }//GEN-LAST:event_panelProveedorMouseEntered

    private void panelProveedorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelProveedorMouseExited
        if (opciones1[3])
            panelProveedor.setBackground(new Color(153,153,153));
    }//GEN-LAST:event_panelProveedorMouseExited

    private void panelProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelProveedorMouseClicked
        reset(3);
        ControllerProveedor controller=new ControllerProveedor();
        controller.run();
        controller.getVista().setSize(1000, 1000);
        controller.getVista().setLocation(0, 0);
        panelCambiante.removeAll();
        panelCambiante.add(controller.getVista(), BorderLayout.CENTER);
        panelCambiante.revalidate();
        panelCambiante.repaint();
    }//GEN-LAST:event_panelProveedorMouseClicked

    private void panelSuperiorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelSuperiorMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_panelSuperiorMousePressed

    private void panelSuperiorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelSuperiorMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_panelSuperiorMouseDragged

    private void textSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textSalirMouseEntered
        panelSalir.setBackground(Color.red);
        textSalir.setForeground(Color.white);
    }//GEN-LAST:event_textSalirMouseEntered

    private void textSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textSalirMouseExited
        panelSalir.setBackground(Color.black);
        textSalir.setForeground(Color.white);
    }//GEN-LAST:event_textSalirMouseExited

    private void textSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_textSalirMouseClicked

    private void textMiniMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textMiniMouseExited
        panelMini.setBackground(Color.black);
        textMini.setForeground(Color.white);
    }//GEN-LAST:event_textMiniMouseExited

    private void textMiniMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textMiniMouseEntered
        panelMini.setBackground(new Color(153,153,153));
    }//GEN-LAST:event_textMiniMouseEntered

    private void textMiniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textMiniMouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_textMiniMouseClicked

    private void panelEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelEmpleadoMouseClicked
        reset(2);
        ControllerEmpleado controller=new ControllerEmpleado();
        controller.run();
        controller.getVista().setSize(1000, 1000);
        controller.getVista().setLocation(0, 0);
        panelCambiante.removeAll();
        panelCambiante.add(controller.getVista(), BorderLayout.CENTER);
        panelCambiante.revalidate();
        panelCambiante.repaint();
    }//GEN-LAST:event_panelEmpleadoMouseClicked

    private void panelEmpleadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelEmpleadoMouseEntered
        if (opciones1[2])
            panelEmpleado.setBackground(new Color(200,200,200));
    }//GEN-LAST:event_panelEmpleadoMouseEntered

    private void panelEmpleadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelEmpleadoMouseExited
        if(opciones1[2]){
            panelEmpleado.setBackground(new Color(153,153,153));
        }
    }//GEN-LAST:event_panelEmpleadoMouseExited

    private void panelAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelAtrasMouseClicked
        ControllerLogin cl = new ControllerLogin();
        cl.run();
        this.dispose();
    }//GEN-LAST:event_panelAtrasMouseClicked

    private void panelProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelProductoMouseClicked
        reset1(0);
        ControllerProducto controller=new ControllerProducto();
        controller.run();
        controller.getVista().setSize(1000, 1000);
        controller.getVista().setLocation(0, 0);
        panelCambiante.removeAll();
        panelCambiante.add(controller.getVista(), BorderLayout.CENTER);
        panelCambiante.revalidate();
        panelCambiante.repaint();
    }//GEN-LAST:event_panelProductoMouseClicked

    private void panelProductoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelProductoMouseEntered
        if (opciones2[0])
            panelProducto.setBackground(new Color(200,200,200));
    }//GEN-LAST:event_panelProductoMouseEntered

    private void panelProductoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelProductoMouseExited
        if(opciones2[0]){
            panelProducto.setBackground(new Color(153,153,153));
        }
    }//GEN-LAST:event_panelProductoMouseExited

    private void panelFiltrarFVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelFiltrarFVMouseClicked
        reset1(1);
        ControllerFiltrarFV controller=new ControllerFiltrarFV();
        controller.run();
        controller.getVista().setSize(1000, 1000);
        controller.getVista().setLocation(0, 0);
        panelCambiante.removeAll();
        panelCambiante.add(controller.getVista(), BorderLayout.CENTER);
        panelCambiante.revalidate();
        panelCambiante.repaint();
    }//GEN-LAST:event_panelFiltrarFVMouseClicked

    private void panelFiltrarFVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelFiltrarFVMouseEntered
         if (opciones2[1])
            panelFiltrarFV.setBackground(new Color(200,200,200));
    }//GEN-LAST:event_panelFiltrarFVMouseEntered

    private void panelFiltrarFVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelFiltrarFVMouseExited
        if(opciones2[1]){
            panelFiltrarFV.setBackground(new Color(153,153,153));
        }
    }//GEN-LAST:event_panelFiltrarFVMouseExited

    private void txtAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAtrasMouseClicked
        //SE MUESTRAN LAS OPCIONES DE GERENTE
        txtAtras.setVisible(false);
        txtSiguiente.setVisible(true);
        panelOpciones1.setVisible(true);
        //SE OCULTAN LAS DE JEFE DE ALMACEN
        panelOpciones2.setVisible(false);
    }//GEN-LAST:event_txtAtrasMouseClicked

    private void txtSiguienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSiguienteMouseClicked
        //SE MUESTRAN LAS OPCIONES DE JEFE DE ALMACEN
        txtAtras.setVisible(true);
        txtSiguiente.setVisible(false);
        panelOpciones2.setVisible(true);
        //SE OCULTAN LAS DE GERENTE
        panelOpciones1.setVisible(false);
    }//GEN-LAST:event_txtSiguienteMouseClicked

    public void reset(int opcion) {
        for (int i = 0; i < opciones1.length; i++) {
           opciones1[i] = true;
        }
        if(opcion!=-1){
            opciones1[opcion] = false;
            reset1(-1);
        }
        if (opcion != 0) {
           panelPedido.setBackground(new Color(153,153,153));
        }
        if (opcion != 1) {
           panelCliente.setBackground(new Color(153,153,153));
        }
        if (opcion != 2) {
           panelEmpleado.setBackground(new Color(153,153,153));
        }
        if (opcion != 3) {
           panelProveedor.setBackground(new Color(153,153,153));
        }
        
    }
    public void reset1(int opcion) {
        for (int i = 0; i < opciones2.length; i++) {
           opciones2[i] = true;
        }
        if(opcion!=-1){
            opciones2[opcion] = false;
            reset(-1);
        }
        if (opcion != 0) {
           panelProducto.setBackground(new Color(153,153,153));
        }
        if (opcion != 1) {
           panelFiltrarFV.setBackground(new Color(153,153,153));
        }
        
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JPanel panelAtras;
    public javax.swing.JPanel panelCambiante;
    public javax.swing.JPanel panelCliente;
    public javax.swing.JPanel panelEmpleado;
    public javax.swing.JPanel panelFiltrarFV;
    private javax.swing.JPanel panelIzquierda;
    private javax.swing.JPanel panelMini;
    public javax.swing.JPanel panelOpciones1;
    public javax.swing.JPanel panelOpciones2;
    public javax.swing.JPanel panelOpcionesRol;
    public javax.swing.JPanel panelPedido;
    public javax.swing.JPanel panelProducto;
    public javax.swing.JPanel panelProveedor;
    public javax.swing.JPanel panelRol;
    private javax.swing.JPanel panelSalir;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JLabel textMini;
    private javax.swing.JLabel textSalir;
    public javax.swing.JPanel txtAtras;
    public javax.swing.JLabel txtCliente;
    public javax.swing.JLabel txtCliente1;
    public javax.swing.JLabel txtCompania;
    public javax.swing.JLabel txtCompania1;
    public javax.swing.JLabel txtEmpleado;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JLabel txtProveedor;
    public javax.swing.JTextField txtRol;
    public javax.swing.JPanel txtSiguiente;
    // End of variables declaration//GEN-END:variables
}
