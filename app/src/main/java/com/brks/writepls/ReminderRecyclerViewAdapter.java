package com.brks.writepls;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ReminderRecyclerViewAdapter extends RecyclerView.Adapter<ReminderRecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<Reminder> mData;
    Dialog mDialog;
    int selected;

    public ReminderRecyclerViewAdapter(Context mContext, List<Reminder> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.reminders_list_item,viewGroup,false);
        final MyViewHolder viewHolder = new MyViewHolder(v);

        //---------------------Инициализация диалогового окна и его вызов по кнопке----------------------------------------------------------
        mDialog = new Dialog(mContext);
        mDialog.setContentView(R.layout.dialog_delete_item);
        Button yes_button = mDialog.findViewById(R.id.dialog_yes_btn);
        Button no_button = mDialog.findViewById(R.id.dialog_no_btn);

        viewHolder.item_reminder.setOnLongClickListener(new View.OnLongClickListener() {
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
                    deleteItem(selected);
                    mDialog.cancel();
                    notifyDataSetChanged();
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

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.time.setText(mData.get(position).getTime());
        holder.aSwitch.setChecked(mData.get(position).isFlag());
        holder.text.setText(mData.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView time;
        private Switch aSwitch;
        private TextView text;
        private LinearLayout item_reminder;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            item_reminder = itemView.findViewById(R.id.note_item);
            time = itemView.findViewById(R.id.time_reminder);
            aSwitch = itemView.findViewById(R.id.switch_reminder);
            text = itemView.findViewById(R.id.text_reminder);
        }
    }

    public void addItem(int position, Reminder reminder){
        mData.add(position, reminder);
        //Мы можем вызвать
        super.notifyItemInserted(position);
    }

    //Удаление данных
    public void deleteItem(int position){
        mData.remove(position);

        //То же самое с методом
        super.notifyItemRemoved(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mData.size());
        RemindersFragment.decreasePosition();


    }


}
