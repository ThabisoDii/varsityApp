package com.example.academy_intern.varsityapp.classes;

public class User extends Person{

    private String email;
    private String password;


    public User(){

    }

    public User(String name,String surname,String email,String password){
        super(name,surname);
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
