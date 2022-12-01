/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.aed_finalproject;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.Iterator;
import org.bson.Document;

/**
 *
 * @author Shardul
 */
public class AED_FinalProject {

    public static void main(String[] args) {
        MongoClient client = MongoClients.create("mongodb+srv://suraj:7021072380@cluster0.ehrr7jd.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase database = client.getDatabase("SportsManagement");
        
//      If want to connect to new collection create instacne below this.
//      And pass the object to other class.
        MongoCollection<Document> admin = database.getCollection("admin");
//      collection initialization ends here
// The following code is to test the connection
        FindIterable<Document> iterDoc = admin.find();
      Iterator it = iterDoc.iterator();
      while (it.hasNext()) {
         System.out.println(it.next());

    }
    }
}
    
