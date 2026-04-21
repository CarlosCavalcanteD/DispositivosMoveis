package com.example.lista3_exercicio1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.IntentFilter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private TextView resultado;
    private BluetoothReceiver bluetoothReceiver;
    private AirplaneReceiver airplaneReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        resultado = findViewById(R.id.resultado);

        bluetoothReceiver = new BluetoothReceiver(resultado);
        airplaneReceiver = new AirplaneReceiver(resultado);

        registerReceiver(bluetoothReceiver,
                new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED));

        registerReceiver(airplaneReceiver,
                new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(bluetoothReceiver);
        unregisterReceiver(airplaneReceiver);
    }
}