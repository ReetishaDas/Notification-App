package com.example.notification_590;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Notify(View v){
        int notifyID=100;
        String Channel_ID="my_ch_id";
        String Channel_Name="my_channel_name";
        int importance = NotificationManager.IMPORTANCE_HIGH;
        NotificationChannel notificationChannel = new NotificationChannel(Channel_ID,Channel_Name,importance);
        NotificationManager notificationManager =(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(notificationChannel);
        Intent intent = new Intent(this,MainActivity2.class);
        EditText date=findViewById(R.id.editTextTextPersonName);
        String billdate=date.getText().toString();
        intent.putExtra("billingdate",billdate);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,0);
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,Channel_ID);
        builder.setSmallIcon(R.drawable.a).setWhen(System.currentTimeMillis())
                .setOnlyAlertOnce(true);
        builder.setContentIntent(pendingIntent);
        builder.setContentTitle("NEW NOTIFICATION");
        builder.setContentText("**Payment Reminder** Tap for more info..");
        notificationManager.notify(notifyID,builder.build());
    }
}