/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import com.mongodb.Cursor;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import database.CRUDDatabase;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import model.MedicalHistory;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author priyankakhimyani
 */
public class PharmacyService {
    
    private CRUDDatabase crud = new CRUDDatabase();
    private ArrayList<Document> records = new ArrayList<>();
    
    public ArrayList<Document> getArrayData(){
    
        return this.records;
    }
    
    public MongoCollection<Document> getCollection(){
    
        return crud.getCollection("medical");
    }
    
    private String getName(ObjectId id){
    
        return (String) crud.getRecordByKey("_id", id, "users").get("name");
    
    }
    
    
    public DefaultTableModel getData() throws ParseException{
    
       prepareData();
       this.records =  sortByDate(this.records);
       return returnTableModel(this.records);
        
    }
    
    
    private void prepareData(){
    
        FindIterable<Document> fi = getCollection().find();
        MongoCursor<Document> cursor = fi.iterator();
        
        
        while(cursor.hasNext()){
        
            Document doc = cursor.next();
            
            ArrayList<Document> arr = (ArrayList<Document>) doc.get("history");
            
            for(int i = 0; i < arr.size() ; i++){
                
                Document newDoc = new Document();
                Document record = arr.get(i);
                
                if(!record.get("medicine").toString().isEmpty()){
                    SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                    SimpleDateFormat outputFormat= new SimpleDateFormat("MM/dd/yyyy");
                    newDoc.append("date", outputFormat.format(record.get("date")));
                    newDoc.append("doctor", getName((ObjectId) record.get("docId")));
                    newDoc.append("medicine", record.get("medicine") );
                    newDoc.append("status", record.get("status"));
                    newDoc.append("name", doc.get("name"));
                    newDoc.append("historyid", record.get("id"));
                    newDoc.append("id", doc.get("_id"));

                    records.add(newDoc);
                }
                
            }
            
        }
    
    }
    
    public DefaultTableModel returnTableModel(ArrayList<Document> recordDocuments){
        
        recordDocuments = recordDocuments != null ? recordDocuments : this.records;
        
        String[] columnNames = { "Date", "Doctor Name", "Medicine", "Status" ,"Name"};
    
        DefaultTableModel model = new DefaultTableModel(columnNames, 0){
                @Override
                public boolean isCellEditable(int row, int column) {
                   //all cells false
                   return false;
                };
        };
        
        for(int i = 0; i < recordDocuments.size(); i++){
            
            Document order = recordDocuments.get(i);
            
            if(order.get("medicine").toString().length() > 0){
                
                model.addRow(new Object[] { order.get("date"), order.get("doctor"), order.get("medicine"), order.get("status"), order.get("name")});
            
            }
      
        } 
         
        return model;
    }
    
    
    private ArrayList<Document> sortByDate(ArrayList<Document> allRecords) throws ParseException{
        
        
        for (int i = 0; i < allRecords.size()-1 ; i++){
            
            int largest = i;
            
            for (int j = i+1; j < allRecords.size() ; j++){
                SimpleDateFormat sdformat = new SimpleDateFormat("MM/dd/yyyy");
                Date d1 = sdformat.parse(allRecords.get(largest).get("date").toString());
                Date d2 = sdformat.parse(allRecords.get(j).get("date").toString());
        
                if(d2.compareTo(d1) > 0){
                    largest = j;
                }
            }
            
            Document temp = allRecords.get(i);
            allRecords.set(i, allRecords.get(largest));
            allRecords.set(largest, temp);
            
        }
        
        return allRecords;
    }
    
    public int updateStatus(int row){
    
       
        Document record = records.get(row);
        
        Document doc = crud.getRecordByKey("_id", (ObjectId) record.get("id"), "medical");
        
        ArrayList<Document> arr = (ArrayList<Document>) doc.get("history");
        
        
        for(int i = 0; i < arr.size(); i++){
            
            Document d = arr.get(i);
            
            if(d.get("id").equals(record.get("historyid"))){
            
                d.append("status", "Done");
                break;
            }
            
        }
        
        MongoCollection<Document> collection = getCollection();
        
        Document query = new Document().append("_id",  (ObjectId) record.get("id"));
        
        Bson updates = Updates.combine(
                    Updates.set("history", arr));
        UpdateOptions options = new UpdateOptions().upsert(true);
        
        return crud.updateDocumentById(query, updates, options, collection);
        
    }
    
}
