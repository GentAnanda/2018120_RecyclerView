package com.example.recyclerview1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.recyclerview1.adapters.DrinkAdapter;
import com.example.recyclerview1.datas.DrinkData;
import com.example.recyclerview1.models.Drink;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvDrink;
    public List<Drink> drinkList = new ArrayList<>();
    int pilihan = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Drinks");

        rvDrink = findViewById(R.id.rv_drink);

        drinkList = DrinkData.getDataDrink();
        DrinkAdapter DrinkAdapter = new DrinkAdapter(drinkList);

        rvDrink.setAdapter(DrinkAdapter);
        rvDrink.setLayoutManager(new LinearLayoutManager(this));

        rvDrink.addItemDecoration(new DividerItemDecoration
                (this, DividerItemDecoration.VERTICAL));

        DrinkAdapter.setOnItemClickCallback(new DrinkAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Drink data) {
                if(pilihan == 1) {
                    rvDrink.setLayoutManager(new GridLayoutManager(getApplicationContext(),3));
                    pilihan = 2;
                } else if(pilihan == 2) {
                    rvDrink.setLayoutManager(new StaggeredGridLayoutManager(2,
                            StaggeredGridLayoutManager.VERTICAL));
                }
            }
        });
    }

    private void showSelectedFood(Drink data) {
        Toast.makeText(this, "Kamu memilih " + data.getName(), Toast.LENGTH_SHORT).show();
    }
}