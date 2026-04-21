package com.example.lista3_exercicio2;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

public class MeuService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this, "Service iniciou", Toast.LENGTH_SHORT).show();
        String channelId = "canal";

        NotificationChannel channel = new NotificationChannel(
                channelId,
                "Canal Serviço",
                NotificationManager.IMPORTANCE_DEFAULT
        );

        NotificationManager manager = getSystemService(NotificationManager.class);
        manager.createNotificationChannel(channel);

        startForeground(1,
                new NotificationCompat.Builder(this, channelId)
                        .setContentTitle("Serviço Ativo")
                        .setContentText("Serviço em execução")
                        .setSmallIcon(android.R.drawable.ic_media_play)
                        .build()
        );

        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}