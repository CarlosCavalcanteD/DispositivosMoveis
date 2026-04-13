package com.example.lista2_l1q3;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BuscarMidiaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_midia);
    }

    public void handleBuscar(View view) {
        EditText input = findViewById(R.id.inputBusca);
        TextView resultado = findViewById(R.id.resultado);

        String busca = input.getText().toString();

        for (Midia m : MidiaRepository.lista) {
            if (m.getTitulo().equalsIgnoreCase(busca)) {
                resultado.setText(m.exibirDetalhes());
                return;
            }
        }

        resultado.setText("Mídia não encontrada.");
    }
}