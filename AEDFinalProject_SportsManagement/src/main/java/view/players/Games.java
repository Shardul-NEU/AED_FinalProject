/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.players;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JSplitPane;
import javax.swing.table.DefaultTableModel;
import location.Location;
import model.Matches;
import services.MatchesService;

/**
 *
 * @author priyankakhimyani
 */
public class Games extends javax.swing.JPanel {

    /**
     * Creates new form Games
     */

    public List<Matches> matchesList = new ArrayList<Matches>();
    int count = 1;
    String username;
    String game;
    public Games(String game) {
        initComponents();
        
        this.game = game;
        
        MatchesService matchservice = new MatchesService();
        this.matchesList = matchservice.fetchAllRecords(this.game);
        DefaultTableModel dtm=(DefaultTableModel) this.gamesTable.getModel();
        String[] columnNames = { "Count", "Team", "Opponent", "Winner", "Final Score", "Stadium", "MVP" };
        DefaultTableModel model = new DefaultTableModel(columnNames, 0){
                @Override
                public boolean isCellEditable(int row, int column) {
                   //all cells false
                   return false;
                };
        };
        
        matchesList.forEach(match ->{
            
            model.addRow(new Object[] { count, match.getTeam(), match.getOpponent(), match.getWinner(), match.getFinalScore(), match.getStadium(), match.getMvp()});
            count++;
        });
        
        gamesTable.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        gamesTable = new javax.swing.JTable();
        gardenArena = new javax.swing.JButton();
        matthewsArena = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(234, 234, 253));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gamesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(gamesTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 112, 679, 444));

        gardenArena.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        gardenArena.setText("TD Garden");
        gardenArena.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gardenArenaMouseClicked(evt);
            }
        });
        gardenArena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gardenArenaActionPerformed(evt);
            }
        });
        add(gardenArena, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 30, 147, 49));

        matthewsArena.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        matthewsArena.setText("Matthews Arena");
        matthewsArena.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                matthewsArenaMouseClicked(evt);
            }
        });
        add(matthewsArena, new org.netbeans.lib.awtextra.AbsoluteConstraints(374, 30, 176, 49));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Location.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 32, 44, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void gardenArenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gardenArenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gardenArenaActionPerformed

    private void gardenArenaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gardenArenaMouseClicked
        // TODO add your handling code here:
        Location location = new Location("TD Garden");
        location.setDefaultCloseOperation(1);
        
    }//GEN-LAST:event_gardenArenaMouseClicked

    private void matthewsArenaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_matthewsArenaMouseClicked
        // TODO add your handling code here:
        
        Location location = new Location("Matthews Arena");
        location.setDefaultCloseOperation(1);
    }//GEN-LAST:event_matthewsArenaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable gamesTable;
    private javax.swing.JButton gardenArena;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton matthewsArena;
    // End of variables declaration//GEN-END:variables
}
