package com.example.recyclerview1.datas;

import com.example.recyclerview1.R;
import com.example.recyclerview1.models.Drink;

import java.util.ArrayList;

public class DrinkData {
    private static String [] drinkName = {
            "Ice Milk Chocolate",
            "Ice Matcha Latte",
            "Ice Milk Coffe",

    };

    private static String [] drinkPrice = {
            "Rp.150.000",
            "Rp.200.000",
            "Rp.250.000",

    };

    private static int [] drinkImage = {
            R.drawable.coksu,
            R.drawable.matcha2,
            R.drawable.kopsu,


    };

    public static ArrayList<Drink> getDataDrink() {
        ArrayList<Drink> list = new ArrayList<>();
        for(int i=0;i<drinkName.length;i++){
            Drink food = new Drink(drinkName[i],"Rp " + drinkPrice[i], drinkImage[i]);
            list.add(food);
        }
        return list;
    }
}
