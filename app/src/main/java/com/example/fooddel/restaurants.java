package com.example.fooddel;

import static android.app.PendingIntent.getActivity;

import static androidx.core.content.ContentProviderCompat.requireContext;
import static java.security.AccessController.getContext;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.fooddel.VerticalRes.HomeVerAdapt;
import com.example.fooddel.VerticalRes.HomeVerModels;

import java.util.ArrayList;
import java.util.List;

public class restaurants extends AppCompatActivity  {


    RecyclerView homeVerticalRec;
    List<HomeVerModels> homeVerModelsList;
    HomeVerAdapt homeVerAdapt;
    TextView textview;
    ArrayList<String> arrayList;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        textview=findViewById(R.id.testView);

        // initialize array list
        arrayList=new ArrayList<>();

        // set value in array list
        arrayList.add("По популярности");
        arrayList.add("По ценам");
        arrayList.add("По оценке");


        textview.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            // Initialize dialog
                                            dialog = new Dialog(restaurants.this);

                                            // set custom dialog
                                            dialog.setContentView(R.layout.dialog_searchable_spinner);
                                            dialog.getWindow().setLayout(650, 800);

                                            // set transparent background
                                            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                                            // show dialog
                                            dialog.show();

                                            // Initialize and assign variable

                                            ListView listView = dialog.findViewById(R.id.list_view);

                                            // Initialize array adapter
                                            ArrayAdapter<String> adapter = new ArrayAdapter<>(restaurants.this, android.R.layout.simple_list_item_1, arrayList);

                                            // set adapter
                                            listView.setAdapter(adapter);
                                            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                                @Override
                                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                    // when item selected from list
                                                    // set selected item on textView
                                                    textview.setText(adapter.getItem(position));

                                                    // Dismiss dialog
                                                    dialog.dismiss();
                                                }
                                            });

                                        }
                                    });







        homeVerticalRec = findViewById(R.id.home_ver_rec);
        homeVerModelsList = new ArrayList<>();
        homeVerModelsList.add(new HomeVerModels(R.drawable.kfc, "Kfc", "5,0"));
        homeVerModelsList.add(new HomeVerModels(R.drawable.donalds, "McDonalds", "5,0"));
        homeVerModelsList.add(new HomeVerModels(R.drawable.burger, "Burger King", "4,8"));
        homeVerModelsList.add(new HomeVerModels(R.drawable.spotchoose, "Spot&Choos", "4,7"));
        homeVerModelsList.add(new HomeVerModels(R.drawable.newyork, "NewYork", "4,7"));
        homeVerAdapt = new HomeVerAdapt((Context) this, (ArrayList<HomeVerModels>) homeVerModelsList);
        homeVerticalRec.setAdapter(homeVerAdapt);
        homeVerticalRec.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    }


}
