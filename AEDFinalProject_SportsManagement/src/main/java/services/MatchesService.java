/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.util.ArrayList;
import java.util.List;
import model.Matches;
import model.User;
import org.bson.Document;
import repository.MatchesRepository;

/**
 *
 * @author Shardul
 */
public class MatchesService {
    
    public MatchesService() {
        this.repository = new MatchesRepository();
    }
    MatchesRepository repository;
    
    public List<Matches> fetchAllRecords(){
         List<Document> documents= this.repository.fetchMatches();
         List<Matches> match= new ArrayList<Matches>();
         for(Document doc: documents){
            Matches matches = new Matches(doc.getString("game"), doc.getString("team"), doc.getString("opponent"), doc.getString("winner"), doc.getString("finalscore"), doc.getString("stadium"), doc.getString("MVP"));
            matches.setId(doc.getObjectId("_id"));
            match.add(matches);
         }
         
         return match;
     }
    
    public int updateMatches(Matches match){
        int rowsUpdate= this.repository.updateMatchesInfo(match);
        return rowsUpdate;
}
    public Matches insertUser(Matches match){
        return this.repository.creatematch(match);
        
    }
}
