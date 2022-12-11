/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import database.CRUDDatabase;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;
import view.venue.New_Staff;

/**
 *
 * @author Shardul
 */
public class VenueService {
    
    public static void filltable(ArrayList<Document> staffList, JTable ordersTable){
        String[] columnNames = { "UserId", "Name", "Password","Phone", "Email"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0){
                @Override
                public boolean isCellEditable(int row, int column) {
                   //all cells false
                   return false;
                };
        };
        staffList.forEach(staff ->{
            
            model.addRow(new Object[] { staff.get("userId"), staff.get("name"), staff.get("password"), staff.get("phone"), staff.get("email")});
        });
        
        ordersTable.setModel(model);
    }
    
    public static void totalstaffcount(JLabel rrCount, ArrayList<Document> staffList ){
        rrCount.setText(staffList.size()+"");
    }
    public static void refreshtable(JLabel rrCount,JTable ordersTable,String venue,String staff ){
        Document doc = new CRUDDatabase().getRecordByTwoKeys("venue", venue, "staff", staff, "venueStaff");
        
        ArrayList<Document> staffList = (ArrayList<Document>) doc.get("staffList");
        totalstaffcount(rrCount, staffList);
        filltable(staffList, ordersTable);
    }
    public static void createNew(JComboBox jComboBox1, String staff){
    New_Staff window;
        window = new New_Staff(staff,jComboBox1.getSelectedItem().toString());
        window.show();
        window.setDefaultCloseOperation(1);
    }
}
