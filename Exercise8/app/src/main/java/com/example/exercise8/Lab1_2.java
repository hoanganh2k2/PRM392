package com.example.exercise8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Lab1_2 extends AppCompatActivity {
    private TextView textViewId;
    private TextView textViewName;
    private TextView textViewDescription;
    private Button btnClickMe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lab12);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textViewId = findViewById(R.id.textViewDetailId);
        textViewName = findViewById(R.id.textViewDetailName);
        btnClickMe = findViewById(R.id.buttonClickMe);
        textViewDescription =
                findViewById(R.id.textViewDetailDescription);
        int id = getIntent().getIntExtra("id", -1);
        String name = getIntent().getStringExtra("name");
        String description =
                getIntent().getStringExtra("description");
        textViewId.setText(String.valueOf(id));
        textViewName.setText(name);
        textViewDescription.setText(description);

        btnClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lab1_2.this,Lab1.class);
                startActivity(intent);
            }
        });
    }
}