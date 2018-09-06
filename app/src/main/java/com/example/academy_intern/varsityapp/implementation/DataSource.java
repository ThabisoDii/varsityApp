package com.example.academy_intern.varsityapp.implementation;

import android.text.TextUtils;
import android.util.Patterns;

import com.example.academy_intern.varsityapp.classes.User;
import com.example.academy_intern.varsityapp.theinterface.DataInterface;

import java.util.ArrayList;

public class DataSource implements DataInterface{

    static ArrayList<User> listUsers = new ArrayList<>();



    public String addUser(User aUser){
        String message = "";

        if(aUser == null){
            message = "Unsuccesful";
        }else{

            boolean isRegistered = listUsers.add(aUser);////done
            if(isRegistered){
                message = "Registered";

            }

        }

        return message;
    }

    public User login(String email,String password){

        User user = null;

        for(int x = 0;x < listUsers.size();x++){

            String validEmail = listUsers.get(x).getEmail();
            String validPassword = listUsers.get(x).getPassword();

            if(validEmail.equalsIgnoreCase(email) && validPassword.equals(password)){
                user = listUsers.get(x);
                break;
            }
        }
    return user;
    }

    public String getUser(String email){
    User user = null;
    String output = "";
        for(int x = 0;x < listUsers.size();x++){

            String validEmail = listUsers.get(x).getEmail();

            if(validEmail.equalsIgnoreCase(email)){
                user = listUsers.get(x);
                break;
            }
        }
     output = "Name :"+user.getName()+"\nSurname"+user.getSurname();


        return output;

    }

    public static boolean validateEmail(String email){
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }





}
