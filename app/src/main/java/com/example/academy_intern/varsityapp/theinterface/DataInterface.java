package com.example.academy_intern.varsityapp.theinterface;

import com.example.academy_intern.varsityapp.classes.User;

public interface DataInterface {

    User login(String email, String password);
    public String addUser(User user);
}
