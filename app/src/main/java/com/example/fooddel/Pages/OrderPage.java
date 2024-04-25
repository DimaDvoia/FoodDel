package com.example.fooddel.Pages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.fooddel.Pages.kfc_page;
import com.example.fooddel.R;
import com.example.fooddel.order;
import com.example.fooddel.ver2rec.ver2Models;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderPage extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference myRef;

    FirebaseUser user = mAuth.getInstance().getCurrentUser();


    Button btn;

    ListView orders_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);

        btn = findViewById(R.id.Upbtnnn);
        orders_list = findViewById(R.id.Orderslist1);

        List<String> courseTitle = new ArrayList<>();
        for (ver2Models c : kfc_page.Fullver2Models) {
            if (order.items_id.contains(c.getId()))
                courseTitle.add(c.getName());


        }

        orders_list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, courseTitle));
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                addOrdersToFirebase(orders_list);

            }
        });

    }

    public static void addOrdersToFirebase(ListView ordersList) {
        // Получить адаптер списка
        ArrayAdapter adapter = (ArrayAdapter) ordersList.getAdapter();

        // Создать список для элементов
        List<String> courseTitle = new ArrayList<>();

        // Перебрать элементы и добавить их в список
        for (int i = 0; i < adapter.getCount(); i++) {
            courseTitle.add(adapter.getItem(i).toString());
        }

        // Получить ссылку на местоположение в базе данных
        DatabaseReference ordersRef = FirebaseDatabase.getInstance().getReference().child("orders");

        // Создать уникальный идентификатор для каждой пачки
        String batchId = ordersRef.push().getKey();

        // Создать объект HashMap для пачки
        Map<String, Object> batchData = new HashMap<>();

        // Создать список для пачки элементов
        List<Map<String, Object>> ordersBatch = new ArrayList<>();

        // Добавить элементы в пачку
        for (String item : courseTitle) {
            // Создать объект HashMap для каждого заказа
            Map<String, Object> order = new HashMap<>();
            order.put("item", item);

            // Добавить объект в список пачки
            ordersBatch.add(order);
        }

        // Добавить список пачки в объект HashMap
        batchData.put(batchId, ordersBatch);

        // Сохранить пачку объектов в базе данных
        ordersRef.updateChildren(batchData);

    }
}
