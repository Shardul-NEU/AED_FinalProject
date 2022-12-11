/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import database.CRUDDatabase;
import database.DataBaseConnection;
import model.Medical;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.util.JSON;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import model.MedicalHistory;
import org.bson.types.ObjectId;

/**
 *
 * @author Shardul
 */
public class MedicalRepository {

    private MongoDatabase connection = DataBaseConnection.connectToDatabase().database;
    ;
    
    private CRUDDatabase crud = new CRUDDatabase();
    ;
    private final String SCHEMANAME = "medical";
    private final static String playerId = "playerId";
    private final static String historyField = "history";

    public long insertAppointments(Medical medicalModel) {
        if (medicalModel != null && medicalModel.getPlayerId() != null) {
            try {
                MongoCollection<Document> docs = this.crud.getCollection(SCHEMANAME);
                Document document = docs.find(Filters.eq(playerId, medicalModel.getPlayerId())).first();
                if (document == null) {
                    //create a new player with history
                    Document doc = new Document();
                    doc.append(playerId, medicalModel.getPlayerId());
                    doc.append("name", medicalModel.getName());
                    this.crud.insertDocument(doc, SCHEMANAME);
                }
                //insert appointment
                MedicalHistory history = medicalModel.getHistory().get(0);
                BasicDBObject obj = (BasicDBObject) JSON.parse(new Gson().toJson(history));
                obj.append("docId", history.getDocId());
                obj.append("date",history.getDate());
//                this.crud.addInArrayById(medicalModel.getPlayerId(), obj, historyField, SCHEMANAME);
                BasicDBObject match = new BasicDBObject();
                match.put(playerId, medicalModel.getPlayerId());
                BasicDBObject updateArray = new BasicDBObject();
                 
                updateArray.put("$push", new BasicDBObject(historyField, obj));
                UpdateResult result = docs.updateOne(match, updateArray);
                return result.getModifiedCount();
            } catch (Exception ex) {
                ex.printStackTrace();
                return -1;
            }
        } else {
            return -1;
        }

    }
    
    public boolean isDuplicateAppointment(ObjectId personId,ObjectId doctorId, Date requestDate){
//            this.crud.getRecordByKey(playerId, personId, SCHEMANAME);
            MongoCollection<Document> docs = this.crud.getCollection(SCHEMANAME);
                Document document = docs.find(Filters.eq(playerId,personId)).first();
                if (document == null) {
                    //create a new player with history
                    return false;
                }
                List<Document> history=document.get("history",List.class);
                
                SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
                for(Document doc:history){
                    ObjectId tempDocId=doc.get("docId", ObjectId.class);
                  
                    if(tempDocId.equals(doctorId)){
                          Date reservedDate= doc.getDate("date");
                        Calendar c1=Calendar.getInstance();
                        Calendar c2=Calendar.getInstance();
                        c1.setTime(requestDate);
                        c2.setTime(reservedDate);
                        if(c1.get(Calendar.YEAR)==c2.get(Calendar.YEAR) && c1.get(Calendar.MONTH)==c2.get(Calendar.MONTH)  && c1.get(Calendar.DAY_OF_MONTH)==c2.get(Calendar.DAY_OF_MONTH)  ){
                            return true;
                        }
                    }
                }
                return false;
    }

    public static void main(String[] args) {
        ObjectId id = new ObjectId("6394de72a7c4e9628926d008");
        MedicalHistory history = new MedicalHistory(null, "knees", "testing via code", "TA", new Date(), "REQUESTED", new ObjectId("63941fc0b283fac982ecf135"));
        List<MedicalHistory> histories = new ArrayList<>();
        histories.add(history);
        Medical model = new Medical(id, "John Doe", histories);
        MedicalRepository repo = new MedicalRepository();
        repo.insertAppointments(model);

    }
}
