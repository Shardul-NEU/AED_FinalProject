/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import com.mongodb.client.MongoCollection;
import database.CRUDDatabase;
import org.bson.Document;

/**
 *
 * @author priyankakhimyani
 */
public class DoctorService {
    
    CRUDDatabase crud = new CRUDDatabase();
    
    public MongoCollection<Document> getCollection(){
    
        return crud.getCollection("medical");
    }
    
    public void returnDateSortedData(){
        
        MongoCollection<Document> col = getCollection();
        
    }
    
}
