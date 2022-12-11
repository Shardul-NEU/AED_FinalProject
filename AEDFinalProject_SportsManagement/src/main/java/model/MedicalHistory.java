/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
import org.bson.types.ObjectId;

/**
 *
 * @author Shardul
 */
public class MedicalHistory {
    
    private ObjectId id;
    private String shownFor;
    private String notes;
    private String medicine;
    private Date date;
    private String status;
    private ObjectId docId;

    public MedicalHistory(ObjectId id, String shownFor, String notes, String medicine, Date date, String status, ObjectId docId) {
        this.id = id;
        this.shownFor = shownFor;
        this.notes = notes;
        this.medicine = medicine;
        this.date = date;
        this.status = status;
        this.docId = docId;
    }
    
     public MedicalHistory() {
    }

    
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getShownFor() {
        return shownFor;
    }

    public void setShownFor(String shownFor) {
        this.shownFor = shownFor;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ObjectId getDocId() {
        return docId;
    }

    public void setDocId(ObjectId docId) {
        this.docId = docId;
    }
    
    
    
}
