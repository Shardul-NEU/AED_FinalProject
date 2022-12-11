/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author priyankakhimyani
 */
public class CRUDDatabase {
    
    public MongoCollection<Document> getCollection(String collectionName){
        
        MongoDatabase database = DataBaseConnection.connectToDatabase().database;
    
        return database.getCollection(collectionName);
    }
    
    public Document getRecordByKey(String key, String value, String collectionName){
    
    
        MongoCollection<Document> doc = getCollection(collectionName);
        
        return doc.find(new Document(key, value)).first();
        
    }
    
    public Document getRecordByKey(String key, ObjectId value, String collectionName){
    
    
        MongoCollection<Document> doc = getCollection(collectionName);
        
        return doc.find(new Document(key, value)).first();
        
    }
    
    public DeleteResult deleteRecordByKey(String key, String value, String collectionName){
    
    
        MongoCollection<Document> doc = getCollection(collectionName);
        
        return doc.deleteOne(Filters.eq(key, value));
        
    }
    
    public MongoCursor<Document> getRecords(String collectionName){
    
    
        MongoCollection<Document> doc = getCollection(collectionName);
        
        return doc.find().iterator();
        
    }
    
    public Document getRecordByTwoKeys(String key1, String value1, String key2, String value2, String collectionName){
    
    
        MongoCollection<Document> doc = getCollection(collectionName);
        
        return doc.find(Filters.and(Filters.eq(key1, value1),Filters.eq(key2, value2) )).first();
        
    }
    
    public int addInArrayById(ObjectId id, BasicDBObject obj, String key, String collection){
    
        BasicDBObject match = new BasicDBObject();
        match.put( "_id", id );
        
        BasicDBObject updateArray = new BasicDBObject();
        updateArray.put( "$push", new BasicDBObject( key, obj ) );
        
        UpdateResult result= getCollection(collection).updateOne(match, updateArray );
    
        return (int) result.getModifiedCount();
    }
    
    public int deleteFomArray(ObjectId id, ArrayList<Document> doc, String key, String collection){
        
    
        MongoCollection<Document> coll = getCollection(collection);
        
        Document query = new Document().append("_id",  id);
         
        Bson updates = Updates.combine(Updates.set(key, doc));
        UpdateResult result = null;
        
        try {
                result = coll.updateOne(query, updates);
                
            } catch (MongoException me) {
                System.err.println("Unable to update due to an error: " + me);
            }
                 
                    
        
        return (int) result.getModifiedCount();
    }
    

     public int updateDocumentById(Document query, Bson updates, UpdateOptions options, String collection){
         MongoCollection<Document> coll = getCollection(collection);
        try {
                UpdateResult result = coll.updateOne(query, updates, options);
                return (int) result.getModifiedCount();
            } catch (MongoException me) {
                System.err.println("Unable to update due to an error: " + me);
            }
        return 0;
    
    }

    public void insertDocument(Document doc, String collectionName){
       MongoCollection<Document> collection=this.getCollection(collectionName);
        collection.insertOne(doc);
                
    }
    
     public int updateObjectOfKey(ObjectId id, String key ,Document obj, String collectionName ){
         
         MongoCollection<Document> doc= this.getCollection(collectionName);
        Document query = new Document().append("_id",  id);
        Bson updates = Updates.combine(
                Updates.set(key, obj));

        UpdateOptions options = new UpdateOptions().upsert(true);
        UpdateResult result = null;
        try {
             result= doc.updateOne(query, updates, options);
        } catch (MongoException me) {
            System.err.println("Unable to update due to an error: " + me);
        }
        
        if(result != null ){
            return (int) result.getModifiedCount();
        }
        
        return 0;
        
    
    }
     
     public int updateDocumentById(Document query, Bson updates, UpdateOptions options, MongoCollection collection){
        
        try {
                UpdateResult result = collection.updateOne(query, updates, options);
                return (int) result.getModifiedCount();
            } catch (MongoException me) {
                System.err.println("Unable to update due to an error: " + me);
            }
        return 0;
    
    }
    
}
