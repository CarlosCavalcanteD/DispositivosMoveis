package com.example.lista2_l1q3;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ReproduzirMidiaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproduzir_midia);
    }

    public void handleReproduzir(View view) {
        EditText input = findViewById(R.id.inputBusca);
        String titulo = input.getText().toString();

        for (Midia m : MidiaRepository.lista) {
            if (m.getTitulo().equalsIgnoreCase(titulo)) {
                Toast.makeText(this, m.reproduzir(), Toast.LENGTH_LONG).show();
                return;
            }
        }

        Toast.makeText(this, "Mídia não encontrada.", Toast.LENGTH_SHORT).show();
    }
}