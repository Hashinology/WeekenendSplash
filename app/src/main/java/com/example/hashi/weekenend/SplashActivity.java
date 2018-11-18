package com.example.hashi.weekenend;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        /*made handler object */
        Handler handler=new Handler();

        /*set delayed to handler*/
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                /*to start next activity*/
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
            }
            /*2 seconds delays ie 1 sec=1000 mili second*/
        },2000);

    }
}
