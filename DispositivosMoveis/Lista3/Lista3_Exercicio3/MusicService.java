package com.example.lista3_exercicio3;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.core.app.NotificationCompat;

public class MusicService extends Service {

    private MediaPlayer player;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        player = MediaPlayer.create(this, R.raw.risada_atumalaca);
        player.start();


        String channelId = "canal";

        NotificationChannel channel = new NotificationChannel(
                channelId,
                "Canal Música",
                NotificationManager.IMPORTANCE_DEFAULT
        );

        NotificationManager manager = getSystemService(NotificationManager.class);
        manager.createNotificationChannel(channel);

        startForeground(2,
                new NotificationCompat.Builder(this, channelId)
                        .setContentTitle("Tocando música")
                        .setSmallIcon(android.R.drawable.ic_media_play)
                        .build()
        );

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (player != null) {
            player.stop();
            player.release();
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}