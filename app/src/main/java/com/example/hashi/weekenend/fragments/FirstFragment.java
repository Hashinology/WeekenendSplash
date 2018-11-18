package com.example.hashi.weekenend.fragments;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hashi.weekenend.FragmentsActivity;
import com.example.hashi.weekenend.NotificationActivity;
import com.example.hashi.weekenend.R;
/*import com.karimapps.timermultitask.FragmentsActivity;
import com.karimapps.timermultitask.NotificationActivity;
import com.karimapps.timermultitask.R;*/

import static android.support.v7.appcompat.R.attr.title;



public class FirstFragment extends Fragment {
    private Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragment_view = inflater.inflate(R.layout.first_fragment, container, false);
        context = getActivity();
        /*got ids of all views*/
        Button btn_show_Alert = fragment_view.findViewById(R.id.btn_alert);
        Button btn_default_alert = fragment_view.findViewById(R.id.btn_default_alert);
        Button btn_alert_options = fragment_view.findViewById(R.id.btn_alert_options);
        Button btn_notification = fragment_view.findViewById(R.id.btn_notification);
        Button btn_fragments = fragment_view.findViewById(R.id.btn_fragments);
        final Spinner spinner=fragment_view.findViewById(R.id.spinner);
        /*custome alert method*/
        btn_show_Alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlert();
            }
        });

        /*default alert method*/
        btn_default_alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                defaultAlert();
            }
        });

        /*notfication method using notification mannager*/
        btn_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNotification();
            }
        });

        /*options list using xml array*/
        btn_alert_options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner.setVisibility(View.VISIBLE);
            }
        });

        /*two fragments in an activity to start and stop counter using timer task*/
        btn_fragments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, FragmentsActivity.class));
            }
        });

        return fragment_view;
    }

    private void showNotification() {


        /*pending intent to show notifications list*/

        Intent intent = new Intent(context, NotificationActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_ONE_SHOT);

//        Uri notification_sound =   Uri.parse("android.resource://"+getApplicationContext().getPackageName()+"/"+R.raw.bell);
        /*ringtone for notifications*/
        Uri notification_sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);

        Log.w("TYPE_RINGTONE", "TYPE_RINGTONExxxxxxxxx ");
        NotificationCompat.Builder notification_builder = new NotificationCompat.Builder(context);
        notification_builder.setSmallIcon(getNotificationIcon());
        notification_builder.setContentTitle("Hshi Test Notification");
        notification_builder.setContentText("Your all notifications are here");
        notification_builder.setAutoCancel(true);
        notification_builder.setSound(notification_sound);
        notification_builder.setContentIntent(pendingIntent);
        /*notification manger class*/

        NotificationManager notificationManager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification_builder.build());
    }

    private int getNotificationIcon() {
        boolean useWhiteIcon = (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP);
        return useWhiteIcon ? R.drawable.logo : R.drawable.logo;
    }




    private void defaultAlert() {
        AlertDialog alertDialog = new AlertDialog.Builder(context)
                //set icon
                .setIcon(android.R.drawable.ic_dialog_alert)
                //set title
                .setTitle("Are you sure to Exit")
                //set message
                .setMessage("Exiting will call finish() method")
                //set positive button
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //set what would happen when positive button is clicked
                        getActivity().finish();
                    }
                })
                //set negative button
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //set what should happen when negative button is clicked
                        Toast.makeText(context,"Nothing Happened",Toast.LENGTH_LONG).show();
                    }
                })
                .show();
    }

    private void showAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(R.layout.alert_screen);
        final AlertDialog dialog = builder.create();
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
            }
        }, 2000);


    }


}

