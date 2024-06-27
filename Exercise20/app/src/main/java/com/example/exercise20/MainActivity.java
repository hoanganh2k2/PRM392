package com.example.exercise20;


import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.bluetooth.BluetoothAdapter;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MainActivity extends AppCompatActivity {
    private WifiReceiver wifiReceiver = new WifiReceiver();
    private BlueToothReceiver bluetoothReceiver = new
            BlueToothReceiver();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        try {
            // Register the receiver
            IntentFilter filter1 = new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION);
            registerReceiver(wifiReceiver, filter1);
            Log.d(TAG, "Wifi - Receiver registered successfully");
        } catch (Exception e) {
            Log.e(TAG, "Wifi - Failed to register receiver", e);
        }
        //Check Bluetooth
        try {
            // Register the receiver
            IntentFilter filter2 = new
                    IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
            registerReceiver(bluetoothReceiver, filter2);
            Log.d(TAG, "Bluetooth - Receiver registered successfully");
        } catch (Exception e) {
            Log.e(TAG, "Bluetooth - Failed to register receiver",
                    e);
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        //Wifi
        if (wifiReceiver != null) {
            unregisterReceiver(wifiReceiver);
        }
        //Bluetooth
        if (bluetoothReceiver != null) {
            unregisterReceiver(bluetoothReceiver);
        }
    }
}