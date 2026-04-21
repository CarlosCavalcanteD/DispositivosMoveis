package com.example.lista3_exercicio1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

public class AirplaneReceiver extends BroadcastReceiver {

    private TextView resultado;

    public AirplaneReceiver(TextView resultado) {
        this.resultado = resultado;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        boolean ligado = intent.getBooleanExtra("state", false);

        if (ligado) {
            resultado.setText("Modo Avião Ativado");
        } else {
            resultado.setText("Modo Avião Desativado");
        }
    }
}