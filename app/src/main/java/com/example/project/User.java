package com.example.project;

import com.google.firebase.auth.FirebaseUser;


public class User {

    public String email;
    public String firstName;
    public String lastName;
    public String password;
    public String phoneNum;
    public String uID;
    public Boolean isActive = false;

    public User(String email, String firstName, String lastName, String password, String phoneNum) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phoneNum = phoneNum;
    }
    public User(){}

   public void setuID(String uID){
        this.uID = uID;
   }

   public String getuID(){
        return uID;
   }
    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
