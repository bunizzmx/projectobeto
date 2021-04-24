package com.bunizz.comida;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class main_fragment extends Fragment {
change_instance listener;
Button B1, B2, B3;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.main_fragments, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        B1= view.findViewById(R.id.BOTTON_1);
            B1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onChange(1);
                }
            });
        B2= view.findViewById(R.id.BOTTON_2);
        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onChange(2);
            }
        });
        B3= view.findViewById(R.id.BOTTON_3);
        B3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onChange(3);
            }
        });


    }
    public static main_fragment newInstance() {
        return new main_fragment();
    }   @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener= (change_instance) context;

    }



}
