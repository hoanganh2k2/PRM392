package com.example.exercise5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Lab1_Login extends AppCompatActivity {
    public Button myButton;
    public EditText myUser;
    public EditText myPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lab1_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        myButton = findViewById(R.id.button);
        myUser = findViewById(R.id.editTextTextUsername);
        myPass = findViewById(R.id.editTextTextPassword);
    }
    public void onLogin(View view){
        if(myUser.getText().toString().equals("admin@gmail.com")&&
        myPass.getText().toString().equals("123456")){
            Toast.makeText(getApplicationContext(),"Login successfully",Toast.LENGTH_SHORT).show();
        }
        else Toast.makeText(getApplicationContext(),"Login failed",Toast.LENGTH_SHORT).show();
    }
}