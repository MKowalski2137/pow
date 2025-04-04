package com.example.powtorzenie;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

public class pomocnik {
    private static final String CHANNEL_ID = "default_channel";
    private static final String CHANNEL_NAME = "Kanał powiadomień";


    public static void wyslij(int NotificationID, AppCompatActivity activity,String title,String message, int styleType,int LargeIconResID){
        if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.TIRAMISU){     //sprawdza wersję uządzenia
            if(ContextCompat.checkSelfPermission(activity, android.Manifest.permission.POST_NOTIFICATIONS)!= PackageManager.PERMISSION_GRANTED){        //sprawdza czy jest zgoda na wyyłanie powadomień
                ActivityCompat.requestPermissions(activity, new String [] {android.Manifest.permission.POST_NOTIFICATIONS}, 100);
                return;
            }
        }
    }
}
