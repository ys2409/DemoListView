package com.myapplicationdev.android.demolistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayAdapter aa;
    ArrayList<Food> food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) this.findViewById(R.id.lvFood);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Food selectedFood = food.get(position);
                Toast.makeText(MainActivity.this, selectedFood.getName() + " Star: " + selectedFood.isStar(), Toast.LENGTH_LONG).show();
            }
        });

        //create a few food obj in food array
        food = new ArrayList<Food>();
        food.add(new Food("Ah Lat Coffee", false));
        food.add(new Food("Rocky Choc", true));
        food.add(new Food("Kid Cat Choc", true));
        //link activity obj, row.xml layout for
        //each row and food string array together
        aa = new FoodAdapter(this, R.layout.row, food);
        lv.setAdapter(aa);
    }
}