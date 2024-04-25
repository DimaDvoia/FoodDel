package com.example.fooddel.Pages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fooddel.R;
import com.example.fooddel.order;

public class tovarPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tovar);

        ImageView image1 = findViewById(R.id.TovarIMG);
        TextView name = findViewById(R.id.NameBURG);
        TextView descrip = findViewById(R.id.descripburg1);
        TextView price = findViewById(R.id.price1);

        image1.setImageResource(getIntent().getIntExtra("Image", 0));
        name.setText(getIntent().getStringExtra("Name" ));
        descrip.setText(getIntent().getStringExtra("Descrip"));
        price.setText(getIntent().getStringExtra("Price"));

    }


    public void addToCart(View view){
        int item_id = getIntent().getIntExtra("ID", 0);
        order.items_id.add(item_id);
        Toast.makeText(this, "Добавлено!", Toast.LENGTH_LONG).show();
    }
}