/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.aed_finalproject;

import Venue_Updated.MainStaff;
import Venue_Updated.SecStaff;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import inventory.Inventory;
import org.bson.Document;

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

    public static void main(String[] args) {
        
        
//      If want to connect to new collection create instacne below this.
//      And pass the object to other class.
//      collection initialization ends here
        // The following code is to test the connection
//      FindIterable<Document> iterDoc = db.maintenanceStaff.find();
//      Iterator it = iterDoc.iterator();
//      while (it.hasNext()) {
//         System.out.println(it.next());
//         PageFrame frame = new PageFrame();
        //new Inventory();
        new SecStaff();
        
//        frame.setVisible(true);
    }
    }
    
