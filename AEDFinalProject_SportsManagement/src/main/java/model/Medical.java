/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Shardul
 */
public class Medical {
    
    private ObjectId playerId;
    private String name;
    private List<MedicalHistory> history;

    public Medical(ObjectId playerId, String name, List<MedicalHistory> history) {
        this.playerId = playerId;
        this.name = name;
        this.history = history;
    }
    
    

    public ObjectId getPlayerId() {
        return playerId;
    }

    public void setPlayerId(ObjectId playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MedicalHistory> getHistory() {
        return history;
    }

    public void setHistory(List<MedicalHistory> history) {
        this.history = history;
    }
    
    
    
}
