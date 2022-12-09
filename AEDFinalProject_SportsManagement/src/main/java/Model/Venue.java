/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;

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
    
    
}