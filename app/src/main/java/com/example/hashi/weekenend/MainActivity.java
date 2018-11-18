package com.example.hashi.weekenend;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hashi.weekenend.fragments.FirstFragment;
/*import com.karimapps.timermultitask.R;
import com.karimapps.timermultitask.fragments.FirstFragment;*/



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*transaction of home fragment*/
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        Fragment fragment=new FirstFragment();
        fragmentTransaction.replace(R.id.fragment_container,fragment);
        fragmentTransaction.commit();
    }

}
