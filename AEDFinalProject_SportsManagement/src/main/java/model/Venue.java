/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import view.venue.New_Staff;
import database.CRUDDatabase;
import enums.ROLES;
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