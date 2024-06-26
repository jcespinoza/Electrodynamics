/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import org.opensourcephysics.controls.CalculationControl;
import org.opensourcephysics.controls.SimulationControl;

/**
 *
 * @author Jay C Espinoza
 */
public class OriginalsMenu extends javax.swing.JFrame {

    /**
     * Creates new form OriginalsMenu
     */
    public OriginalsMenu() {
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

        jLabel1 = new javax.swing.JLabel();
        oEFieldButton = new javax.swing.JButton();
        mEFieldButtonb = new javax.swing.JButton();
        oEFLineButton = new javax.swing.JButton();
        FLineApp3a = new javax.swing.JButton();
        mEFieldAppButtond = new javax.swing.JButton();
        mEFieldButtonc = new javax.swing.JButton();
        mFLApp2 = new javax.swing.JButton();
        mEPotentialButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Elige una Applet");

        oEFieldButton.setText("ElectricFieldApp Original");
        oEFieldButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oEFieldButtonActionPerformed(evt);
            }
        });

        mEFieldButtonb.setText("Mod. ElectricFieldApp 10.1 b");
        mEFieldButtonb.setToolTipText("");
        mEFieldButtonb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mEFieldButtonbActionPerformed(evt);
            }
        });

        oEFLineButton.setText("ElectricFieldLineApp Original");
        oEFLineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oEFLineButtonActionPerformed(evt);
            }
        });

        FLineApp3a.setText("Mod FieldLineApp 10.3 a");
        FLineApp3a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FLineApp3aActionPerformed(evt);
            }
        });

        mEFieldAppButtond.setText("Mod ElectricFieldApp 10.1 d");
        mEFieldAppButtond.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mEFieldAppButtondActionPerformed(evt);
            }
        });

        mEFieldButtonc.setText("Mod ElectricFieldApp 10.1 c");
        mEFieldButtonc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mEFieldButtoncActionPerformed(evt);
            }
        });

        mFLApp2.setText("Mod FieldLineApp 10.2 d");
        mFLApp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mFLApp2ActionPerformed(evt);
            }
        });

        mEPotentialButton.setText("Mod ElectricPotentialApp");
        mEPotentialButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mEPotentialButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(oEFieldButton))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(oEFLineButton)))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(mEPotentialButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mEFieldButtonb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(FLineApp3a, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mEFieldAppButtond, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mEFieldButtonc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mFLApp2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oEFieldButton)
                    .addComponent(mEFieldButtonb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mEFieldButtonc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mEFieldAppButtond)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oEFLineButton)
                    .addComponent(mFLApp2))
                .addGap(8, 8, 8)
                .addComponent(FLineApp3a)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mEPotentialButton)
                .addGap(70, 70, 70))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mEFieldButtonbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mEFieldButtonbActionPerformed
        EFApp2 ef2 = new EFApp2();
        SimulationControl.createApp(ef2);
    }//GEN-LAST:event_mEFieldButtonbActionPerformed

    private void oEFieldButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oEFieldButtonActionPerformed
        CalculationControl.createApp(new ElectricFieldApp());
    }//GEN-LAST:event_oEFieldButtonActionPerformed

    private void oEFLineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oEFLineButtonActionPerformed
        CalculationControl.createApp(new FieldLineApp());
    }//GEN-LAST:event_oEFLineButtonActionPerformed

    private void mEFieldButtoncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mEFieldButtoncActionPerformed
        SimulationControl.createApp(new EFApp3());
    }//GEN-LAST:event_mEFieldButtoncActionPerformed

    private void mEFieldAppButtondActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mEFieldAppButtondActionPerformed
        SimulationControl.createApp(new EFApp4());
    }//GEN-LAST:event_mEFieldAppButtondActionPerformed

    private void FLineApp3aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FLineApp3aActionPerformed
        CalculationControl.createApp(new FieldLineApp31());
    }//GEN-LAST:event_FLineApp3aActionPerformed

    private void mFLApp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mFLApp2ActionPerformed
        CalculationControl.createApp(new FieldLineApp2());
    }//GEN-LAST:event_mFLApp2ActionPerformed

    private void mEPotentialButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mEPotentialButtonActionPerformed
        CalculationControl.createApp(new ElectricPotentialApp());
    }//GEN-LAST:event_mEPotentialButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OriginalsMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OriginalsMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OriginalsMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OriginalsMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OriginalsMenu().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton FLineApp3a;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton mEFieldAppButtond;
    private javax.swing.JButton mEFieldButtonb;
    private javax.swing.JButton mEFieldButtonc;
    private javax.swing.JButton mEPotentialButton;
    private javax.swing.JButton mFLApp2;
    private javax.swing.JButton oEFLineButton;
    private javax.swing.JButton oEFieldButton;
    // End of variables declaration//GEN-END:variables
}
