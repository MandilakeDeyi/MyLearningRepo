package com.example.grid2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Mystore_Adapter extends RecyclerView.Adapter<Mystore_Adapter.ViewHolder> {
    ArrayList<String> data;
    ArrayList<String>price_data;
    Context context;

    public Mystore_Adapter(Context context, ArrayList<String>data, ArrayList<String>price_data) {
        this.data=data;
        this.price_data=price_data;
        this.context=context;
    }
    @NonNull
    @Override
    public Mystore_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View nameView=layoutInflater.inflate(R.layout.seller_items,parent,false);
        ViewHolder viewHolder = new ViewHolder(nameView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull Mystore_Adapter.ViewHolder holder, int position) {
        holder.check_name.setText(data.get(position));
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Click on delete",Toast.LENGTH_SHORT).show();
            }
        });
        holder.check_price.setText(price_data.get(position));

    }

    @Override
    public int getItemCount() {
        return data.size() ;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView thirdImage;
        TextView check_name,check_price;
        Button delete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            check_name=itemView.findViewById(R.id.saved_name);
            check_price=itemView.findViewById(R.id.saved_price);
            thirdImage=itemView.findViewById(R.id.imageView3);
             delete=itemView.findViewById(R.id.delete);
        }
    }
}
