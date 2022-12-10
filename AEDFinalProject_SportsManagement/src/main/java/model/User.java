/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import enums.ROLES;
import java.util.Date;
/**
 *
 * @author priyankakhimyani
 */
public class User {
    
    private String name;
    private String email;
    private ROLES roles;
    private Integer height;
    private Integer weight;
    private String username;
    private String password;
    private String phoneNumber;
    
    public User() {
    }

    
    public User(String name, String email, ROLES roles, Integer height, Integer weight,String phoneNumber, String username, String password) {
        this.name = name;
        this.email = email;
        this.roles = roles;
        this.height = height;
        this.weight = weight;
        this.username = username;
        this.password = password;
        this.phoneNumber=phoneNumber;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ROLES getRoles() {
        return roles;
    }

    public void setRoles(ROLES roles) {
        this.roles = roles;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    
    
}
