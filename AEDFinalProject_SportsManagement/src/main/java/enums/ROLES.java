/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

/**
 *
 * @author priyankakhimyani
 */
public enum ROLES {
    PLAYER("player"),
    COACH("coach"),
    DOCTOR("doctor"),
    /**
     *
     */
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
            case "player": return ROLES.PLAYER;
            default:
                return null;
        }

    }
    
       
    @Override
    public String toString(){
        return this.name;
    }
}
