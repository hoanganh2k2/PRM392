package com.example.trial;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trial.adapters.AdapterStudent;
import com.example.trial.data.DBHandler;
import com.example.trial.models.Student;

import java.util.List;

public class SQLiteActivity extends AppCompatActivity {
    private EditText inputId, inputName, inputEmail;
    private Button buttonAdd;
    private DBHandler dbHandler;
    private AdapterStudent adapterStudent;
    private List<Student> studentList;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sqlite);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        inputId = findViewById(R.id.IdET);
        inputName = findViewById(R.id.NameET);
        inputEmail = findViewById(R.id.EmailET);
        buttonAdd = findViewById(R.id.AddBtn);
        dbHandler = new DBHandler(this);
        studentList = dbHandler.getAllStudents();
        recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapterStudent = new AdapterStudent(studentList);
        // Set the Adapter to RecyclerView
        recyclerView.setAdapter(adapterStudent);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get input data
                String id = inputId.getText().toString();
                String name = inputName.getText().toString();
                String email = inputEmail.getText().toString();
                //Validate
                if(id.isEmpty()){
                    Toast.makeText(SQLiteActivity.this, "Id is required",
                            Toast.LENGTH_SHORT).show();
                }else if(name.isEmpty()){
                    Toast.makeText(SQLiteActivity.this, "Name is required",
                            Toast.LENGTH_SHORT).show();
                }else if(email.isEmpty()){
                    Toast.makeText(SQLiteActivity.this, "Email is required",
                            Toast.LENGTH_SHORT).show();
                }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    Toast.makeText(SQLiteActivity.this, "Email is invalid",
                            Toast.LENGTH_SHORT).show();
                }else if (dbHandler.getStudent(id) != null){
                    Toast.makeText(SQLiteActivity.this, "Id already exists",
                            Toast.LENGTH_SHORT).show();
                }else if(dbHandler.getStudentByEmail(email) != null){
                    Toast.makeText(SQLiteActivity.this, "Email already exists",
                            Toast.LENGTH_SHORT).show();
                }else{
                    // Add data
                    Student student = new Student(id, name, email);
                    dbHandler.addStudent(student);

                    inputId.setText("");
                    inputName.setText("");
                    inputEmail.setText("");

                    recreate();
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId() == R.id.SQLite) {
            Toast.makeText(this, "SQLite clicked",
                    Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, SQLiteActivity.class);
            startActivity(intent);
            return true;
        }
        else if (item.getItemId() == R.id.API)
        {
            Toast.makeText(this, "API clicked",
                    Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, APIActivity.class);
            startActivity(intent);
            return true;
        }
        else
            return super.onOptionsItemSelected(item);
    }
}