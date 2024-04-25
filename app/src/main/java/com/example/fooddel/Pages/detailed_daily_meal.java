package com.example.fooddel.Pages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.fooddel.R;
import com.example.fooddel.order;
import com.example.fooddel.ui.ui.dailymeal.DetailedDailyAdapter;
import com.example.fooddel.ui.ui.dailymeal.DetailedDailyModel;

import java.util.ArrayList;
import java.util.List;

public class detailed_daily_meal extends AppCompatActivity {

    RecyclerView recyclerView;
    public static ArrayList<DetailedDailyModel> detailedDailyModelList = new ArrayList<>();
    DetailedDailyAdapter dailyAdapter;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_daily_meal);

        String type = getIntent().getStringExtra("type");


        recyclerView = findViewById(R.id.detailed_rec);
        imageView = findViewById(R.id.detailed_img);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        detailedDailyModelList = new ArrayList<>();
        dailyAdapter = new DetailedDailyAdapter(detailedDailyModelList);
        recyclerView.setAdapter(dailyAdapter);


        if(type!=null && type.equalsIgnoreCase("Завтрак")){

            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.brake1,"600","описание", "5.0","Завтрак","9:00 - 12:00", 1));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.brake2,"Завтрак","описание", "4.0","490","9:00 - 12:00", 1));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.brake3,"Завтрак","описание", "4.8","190","9:00 - 12:00", 1));
            dailyAdapter.notifyDataSetChanged();
        }
        if(type!=null && type.equalsIgnoreCase("Ланч")){
            imageView.setImageResource(R.drawable.lunch);
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.lunch1,"Ланч","описание", "5.0","390","9:00 - 12:00", 1));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.lunch2,"Ланч","описание", "4.0","290","9:00 - 12:00", 1));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.lunch3,"Ланч","описание", "4.8","180","9:00 - 12:00", 1));
            dailyAdapter.notifyDataSetChanged();
        }

    }
    public void addToCart(View view){
        int item_id = getIntent().getIntExtra("ID", 0);
        order.items_id.add(item_id);
        Toast.makeText(this, "Добавлено!", Toast.LENGTH_LONG).show();
    }
}