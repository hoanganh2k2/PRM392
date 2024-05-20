package com.example.exercise5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Lab2_Calculator extends AppCompatActivity {
    public EditText num1;
    public EditText num2;
    public Button add;
    public Button sub;
    public Button mol;
    public Button div;
    public TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lab2_calculator);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mol = findViewById(R.id.mol);
        div = findViewById(R.id.div);
        result = findViewById(R.id.result);
    }
    public void onAdd(View view){
        int number1 = Integer.parseInt(num1.getText().toString());
        int number2 = Integer.parseInt(num2.getText().toString());
        int rs = number1+number2;
        result.setText("Result: " + rs);
    }
    public void onSub(View view){
        int number1 = Integer.parseInt(num1.getText().toString());
        int number2 = Integer.parseInt(num2.getText().toString());
        int rs = number1-number2;
        result.setText("Result: " + rs);
    }
    public void onMol(View view){
        int number1 = Integer.parseInt(num1.getText().toString());
        int number2 = Integer.parseInt(num2.getText().toString());
        int rs = number1*number2;
        result.setText("Result: " + rs);
    }
    public void onDiv(View view){
        int number1 = Integer.parseInt(num1.getText().toString());
        int number2 = Integer.parseInt(num2.getText().toString());
        int rs = number1/number2;
        result.setText("Result: " + rs);
    }
}