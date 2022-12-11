/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import database.CRUDDatabase;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Locale;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import validation.Validation;

/**
 *
 * @author priyankakhimyani
 */
public class DoctorService {
    
    CRUDDatabase crud = new CRUDDatabase();
    
    public MongoCollection<Document> getCollection(){
    
        return crud.getCollection("medical");
    }
    
    public ArrayList<Document> returnDateSortedData(ObjectId doctorId) throws ParseException{
        
        
        MongoCollection<Document> col = getCollection();
       
        
        FindIterable<Document> fi = col.find();
        MongoCursor<Document> cursor = fi.iterator();
        ArrayList<Document> allHistory = new ArrayList<Document>();
        
        try {
            while(cursor.hasNext()) {               
                Document doc = cursor.next();
                ArrayList<Document> histories = (ArrayList<Document>) doc.get("history");
                
                
                
                for(int i = 0; i < histories.size(); i++){
                
                    Document d = (Document) histories.get(i);
                    
                    if(d.get("docId").toString().equals(doctorId.toString())){
                        
                        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                        SimpleDateFormat outputFormat= new SimpleDateFormat("MM/dd/yyyy");


                        String finalStr;
                        finalStr = outputFormat.format(d.get("date"));
                        d.append("date", finalStr);
                        d.append("name", doc.get("name"));
                        d.append("medicalId", doc.get("_id"));


                        allHistory.add(d);
                    }
                }   
            }
        } finally {
            cursor.close();
        }
         
        return sortByDate(allHistory);
    
    }
    
    public String getDoctorName(ObjectId id){
    
        return crud.getRecordByKey("_id", id, "users").get("name").toString();
    
    }
    
    private ArrayList<Document> sortByDate(ArrayList<Document> allHistory) throws ParseException{
        
        
        for (int i = 0; i < allHistory.size()-1 ; i++){
            
            int largest = i;
            
            for (int j = i+1; j < allHistory.size() ; j++){
                SimpleDateFormat sdformat = new SimpleDateFormat("MM/dd/yyyy");
                Date d1 = sdformat.parse(allHistory.get(largest).get("date").toString());
                Date d2 = sdformat.parse(allHistory.get(j).get("date").toString());
        
                if(d2.compareTo(d1) > 0){
                    largest = j;
                }
            }
            
            Document temp = allHistory.get(i);
            allHistory.set(i, allHistory.get(largest));
            allHistory.set(largest, temp);
            
        }
        
        return allHistory;
    }
    
    public Document getSelectedAppointment(ArrayList<Document> appointment, String name, String date){
    
        for(int i = 0; i < appointment.size(); i++ ){
        
            Document doc = appointment.get(i);
            
            if(doc.get("name").equals(name) && doc.get("date").equals(date)){
            
                return doc;
            }
        
        }
    
        return null;
    }
    
    public String validateField(String shownFor, String notes, String medicine){
        Validation valid = new Validation();
        
        String message = "";
        

        if(!valid.onlyCharactersWithCommaPeriod(shownFor)){
            
            message+="Diagnosis For, ";
        
        }
        if(!valid.onlyCharactersWithCommaPeriod(notes)){
            
            message+="Notes, ";
        
        }
        if(!valid.onlyCharactersWithCommaPeriod(medicine)){
            
            message+="Medicine, ";
        
        }
        
        if(message.length() < 1){
            
            return "";
        }
        return message+=" are not valid!";
        
        
    }
    
    public int updateAppointment(Document doc){
                
       
        Document playerRecord =  crud.getRecordByKey("_id", (ObjectId) doc.get("medicalId"), "medical");

        String str = doc.get("date").toString()+" 00:00"; 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");

        Document newDoc = new Document()
                .append("id", (ObjectId)doc.get("id"))
                .append("shownFor", doc.get("shownFor"))
                .append("notes", doc.get("notes"))
                .append("medicine", doc.get("medicine"))
                .append("date", LocalDateTime.parse(str, formatter))
                .append("status", doc.get("status"))
                .append("docId", (ObjectId) doc.get("docId"));

        ArrayList<Document> playerHistories = (ArrayList<Document>) playerRecord.get("history");

        int index = -1;

        for(int i =0; i< playerHistories.size(); i++){

            Document playerHistory  = playerHistories.get(i);
            if(doc.get("id").toString().equals(playerHistory.get("id").toString())){

                index = i;
            }
        }

        playerHistories.set(index, newDoc);



        Document query = new Document().append("_id",  (ObjectId)doc.get("medicalId"));
        
        Bson updates = Updates.combine(
        Updates.set("history", playerHistories));

        UpdateOptions options = new UpdateOptions().upsert(true);

        return crud.updateDocumentById(query, updates, options, "medical");
        

    }
    
    
    public ArrayList<Document> getPlayerMedicalData(ObjectId id) throws ParseException{
        
        Document playerData = (Document) crud.getRecordByKey("_id", id, "medical");
        
        ArrayList<Document> histories = (ArrayList<Document>) playerData.get("history");//sortByDate((ArrayList<Document>) playerData.get("history"));
  
        
        for(int i = 0; i < histories.size(); i++){
                
                    Document d = (Document) histories.get(i);
                  
                    SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                    SimpleDateFormat outputFormat= new SimpleDateFormat("MM/dd/yyyy");


                    String finalStr;
                    finalStr = outputFormat.format(d.get("date"));
                    d.append("date", finalStr);
                     
                } 
        
        
        return histories;
    }
    
   
    
}
