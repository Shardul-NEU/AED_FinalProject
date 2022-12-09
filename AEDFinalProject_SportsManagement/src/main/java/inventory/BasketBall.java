/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package inventory;

/**
 *
 * @author priyankakhimyani
 */
public class BasketBall extends javax.swing.JPanel {

    /**
     * Creates new form BasketBall
     */
    public BasketBall() {
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

        //BufferedImage myPicture = ImageIO.read(new File("ictures/basketball.jpeg"));
        backBoard = new javax.swing.JLabel(new javax.swing.ImageIcon(getClass().getResource("/Pictures/backboard.jpeg")));
        //BufferedImage myPicture = ImageIO.read(new File("ictures/basketball.jpeg"));
        ball1 = new javax.swing.JLabel(new javax.swing.ImageIcon(getClass().getResource("/Pictures/basketball.jpeg")));
        //BufferedImage myPicture = ImageIO.read(new File("ictures/basketball.jpeg"));
        ringsandrims1 = new javax.swing.JLabel(new javax.swing.ImageIcon(getClass().getResource("/Pictures/ringsandrims.jpeg")));
        //BufferedImage myPicture = ImageIO.read(new File("ictures/basketball.jpeg"));
        shoes = new javax.swing.JLabel(new javax.swing.ImageIcon(getClass().getResource("/Pictures/shoes.jpeg")));
        //BufferedImage myPicture = ImageIO.read(new File("ictures/basketball.jpeg"));
        jersey = new javax.swing.JLabel(new javax.swing.ImageIcon(getClass().getResource("/Pictures/jersey.jpeg")));
        //BufferedImage myPicture = ImageIO.read(new File("ictures/basketball.jpeg"));
        nets = new javax.swing.JLabel(new javax.swing.ImageIcon(getClass().getResource("/Pictures/nets.jpeg")));

        setBackground(new java.awt.Color(232, 243, 214));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backBoard.setText("a");
        backBoard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backBoardMouseClicked(evt);
            }
        });
        add(backBoard, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 330, 176, 168));

        backBoard.setSize(80, 80);
        ball1.setBackground(new java.awt.Color(255, 102, 102));
        ball1.setText("a");
        ball1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ball1MouseClicked(evt);
            }
        });
        add(ball1, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 55, 176, 168));

        ringsandrims1.setText("a");
        ringsandrims1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ringsandrims1MouseClicked(evt);
            }
        });
        add(ringsandrims1, new org.netbeans.lib.awtextra.AbsoluteConstraints(442, 55, 176, 168));

        shoes.setText("b");
        shoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                shoesMouseClicked(evt);
            }
        });
        add(shoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 341, 176, 168));

        jersey.setText("v");
        jersey.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jerseyMouseClicked(evt);
            }
        });
        add(jersey, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 590, 176, 168));

        nets.setText("v");
        nets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                netsMouseClicked(evt);
            }
        });
        add(nets, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 590, 176, 168));
    }// </editor-fold>//GEN-END:initComponents

    private void backBoardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBoardMouseClicked
        // TODO add your handling code here:
        Backboard bck = new Backboard();
        bck.setDefaultCloseOperation(1);
       
    }//GEN-LAST:event_backBoardMouseClicked

    private void ball1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ball1MouseClicked
        // TODO add your handling code here:
        Ball bb = new Ball();
        bb.setDefaultCloseOperation(1);
    }//GEN-LAST:event_ball1MouseClicked

    private void ringsandrims1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ringsandrims1MouseClicked
        // TODO add your handling code here:
        RingsAndRims rr = new RingsAndRims();
        rr.setDefaultCloseOperation(1);
    }//GEN-LAST:event_ringsandrims1MouseClicked

    private void shoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shoesMouseClicked
        // TODO add your handling code here:
        Shoes shoes = new Shoes();
        shoes.setDefaultCloseOperation(1);
    }//GEN-LAST:event_shoesMouseClicked

    private void jerseyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jerseyMouseClicked
        // TODO add your handling code here:
        Jersey jersey = new Jersey();
        jersey.setDefaultCloseOperation(1);
    }//GEN-LAST:event_jerseyMouseClicked

    private void netsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_netsMouseClicked
        // TODO add your handling code here:
        Nets nets = new Nets();
        nets.setDefaultCloseOperation(1);
    }//GEN-LAST:event_netsMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backBoard;
    private javax.swing.JLabel ball1;
    private javax.swing.JLabel jersey;
    private javax.swing.JLabel nets;
    private javax.swing.JLabel ringsandrims1;
    private javax.swing.JLabel shoes;
    // End of variables declaration//GEN-END:variables
}
