package com.example.project;

import com.google.firebase.auth.FirebaseUser;


public class User {

    private FirebaseUser email;

    private FirebaseUser firstName;
    private FirebaseUser lastName;
    private FirebaseUser password;


    public User(){

    }

    public User(FirebaseUser email, FirebaseUser firstName, FirebaseUser lastName, FirebaseUser password){
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }



    public FirebaseUser getEmail() {
        return email;
    }

    public void setEmail(FirebaseUser email) {
        this.email = email;
    }

    public FirebaseUser getFirstName() {
        return firstName;
    }

    public void setFirstName(FirebaseUser firstName) {
        this.firstName = firstName;
    }

    public FirebaseUser getLastName() {
        return lastName;
    }

    public void setLastName(FirebaseUser lastName) {
        this.lastName = lastName;
    }


    public FirebaseUser getPassword() {
        return password;
    }

    public void setPassword(FirebaseUser password) {
        this.password = password;
    }
}
