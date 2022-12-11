/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import enums.ROLES;
import java.util.ArrayList;
import java.util.List;
import model.ActiveUser;
import repository.*;
import model.User;
import org.bson.Document;

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
    
     public int updateUser(User user){
        int rowsUpdate= this.repository.updateUserInfo(user);
        return rowsUpdate;
        
    }
     
     public List<ROLES> getUniqueRoles(){
          return this.repository.getUniqueRoles();
     }
     
     
     public User findUserByUserName(String username){
        return this.repository.fetchUserByUserName(username);
     }
     
     public List<User> fetchUserByRoles(ROLES role){
         return this.repository.fetchUserByRoles(role);
     }
     
     public List<User> fetchAllRecords(){
         List<Document> documents= this.repository.fetchUser();
         List<User> users= new ArrayList<User>();
         for(Document doc: documents){
              User user = new User(doc.getString("name"), doc.getString("email"), ROLES.getRoles(doc.getString("role")), doc.getInteger("height"), doc.getInteger("weight"), doc.getString("phone"), doc.getString("username"), doc.getString("password"));
            user.setId(doc.getObjectId("_id"));
             users.add(user);
         }
         
         return users;
     }
}

