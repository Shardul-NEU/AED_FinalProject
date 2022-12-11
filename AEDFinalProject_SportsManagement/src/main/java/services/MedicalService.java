/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
import java.util.Date;
import model.Medical;
import org.bson.types.ObjectId;
import repository.MedicalRepository;

/**
 *
 * @author Shardul
 */
public class MedicalService {
    
    private MedicalRepository medicalRepository= new MedicalRepository();
    
    public Medical createAppointment(Medical medicalModel){
        
        long count=this.medicalRepository.insertAppointments(medicalModel);
        if(count < 1) return null;
        return medicalModel;
    }
    
    
    public boolean isDuplicateAppointment(ObjectId personId,ObjectId doctorId, Date requestDate){
        return this.medicalRepository.isDuplicateAppointment(personId, doctorId, requestDate);
     
    }
    
}
