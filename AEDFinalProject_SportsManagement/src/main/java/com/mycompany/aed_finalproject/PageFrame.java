/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.aed_finalproject;

import view.venue.secPanel;
import view.venue.mainPanel;
import model.Venue;
import view.venue.shiftsPanel;

/**
 *
 * @author Shardul
 */
public class PageFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainPageFrame
     */
    Venue venue;
    public PageFrame() {
        initComponents();
        venue = new Venue();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        venSplitPane = new javax.swing.JSplitPane();
        venMenu = new javax.swing.JPanel();
        mainButton = new javax.swing.JButton();
        secButton = new javax.swing.JButton();
        shiftButton = new javax.swing.JButton();
        venWorkArea = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        venMenu.setMinimumSize(new java.awt.Dimension(150, 243));

        mainButton.setText("Maintenance");
        mainButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainButtonActionPerformed(evt);
            }
        });

        secButton.setText("Security");
        secButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secButtonActionPerformed(evt);
            }
        });

        shiftButton.setText("Shifts");
        shiftButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shiftButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout venMenuLayout = new javax.swing.GroupLayout(venMenu);
        venMenu.setLayout(venMenuLayout);
        venMenuLayout.setHorizontalGroup(
            venMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, venMenuLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(venMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(secButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shiftButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mainButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );
        venMenuLayout.setVerticalGroup(
            venMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(venMenuLayout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(mainButton)
                .addGap(39, 39, 39)
                .addComponent(secButton)
                .addGap(46, 46, 46)
                .addComponent(shiftButton)
                .addContainerGap())
        );

        venSplitPane.setLeftComponent(venMenu);

        venWorkArea.setPreferredSize(new java.awt.Dimension(800, 600));
        venWorkArea.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        venSplitPane.setRightComponent(venWorkArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(venSplitPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(venSplitPane)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainButtonActionPerformed
        // TODO add your handling code here:
        mainPanel mainPanel = new mainPanel(venue);
        venSplitPane.setRightComponent(mainPanel);
    }//GEN-LAST:event_mainButtonActionPerformed

    private void secButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secButtonActionPerformed
        // TODO add your handling code here:
        secPanel secPanel = new secPanel(venue);
        venSplitPane.setRightComponent(secPanel);
    }//GEN-LAST:event_secButtonActionPerformed

    private void shiftButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shiftButtonActionPerformed
        // TODO add your handling code here:
        shiftsPanel shiftPanel = new shiftsPanel(venue);
        venSplitPane.setRightComponent(shiftPanel);
    }//GEN-LAST:event_shiftButtonActionPerformed

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
            java.util.logging.Logger.getLogger(PageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PageFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton mainButton;
    private javax.swing.JButton secButton;
    private javax.swing.JButton shiftButton;
    private javax.swing.JPanel venMenu;
    private javax.swing.JSplitPane venSplitPane;
    private javax.swing.JPanel venWorkArea;
    // End of variables declaration//GEN-END:variables
}
