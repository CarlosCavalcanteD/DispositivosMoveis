package com.example.lista2_ciclodevida;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        System.out.println("onCreate() chamado");

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("onStart() chamado");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("onResume() chamado");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("onPause() chamado");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("onStop() chamado");
    }
}