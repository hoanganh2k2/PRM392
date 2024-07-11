package com.example.trial;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trial.adapters.AdapterTodo;
import com.example.trial.data.ApiService;
import com.example.trial.models.Todo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_apiactivity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //permission
        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this, "Permission already granted",
                    Toast.LENGTH_SHORT).show();
        }else{
            requestPermissionLauncher.launch(Manifest.permission.INTERNET);
        }

        // Tải dữ liệu từ API
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<Todo>> call = apiService.getTodos();
        call.enqueue(new Callback<List<Todo>>() {
            @Override
            public void onResponse(Call<List<Todo>> call, Response<List<Todo>> response) {
                List<Todo> todos = response.body();
                adapter = new AdapterTodo(todos);
                recyclerView.setAdapter(adapter);
            }
            @Override
            public void onFailure(Call<List<Todo>> call, Throwable t) {
            }
        });
    }
    private final ActivityResultLauncher<String>
            requestPermissionLauncher =
            registerForActivityResult(new
                    ActivityResultContracts.RequestPermission(), isGranted -> {
                if (isGranted) {
                    Toast.makeText(APIActivity.this, "Permission granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(APIActivity.this, "Permission denied", Toast.LENGTH_SHORT).show();
                }
            });
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