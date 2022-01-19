package com.example.grid2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;

public class RecyclerAdaptor2 extends RecyclerView.Adapter<RecyclerAdaptor2.ViewHolder> implements Filterable {
    ArrayList<String> pro_namelist;
    ArrayList<String>pro_pricelist;
    ArrayList<Integer>imageslist;
    ArrayList<String>all_products;
    ArrayList<String>pro_descri;
    Context context;
    public RecyclerAdaptor2(Context context,ArrayList<String>pro_namelist,ArrayList<String>pro_pricelist,ArrayList<Integer>imageslist,ArrayList<String>pro_descri){
        this.context=context;
        this.pro_namelist=pro_namelist;
        this.pro_pricelist=pro_pricelist;
        this.imageslist=imageslist;
        this.pro_descri=pro_descri;
        this.all_products= new ArrayList<>(pro_namelist);
    }

    @NonNull
    @Override
    public RecyclerAdaptor2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View nameView=layoutInflater.inflate(R.layout.gridmyitem,parent,false);
        ViewHolder viewHolder = new ViewHolder(nameView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdaptor2.ViewHolder holder, int position) {
        holder.grid_name.setText(pro_namelist.get(position));
        holder.grid_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Click on "+pro_namelist.get(position),Toast.LENGTH_SHORT).show();
            }
        });
        holder.grid_price.setText(pro_pricelist.get(position));
        holder.grid_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String confirmed_name_grid = pro_namelist.get(position);
                String confirmed_price_grid = pro_pricelist.get(position);
                String confirmed_descrip_grid =pro_descri.get(position);
                Integer confirmed_images_grid = imageslist.get(position);
                Intent intent = new Intent(context, Item_details.class);
                intent.putExtra("confirmed_name", confirmed_name_grid);
                intent.putExtra("confirmed_price", confirmed_price_grid);
                intent.putExtra("confirmed_descrip",confirmed_descrip_grid);
                intent.putExtra("image",confirmed_images_grid);
                context.startActivity(intent);
            }
        });
        holder.grid_image.setImageResource(imageslist.get(position));
        holder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Click on like",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return pro_namelist.size();
    }

    @Override
    public Filter getFilter() {

        return filter;
    }
    Filter filter= new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<String> filteredList = new ArrayList<>();
            if(constraint.toString().isEmpty()){
                filteredList.addAll(all_products);
            }else{
                for(String products:all_products){
                    if(products.toLowerCase().contains(constraint.toString().toLowerCase())){
                        filteredList.add(products);
                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;

            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            pro_namelist.clear();
            pro_namelist.addAll((Collection<? extends String>) results.values);
            notifyDataSetChanged();
        }

    };


    public class ViewHolder extends RecyclerView.ViewHolder{
         ImageView grid_image,like;
        TextView grid_name, grid_price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            grid_name =itemView.findViewById(R.id.p_name_grid);
            grid_price =itemView.findViewById(R.id.p_price_grid);
            grid_image =itemView.findViewById(R.id.imageId_grid);
            like=itemView.findViewById(R.id.like_button);
        }
    }
}
