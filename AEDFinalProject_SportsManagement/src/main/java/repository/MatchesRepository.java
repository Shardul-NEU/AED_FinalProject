/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import database.CRUDDatabase;
import database.DataBaseConnection;
import enums.ROLES;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.Matches;
import model.Matches;
import model.User;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author Shardul
 */
public class MatchesRepository {
    private MongoDatabase connection = DataBaseConnection.connectToDatabase().database;
    
    private CRUDDatabase crud = new CRUDDatabase();
    
    private final String SCHEMANAME = "matches";
    private final static String ObjectId = "opponent";
    
    public Matches createMatches(Matches matches) {

        Document doc = new Document();
        doc.append("game", matches.getGame());
        doc.append("team", matches.getTeam());
        doc.append("opponent", matches.getOpponent());
        doc.append("winner", matches.getWinner());
        doc.append("finalScore", matches.getFinalScore());
        doc.append("stadium", matches.getStadium());
        doc.append("mvp", matches.getMvp());
        this.crud.insertDocument(doc, SCHEMANAME);
        return matches;
    }
    
    public List<Document> fetchMatches(String game){
        MongoCollection<Document> document=this.crud.getCollection(SCHEMANAME);
        FindIterable<Document> iterDoc=document.find();
        Iterator<Document> itr= iterDoc.iterator();
        List<Document> documents= new ArrayList<Document>();
        while(itr.hasNext()){
            Document doc = itr.next();
            if(game != null){
                if(doc.get("game").toString().equals(game)){
                    documents.add(doc);
                }
            }else{
                documents.add(doc);
            }
            
        }
        return documents;
    }
    
    public Matches creatematch(Matches match) {

        Document doc = new Document();
        doc.append("game", match.getGame());
        doc.append("team", match.getTeam());
        doc.append("opponent", match.getOpponent());
        doc.append("winner", match.getWinner());
        doc.append("finalscore", match.getFinalScore());
        doc.append("stadium", match.getStadium());
        doc.append("MVP", match.getMvp());
        this.crud.insertDocument(doc, SCHEMANAME);
        return match;
    }
    
    public Matches fetchUserByUserName(String username) {

        MongoCollection<Document> document = this.crud.getCollection(SCHEMANAME);
        if (document == null) {
            return null;
        }
        Document doc = document.find(Filters.and(Filters.eq(ObjectId, username ))).first();
        if (doc != null) {
            Matches matches = new Matches(doc.getString("game"), doc.getString("team"), doc.getString("opponent"), doc.getString("winner"), doc.getString("finalscore"), doc.getString("stadium"), doc.getString("MVP"));
            matches.setId(doc.getObjectId("_id"));
            return matches;
        }
        return null;
    }
    
    
    
     public int updateMatchesInfo(Matches matches) {
        Document doc = new Document();

         Matches exisitingMatches = this.fetchUserByUserName(matches.getOpponent());
        if (matches.getGame() == null) {
            matches.setGame(exisitingMatches.getGame());
        }
        if (matches.getTeam() == null) {
            matches.setTeam(exisitingMatches.getTeam());
        }
        if (matches.getOpponent() == null) {
            matches.setOpponent(exisitingMatches.getOpponent());
        }
        if (matches.getWinner() == null) {
            matches.setWinner(exisitingMatches.getWinner());
        }
        if (matches.getFinalScore() == null) {
            matches.setFinalScore(exisitingMatches.getFinalScore());
        }
        if (matches.getStadium() == null) {
            matches.setStadium(exisitingMatches.getStadium());
        }
        if (matches.getMvp() == null) {
            matches.setMvp(exisitingMatches.getMvp());
        }

        Document query = new Document().append("_id", exisitingMatches.getId());
        Bson updates = Updates.combine(
                Updates.set("game", matches.getGame()),
                Updates.set("team", matches.getTeam()),
                Updates.set("opponent", matches.getOpponent()),
                Updates.set("winner", matches.getWinner()),
                Updates.set("finalscore", matches.getFinalScore()),
                Updates.set("stadium", matches.getStadium()),
                Updates.set("MVP", matches.getMvp()));

        UpdateOptions options = new UpdateOptions().upsert(false);
        UpdateResult result = null;
        try {
            result = this.crud.getCollection(SCHEMANAME).updateOne(query, updates, options);
        } catch (MongoException me) {
            me.printStackTrace();
            System.err.println("Unable to update due to an error: " + me);
        }

        if (result != null) {
            return (int) result.getModifiedCount();
        }
        return -1;
    }
}
