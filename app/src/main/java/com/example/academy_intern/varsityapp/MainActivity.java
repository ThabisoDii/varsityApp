package com.example.academy_intern.varsityapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.academy_intern.varsityapp.implementation.DataSource;
import com.example.academy_intern.varsityapp.classes.User;

public class MainActivity extends AppCompatActivity {

    EditText etName,etSurname,etEmail,etPassword,etConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Welcome to varisty");

    }

    public void register(View view){
        DataSource ds = new DataSource();
        String message = "";

        String name = (etName = (EditText)findViewById(R.id.etName)).getText().toString();
        if(name.matches("")){
            etName.setError("Field cannot be empty");
        }

        String surname = (etSurname = (EditText)findViewById(R.id.etSurname)).getText().toString();
        if(name.matches("")){
            etSurname.setError("Field cannot be empty");
        }

        String email = (etEmail = (EditText)findViewById(R.id.etEmail)).getText().toString();
        if(name.matches("")){
            etEmail.setError("Field cannot be empty");
        }

        boolean isvalidEmail = DataSource.validateEmail(email);



        String password = (etPassword = (EditText)findViewById(R.id.etPassword)).getText().toString();
        if(name.matches("")){
            etPassword.setError("Field cannot be empty");
        }

        String passwordConfirm = (etConfirmPassword = (EditText)findViewById(R.id.etConfirmPassword)).getText().toString();
        if(name.matches("")){
            etConfirmPassword.setError("Field cannot be empty");
        }

        if(!passwordConfirm.equals(password)){
            Toast.makeText(this,"Passwords don't match",Toast.LENGTH_LONG).show();
            User user = null;
            message = ds.addUser(user);
        }else if(name.matches("") || surname.matches("") || email.matches("") || password.matches("")){
            User user = null;
            message = ds.addUser(user);
        }else if(isvalidEmail == false){
            User user = null;
            message = ds.addUser(user);
                Toast.makeText(this,"Email format incorrect",Toast.LENGTH_LONG).show();
        }
        else{
            User user = new User(name,surname,email,password);
            message = ds.addUser(user);
        }


        Toast.makeText(this,message,Toast.LENGTH_LONG).show();


    }

    public void login(View view){
        //Toast.makeText(this,"mmmmm",Toast.LENGTH_LONG).show();
        Intent move = new Intent(MainActivity.this,LoginActivity.class);
        startActivity(move);
    }
}
