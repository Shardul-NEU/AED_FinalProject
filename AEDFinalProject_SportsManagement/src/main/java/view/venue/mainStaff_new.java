/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.venue;

import database.CRUDDatabase;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.bson.Document;
import org.bson.types.ObjectId;
import static services.VenueService.createNew;
import static services.VenueService.refreshtable;

/**
 *
 * @author Shardul
 */
public class mainStaff_new extends javax.swing.JPanel {
    ArrayList<Document> staffList;
    String staff = "maintenance";
    Document doc;
    String name;
    int count;
    String email;
    String userId;
    String password;
    long phone;
    /**
     * Creates new form mainStaff_new
     */
    public mainStaff_new() {
        initComponents();
        setVisible(true);
        String venue = "marino";
        refreshtable(rrCount,ordersTable,venue,staff);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        refreshBtn = new javax.swing.JButton();
        deleteOrder = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rrCount = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ordersTable = new javax.swing.JTable();
        CreateBtn = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

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
        ordersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
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

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "marino", "squashbusters" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(51, 51, 51)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CreateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deleteOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rrCount, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rrCount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void refreshBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshBtnMouseClicked

    }//GEN-LAST:event_refreshBtnMouseClicked

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        // TODO add your handling code here:
        refreshtable(rrCount,ordersTable,jComboBox1.getSelectedItem().toString(),staff);
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void deleteOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteOrderMouseClicked
        // TODO add your handling code here:
               Document doc1 = new CRUDDatabase().getRecordByTwoKeys("venue", jComboBox1.getSelectedItem().toString(), "staff", staff, "venueStaff");
               ArrayList<Document> arr =  (ArrayList<Document>) doc1.get("staffList");
               int j = -1;
               for(int i = 0; i< arr.size(); i++){
            
                        Document doc = arr.get(i);
            
                        if(doc.get("userId").toString().equals(userId)
                                && (doc.get("name").toString().equals(name))
                                && (doc.get("password").toString().equals(password))
                                && (Long.parseLong(doc.get("phone").toString())==phone)
                                &&(doc.get("email").toString().equals(email))
                           ){
                
                               j = i;
                            }
            
                    }
        
               if(j > -1){
            
                        arr.remove(j);
                    }
       
                ObjectId id = (ObjectId) new CRUDDatabase().getRecordByTwoKeys("venue", jComboBox1.getSelectedItem().toString(), "staff", staff, "venueStaff").get("_id");
        
                int result = new CRUDDatabase().deleteFomArray(id, arr, "staffList", "venueStaff");
        
                if(result > 0){
                        JOptionPane.showMessageDialog(this,
                                "Order was deleted.",
                                "Order  delete",
                                JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(this,
                                "Error while deleting order",
                                "Order delete",
                                JOptionPane.ERROR_MESSAGE);
                    }
               refreshtable(rrCount,ordersTable,jComboBox1.getSelectedItem().toString(),staff);
    }//GEN-LAST:event_deleteOrderMouseClicked

    private void deleteOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteOrderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteOrderActionPerformed

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
        createNew(jComboBox1, staff);
    }//GEN-LAST:event_CreateBtnActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        
        refreshtable(rrCount,ordersTable,jComboBox1.getSelectedItem().toString(),staff);
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreateBtn;
    private javax.swing.JButton deleteOrder;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable ordersTable;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JLabel rrCount;
    // End of variables declaration//GEN-END:variables

}
