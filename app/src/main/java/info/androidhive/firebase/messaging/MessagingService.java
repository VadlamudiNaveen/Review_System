package info.androidhive.firebase.messaging;

import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import info.androidhive.firebase.R;
import info.androidhive.firebase.survey_data_form.Survey_form;

public class MessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        showNotification(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody());
        //Toast.makeText(MessagingService.this,MainActivity.class,Toast.LENGTH_LONG).show();
        Intent tent=new Intent(this, Survey_form.class);
        // tent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        //PendingIntent pendingIntent=PendingIntent.getActivity(this,0,tent,PendingIntent.FLAG_ONE_SHOT);
        startActivity(tent);;
    }
    public void showNotification(String title,String message){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "mynotifications")
                .setContentTitle(title)
                .setSmallIcon(R.drawable.common_google_signin_btn_icon_light_normal_background)
                .setAutoCancel(true)
                .setContentText(message);
        NotificationManagerCompat manager= NotificationManagerCompat.from(this);
        manager.notify(999,builder.build());
    }
}
