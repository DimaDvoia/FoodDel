package com.example.fooddel.ui.ui.dailymeal;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fooddel.R;

import java.util.ArrayList;
import java.util.List;

public class daily_meal_fragment extends Fragment {

    RecyclerView recyclerView;
    List<DailyMealModel> dailyMealModels;
    DailyAdapter dailyMealAdapter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_daily_meal_fragment, container, false);

        recyclerView = root.findViewById(R.id.daily_meal_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dailyMealModels = new ArrayList<>();

        dailyMealModels.add(new DailyMealModel(R.drawable.breakfast,"Завтрак", "25%","Питательно и энергично ","Завтрак"));
        dailyMealModels.add(new DailyMealModel(R.drawable.lunch,"Ланч", "15%","Быстро и сытно. ","Ланч"));
        dailyMealModels.add(new DailyMealModel(R.drawable.dinnner,"Ужин", "22%","Изыскано и вкусно ","Ужин"));
        dailyMealModels.add(new DailyMealModel(R.drawable.sweets,"Дессерт", "28%","Сладко и нежно ","Дессерт"));
        dailyMealModels.add(new DailyMealModel(R.drawable.kofee,"Коффе", "35%","Ароматно и бодряще ","Коффе"));


        dailyMealAdapter = new DailyAdapter(getContext(),dailyMealModels);
        recyclerView.setAdapter(dailyMealAdapter);
        dailyMealAdapter.notifyDataSetChanged();
        return root;
    }
}