/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.players;

import enums.ROLES;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Matches;
import model.User;
import services.MatchesService;
import services.UserService;

/**
 *
 * @author Shardul
 */
public class UpdateMatchframe extends javax.swing.JFrame {
    
    private MatchesService userService;
    private List<String> rolesArr;
    private String inputError;
    private UserService Service;

    /**
     * Creates new form UpdateMatchframe
     */
    public UpdateMatchframe(Matches matches) {
        
        initComponents();
        this.userService = new MatchesService();
        this.Service = new UserService();
       populateRolesDropDown();
        if (matches != null) {
            populateDefaultValues(matches);
    }
        setOperationList(matches != null);
    }
    private void setOperationList(Boolean isUpdate) {
        addButton.setVisible(!isUpdate);
        updateButton.setVisible(isUpdate);

    }
    public void populateRolesDropDown() {
        List<User> user = this.Service.fetchUserByRoles(ROLES.BBPLAYER);
        rolesArr = new ArrayList<String>();
        user.stream().forEach((r) -> rolesArr.add(r.getName()));
        String str[] = new String[user.size()];
        playerCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(rolesArr.toArray(str)));

    }
    
    
     public void populateDefaultValues(Matches user) {
        TeamTF.setText(user.getTeam());
        opponentTextF.setText(user.getOpponent());
        winnerTextF.setText(user.getWinner());
        finalScoreTextF.setText(user.getFinalScore());
        stadiumTextF.setText(user.getStadium());
        for (int i = 0; i < playerCombobox.getItemCount(); i++) {
            String key = Arrays.stream(playerCombobox.getItemAt(i).split("")).reduce("", (x, s) -> x + s);
            if (key.equalsIgnoreCase(user.getMvp())) {
                playerCombobox.setSelectedIndex(i);
            }
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TeamTF = new javax.swing.JTextField();
        opponentTextF = new javax.swing.JTextField();
        winnerTextF = new javax.swing.JTextField();
        finalScoreTextF = new javax.swing.JTextField();
        stadiumTextF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        playerCombobox = new javax.swing.JComboBox<>();
        updateButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(234, 234, 253));

        jLabel1.setText("Team");

        jLabel2.setText("Stadium");

        jLabel3.setText("Winner");

        jLabel4.setText("Opponent");

        jLabel5.setText("Final Score");

        jLabel6.setText("MVP");

        playerCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(winnerTextF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TeamTF, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(stadiumTextF))
                    .addComponent(addButton))
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateButton)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(opponentTextF)
                        .addComponent(finalScoreTextF)
                        .addComponent(playerCombobox, 0, 178, Short.MAX_VALUE)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(5, 5, 5)
                        .addComponent(opponentTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(finalScoreTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(playerCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(5, 5, 5)
                        .addComponent(TeamTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(winnerTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stadiumTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateButton)
                    .addComponent(addButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        try {
//            if (!this.isFieldValid(true)) {
//                JOptionPane.showMessageDialog(new JFrame(), this.inputError, "Dialog",
//                        JOptionPane.ERROR_MESSAGE);
//
//                return;
//            }
            Matches user = this.getUserObjectFromUI();
            int rowCount = this.userService.updateMatches(user);
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
    }//GEN-LAST:event_updateButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
//        if (!this.isFieldValid(false)) {
//                JOptionPane.showMessageDialog(new JFrame(), this.inputError, "Dialog",
//                        JOptionPane.ERROR_MESSAGE);
//
//                return;
//            }
        Matches user = this.getUserObjectFromUI();
        try {
            this.userService.insertUser(user);
            JOptionPane.showMessageDialog(new JFrame(), "User profile created", "Dialog",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(), "Opps!! Inserting failed", "Dialog",
                    JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_addButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public Matches getUserObjectFromUI() {
        String game = "basketball";
        String team = TeamTF.getText();
        String opponent = opponentTextF.getText();
        String winner = winnerTextF.getText();
        String mvp = (String)playerCombobox.getSelectedItem();
        String stadium = stadiumTextF.getText();
        String finalScore = finalScoreTextF.getText();
        return new Matches(game, team, opponent, winner, finalScore, stadium, mvp);

    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TeamTF;
    private javax.swing.JButton addButton;
    private javax.swing.JTextField finalScoreTextF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField opponentTextF;
    private javax.swing.JComboBox<String> playerCombobox;
    private javax.swing.JTextField stadiumTextF;
    private javax.swing.JButton updateButton;
    private javax.swing.JTextField winnerTextF;
    // End of variables declaration//GEN-END:variables
}
