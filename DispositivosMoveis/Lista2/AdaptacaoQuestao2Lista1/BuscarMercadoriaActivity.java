package com.example.lista2_l1q2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class BuscarMercadoriaActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_buscar_mercadoria);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void handleBuscarMercadoria(View view) {

        if(MercadoriaRepository.lista.isEmpty()) {
            Toast.makeText(BuscarMercadoriaActivity.this, "Não há mercadorias registradas!", Toast.LENGTH_SHORT).show();
            return;
        }

        EditText mercadoriaNameSearchText = findViewById(R.id.mercadoriaNameSearchText);
        String mercadoriaName = mercadoriaNameSearchText.getText().toString();

        for (Mercadoria m : MercadoriaRepository.lista) {
            if (m.getNome().equalsIgnoreCase(mercadoriaName)) {
                EditText mercadoriaPesoPlainText = findViewById(R.id.mercadoriaPesoFound);
                EditText mercadoriaIdPlainText = findViewById(R.id.mercadoriaIdFound);

                mercadoriaIdPlainText.setText(String.valueOf(m.getCodigo()));
                mercadoriaPesoPlainText.setText(String.valueOf(m.getPeso()));
                mercadoriaIdPlainText.setText(m.getNome());
                return;
            }
        }
    }
    public void handleReturnToMenu(View view) {
        Intent mainScreen = new Intent(this, MainActivity.class);
        startActivity(mainScreen);
        finish();
    }
}