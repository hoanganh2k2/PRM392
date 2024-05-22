package com.example.exercise6_7;

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

public class Exercise7_acc2 extends AppCompatActivity {
    public TextView tvShow;
    public Button btnClickMe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exercise7_acc2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tvShow = (TextView) findViewById(R.id.tvShow);
        btnClickMe = (Button) findViewById(R.id.buttonClickMe);
        if (getIntent()!=null) {
            String data = getIntent().getStringExtra("MESSAGE");
            tvShow.setText("Hello " + data);
        }
        btnClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Exercise7_acc2.this,Exercise7.class);
                startActivity((intent));
            }
        });
    }
}