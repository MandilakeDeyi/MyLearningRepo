package com.example.grid2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;

public class Sell extends AppCompatActivity {

    Button btn;
    Uri uri;
    EditText pro_price, pro_descrip, name;
    ImageView imageView;
    int SELECT_IMAGE_CODE = 1;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.toolbar);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_sell);

        bottomNavigationView = findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.sell);
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
                        startActivity(new Intent(getApplicationContext(),My_store.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.sell:
                        return true;
                }
                return false;
            }
        });

        pro_descrip = (EditText) findViewById(R.id.description);
        name = (EditText) findViewById(R.id.name);
        pro_price = (EditText) findViewById(R.id.price);
        btn = findViewById(R.id.btn);


        imageView = findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Title"), SELECT_IMAGE_CODE);

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pro_name = name.getText().toString();
                String descrip = pro_descrip.getText().toString();
                String price_pro = pro_price.getText().toString();
                Intent intent = new Intent(Sell.this, Confirme_Page.class);
                intent.putExtra("descrip", descrip);
                intent.putExtra("name", pro_name);
                intent.putExtra("img", uri);
                intent.putExtra("price", price_pro);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
           Uri uri = data.getData();
           // imageView.setImageURI(uri);
            Picasso.with(this).load(uri).fit().into(imageView);

        }
    }
}
