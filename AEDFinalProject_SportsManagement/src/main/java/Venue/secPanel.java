/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Venue;

import Model.Venue;
import Model.database;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;
import javax.swing.JOptionPane;
import org.bson.Document;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Shardul
 */
public class secPanel extends javax.swing.JPanel {

    /**
     * Creates new form secPanel
     */
    // creates an instance of database
    database db = new database();
    
   // code to update the table on the page
    
    private void tableUpdate(){
        String[] columnNames = {"UserId", "Name", "Phone", "Email"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        MongoCursor<Document> cursor = db.securityStaff.find().iterator();
        while (cursor.hasNext()) {
            Object obj = cursor.next();
            Document dc = (Document) obj;
            String UserId = (String)dc.get("UserId");
            String Name = (String)dc.get("Name");
            Long Phone  = (Long)dc.get("Phone");
            String Email = (String)dc.get("Email");
            model.addRow(new Object[] {UserId, Name, Phone, Email });
        }
        secTable.setModel(model);
    } 
    public secPanel(Venue venue) {
        initComponents();
        tableUpdate();
    }
    //method to clear text fields in the page
    private void clearFields(){
        secUserIdTextF.setText("");
        secNameTextF.setText("");
        secPasswordTextF.setText("");
        secPhoneTextF.setText("");
        secEmailTextF.setText("");
    }
    
    private Document selectedRowData(int rowSelected){
    String key = secTable.getColumnName(0);
        MongoCursor<Document> cursor = db.securityStaff.find().iterator();
        Document result = new Document();
        while (cursor.hasNext()) {
            Object obj = cursor.next();
            Document dc = (Document) obj;
            String check = dc.getString(key);
            for(String value = secTable.getValueAt(rowSelected, 0).toString();check.equals(value);){
//            System.out.println(value);
//            System.out.println(dc);
            result = dc;
            break;
            }
        }
        return result;
    }
    // code to reset fields in the page
     private void resetFields(Document dc){
        secUserIdTextF.setText(dc.getString("UserId"));
        secNameTextF.setText(dc.getString("Name"));
        secPasswordTextF.setText(dc.getString("Password"));
        secPhoneTextF.setText(dc.getLong("Phone").toString());
        secEmailTextF.setText(dc.getString("Email"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        secHedingLabel = new javax.swing.JLabel();
        secUserIDLabel = new javax.swing.JLabel();
        secPasswordLabel = new javax.swing.JLabel();
        secNameLabel = new javax.swing.JLabel();
        secPhoneLabel = new javax.swing.JLabel();
        secEmailLabel = new javax.swing.JLabel();
        secUserIdTextF = new javax.swing.JTextField();
        secNameTextF = new javax.swing.JTextField();
        secPasswordTextF = new javax.swing.JTextField();
        secPhoneTextF = new javax.swing.JTextField();
        secEmailTextF = new javax.swing.JTextField();
        secSearchTextF = new javax.swing.JTextField();
        secSearchButton = new javax.swing.JButton();
        secCreateButton = new javax.swing.JButton();
        secUpdateButton = new javax.swing.JButton();
        secViewButton = new javax.swing.JButton();
        secScrollPane = new javax.swing.JScrollPane();
        secTable = new javax.swing.JTable();
        secDeleteButton = new javax.swing.JButton();
        secCancelButton = new javax.swing.JButton();

        secHedingLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        secHedingLabel.setText("Security Staff");
        secHedingLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        secUserIDLabel.setText("User ID");

        secPasswordLabel.setText("Password");

        secNameLabel.setText("Name");

        secPhoneLabel.setText("Phone");

        secEmailLabel.setText("Email");

        secUserIdTextF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secUserIdTextFActionPerformed(evt);
            }
        });

        secPasswordTextF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secPasswordTextFActionPerformed(evt);
            }
        });

        secSearchTextF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secSearchTextFActionPerformed(evt);
            }
        });

        secSearchButton.setText("Search");
        secSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secSearchButtonActionPerformed(evt);
            }
        });

        secCreateButton.setText("Create");
        secCreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secCreateButtonActionPerformed(evt);
            }
        });

        secUpdateButton.setText("Update");
        secUpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secUpdateButtonActionPerformed(evt);
            }
        });

        secViewButton.setText("View");
        secViewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secViewButtonActionPerformed(evt);
            }
        });

        secTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "User ID", "Name", "Phone", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        secScrollPane.setViewportView(secTable);

        secDeleteButton.setText("Delete");
        secDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secDeleteButtonActionPerformed(evt);
            }
        });

        secCancelButton.setText("Cancel");
        secCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secCancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(secCreateButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(secViewButton)
                        .addGap(18, 18, 18)
                        .addComponent(secUpdateButton)
                        .addGap(18, 18, 18)
                        .addComponent(secDeleteButton)
                        .addGap(151, 151, 151)
                        .addComponent(secCancelButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(secHedingLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(secEmailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(secEmailTextF))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(secPhoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(secPhoneTextF))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(secPasswordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(secPasswordTextF, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(secUserIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(secNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(secNameTextF, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(secUserIdTextF, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(secScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(secSearchTextF, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27)
                            .addComponent(secSearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(secHedingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(secSearchTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(secSearchButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(secUserIDLabel)
                            .addComponent(secUserIdTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(secNameTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(secNameLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(secPasswordLabel)
                            .addComponent(secPasswordTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(secPhoneLabel)
                            .addComponent(secPhoneTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(secEmailLabel)
                            .addComponent(secEmailTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(secScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(secCreateButton)
                    .addComponent(secViewButton)
                    .addComponent(secDeleteButton)
                    .addComponent(secUpdateButton)
                    .addComponent(secCancelButton))
                .addContainerGap(69, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void secUserIdTextFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secUserIdTextFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_secUserIdTextFActionPerformed

    private void secPasswordTextFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secPasswordTextFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_secPasswordTextFActionPerformed

    private void secSearchTextFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secSearchTextFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_secSearchTextFActionPerformed

    private void secCreateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secCreateButtonActionPerformed
        // TODO add your handling code here:
        String check ="";
        String selected= secUserIdTextF.getText();
        if (selected.equals(check)) {
            JOptionPane.showMessageDialog(this, "Create Unsuccessful : Blank Fields Found");
        }
        else {
        Document secStaff = new Document();
        secStaff.put("UserId",secUserIdTextF.getText());
        secStaff.put("Name",secNameTextF.getText());
        secStaff.put("Password",secPasswordTextF.getText());
        long phone = Long.parseLong(secPhoneTextF.getText());
        secStaff.put("Phone",phone);
        secStaff.put("Email",secEmailTextF.getText());
        db.securityStaff.insertOne(secStaff);
        
        JOptionPane.showMessageDialog(this,"Security personel Information Created");
        tableUpdate();
        clearFields();
        }
    }//GEN-LAST:event_secCreateButtonActionPerformed

    private void secViewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secViewButtonActionPerformed
        // TODO add your handling code here:
        int selectedIndex= secTable.getSelectedRow();
        if (selectedIndex<0) {
            JOptionPane.showMessageDialog(this, "Select a row to view details");
        }
        else{
        Document dc = selectedRowData(selectedIndex);
        resetFields(dc);
       }
    }//GEN-LAST:event_secViewButtonActionPerformed

    private void secUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secUpdateButtonActionPerformed
        // TODO add your handling code here:
        String check = "";
  String selected= secUserIdTextF.getText();
        if (selected.equals(check)) {
            JOptionPane.showMessageDialog(this, "Please view the data to update");
        }
       else{
       long Phone = Long.parseLong(secPhoneTextF.getText());
         db.securityStaff.updateOne(
              eq("UserId",secUserIdTextF.getText()),
                combine(set("Name",secNameTextF.getText()), set("Password", secPasswordTextF.getText()),
                        set("Phone",Phone), set("Email",secEmailTextF.getText())));
        tableUpdate();
        JOptionPane.showMessageDialog(this,"Update Successful");
        clearFields();
        }
    }//GEN-LAST:event_secUpdateButtonActionPerformed

    private void secDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secDeleteButtonActionPerformed
        // TODO add your handling code here:
        int selectedIndex= secTable.getSelectedRow();
        if (selectedIndex<0) {
            JOptionPane.showMessageDialog(this, "Select a row to delete");
        }
        else{
        String value = secTable.getValueAt(selectedIndex, 0).toString();
        db.securityStaff.deleteOne(eq("UserId",value));
        tableUpdate();
        JOptionPane.showMessageDialog(this,"Selected row is deleted");
        clearFields();
        }
    }//GEN-LAST:event_secDeleteButtonActionPerformed

    private void secCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secCancelButtonActionPerformed
        // TODO add your handling code here:
        clearFields();
        tableUpdate();
    }//GEN-LAST:event_secCancelButtonActionPerformed

    private void secSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secSearchButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_secSearchButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton secCancelButton;
    private javax.swing.JButton secCreateButton;
    private javax.swing.JButton secDeleteButton;
    private javax.swing.JLabel secEmailLabel;
    private javax.swing.JTextField secEmailTextF;
    private javax.swing.JLabel secHedingLabel;
    private javax.swing.JLabel secNameLabel;
    private javax.swing.JTextField secNameTextF;
    private javax.swing.JLabel secPasswordLabel;
    private javax.swing.JTextField secPasswordTextF;
    private javax.swing.JLabel secPhoneLabel;
    private javax.swing.JTextField secPhoneTextF;
    private javax.swing.JScrollPane secScrollPane;
    private javax.swing.JButton secSearchButton;
    private javax.swing.JTextField secSearchTextF;
    private javax.swing.JTable secTable;
    private javax.swing.JButton secUpdateButton;
    private javax.swing.JLabel secUserIDLabel;
    private javax.swing.JTextField secUserIdTextF;
    private javax.swing.JButton secViewButton;
    // End of variables declaration//GEN-END:variables
}