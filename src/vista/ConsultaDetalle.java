/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;
import DAO.*;

import javax.swing.table.DefaultTableModel;



/**
 *
 * @author thermaltaque
 */
public class ConsultaDetalle extends javax.swing.JInternalFrame  {

     CRUDdetallefactura crud = new CRUDdetallefactura();
    public ConsultaDetalle() {
        initComponents();
        crud.MostrarCodDetalleFactura(jtblFacturasF,"");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Detalle = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jConsultaFactura = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblFacturasF = new javax.swing.JTable();
        jtxtCFacturas = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Detalle.setBackground(new java.awt.Color(255, 255, 255));
        Detalle.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Registro del Detalle de la Facturas");
        Detalle.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        jConsultaFactura.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ingrese la factura", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        jConsultaFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jConsultaFacturaKeyReleased(evt);
            }
        });
        Detalle.add(jConsultaFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 290, 60));

        getContentPane().add(Detalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 1380, 190));

        jtblFacturasF.setModel(new javax.swing.table.DefaultTableModel(
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
        jtblFacturasF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblFacturasFMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtblFacturasF);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 1380, 550));

        jtxtCFacturas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jtxtCFacturas.setText("Cantidad de Detalle de Facturas:");
        getContentPane().add(jtxtCFacturas, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 790, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtblFacturasFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblFacturasFMouseClicked
        int fila = jtblFacturasF.rowAtPoint(evt.getPoint());
        int fecha = jtblFacturasF.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel)jtblFacturasF.getModel();
     
    }//GEN-LAST:event_jtblFacturasFMouseClicked

    private void jConsultaFacturaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jConsultaFacturaKeyReleased
      crud.MostrarCodDetalleFactura(jtblFacturasF,jConsultaFactura.getText());
    }//GEN-LAST:event_jConsultaFacturaKeyReleased

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Facturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Facturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Facturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Facturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Facturas().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Detalle;
    public javax.swing.JTextField jConsultaFactura;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jtblFacturasF;
    public javax.swing.JLabel jtxtCFacturas;
    // End of variables declaration//GEN-END:variables
}
