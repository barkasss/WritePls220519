package com.brks.writepls;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.List;

public class RemindersFragment extends Fragment {

    Button addBtn;
    Dialog newReminderDialog;
    Button cancelBtn;
    Button doneBtn;
    EditText mainText;
    TimePicker timePicker;

    private RecyclerView reminderRecyclerView;
    private List<Reminder> lstReminder = new ArrayList<>();
    private static int position = 0; // индекс заметок в lstReminder
    int namePosition = 1;            // номер новой заметки при ее создании
    ReminderRecyclerViewAdapter recyclerAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_reminders, container, false);

        recyclerAdapter = new ReminderRecyclerViewAdapter(getContext(),lstReminder);
        reminderRecyclerView = v.findViewById(R.id.reminders_recyclerView);
        reminderRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        reminderRecyclerView.setAdapter(recyclerAdapter);

        newReminderDialog = new Dialog(getContext());
        newReminderDialog.setContentView(R.layout.dialog_new_reminder);
        mainText = newReminderDialog.findViewById(R.id.text_reminder);
        timePicker = newReminderDialog.findViewById(R.id.timePicker);
        cancelBtn = newReminderDialog.findViewById(R.id.cancelBtn);
        doneBtn = newReminderDialog.findViewById(R.id.doneBtn);
        doneBtn.setEnabled(false);


        timePicker.setIs24HourView(true);
        try {
            mainText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    if (mainText.getText().toString().equals("")|| mainText.getText().toString().equals(" ")) {
                        doneBtn.setEnabled(false);
                    } else {
                        doneBtn.setEnabled(true);
                    }
                }
            });
        }catch (NullPointerException e){
            System.out.println(e);
        }

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newReminderDialog.cancel(); // Отмена
            }
        });
        doneBtn.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                recyclerAdapter.addItem(position,new Reminder(String.valueOf(timePicker.getHour())+ ":" + String.valueOf(timePicker.getMinute()),true,mainText.getText().toString()));
                position++;

            }
        });

        addBtn = v.findViewById(R.id.addBtnReminder);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newReminderDialog.show();

            }
        });




        return v;
    }


    public static void decreasePosition() {
        position--;
    }

}
