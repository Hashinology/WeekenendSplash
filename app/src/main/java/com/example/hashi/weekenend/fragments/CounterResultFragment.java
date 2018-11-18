package com.example.hashi.weekenend.fragments;

import android.annotation.SuppressLint;
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
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/*import com.karimapps.timermultitask.NotificationActivity;
import com.karimapps.timermultitask.R;*/


import com.example.hashi.weekenend.R;

import java.util.Timer;
import java.util.TimerTask;


public class CounterResultFragment extends Fragment  {
    private Context context;
    private TextView tv_counter;
    private Timer timer;
    private TimerTask doAsynchronousTask;
    private int counter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragment_view = inflater.inflate(R.layout.result_fragment, container, false);
        context = getActivity();
        tv_counter=fragment_view.findViewById(R.id.tv_counter);
        Bundle bundle=this.getArguments();

        if (bundle!=null) {
            String isStrat=bundle.getString("start");

            if(isStrat.equalsIgnoreCase("true")){
                tv_counter.setText("started");
                startService();

            }else{
                tv_counter.setText("stopped");
                if(timer!=null){
                    timer=null;
                    doAsynchronousTask=null;
                }

            }
        }

//        Button btn_show_Alert = fragment_view.findViewById(R.id.btn_alert);
        return  fragment_view;
    }




    public void startService() {
        final Handler handler = new Handler();
        timer = new Timer();
        doAsynchronousTask = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @SuppressLint("SetTextI18n")
                    public void run() {
                        try {
                            /*set vlaue here */

                            tv_counter.setText("" + counter++);
                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                        }
                    }
                });
            }
        };
        timer.schedule(doAsynchronousTask, 0, 1000);
    }
}
