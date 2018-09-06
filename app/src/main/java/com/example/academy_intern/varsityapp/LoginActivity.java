package com.example.academy_intern.varsityapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.academy_intern.varsityapp.implementation.DataSource;
import com.example.academy_intern.varsityapp.classes.User;

public class LoginActivity extends AppCompatActivity {

    EditText etEmailLogin,etPasswordLogin;
    DataSource ds = new DataSource();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void verifyUser(View view){

        String email = (etEmailLogin = (EditText)findViewById(R.id.etEmailLogin)).getText().toString();

        if(TextUtils.isEmpty(email)){
            etEmailLogin.setError("Field cannot be empty");
        }
        String password = (etPasswordLogin = (EditText)findViewById(R.id.etPasswordLogin)).getText().toString();
        if(TextUtils.isEmpty(password)){
            etPasswordLogin.setError("Field cannot be empty");
        }





        User user = ds.login(email,password);// move this class to the next acitvity

        if(user != null){
            Toast.makeText(this,"logged in",Toast.LENGTH_LONG).show();
            Intent move = new Intent(LoginActivity.this,UserActivity.class);
            move.putExtra("userSurname",user.getSurname());
            move.putExtra("userName",user.getName());
            startActivity(move);

        }
        else{
            Toast.makeText(this,"not logged in",Toast.LENGTH_SHORT).show();
        }

    }
}
