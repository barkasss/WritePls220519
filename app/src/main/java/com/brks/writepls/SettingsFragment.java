package com.brks.writepls;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;



public class SettingsFragment extends Fragment {
    Switch switch_pop_up;
   // Button applyBtn;
    boolean switchState = true ;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_settings, container, false);

        switch_pop_up = v.findViewById(R.id.switch_pop_up);
        switch_pop_up.setChecked(switchState);
        switch_pop_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               switchState = !switchState;
               switch_pop_up.setChecked(switchState);

            }
        });
        return v; }
    public boolean getSPUisChecked(){
        System.out.println(switchState);
        System.out.println("хай");
        return switchState;
    }
}