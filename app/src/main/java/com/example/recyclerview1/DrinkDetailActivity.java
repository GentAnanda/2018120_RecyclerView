package com.example.recyclerview1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.recyclerview1.models.Drink;

public class DrinkDetailActivity extends AppCompatActivity {

    ImageView iv_drink;
    TextView drink_title, drink_price;
    public static final String ITEM_EXTRA = "item_extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_detail);

        iv_drink = findViewById(R.id.image_logo);
        drink_title = findViewById(R.id.tv_title_detail);
        drink_price = findViewById(R.id.tv_price_detail);

        Drink drink = getIntent().getParcelableExtra(ITEM_EXTRA);
        if(drink != null) {
            Glide.with(this)
                    .load(drink.getLogo())
                    .into(iv_drink);
            drink_title.setText(drink.getName());
            drink_price.setText(drink.getPrice());
        }

        if(getSupportActionBar() != null) {
            getSupportActionBar().setTitle("drink Detail");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}