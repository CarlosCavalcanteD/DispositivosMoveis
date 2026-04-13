package com.example.appduastelas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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

    public void handleEnviar(View view) {
        EditText nomeInput = findViewById(R.id.inputNome);
        EditText idadeInput = findViewById(R.id.inputIdade);

        String nome = nomeInput.getText().toString();
        String idade = idadeInput.getText().toString();

        Intent intent = new Intent(this, SegundaActivity.class);
        intent.putExtra("nome", nome);
        intent.putExtra("idade", idade);

        startActivity(intent);
    }
}