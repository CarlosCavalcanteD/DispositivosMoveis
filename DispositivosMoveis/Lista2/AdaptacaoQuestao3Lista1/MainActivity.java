package com.example.lista2_l1q3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void handleCadastrar(View view) {
        startActivity(new Intent(this, CadastrarMidiaActivity.class));
    }

    public void handleListar(View view) {
        startActivity(new Intent(this, ListarMidiaActivity.class));
    }

    public void handleBuscar(View view) {
        startActivity(new Intent(this, BuscarMidiaActivity.class));
    }

    public void handleReproduzir(View view) {
        startActivity(new Intent(this, ReproduzirMidiaActivity.class));
    }

}