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

public class CadastrarMercadoriaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastrar_mercadoria);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void handleCadastrarMercadoria(View view) {
        EditText nomeInput = findViewById(R.id.mercadoriaName);
        EditText pesoInput = findViewById(R.id.mercadoriaPeso);
        EditText idInput = findViewById(R.id.mercadoriaId);

        String nome = nomeInput.getText().toString();
        String pesoStr = pesoInput.getText().toString();
        String idStr = idInput.getText().toString();

        if (nome.isEmpty() || pesoStr.isEmpty() || idStr.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            return;
        }

        double peso = Double.parseDouble(pesoStr);
        int codigo = Integer.parseInt(idStr);

        Mercadoria mercadoria = new Mercadoria();
        mercadoria.setNome(nome);
        mercadoria.setPeso(peso);
        mercadoria.setCodigo(codigo);

        MercadoriaRepository.lista.add(mercadoria);

        Toast.makeText(this, "Mercadoria cadastrada!", Toast.LENGTH_SHORT).show();

        nomeInput.setText("");
        pesoInput.setText("");
        idInput.setText("");
    }

    public void handleReturnToMenu(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}