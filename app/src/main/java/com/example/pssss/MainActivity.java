package com.example.pssss;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import static com.example.zalypa.RemoteDatabaseAuthentication.authenticateUser;

import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);

        EditText editTextUsername = findViewById(R.id.editTextUsername);
        EditText editTextPassword = findViewById(R.id.editTextPassword);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = editTextPassword.getText().toString();
                String username = editTextUsername.getText().toString();
                boolean isAuthenticated = authenticateUser(username, password);

                if (isAuthenticated) {
                    button.setText("Я молодец");
                } else {
                    button.setText("Я тоже молодец");
                }


            }
        });




    }

}
