/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author Shardul
 */
public class database {
    
    public MongoClient client = MongoClients.create("mongodb+srv://suraj:7021072380@cluster0.ehrr7jd.mongodb.net/?retryWrites=true&w=majority");
        public MongoDatabase database = client.getDatabase("SportsManagement");
        public MongoCollection<Document> admin = database.getCollection("admin");
        public MongoCollection<Document> maintenanceStaff = database.getCollection("maintenanceStaff");
        public MongoCollection<Document> securityStaff = database.getCollection("securityStaff");
        public MongoCollection<Document> secShift = database.getCollection("secShift");
        public MongoCollection<Document> mainShift = database.getCollection("mainShift");
    }
