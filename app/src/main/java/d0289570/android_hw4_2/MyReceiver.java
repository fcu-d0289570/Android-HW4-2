package d0289570.android_hw4_2;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;

public class MyReceiver extends BroadcastReceiver {

    static int id = 70000;
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        String msg = intent.getStringExtra("KEY_MSG");

        Intent newIntent = new Intent();
        newIntent.setClass(context,MainActivity.class);
        newIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        newIntent.putExtra("KEY_MSG",msg);
 //       context.startActivity(newIntent);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, newIntent, PendingIntent.FLAG_UPDATE_CURRENT);


        Notification notification = null;

        notification = newNotification(context, pendingIntent, "Hello", msg);

        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(id++, notification);
    }

    @SuppressLint("NewApi")
    private Notification newNotification(Context context, PendingIntent pi, String title, String msg){
        Notification.Builder builder = new Notification.Builder(context);
        builder.setContentTitle(title);
        builder.setContentIntent(pi);
        builder.setContentText(msg);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setTicker(msg);
        builder.setWhen(System.currentTimeMillis());
        Notification notification = builder.build();
        return notification;
    }
}
