package com.example.academy_intern.varsityapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.academy_intern.varsityapp.classes.User;
import com.example.academy_intern.varsityapp.implementation.DataSource;

import org.w3c.dom.Text;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        TextView txtName,txtOnline;

        String name = (String)getIntent().getSerializableExtra("userName");
        String surname = (String)getIntent().getSerializableExtra("userSurname");
        txtOnline = (TextView)findViewById(R.id.txtOnline);

        String output = "Welcome "+name+" "+surname;

        txtOnline.setText(output);

    }

    public void searchUser(View view){



        DataSource ds = new DataSource();
        SearchView srcView = (SearchView)findViewById(R.id.srcView);
        TextView txtOutput;
        txtOutput = (TextView)findViewById(R.id.txtOutput);

        Toast.makeText(this,"cliked",Toast.LENGTH_LONG).show();

        String email = srcView.getQuery().toString();

        String user = ds.getUser(email);

        txtOutput.setText(user);




    }
}
