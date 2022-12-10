/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Shardul
 */
public class ActiveUser {
    
    private static User user;
        
    public static void setActiveUser(User user){
        ActiveUser.user=user;
    }
    
    public static User getActiveUser(){
        return user;
    }
    
    
    
}
