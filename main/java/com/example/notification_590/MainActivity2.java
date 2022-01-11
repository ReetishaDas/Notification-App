package com.example.notification_590;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
TextView display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        NotificationManager notificationManager =(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancel(100);
        display=findViewById(R.id.textView4);
        Intent intent=getIntent();
        String Bdate= intent.getStringExtra("billingdate");
        display.setText("Bill Due Amount Calculated From Date:\n" + Bdate +"\nINR 3100 /-\n\n PAY NOW!");
    }
}