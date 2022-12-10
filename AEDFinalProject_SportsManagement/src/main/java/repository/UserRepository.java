/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import com.mongodb.client.model.Filters;
import database.CRUDDatabase;
import database.DataBaseConnection;
import enums.ROLES;
import model.User;
import org.bson.Document;
/**
 *
 * @author Shardul
 */
public class UserRepository {
    
    private MongoDatabase connection= DataBaseConnection.connectToDatabase().database;;
    
    private CRUDDatabase crud=new CRUDDatabase();;
    private final String SCHEMANAME="users";
    private final static String userField="username";
    private final static  String passwordField= "password";
    
    
    
    public User fetchUserByNameAndPassword(String username, String password){
        
        MongoCollection<Document> document= this.crud.getCollection(SCHEMANAME);
        if(document==null){
            return null;
        }
        Document doc=document.find(Filters.and(Filters.eq(userField,username), Filters.eq(passwordField,password))).first();
        if(doc!=null){
            return new User(doc.getString("name"), doc.getString("email"),ROLES.getRoles(doc.getString("role")), doc.getInteger("height"),doc.getInteger("weight"),doc.getString("phone"), username, password);
        }
        return null;
    }
    
    public User fetchUserByUserName(String username){
        
        MongoCollection<Document> document= this.crud.getCollection(SCHEMANAME);
        if(document==null){
            return null;
        }
        Document doc=document.find(Filters.and(Filters.eq(userField,username))).first();
        if(doc!=null){
            return new User(doc.getString("name"), doc.getString("email"),ROLES.getRoles(doc.getString("role")), doc.getInteger("height"),doc.getInteger("weight"),doc.getString("phone"), username, doc.getString("password"));
        }
        return null;
    }
    
    
    public User createUser(User user){
        
        Document doc= new Document();
        doc.append("name", user.getName());
        doc.append("email",user.getEmail());
        doc.append("phone", user.getPhoneNumber());
        doc.append("height", user.getHeight());
        doc.append("weight", user.getWeight());
        doc.append("username", user.getUsername());
        doc.append("password", user.getPassword());
        doc.append("role", user.getRoles());
        this.crud.insertDocument(doc, SCHEMANAME);
        return user;
    }
    
    public User updateUserInfo(User user){
        Document doc= new Document();
        doc.append("name", user.getName());
        doc.append("email",user.getEmail());
        doc.append("phone", user.getPhoneNumber());
        doc.append("height", user.getHeight());
        doc.append("weight", user.getWeight());
        doc.append("username", user.getUsername());
        doc.append("password", user.getPassword());
        doc.append("role", user.getRoles());
        this.crud.insertDocument(doc, SCHEMANAME);
        return user;
    }
}
