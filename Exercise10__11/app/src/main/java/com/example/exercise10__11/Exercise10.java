package com.example.exercise10__11;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Exercise10 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exercise10);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        if(ContextCompat.checkSelfPermission
                (this, Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Permission already granted", Toast.LENGTH_SHORT).show();
        }else{
            requestPermissionLauncher.launch(android.Manifest.permission.READ_CONTACTS);
        }
    }

    private final ActivityResultLauncher<String>
            requestPermissionLauncher = registerForActivityResult( new
            ActivityResultContracts.RequestPermission(), isGranted -> {
        if (isGranted) {
            // Permission is granted. You can perform there lasted task
            Toast.makeText(Exercise10.this, "Permission granted", Toast.LENGTH_SHORT).show();
        } else {
            // Permission is denied. Show a message to the user
            Toast.makeText(Exercise10.this, "Permission denied", Toast.LENGTH_SHORT).show();
        }
    });
}
