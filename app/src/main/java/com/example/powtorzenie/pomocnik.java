package com.example.powtorzenie;

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
    private static final String CHANNEL_NAME = "Kanał powiadomień";     //zmienne ważne do kanału powiadomień


    public static void wyslij(int NotificationID, AppCompatActivity activity,String title,String message, int styleType,int LargeIconResID){
        if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.TIRAMISU){     //sprawdza czy wersja android jest wyższa od Tiramisu(33)
            if(ContextCompat.checkSelfPermission(activity, android.Manifest.permission.POST_NOTIFICATIONS)!= PackageManager.PERMISSION_GRANTED){        //sprawdza czy jest zgoda na wyyłanie powadomień
                ActivityCompat.requestPermissions(activity, new String [] {android.Manifest.permission.POST_NOTIFICATIONS}, 100);       //prosi o pozwolenie na wysyłanie powiadomień jeśli takiego nie ma
                return;
            }
        };
        NotificationManager menager= (NotificationManager)
                activity.getSystemService(Context.NOTIFICATION_SERVICE);        //bierze dostęp do usługi powiadomień
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){        //sprawdza czy wersja android jest wyższa od O
            NotificationChannel kanal= new NotificationChannel(CHANNEL_ID,CHANNEL_NAME,menager.IMPORTANCE_HIGH);        //robi kanał powiadomień zawierający menadżera powiadomień, channel id,name oraz wysoką ważność powiadomienia
            menager.createNotificationChannel(kanal);       //inicjalizuje kanał powiadomień

        }
        NotificationCompat.Builder budowniczy =     //robi buildera który jest używany do tworzenia powiadomień
                new NotificationCompat.Builder(activity, CHANNEL_ID)
                        .setSmallIcon(R.drawable.burd)
                        .setContentTitle(title)
                        .setContentText(message)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setAutoCancel(true);



        switch (styleType) {
            case 1:     //robi zwykłą wiadomość
                budowniczy.setStyle(new NotificationCompat.BigTextStyle().bigText(message));
                break;
            case 2:     //robi wiadomość z obrazem
                if (LargeIconResID != 0) {
                    Bitmap largeIcon = BitmapFactory.decodeResource(activity.getResources(), LargeIconResID);
                    budowniczy.setLargeIcon(largeIcon);
                    budowniczy.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(largeIcon).setBigContentTitle(title));
                }
                break;
            case 3:     //robi długą wiadomość
                NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
                inboxStyle.addLine(message);
                inboxStyle.addLine("Dodatkowa linia tekstu");
                budowniczy.setStyle(inboxStyle);
                break;
        }
        menager.notify(NotificationID, budowniczy.build());
    }
}

