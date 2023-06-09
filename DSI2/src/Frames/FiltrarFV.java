/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Frames;

import Controller.ControllerFiltrarFV;
import Controller.ControllerMetodos;
import java.awt.Color;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author arnol
 */
public class FiltrarFV extends javax.swing.JPanel {
    
    /**
     * Creates new form Cliente
     */
    //DECLARACION DE OBJETOS
    SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-dd");
    ControllerFiltrarFV cffv = new ControllerFiltrarFV(this);
    public DefaultTableModel modelo = new DefaultTableModel();
    public TableRowSorter<DefaultTableModel> sorter;
    ControllerMetodos metodo = new ControllerMetodos();
    //DECLARACIÓN DE VARIABLES 
    public FiltrarFV(){
        initComponents();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDatos = new javax.swing.JPanel();
        panelSuperior = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        txtTitulo = new javax.swing.JLabel();
        img1 = new javax.swing.JLabel();
        img2 = new javax.swing.JLabel();
        panelIzquierda = new javax.swing.JPanel();
        btnMes = new javax.swing.JPanel();
        txtAnadir = new javax.swing.JLabel();
        btnTrimestre = new javax.swing.JPanel();
        txtAnadir1 = new javax.swing.JLabel();
        btnSemestre = new javax.swing.JPanel();
        txtModificar = new javax.swing.JLabel();
        btnAnio = new javax.swing.JPanel();
        txtEliminar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelMes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        panelSemestre = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla2 = new javax.swing.JTable();
        panelTrimestre = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        panelAnio = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabla3 = new javax.swing.JTable();

        setMinimumSize(new java.awt.Dimension(950, 600));
        setPreferredSize(new java.awt.Dimension(950, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelDatos.setBackground(new java.awt.Color(255, 255, 255));
        panelDatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelSuperior.setBackground(new java.awt.Color(0, 0, 0));
        panelSuperior.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        panelSuperior.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 63, 530, 10));

        txtTitulo.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        txtTitulo.setForeground(new java.awt.Color(255, 255, 255));
        txtTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTitulo.setText("FILTRAR PRODUCTOS");
        panelSuperior.add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 27, 530, 30));

        img1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/farmacia.png"))); // NOI18N
        panelSuperior.add(img1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 20, 59, 50));

        img2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/farmacia.png"))); // NOI18N
        panelSuperior.add(img2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 59, 50));

        panelDatos.add(panelSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 100));

        panelIzquierda.setBackground(new java.awt.Color(204, 204, 204));
        panelIzquierda.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnMes.setBackground(new java.awt.Color(255, 255, 255));
        btnMes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMesMouseExited(evt);
            }
        });
        btnMes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtAnadir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtAnadir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtAnadir.setText("Mes");
        btnMes.add(txtAnadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 37));

        panelIzquierda.add(btnMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        btnTrimestre.setBackground(new java.awt.Color(255, 255, 255));
        btnTrimestre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTrimestre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTrimestreMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTrimestreMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTrimestreMouseExited(evt);
            }
        });
        btnTrimestre.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtAnadir1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtAnadir1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtAnadir1.setText("Trimestre");
        btnTrimestre.add(txtAnadir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 37));

        panelIzquierda.add(btnTrimestre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        btnSemestre.setBackground(new java.awt.Color(255, 255, 255));
        btnSemestre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSemestre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSemestreMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSemestreMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSemestreMouseExited(evt);
            }
        });
        btnSemestre.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtModificar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtModificar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtModificar.setText("Semestre");
        btnSemestre.add(txtModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 37));

        panelIzquierda.add(btnSemestre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        btnAnio.setBackground(new java.awt.Color(255, 255, 255));
        btnAnio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAnio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAnioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAnioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAnioMouseExited(evt);
            }
        });
        btnAnio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtEliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtEliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtEliminar.setText("Año");
        btnAnio.add(txtEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 37));

        panelIzquierda.add(btnAnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/empleado.png"))); // NOI18N
        panelIzquierda.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 140, 140));

        panelDatos.add(panelIzquierda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 190, 500));

        panelMes.setBackground(new java.awt.Color(255, 255, 255));
        panelMes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Fecha de vencimiento", "Proveedor", "Cantidad"
            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setMinWidth(50);
            tabla.getColumnModel().getColumn(0).setMaxWidth(50);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(50);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        panelMes.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 23, 626, 440));

        panelDatos.add(panelMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 760, 500));

        panelSemestre.setBackground(new java.awt.Color(255, 255, 255));
        panelSemestre.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Fecha de vencimiento", "Proveedor", "Cantidad"
            }
        ));
        tabla2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabla2);
        if (tabla2.getColumnModel().getColumnCount() > 0) {
            tabla2.getColumnModel().getColumn(0).setMinWidth(50);
            tabla2.getColumnModel().getColumn(0).setMaxWidth(50);
            tabla2.getColumnModel().getColumn(1).setPreferredWidth(50);
            tabla2.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        panelSemestre.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 23, 626, 440));

        panelDatos.add(panelSemestre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 760, 500));

        panelTrimestre.setBackground(new java.awt.Color(255, 255, 255));
        panelTrimestre.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Fecha de vencimiento", "Proveedor", "Cantidad"
            }
        ));
        tabla1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla1);
        if (tabla1.getColumnModel().getColumnCount() > 0) {
            tabla1.getColumnModel().getColumn(0).setMinWidth(50);
            tabla1.getColumnModel().getColumn(0).setMaxWidth(50);
            tabla1.getColumnModel().getColumn(1).setPreferredWidth(50);
            tabla1.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        panelTrimestre.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 23, 626, 440));

        panelDatos.add(panelTrimestre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 760, 500));

        panelAnio.setBackground(new java.awt.Color(255, 255, 255));
        panelAnio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Fecha de vencimiento", "Proveedor", "Cantidad"
            }
        ));
        tabla3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla3MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tabla3);
        if (tabla3.getColumnModel().getColumnCount() > 0) {
            tabla3.getColumnModel().getColumn(0).setMinWidth(50);
            tabla3.getColumnModel().getColumn(0).setMaxWidth(50);
            tabla3.getColumnModel().getColumn(1).setPreferredWidth(50);
            tabla3.getColumnModel().getColumn(3).setPreferredWidth(50);
            tabla3.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        panelAnio.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 23, 626, 440));

        panelDatos.add(panelAnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 760, 500));

        add(panelDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 600));
    }// </editor-fold>//GEN-END:initComponents

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        
    }//GEN-LAST:event_tablaMouseClicked

    private void btnMesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMesMouseClicked
        cffv.visible_mes();
        //SE CAMBIA EL TITULO
        txtTitulo.setText("FILTRAR PRODUCTOS POR MES");
        //LISTA USUARIOS
        cffv.limpiarTabla();
        cffv.listar(1);
    }//GEN-LAST:event_btnMesMouseClicked

    private void btnMesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMesMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMesMouseEntered

    private void btnMesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMesMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMesMouseExited

    private void btnSemestreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSemestreMouseClicked
        cffv.visible_semestre();
        //SE CAMBIA EL TITULO
        txtTitulo.setText("FILTRAR PRODUCTOS POR SEMESTRE");
        //LISTA USUARIOS
        cffv.limpiarTabla();
        cffv.listar(6);
    }//GEN-LAST:event_btnSemestreMouseClicked

    private void btnSemestreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSemestreMouseEntered

    }//GEN-LAST:event_btnSemestreMouseEntered

    private void btnSemestreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSemestreMouseExited

    }//GEN-LAST:event_btnSemestreMouseExited

    private void btnAnioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnioMouseClicked
        cffv.visible_anio();
        //SE CAMBIA EL TITULO
        txtTitulo.setText("FILTRAR PRODUCTOS POR AÑO");
        //LISTA USUARIOS
        cffv.limpiarTabla();
        cffv.listar(12);
    }//GEN-LAST:event_btnAnioMouseClicked

    private void btnAnioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnioMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAnioMouseEntered

    private void btnAnioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnioMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAnioMouseExited

    private void btnTrimestreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrimestreMouseClicked
        cffv.visible_trimestre();
        //SE CAMBIA EL TITULO
        txtTitulo.setText("FILTRAR PRODUCTOS POR TRIMESTRE");
        //LISTA USUARIOS
        cffv.limpiarTabla();
        cffv.listar(3);
    }//GEN-LAST:event_btnTrimestreMouseClicked

    private void btnTrimestreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrimestreMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTrimestreMouseEntered

    private void btnTrimestreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrimestreMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTrimestreMouseExited

    private void tabla1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabla1MouseClicked

    private void tabla2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabla2MouseClicked

    private void tabla3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabla3MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel btnAnio;
    public javax.swing.JPanel btnMes;
    public javax.swing.JPanel btnSemestre;
    public javax.swing.JPanel btnTrimestre;
    private javax.swing.JLabel img1;
    private javax.swing.JLabel img2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JPanel panelAnio;
    public javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelIzquierda;
    public javax.swing.JPanel panelMes;
    public javax.swing.JPanel panelSemestre;
    private javax.swing.JPanel panelSuperior;
    public javax.swing.JPanel panelTrimestre;
    public javax.swing.JTable tabla;
    public javax.swing.JTable tabla1;
    public javax.swing.JTable tabla2;
    public javax.swing.JTable tabla3;
    private javax.swing.JLabel txtAnadir;
    private javax.swing.JLabel txtAnadir1;
    private javax.swing.JLabel txtEliminar;
    private javax.swing.JLabel txtModificar;
    private javax.swing.JLabel txtTitulo;
    // End of variables declaration//GEN-END:variables
}
