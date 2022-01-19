package com.example.grid2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class My_store extends AppCompatActivity {

    RecyclerView recyclerView;
    Mystore_Adapter adaptor;
    ArrayList<String> product_name;
    ArrayList<String>product_price;
    TextView my_store;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.toolbar);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_my_store);

        bottomNavigationView = findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.MyStore);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.profile_page:
                        startActivity(new Intent(getApplicationContext(),Profile.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.MyStore:

                        return true;
                    case R.id.sell:
                        startActivity(new Intent(getApplicationContext(),Sell.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        my_store = (TextView)findViewById(R.id.my_store);
        product_name=new ArrayList<>();
        product_price=new ArrayList<>();
        String get_confirmed_name = getIntent().getStringExtra("confirmed_name");
        String get_confirme_price= getIntent().getStringExtra("confirmed_price");
        product_name.add(get_confirmed_name);
        product_price.add(get_confirme_price);
        product_name.add("ph pc");
        product_name.add("iphone sx6");
        product_name.add("lenove pc");
        product_name.add("Nike AF1");
        product_price.add("R 5000");
        product_price.add("R 23000");
        product_price.add("R 4550");
        product_price.add("R 1800");

        recyclerView= findViewById(R.id.reclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adaptor=new Mystore_Adapter(this,product_name,product_price);
        recyclerView.setAdapter(adaptor);
        my_store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(My_store.this,MainActivity.class);
                startActivity(intent);
            }
        });

        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            int position = viewHolder.getAdapterPosition();
            switch (direction){
                case ItemTouchHelper.LEFT:
                    product_name.remove(position);
                    product_price.remove(position);
                    adaptor.notifyItemRemoved(position);
                    break;
                case ItemTouchHelper.RIGHT:
                    product_name.remove(position);
                    product_price.remove(position);
                    adaptor.notifyItemRemoved(position);
            }
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);






    }

}