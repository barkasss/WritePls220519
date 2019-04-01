package com.brks.writepls;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import static java.text.DateFormat.getDateInstance;

public class NotesFragment extends Fragment {
    Button addBtn;



    private RecyclerView notesRecyclerView;
    private List<Note> lstNote = new ArrayList<>();
    private static int position = 0; // индекс заметок в lstNote
    int namePosition = 1;            // номер новой заметки при ее создании
    RecyclerViewAdapter recyclerAdapter;





    public NotesFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_notes, container, false);

        recyclerAdapter = new RecyclerViewAdapter(getContext(),lstNote);
        notesRecyclerView = v.findViewById(R.id.notes_recyclerView);
        notesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        notesRecyclerView.setAdapter(recyclerAdapter);


        //Создание первой заметки при входе
        recyclerAdapter.addItem(position,new Note("Первая заметка",
                getDateInstance().format(System.currentTimeMillis()),
                R.drawable.btn_favourite_off, "Текст заметки" ));
        position++;


        addBtn = v.findViewById(R.id.addBtn);







        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Создание новой заметки
                recyclerAdapter.addItem(position,new Note("Новая заметка " + namePosition,
                        getDateInstance().format(System.currentTimeMillis()),
                        R.drawable.btn_favourite_off, "Текст заметки" ));
                //Обновление адаптера
                recyclerAdapter.notifyItemInserted(position);
                //Обновление позиции
                position++;
                //Обновление переменной нумерации новых записок
                namePosition++;
                System.out.println(123);
            }
        });

        return v;
    }

   // public static void decreasePosition() {
    //    position--;
   // }
}