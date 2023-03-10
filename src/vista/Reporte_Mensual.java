/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista;

import DAO.CRUDreporteMensual;

/**
 *
 * @author thermaltaque
 */
public class Reporte_Mensual extends javax.swing.JInternalFrame {

    CRUDreporteMensual crud = new CRUDreporteMensual();
       
    public Reporte_Mensual() {
        initComponents();
        crud.MostrarMESEnTabla(jbtlRmensual,"");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Restaurar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        janos = new javax.swing.JTextField();
        jMeses1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jbtlRmensual = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jCDR = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Busqueda Por Mes:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        Restaurar.setBackground(new java.awt.Color(0, 0, 0));
        Restaurar.setForeground(new java.awt.Color(255, 255, 255));
        Restaurar.setText("Restaurar");
        jPanel1.add(Restaurar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 570, 170, 50));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pizzas.png"))); // NOI18N
        jLabel3.setMaximumSize(new java.awt.Dimension(200, 200));
        jLabel3.setMinimumSize(new java.awt.Dimension(200, 200));
        jLabel3.setPreferredSize(new java.awt.Dimension(200, 200));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 140, 220));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 51));
        jLabel7.setText("Reporte Mensual");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 410, 70));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setText("Busqueda Por A??o:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, 30));

        janos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        janos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                janosKeyReleased(evt);
            }
        });
        jPanel1.add(janos, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, 160, 50));

        jMeses1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMeses1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMeses1MouseClicked(evt);
            }
        });
        jMeses1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jMeses1KeyReleased(evt);
            }
        });
        jPanel1.add(jMeses1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 160, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 440, 670));

        jbtlRmensual.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jbtlRmensual);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 920, 520));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setText("Reporte Mensual");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 410, 70));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setText("Reporte Mensual");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 410, 70));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 51));
        jLabel6.setText("Reporte Mensual");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 410, 70));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Reporte Mensual");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, -1, 70));

        jCDR.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jCDR.setText("Cantidad De Reporte:");
        getContentPane().add(jCDR, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 650, -1, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMeses1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMeses1MouseClicked
     
    }//GEN-LAST:event_jMeses1MouseClicked

    private void janosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_janosKeyReleased
       crud.MostrarANOEnTabla(jbtlRmensual, janos.getText());
    }//GEN-LAST:event_janosKeyReleased

    private void jMeses1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMeses1KeyReleased
        crud.MostrarMESEnTabla(jbtlRmensual, jMeses1.getText());
    }//GEN-LAST:event_jMeses1KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Restaurar;
    public javax.swing.JLabel jCDR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public javax.swing.JTextField jMeses1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField janos;
    public javax.swing.JTable jbtlRmensual;
    // End of variables declaration//GEN-END:variables
}
