package com.example.lista3_exercicio1;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

public class BluetoothReceiver extends BroadcastReceiver {

    private TextView resultado;

    public BluetoothReceiver(TextView resultado) {
        this.resultado = resultado;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, -1);

        if (state == BluetoothAdapter.STATE_ON) {
            resultado.setText("Bluetooth Ativado");
        } else if (state == BluetoothAdapter.STATE_OFF) {
            resultado.setText("Bluetooth Desativado");
        }
    }
}