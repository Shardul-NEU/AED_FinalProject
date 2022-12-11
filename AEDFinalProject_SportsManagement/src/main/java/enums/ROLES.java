/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

/**
 *
 * @author Shardul
 */
public enum ROLES {
    IHPLAYER("ihplayer"),
    COACH("coach"),
    DOCTOR("doctor"),
    BBPLAYER("bbplayer"),
    VENUEADMIN("venueadmin"),
    SYSADMIN("systemAdmin"),
    PHARMACY("pharmacyadmin"),
    IVTADMIN("ivtadmin"),
    TEAMMANAGER("teammanager");
    private String name;
    ROLES(String name){
        this.name=name;
    }
    
    public static ROLES getRoles(String s){
        if(s==null) return null;
        switch(s.toLowerCase()){
            case "coach": return ROLES.COACH;
            case "teammanager": return ROLES.TEAMMANAGER;
            case "doctor": return ROLES.DOCTOR;
            case "bbplayer": return ROLES.BBPLAYER;
            case "venueadmin": return ROLES.VENUEADMIN;
            case "systemadmin":return ROLES.SYSADMIN;
            case "pharmacyadmin": return ROLES.PHARMACY;
            case "ivtadmin": return ROLES.IVTADMIN;
            case "ihplayer": return ROLES.IHPLAYER;
            
            default:
                return null;
        }

    }
    
       
    @Override
    public String toString(){
        return this.name;
    }
}
