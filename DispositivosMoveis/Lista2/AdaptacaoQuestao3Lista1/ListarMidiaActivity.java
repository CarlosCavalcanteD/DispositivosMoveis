package com.example.lista2_l1q3;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ListarMidiaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_midia);

        TextView resultado = findViewById(R.id.resultado);

        if (MidiaRepository.lista.isEmpty()) {
            resultado.setText("Nenhuma mídia cadastrada.");
            return;
        }

        StringBuilder sb = new StringBuilder();

        for (Midia m : MidiaRepository.lista) {
            sb.append(m.exibirDetalhes()).append("\n\n");
        }

        resultado.setText(sb.toString());
    }
}