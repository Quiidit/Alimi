package com.example.mypush;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap mLargeIconForNoti = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background);
                PendingIntent mPendingIntent = PendingIntent.getActivities(MainActivity.this, 0,
                        new Intent[]{new Intent(getApplicationContext(), MainActivity.class)},
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
                NotificationCompat.Builder mBuilder =
                        new NotificationCompat.Builder(MainActivity.this)
                                .setSmallIcon(R.drawable.ic_launcher_background)
                                .setContentTitle("Alimi")
                                .setContentText("100m 거리 이내에 사야할 것이 있습니다!")
                                .setDefaults(Notification.DEFAULT_VIBRATE)
                                .setLargeIcon(mLargeIconForNoti)
                                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                                .setAutoCancel(true)
                                .setContentIntent(mPendingIntent);

                NotificationManager mNotificationManger =
                        (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                mNotificationManger.notify(0,mBuilder.build());

            }
        });
    }
}