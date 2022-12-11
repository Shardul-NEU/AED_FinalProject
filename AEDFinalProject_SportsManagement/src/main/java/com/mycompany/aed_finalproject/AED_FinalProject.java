/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.aed_finalproject;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import database.CRUDDatabase;
import java.text.ParseException;
import org.bson.Document;
import org.bson.types.ObjectId;
import view.common.LoginFrame;
import view.inventory.Inventory;
import view.medical.doctor.DoctorHome;

/**
 *
 * @author Shardul
 */
public class AED_FinalProject {
    
//    public static class database{
//        MongoClient client = MongoClients.create("mongodb+srv://suraj:7021072380@cluster0.ehrr7jd.mongodb.net/?retryWrites=true&w=majority");
//        MongoDatabase database = client.getDatabase("SportsManagement");
//        MongoCollection<Document> admin = database.getCollection("admin");
//        MongoCollection<Document> maintenanceStaff = database.getCollection("maintenanceStaff");
//        MongoCollection<Document> securityStaff = database.getCollection("securityStaff");
//        MongoCollection<Document> secShift = database.getCollection("secShift");
//        MongoCollection<Document> mainShift = database.getCollection("mainShift");
//    }

    public static void main(String[] args) throws ParseException {
        
        
//      If want to connect to new collection create instacne below this.
//      And pass the object to other class.
//      collection initialization ends here
        // The following code is to test the connection
//      FindIterable<Document> iterDoc = db.maintenanceStaff.find();
//      Iterator it = iterDoc.iterator();
//      while (it.hasNext()) {
//         System.out.println(it.next());
//         PageFrame frame = new PageFrame();
//           new Inventory();
//        new LoginFrame().setVisible(true);
//        frame.setVisible(true);
        ObjectId id = (ObjectId) new CRUDDatabase().getRecordByKey("role", "doctor", "users").get("_id");
        new DoctorHome(id);
    }
    }
    
