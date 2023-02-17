

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
     Button b1;
    private static final String CHANNEL_ID="simplified coding";
    private static final String CHANNEL_NAME="simplified coding";
    private static final String CHANNEL_DESC="simplified coding Notification";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       b1= findViewById(R.id.button);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {
            NotificationChannel channel=new NotificationChannel(CHANNEL_ID,CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription((CHANNEL_DESC));
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);

        }

       b1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               displayNotification();
           }
       });
    }
    private void displayNotification()
    {
        NotificationCompat.Builder mBuilder=new NotificationCompat.Builder(this,CHANNEL_ID).
                setSmallIcon(R.drawable.ic_notification_bell).setContentTitle("PADHLEY LODEY ").setContentText("bhaut hogyi nisha se baat")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat mnotification =NotificationManagerCompat.from(this
        );

       mnotification.notify(1,mBuilder.build());
    }
}
