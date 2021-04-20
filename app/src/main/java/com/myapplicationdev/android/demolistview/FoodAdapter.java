package com.myapplicationdev.android.demolistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FoodAdapter extends ArrayAdapter<Food> {
    private ArrayList<Food> food;
    private Context context;
    private TextView tvFoodName;
    private ImageView ivStar;

    public FoodAdapter(Context context, int resource, ArrayList<Food> objects){
        super(context, resource, objects);
        //store food passed to adapter
        food = objects;
        //store context obj
        this.context = context;
    }
    //getView method call everytime LV needs row
    public View getView(int position, View convertView, ViewGroup parent){
        // usual way to get layout inflator obj to inflate xml
        // file into view obj
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //inflate row.xml as layout for view obj
        View rowView = inflater.inflate(R.layout.row, parent, false);
        //get textview obj
        tvFoodName = (TextView) rowView.findViewById(R.id.tvFoodName);
        //get imageview obj
        ivStar = (ImageView) rowView.findViewById(R.id.ivStar);
        //parameter "position" is index
        // of row LV is requesting
        //get back food at the same index
        Food currentFood = food.get(position);
        //set textview to show food
        tvFoodName.setText(currentFood.getName());
        //set image to star/no star accordingly
        if(currentFood.isStar()) {
            ivStar.setImageResource(R.drawable.star);
        } else {
            ivStar.setImageResource(R.drawable.nostar);
        }
        //return done up view to LV
        return rowView;
    }
}
