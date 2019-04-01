package com.brks.writepls;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<Note> mData;
    Dialog mDialog;
    //NotesFragment notesFragment;
    int selected;



    public RecyclerViewAdapter(Context mContext, List<Note> mData) {
        this.mContext = mContext;
        this.mData = mData;
        //this.notesFragment = notesFragment;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.notes_list_item,viewGroup,false);
        final MyViewHolder viewHolder = new MyViewHolder(v);


        //---------------------Инициализация диалогового окна и его вызов по кнопке----------------------------------------------------------
        mDialog = new Dialog(mContext);
        mDialog.setContentView(R.layout.dialog_note);
        Button yes_button = mDialog.findViewById(R.id.dialog_yes_btn);
        Button no_button = mDialog.findViewById(R.id.dialog_no_btn);

        viewHolder.item_note.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(mContext,"Test Click" + String.valueOf(viewHolder.getAdapterPosition()),Toast.LENGTH_SHORT).show();
                mDialog.show();
                selected = viewHolder.getAdapterPosition();

                return false;
            }
        });

        yes_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    deleteItem(viewHolder,selected);
                    mDialog.cancel();
                    notifyDataSetChanged();
                    //   for (int i = 0; i < mData.size(); i++) {
                    //      mData[i]
                    //  }
                }catch (ArrayIndexOutOfBoundsException e){
                    Log.e("Error","\n ArrayIndexOutOfBoundsException length=10 index=-1 \n Опять -1, но как ???");
                }
            }
        });

        no_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog.cancel();
            }
        });
    //-------------------------------------------------------------------------------------------------------------------------------------
    // Редактор заметки?

    viewHolder.item_note.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mContext,NoteActivity.class);
            intent.putExtra("Title",viewHolder.tv_Name.getText().toString());
            intent.putExtra("Text",viewHolder.tv_Text.getText().toString());
            intent.putExtra("selected", selected);
            mContext.startActivity(intent);




        }
    });






        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_Name.setText(mData.get(position).getName());
        holder.tv_Date.setText(mData.get(position).getDate());
        holder.button.setBackgroundResource(mData.get(position).getFavourite());
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
        private Button button;
        private TextView tv_Text;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            item_note = itemView.findViewById(R.id.note_item);
            tv_Name = itemView.findViewById(R.id.name_note);
            tv_Date = itemView.findViewById(R.id.date_note);
            button = itemView.findViewById(R.id.favorite_btn_note);
            tv_Text = itemView.findViewById(R.id.text_note);
        }
    }

    //Добавление данных
    public void addItem(int position, Note note){
        mData.add(position, note);
        //Мы можем вызвать
        super.notifyItemInserted(position);
    }

    //Удаление данных
    public void deleteItem(MyViewHolder holder,int position){
        mData.remove(holder.getAdapterPosition());
        //То же самое с методом
        super.notifyItemRemoved(position);
        notifyItemRemoved(holder.getAdapterPosition());
        notifyItemRangeChanged(holder.getAdapterPosition(), mData.size());

    }




}

