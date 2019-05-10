package com.brks.writepls;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class NotesRecyclerViewAdapter extends RecyclerView.Adapter<NotesRecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<Note> mData;



    public NotesRecyclerViewAdapter(Context mContext, List<Note> mData) {
        this.mContext = mContext;
        this.mData = mData;
        //this.notesFragment = notesFragment;
    }



    @RequiresApi(api = Build.VERSION_CODES.M)
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.notes_list_item,viewGroup,false);
        final MyViewHolder viewHolder = new MyViewHolder(v);


        //---------------------Инициализация диалогового окна и его вызов по кнопке----------------------------------------------------------

        viewHolder.item_note.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                menu.add(viewHolder.getAdapterPosition(),0,0,"Удалить");
                menu.add(viewHolder.getAdapterPosition(),1,0,"Изменить");
            }
        });



        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_Name.setText(mData.get(position).getName());
        holder.tv_Date.setText(mData.get(position).getDate());
        holder.tv_Text.setText(mData.get(position).getText());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout item_note;
        private TextView tv_Name;
        private TextView tv_Date;
        private TextView tv_Text;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            item_note = itemView.findViewById(R.id.note_item);
            tv_Name = itemView.findViewById(R.id.name_note);
            tv_Date = itemView.findViewById(R.id.date_note);
            tv_Text = itemView.findViewById(R.id.text_note);
        }
    }


}

