package com.example.hashi.weekenend;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.hashi.weekenend.fragments.CounterFirstFragmentButtons;
import com.example.hashi.weekenend.fragments.CounterResultFragment;
//import com.karimapps.timermultitask.fragments.CounterFirstFragmentButtons;
//import com.karimapps.timermultitask.fragments.CounterResultFragment;
//import com.karimapps.timermultitask.fragments.FirstFragment;


public class FragmentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragments_activity);

        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        Fragment fragment=new CounterFirstFragmentButtons();
        fragmentTransaction.replace(R.id.conatiner_top,fragment);
        fragmentTransaction.commit();


        FragmentTransaction fragmentTransaction1=getSupportFragmentManager().beginTransaction();
        Fragment fragment2=new CounterResultFragment();
        fragmentTransaction1.replace(R.id.conatiner_bottom,fragment2);
        fragmentTransaction1.commit();

    }
}

