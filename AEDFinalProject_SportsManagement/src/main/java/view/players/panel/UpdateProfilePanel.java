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

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(nameTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 173, -1));

        jLabel1.setText("Name");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 65, -1));

        jLabel2.setText("Username");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 65, -1));
        jPanel1.add(usernameTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 173, -1));

        jLabel3.setText("Height");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 65, -1));
        jPanel1.add(heightTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 173, -1));
        jPanel1.add(weightTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 173, -1));

        jLabel4.setText("Weight");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 65, -1));

        jLabel6.setText("password");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 65, -1));

        roleComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        jPanel1.add(roleComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 173, -1));

        jLabel8.setText("Role");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 65, -1));

        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });
        jPanel1.add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 380, -1, -1));

        jLabel9.setText("email");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 250, 65, -1));
        jPanel1.add(emailTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, 173, -1));

        passwordTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTFActionPerformed(evt);
            }
        });
        jPanel1.add(passwordTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 173, -1));

        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        jPanel1.add(addBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 380, -1, -1));

        jLabel10.setText("Phone Number");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, -1, -1));
        jPanel1.add(phoneNumberTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 173, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, -2, 610, 480));
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
