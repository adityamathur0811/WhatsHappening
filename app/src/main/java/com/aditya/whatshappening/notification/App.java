package com.aditya.whatshappening.notification;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application
{
    public static  final String Channel_Td="channel_1";
    @Override
    public void onCreate()
    {
        super.onCreate();
        notification();
    }
    private void notification()
    {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {
            int importance= NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel=new NotificationChannel(Channel_Td,"channel1 1",importance);
            channel.setDescription("this is channel 1");
            NotificationManager notificationManager=getSystemService(NotificationManager.class);
            assert notificationManager != null;
            notificationManager.createNotificationChannel(channel);
        }
    }

}
