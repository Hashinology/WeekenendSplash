package com.example.hashi.weekenend.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.hashi.weekenend.R;

//import com.karimapps.timermultitask.R;


public class CounterFirstFragmentButtons extends Fragment  {

    private Context context;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragment_view = inflater.inflate(R.layout.btn_fragment, container, false);
        context = getActivity();



        Button btn_start = fragment_view.findViewById(R.id.btn_start);
        Button btn_stop = fragment_view.findViewById(R.id.btn_stop);

        /*stop and start buttons fragment*/

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*transaction of fragment with bundle to start*/
                FragmentTransaction fragmentTransaction1=getActivity().getSupportFragmentManager().beginTransaction();
                Fragment fragment2=new CounterResultFragment();
                Bundle bundle=new Bundle();
                bundle.putString("start","true");
                fragment2.setArguments(bundle);
                fragmentTransaction1.replace(R.id.conatiner_bottom,fragment2);
                fragmentTransaction1.commit();


            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*transaction of fragment with bundle to stop*/

                FragmentTransaction fragmentTransaction1=getActivity().getSupportFragmentManager().beginTransaction();
                Fragment fragment2=new CounterResultFragment();
                Bundle bundle=new Bundle();
                bundle.putString("start","fasle");
                fragment2.setArguments(bundle);
                fragmentTransaction1.replace(R.id.conatiner_bottom,fragment2);
                fragmentTransaction1.commit();


            }
        });

        return  fragment_view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);


    }
}
