/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.medical.doctor;

import java.awt.Font;
import java.awt.Toolkit;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;
import org.bson.types.ObjectId;
import services.DoctorService;

/**
 *
 * @author priyankakhimyani
 */
public class DoctorHome extends javax.swing.JFrame {

    /**
     * Creates new form DoctorHome
     */
    
    DoctorService docSer = new DoctorService();
    ArrayList<Document> histories;
    int row = -1;
    String selectedDate = "";
    ObjectId doctorId = null;
    public DoctorHome(ObjectId doctorId) throws ParseException {
        initComponents();
        setResizable(false);
        setVisible(true);
        this.doctorId = doctorId;
        doctorNameLabel.setText(docSer.getDoctorName(this.doctorId));
        histories = docSer.returnDateSortedData(this.doctorId);
        
        fillDateTable();
        
    }
    
    private void fillDateTable(){
    
        String[] columnNames = {"Date"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0){
                @Override
                public boolean isCellEditable(int row, int column) {
                   //all cells false
                   return false;
                };
        };

        for(int i = 0; i < histories.size(); i++){
        
     
            Document history = (Document) histories.get(i);

            model.addRow(new Object[] { history.get("date") });
        
            dateTable.setModel(model);
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

        jPanel1 = new javax.swing.JPanel();
        doctorNameLabel = new javax.swing.JLabel();
        splitPanel = new javax.swing.JSplitPane();
        appScrollPane = new javax.swing.JScrollPane();
        appointmentsTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        dateTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(234, 234, 253));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        doctorNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        doctorNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        doctorNameLabel.setText("Doctor");
        doctorNameLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        jPanel1.add(doctorNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, 30));

        splitPanel.setResizeWeight(0.2);

        appointmentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Name", "Diagnosis For"
            }
        ));
        appointmentsTable.setRowHeight(50);
        appointmentsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                appointmentsTableMouseClicked(evt);
            }
        });
        appScrollPane.setViewportView(appointmentsTable);
        appointmentsTable.setFont(new Font("Serif", Font.PLAIN, 20));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        appointmentsTable.setDefaultRenderer(String.class, centerRenderer);

        splitPanel.setRightComponent(appScrollPane);

        dateTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date"
            }
        ));
        dateTable.setRowHeight(50);
        dateTable.setFont(new Font("Serif", Font.PLAIN, 20));
        dateTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dateTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(dateTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
        );

        splitPanel.setLeftComponent(jPanel2);

        jPanel1.add(splitPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 870, 620));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("Appointments");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, -1, -1));
        jLabel1.setFont(new Font("Serif", Font.PLAIN, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Doctor.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 50, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/Appointments.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, 50, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dateTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dateTableMouseClicked
        // TODO add your handling code here:
        JTable source = (JTable)evt.getSource();
        int row = source.rowAtPoint( evt.getPoint() );
        this.selectedDate = (String) dateTable.getValueAt(row, 0);
        fillAppointments();
        splitPanel.setRightComponent(appScrollPane);
        
    }//GEN-LAST:event_dateTableMouseClicked

    private void appointmentsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appointmentsTableMouseClicked
        // TODO add your handling code here:
        
        
        JTable source = (JTable)evt.getSource();
        int row = source.rowAtPoint( evt.getPoint() );
        String name = appointmentsTable.getValueAt(row, 0).toString();
        
        Document doc = docSer.getSelectedAppointment(histories, name, this.selectedDate);
       
        Diagnosis dia = new Diagnosis(doc);
        
        splitPanel.setRightComponent(dia);
    }//GEN-LAST:event_appointmentsTableMouseClicked
    
    private void fillAppointments(){
        
        String[] columnNames = {"Name", "Diagnosis For"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0){
                @Override
                public boolean isCellEditable(int row, int column) {
                   //all cells false
                   return false;
                };
        };

        for(int i = 0; i < histories.size(); i++){
        
     
            Document history = (Document) histories.get(i);
            if(history.get("date").equals(this.selectedDate)){
                model.addRow(new Object[] { history.get("name"), history.get("shownFor") });
            }
            
        
            appointmentsTable.setModel(model);
        }
     
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane appScrollPane;
    private javax.swing.JTable appointmentsTable;
    private javax.swing.JTable dateTable;
    private javax.swing.JLabel doctorNameLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane splitPanel;
    // End of variables declaration//GEN-END:variables
}
