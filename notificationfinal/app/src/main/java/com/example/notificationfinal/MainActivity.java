package com.example.notificationfinal;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String channel_id = "01" ;
        Button b = findViewById(R.id.button) ;
        b.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                NotificationCompat.Builder mBuilder = new
                        NotificationCompat.Builder(MainActivity. this, "default" )
                        .setSmallIcon(R.drawable.logo_foreground)
                        .setContentTitle( "Notification of Application" )
                        .setContentText( "This is my first push notification" );
                NotificationManager nm = (NotificationManager) getSystemService(Context.
                        NOTIFICATION_SERVICE ) ;
// checking if android version is greater than oreo(API 26) or not
                if (android.os.Build.VERSION. SDK_INT >=
                        android.os.Build.VERSION_CODES. O )
                {
                    NotificationChannel nc = new
                            NotificationChannel( channel_id , "CHANNEL_01" ,
                            NotificationManager.IMPORTANCE_HIGH) ;
                    mBuilder.setChannelId( channel_id) ;
                    nm.createNotificationChannel(nc) ;
                }
                nm.notify(( int ) System. currentTimeMillis (), mBuilder.build()) ;
            }
        }) ; } }