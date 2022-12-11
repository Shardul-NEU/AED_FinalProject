/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import com.mongodb.MongoException;
import com.mongodb.client.DistinctIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import database.CRUDDatabase;
import database.DataBaseConnection;
import enums.ROLES;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.User;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author Shardul
 */
public class UserRepository {

    private MongoDatabase connection = DataBaseConnection.connectToDatabase().database;
    ;
    
    private CRUDDatabase crud = new CRUDDatabase();
    ;
    private final String SCHEMANAME = "users";
    private final static String userField = "username";
    private final static String passwordField = "password";

    public User fetchUserByNameAndPassword(String username, String password) {

        MongoCollection<Document> document = this.crud.getCollection(SCHEMANAME);
        if (document == null) {
            return null;
        }
        Document doc = document.find(Filters.and(Filters.eq(userField, username), Filters.eq(passwordField, password))).first();
        if (doc != null) {
            User user = new User(doc.getString("name"), doc.getString("email"), ROLES.getRoles(doc.getString("role")), doc.getInteger("height"), doc.getInteger("weight"), doc.getString("phone"), username, password);
            user.setId(doc.getObjectId("_id"));
            return user;
        }
        return null;
    }
    
    public List<Document> fetchUser(){
        MongoCollection<Document> document=this.crud.getCollection(SCHEMANAME);
        FindIterable<Document> iterDoc=document.find();
        Iterator<Document> itr= iterDoc.iterator();
        List<Document> documents= new ArrayList<Document>();
        while(itr.hasNext()){
            documents.add(itr.next());
        }
        return documents;
    } 
    
    
    public User fetchUserByUserName(String username) {

        MongoCollection<Document> document = this.crud.getCollection(SCHEMANAME);
        if (document == null) {
            return null;
        }
        Document doc = document.find(Filters.and(Filters.eq(userField, username))).first();
        if (doc != null) {
            User user = new User(doc.getString("name"), doc.getString("email"), ROLES.getRoles(doc.getString("role")), doc.getInteger("height"), doc.getInteger("weight"), doc.getString("phone"), username, doc.getString("password"));
            user.setId(doc.getObjectId("_id"));
            return user;
        }
        return null;
    }

    public User createUser(User user) {

        Document doc = new Document();
        doc.append("name", user.getName());
        doc.append("email", user.getEmail());
        doc.append("phone", user.getPhoneNumber());
        doc.append("height", user.getHeight());
        doc.append("weight", user.getWeight());
        doc.append("username", user.getUsername());
        doc.append("password", user.getPassword());
        doc.append("role", user.getRoles().toString());
        this.crud.insertDocument(doc, SCHEMANAME);
        return user;
    }

    public int updateUserInfo(User user) {
        Document doc = new Document();

        User exisitingUser = this.fetchUserByUserName(user.getUsername());
        if (user.getName() == null) {
            user.setName(exisitingUser.getName());
        }
        if (user.getEmail() == null) {
            user.setEmail(exisitingUser.getEmail());
        }
        if (user.getWeight() == null) {
            user.setWeight(exisitingUser.getWeight());
        }
        if (user.getHeight() == null) {
            user.setHeight(exisitingUser.getHeight());
        }
        if (user.getPhoneNumber() == null) {
            user.setPhoneNumber(exisitingUser.getPhoneNumber());
        }
        if (user.getUsername() == null) {
            user.setUsername(exisitingUser.getUsername());
        }
        if (user.getPassword() == null) {
            user.setPassword(exisitingUser.getPassword());
        }
        if (user.getRoles() == null) {
            user.setRoles(exisitingUser.getRoles());
        }

        Document query = new Document().append("_id", exisitingUser.getId());
        Bson updates = Updates.combine(
                Updates.set("name", user.getName()),
                Updates.set("email", user.getEmail()),
                Updates.set("phone", user.getPhoneNumber()),
                Updates.set("height", user.getHeight()),
                Updates.set("weight", user.getWeight()),
                Updates.set("username", user.getUsername()),
                Updates.set("password", user.getPassword()),
                Updates.set("role", user.getRoles().toString()));

        UpdateOptions options = new UpdateOptions().upsert(false);
        UpdateResult result = null;
        try {
            result = this.crud.getCollection(SCHEMANAME).updateOne(query, updates, options);
        } catch (MongoException me) {
            me.printStackTrace();
            System.err.println("Unable to update due to an error: " + me);
        }

        if (result != null) {
            return (int) result.getModifiedCount();
        }
        return -1;
    }

    public List<User> fetchUserByRoles(ROLES role) {

        List<User> userList = new ArrayList<User>();
        try {
            MongoCollection<Document> document = this.crud.getCollection(SCHEMANAME);
            if (document == null) {
                return null;
            }

            FindIterable<Document> results = document.find(Filters.and(Filters.eq("role", role.toString())));
            MongoCursor<Document> iteror = results.iterator();
            while (iteror.hasNext()) {
                Document doc = iteror.next();
                User user = new User(doc.getString("name"), doc.getString("email"), ROLES.getRoles(doc.getString("role")), doc.getInteger("height"), doc.getInteger("weight"), doc.getString("phone"), doc.getString("username"), doc.getString("password"));
                user.setId(doc.getObjectId("_id"));
                userList.add(user);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return userList;

    }

    public List<ROLES> getUniqueRoles() {

        List<ROLES> rolesList = new ArrayList<ROLES>();
        try {
            MongoCollection<Document> document = this.crud.getCollection(SCHEMANAME);
            DistinctIterable<String> iter = document.distinct("role", String.class);
            MongoCursor<String> results = iter.iterator();
            while (results.hasNext()) {
                ROLES rol = ROLES.getRoles(results.next());
                rolesList.add(rol);
            }
        } catch (MongoException me) {
            System.err.println("An error occurred: " + me);
        }
        return rolesList;
    }
    
    
}
