package com.brks.writepls;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class ShoppingRecyclerViewAdapter extends RecyclerView.Adapter<ShoppingRecyclerViewAdapter.MyViewHolder> {
    Context mContext;
    List<ShoppingElement> mData;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onStatusClick(int position);

    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        mListener = onItemClickListener;
    }

    public ShoppingRecyclerViewAdapter(Context mContext, List<ShoppingElement> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup,  int i) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.shopping_list_item,viewGroup,false);
        final MyViewHolder viewHolder = new MyViewHolder(v,mListener);


        viewHolder.item_shopping_element.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                menu.add(viewHolder.getAdapterPosition(),0,0,"Удалить");
            }
        });

        viewHolder.statusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();

                if(mData.get(position).isStatus() == 1){
                    viewHolder.statusBtn.setBackgroundResource(R.drawable.btn_rounded_grey);
                    viewHolder.statusBtn.setText("Готово");
                    viewHolder.toBuyText.setTextColor(Color.GRAY);

                }else {
                    viewHolder.statusBtn.setBackgroundResource(R.drawable.btn_rounded_light);
                    viewHolder.statusBtn.setText("Купить");
                    viewHolder.toBuyText.setTextColor(Color.BLACK);

                }
                mListener.onStatusClick(position);

            }
        });


        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.toBuyText.setText(mData.get(position).getToBuy());

    }


    @Override
    public int getItemCount() { return mData.size(); }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView toBuyText;
        private Button statusBtn;
        private LinearLayout item_shopping_element;

        public MyViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);

            toBuyText = itemView.findViewById(R.id.shopping_buy_text);
            statusBtn = itemView.findViewById(R.id.statusBtn);
            item_shopping_element = itemView.findViewById(R.id.shopping_item);
            toBuyText.setTextColor(Color.BLACK);


        }
    }
}
