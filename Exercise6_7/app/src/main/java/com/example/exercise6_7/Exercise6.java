package com.example.exercise6_7;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Exercise6 extends AppCompatActivity {

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Exercise6", "State: Started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Exercise6", "State: Resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Exercise6", "State: Pauseed");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.i("Exercise6", "State: Stoped");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Exercise6", "State: Destroyed");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exercise6);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Log.i("Exercise6", "State: Created");
    }
}