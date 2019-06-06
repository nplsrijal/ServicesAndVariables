package com.e.servicesandvariables;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn1,btn2;
   NotificationManagerCompat notificationManagerCompat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        notificationManagerCompat=NotificationManagerCompat.from(this);
        
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayFirstNotification();
            }
        });
        
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplaySecondNotification();
            }
        });

    }

    private void DisplaySecondNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this,"Channel2")
                .setSmallIcon(R.drawable.ic_notifications_black_24dp)
                .setContentTitle("First Message")
                .setContentText("This is first")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE);
        notificationManagerCompat.notify(2,builder.build());
    }

    private void DisplayFirstNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this,"Channel1")
                .setSmallIcon(R.drawable.ic_notifications_black_24dp)
                .setContentTitle("First Message")
                .setContentText("This is first")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE);
        notificationManagerCompat.notify(1,builder.build());


    }



}
