/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.aed_finalproject;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author Shardul
 */
public class AED_FinalProject {

    public static void main(String[] args) {
        MongoClient client = (MongoClient) MongoClients.create("mongodb+srv://suraj:<password>@cluster0.ehrr7jd.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase database = client.getDatabase("SportsManagement");
        
//      If want to connect to new collection create instacne below this.
//      And pass the object to other class.
        MongoCollection<Document> admin = database.getCollection("admin");
//      collection initialization ends here
    }
}
