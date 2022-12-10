/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import enums.ROLES;
import java.util.List;
import model.ActiveUser;
import repository.*;
import model.User;

/**
 *
 * @author Shardul
 */
public class UserService {
    UserRepository repository;

    public UserService() {
        this.repository = new UserRepository();
    }
    
    
//    UserService(){
//        this.repository= new UserRepository();
//    }
    
    public boolean loginUser(String username, String password){
        User user= this.repository.fetchUserByNameAndPassword(username, password);
        ActiveUser.setActiveUser(user);
        return (user!=null);
    }
    
    public User insertUser(User user){
        return this.repository.createUser(user);
        
    }
    
     public User updateUser(User user){
        int rowsUpdate= this.repository.updateUserInfo(user);
        if(rowsUpdate < 1){
            return null;
        }
        return user;
        
    }
     
     public List<ROLES> getUniqueRoles(){
          return this.repository.getUniqueRoles();
     }
}

