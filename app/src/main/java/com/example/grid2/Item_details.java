package com.example.grid2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Item_details extends AppCompatActivity {
     TextView fromGridName,fromGridPrice,fromGridseller,fromGridlike,fromGriddescr;
     Button back;
     ImageView fromGridImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.toolbar);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_item_details);
        String get_confirmed_name_grid = getIntent().getStringExtra("confirmed_name");
        String get_confirme_price_grid= getIntent().getStringExtra("confirmed_price");
        String get_confirmed_descrip_grid = getIntent().getStringExtra("confirmed_descrip");
        String get_confirmed_image = getIntent().getStringExtra("image");
        fromGridName = (TextView)findViewById(R.id.detailed_name);
        fromGridPrice =(TextView)findViewById(R.id.detailed_price);
        fromGriddescr =(TextView)findViewById(R.id.detailed_description);
        fromGridImage =(ImageView)findViewById(R.id.detailed_image);
      //  fromGridImage.setImageResource(Integer.parseInt(get_confirmed_image));
        fromGridName.setText(get_confirmed_name_grid);
        fromGridPrice.setText(get_confirme_price_grid);
        fromGriddescr.setText(get_confirmed_descrip_grid);


        back=(Button) findViewById(R.id.back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Item_details.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}