package com.example.lista2_l1q3;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CadastrarMidiaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_midia);
    }

    public void handleCadastrar(View view) {

        EditText tipoInput = findViewById(R.id.tipo);
        EditText tituloInput = findViewById(R.id.titulo);
        EditText anoInput = findViewById(R.id.ano);

        String tipo = tipoInput.getText().toString();
        String titulo = tituloInput.getText().toString();
        int ano = Integer.parseInt(anoInput.getText().toString());

        if (tipo.equals("1")) {
            EditText artistaInput = findViewById(R.id.extra1);
            EditText albumInput = findViewById(R.id.extra2);

            MidiaRepository.lista.add(
                    new Musica(titulo, ano,
                            artistaInput.getText().toString(),
                            albumInput.getText().toString())
            );

        } else if (tipo.equals("2")) {
            EditText diretorInput = findViewById(R.id.extra1);
            EditText duracaoInput = findViewById(R.id.extra2);

            MidiaRepository.lista.add(
                    new Video(titulo, ano,
                            diretorInput.getText().toString(),
                            Integer.parseInt(duracaoInput.getText().toString()))
            );

        } else if (tipo.equals("3")) {
            EditText anfitriaoInput = findViewById(R.id.extra1);
            EditText episodioInput = findViewById(R.id.extra2);

            MidiaRepository.lista.add(
                    new Podcast(titulo, ano,
                            anfitriaoInput.getText().toString(),
                            Integer.parseInt(episodioInput.getText().toString()))
            );
        }

        Toast.makeText(this, "Mídia cadastrada!", Toast.LENGTH_SHORT).show();
    }
}