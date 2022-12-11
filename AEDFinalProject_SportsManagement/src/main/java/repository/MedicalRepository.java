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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
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

    private void insertAppointments(Medical medicalModel) {
        if (medicalModel != null && medicalModel.getPlayerId() != null) {
            try {
                MongoCollection<Document> docs = this.crud.getCollection(SCHEMANAME);
                BasicDBObject query = new BasicDBObject();
//                query.put(playerId, medicalModel.getPlayerId());
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
//                this.crud.addInArrayById(medicalModel.getPlayerId(), obj, historyField, SCHEMANAME);
                BasicDBObject match = new BasicDBObject();
                match.put(playerId, medicalModel.getPlayerId());
                BasicDBObject updateArray = new BasicDBObject();
                updateArray.put("$push", new BasicDBObject(historyField, obj));
                UpdateResult result = docs.updateOne(match, updateArray);
                result.getModifiedCount();
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        } else {

        }

    }

    public static void main(String[] args) {
        ObjectId id = new ObjectId("6393d12e9c10df3ab8018900");
        MedicalHistory history = new MedicalHistory(null, "knees", "testing via coed", "TA", new Date(), "REQUESTED", new ObjectId("63941fc0b283fac982ecf135"));
        List<MedicalHistory> histories = new ArrayList<>();
        histories.add(history);
        Medical model = new Medical(id, "John Doe", histories);
        MedicalRepository repo = new MedicalRepository();
        repo.insertAppointments(model);

    }

}
