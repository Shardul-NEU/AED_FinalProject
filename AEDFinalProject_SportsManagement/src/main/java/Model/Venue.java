/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Venue_Updated.New_Staff;
import database.CRUDDatabase;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Shardul
 */
public class Venue {
    private String userId;
    private String name;
    private String password;
    private long phone;
    private String email;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
     public Venue(String userId, String name, String password, long phone, String email){
    
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }
     
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
    
    public int deletefromtable(ArrayList<Document> arr, String venue, String staff){
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
       
                ObjectId id = (ObjectId) new CRUDDatabase().getRecordByTwoKeys("venue", venue, "staff", staff, "venueStaff").get("_id");
        
                int result = new CRUDDatabase().deleteFomArray(id, arr, "staffList", "venueStaff");
                return result;
    }
}