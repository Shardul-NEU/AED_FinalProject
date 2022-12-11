/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import enums.ROLES;
import org.bson.types.ObjectId;

/**
 *
 * @author Shardul
 */
public class Matches {
    
    private String game;
    private String team;
    private String opponent;
    private String winner;
    private String finalScore;
    private String stadium;
    private String mvp;
    private ObjectId id;
    public Matches() {
    }
     public Matches(String game, String team, String opponent, String winner, String finalScore, String stadium, String mvp) {
         this.game = game;
         this.team = team;
         this.opponent = opponent;
         this.winner = winner;
         this.finalScore = finalScore;
         this.stadium = stadium;
         this.mvp = mvp;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getOpponent() {
        return opponent;
    }

    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(String finalScore) {
        this.finalScore = finalScore;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getMvp() {
        return mvp;
    }

    public void setMvp(String mvp) {
        this.mvp = mvp;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    
     
    
}
