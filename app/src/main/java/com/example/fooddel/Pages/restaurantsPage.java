package com.example.fooddel.Pages;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.fooddel.R;
import com.example.fooddel.VerticalRes.HomeVerAdapt;
import com.example.fooddel.VerticalRes.HomeVerModels;

import java.util.ArrayList;
import java.util.List;

public class restaurantsPage extends AppCompatActivity {


    RecyclerView homeVerticalRec;
    // объявляю список с молями данных
    static List<HomeVerModels> homeVerModelsList;
    // объявляю адаптер
    static HomeVerAdapt homeVerAdapt;
    TextView textview;
    static ArrayList<String> arrayList = new ArrayList<>();
    Dialog dialog;
    EditText editText7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        textview = findViewById(R.id.testView);
        // инициализируем список
        homeVerticalRec = findViewById(R.id.home_ver_rec);
        // создаем новый массив
        homeVerModelsList = new ArrayList<>();
        //добавляем данные в список
        homeVerModelsList.add(new HomeVerModels(R.drawable.kfc, "Kfc", "5,0", 2));
        homeVerModelsList.add(new HomeVerModels(R.drawable.donalds, "McDonalds", "5,0", 3));
        homeVerModelsList.add(new HomeVerModels(R.drawable.burger, "Burger King", "4,8", 3));
        homeVerModelsList.add(new HomeVerModels(R.drawable.spotchoose, "Spot&Choos", "4,7", 3));
        homeVerModelsList.add(new HomeVerModels(R.drawable.newyork, "NewYork", "4,7", 1));
        // применяем данные к адаптеру
        homeVerAdapt = new HomeVerAdapt((Context) this, (ArrayList<HomeVerModels>) homeVerModelsList);
        homeVerticalRec.setAdapter(homeVerAdapt);
        homeVerticalRec.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView =(SearchView) searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                homeVerAdapt.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
}