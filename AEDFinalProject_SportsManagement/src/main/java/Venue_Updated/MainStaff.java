/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Venue_Updated;
import Model.Venue;
import static Model.Venue.filltable;
import static Model.Venue.totalstaffcount;
import database.CRUDDatabase;
import inventory.NewOrder;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Shardul
 */
public class MainStaff extends javax.swing.JFrame {
    ArrayList<Document> staffList;
    Document doc;
    String name;
    int count;
    String email;
    String userId;
    String password;
    long phone;
    

    /**
     * Creates new form MainStaff
     */
    public MainStaff() {
        initComponents();
        setVisible(true);
        doc = new CRUDDatabase().getRecordByTwoKeys("venue", "marino", "staff", "maintenance", "venueStaff");
        
        staffList = (ArrayList<Document>) doc.get("staffList");
        totalstaffcount(rrCount, staffList);
        filltable(staffList, ordersTable);
    }
  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        refreshBtn = new javax.swing.JButton();
        deleteOrder = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rrCount = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ordersTable = new javax.swing.JTable();
        CreateBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        refreshBtn.setText("Refresh");
        refreshBtn.setFont(new Font("Serif", Font.PLAIN, 20));
        refreshBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshBtnMouseClicked(evt);
            }
        });
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });

        deleteOrder.setText("Delete");
        deleteOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteOrderMouseClicked(evt);
            }
        });
        deleteOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteOrderActionPerformed(evt);
            }
        });

        jLabel1.setText("Maintenance Staff Info");
        jLabel1.setFont(new Font("Serif", Font.PLAIN, 25));

        jLabel2.setText("Total Staff Count");
        jLabel2.setFont(new Font("Serif", Font.PLAIN, 20));

        rrCount.setFont(new Font("Serif", Font.PLAIN, 20));

        jLabel3.setText("Details ->");
        jLabel3.setFont(new Font("Serif", Font.PLAIN, 20));

        ordersTable.setFont(new Font("Serif", Font.PLAIN, 20));
        ordersTable.setRowHeight(50);
        ordersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ordersTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ordersTable);

        CreateBtn.setText("Add New Staff");
        CreateBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CreateBtnMouseClicked(evt);
            }
        });
        CreateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(28, 28, 28)
                        .addComponent(CreateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(deleteOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(refreshBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rrCount, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 4, Short.MAX_VALUE))))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rrCount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refreshBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshBtnMouseClicked
        // TODO add your handling code here:
        ArrayList<Document> staffList = (ArrayList<Document>) doc.get("staff");
        filltable(staffList, ordersTable);
        totalstaffcount(rrCount, staffList);
    }//GEN-LAST:event_refreshBtnMouseClicked

    private void deleteOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteOrderMouseClicked
        // TODO add your handling code here:

//        ArrayList<Document> arr =  (ArrayList<Document>) doc.get("Staff");
//        int j = -1;
//        for(int i = 0; i< arr.size(); i++){
//
//            Document doc = arr.get(i);
//
//            if(doc.get("name").toString().equals(name)
//                && (Integer.parseInt(doc.get("count").toString()) == count)
//                && doc.get("brand").toString().equals(brand)
//            ){
//
//                j = i;
//            }
//
//        }
//
//        if(j > -1){
//
//            arr.remove(j);
//        }
//
//        ObjectId id = (ObjectId) new CRUDDatabase().getRecordByTwoKeys("game", "icehockey", "item", "guards", "inventory").get("_id");
//
//        int result = new CRUDDatabase().deleteFomArray(id, arr, "orders", "inventory");
//
//        if(result > 0){
//            JOptionPane.showMessageDialog(this,
//                "Order was deleted.",
//                "Order  delete",
//                JOptionPane.INFORMATION_MESSAGE);
//        }else{
//            JOptionPane.showMessageDialog(this,
//                "Error while deleting order",
//                "Order delete",
//                JOptionPane.ERROR_MESSAGE);
//        }
//        staffList = (ArrayList<Document>) doc.get("orders");
//        fillOrdertable();
//        totalOrders();
    }//GEN-LAST:event_deleteOrderMouseClicked

    private void ordersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ordersTableMouseClicked
        // TODO add your handling code here:

        JTable source = (JTable)evt.getSource();
        int row = source.rowAtPoint( evt.getPoint() );
        userId = (String) ordersTable.getValueAt(row, 0);
        name = (String) ordersTable.getValueAt(row, 1);
        password = (String) ordersTable.getValueAt(row, 2);
        phone = Long.parseLong(ordersTable.getValueAt(row, 3).toString());
        email = (String) ordersTable.getValueAt(row,4);
    }//GEN-LAST:event_ordersTableMouseClicked

    private void CreateBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_CreateBtnMouseClicked

    private void CreateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateBtnActionPerformed
        // TODO add your handling code here:
        New_Staff window;
        window = new New_Staff("maintenance","marino");
        window.show();
        window.setDefaultCloseOperation(1);
        
    }//GEN-LAST:event_CreateBtnActionPerformed

    private void deleteOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteOrderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteOrderActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_refreshBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreateBtn;
    private javax.swing.JButton deleteOrder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTable ordersTable;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JLabel rrCount;
    // End of variables declaration//GEN-END:variables
}
