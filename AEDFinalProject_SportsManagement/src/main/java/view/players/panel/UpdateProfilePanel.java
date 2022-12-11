/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.players.panel;

import enums.ROLES;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.User;
import services.UserService;
import validation.Validation;

/**
 *
 * @author Shardul
 */
public class UpdateProfilePanel extends javax.swing.JPanel {

    private UserService userService;
    private List<String> rolesArr;
    private String inputError;

    /**
     * Creates new form UpdateProfilePanel
     */
    public UpdateProfilePanel(User user) {
        initComponents();
        this.userService = new UserService();
        populateRolesDropDown();
        if (user != null) {
            populateDefaultValues(user);

        }
        setOperationList(user != null);
    }

    private void setOperationList(Boolean isUpdate) {
        addBtn.setVisible(!isUpdate);
        updateBtn.setVisible(isUpdate);

    }

    /*
    Fetch unique roles from database
     */
    public void populateRolesDropDown() {
        List<ROLES> roles = this.userService.getUniqueRoles();
        rolesArr = new ArrayList<String>();
        roles.stream().forEach((r) -> rolesArr.add(r.toString()));
        String str[] = new String[roles.size()];
        roleComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(rolesArr.toArray(str)));

    }

    public void populateDefaultValues(User user) {
        nameTF.setText(user.getName());
        emailTf.setText(user.getEmail());
        heightTF.setText("" + user.getHeight());
        weightTF.setText("" + user.getWeight());
        passwordTF.setText(user.getPassword());
        roleComboBox.setEnabled(false);
        for (int i = 0; i < roleComboBox.getItemCount(); i++) {
            String key = Arrays.stream(roleComboBox.getItemAt(i).split("")).reduce("", (x, s) -> x + s);
            if (key.equalsIgnoreCase(user.getRoles().toString())) {
                roleComboBox.setSelectedIndex(i);
            }
        }
        usernameTf.setText(user.getUsername());
        usernameTf.setEnabled(false);
        phoneNumberTF.setText(user.getPhoneNumber());
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
        nameTF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        usernameTf = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        heightTF = new javax.swing.JTextField();
        weightTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        roleComboBox = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        updateBtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        emailTf = new javax.swing.JTextField();
        passwordTF = new javax.swing.JPasswordField();
        addBtn = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        phoneNumberTF = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Name");

        jLabel2.setText("Username");

        jLabel3.setText("Height");

        jLabel4.setText("Weight");

        jLabel6.setText("password");

        roleComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));

        jLabel8.setText("Role");

        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        jLabel9.setText("email");

        passwordTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTFActionPerformed(evt);
            }
        });

        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        jLabel10.setText("Phone Number");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roleComboBox, 0, 173, Short.MAX_VALUE)
                    .addComponent(nameTF)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(heightTF)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameTf)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(weightTF, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailTf)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordTF)
                    .addComponent(jLabel10)
                    .addComponent(phoneNumberTF))
                .addGap(78, 78, 78))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(updateBtn)
                .addGap(18, 18, 18)
                .addComponent(addBtn)
                .addContainerGap(192, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phoneNumberTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(weightTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(heightTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(usernameTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(2, 2, 2)
                        .addComponent(roleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateBtn)
                    .addComponent(addBtn))
                .addGap(59, 59, 59))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:

        try {
            if (!this.isFieldValid(true)) {
                JOptionPane.showMessageDialog(new JFrame(), this.inputError, "Dialog",
                        JOptionPane.ERROR_MESSAGE);

                return;
            }
            User user = this.getUserObjectFromUI();
            int rowCount = this.userService.updateUser(user);
            if (rowCount == 0) {
//            error while updating information
                JOptionPane.showMessageDialog(new JFrame(), "There were no new changes to profile", "Dialog",
                        JOptionPane.ERROR_MESSAGE);
            } else if (rowCount < 0) {
                JOptionPane.showMessageDialog(new JFrame(), "Error while updating user information", "Dialog",
                        JOptionPane.ERROR_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(new JFrame(), "User profile updated", "Dialog",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            //error while updating information
            e.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(), "Opps!! something went wrong. Contact administrator", "Dialog",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void passwordTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordTFActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        if (!this.isFieldValid(false)) {
                JOptionPane.showMessageDialog(new JFrame(), this.inputError, "Dialog",
                        JOptionPane.ERROR_MESSAGE);

                return;
            }
        User user = this.getUserObjectFromUI();
        try {
            this.userService.insertUser(user);
            JOptionPane.showMessageDialog(new JFrame(), "User profile created", "Dialog",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(), "Opps!! Inserting failed", "Dialog",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_addBtnActionPerformed

    public User getUserObjectFromUI() {
        String name = nameTF.getText();
        String email = emailTf.getText();
        Integer height = Integer.valueOf(heightTF.getText());
        Integer weight = Integer.valueOf(weightTF.getText());
        String password = passwordTF.getText();
        String roles = (String) roleComboBox.getSelectedItem();
        String username = usernameTf.getText();
        String phone = phoneNumberTF.getText();
        return new User(name, email, ROLES.getRoles(roles), height, weight, phone, username, password);

    }

    private boolean isFieldValid(Boolean isUpdate) {
        Validation validator = new Validation();
        StringBuilder error = new StringBuilder("");
        boolean isValid=true;
        if (!isUpdate) {
            User user = this.userService.findUserByUserName(usernameTf.getText());
            if (user != null) {
                isValid=false;
                error.append("\n Username already exits");
            }
        }
        if (!validator.emailValidation(emailTf.getText())) {
            isValid=false;
            error.append("\n invalid email id ");
        }
        if (!validator.onlyNumbers(phoneNumberTF.getText())) {
            isValid=false;
            error.append("\n Phone number can only hold digits");
        }
        if (!validator.isNumber(weightTF.getText())) {
            isValid=false;
            error.append("\nEnter a valid integer value for weight");
        }
        if (!validator.isNumber(heightTF.getText())) {
            isValid=false;
            error.append("\n Enter a valid integer value for height");

        }
        if (passwordTF.getText().length()<6 || passwordTF.getText().length()>20 ) {
            isValid=false;
            error.append("\n Password should be between 6 to 20 character long");

        }
        this.inputError = error.toString();
        return isValid;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JTextField emailTf;
    private javax.swing.JTextField heightTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameTF;
    private javax.swing.JPasswordField passwordTF;
    private javax.swing.JTextField phoneNumberTF;
    private javax.swing.JComboBox<String> roleComboBox;
    private javax.swing.JButton updateBtn;
    private javax.swing.JTextField usernameTf;
    private javax.swing.JTextField weightTF;
    // End of variables declaration//GEN-END:variables
}
