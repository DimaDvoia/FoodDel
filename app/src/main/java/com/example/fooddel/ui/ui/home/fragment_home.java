package com.example.fooddel.ui.ui.home;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.FragmentNavigator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;



import com.example.fooddel.MainActivity;
import com.example.fooddel.R;
import com.example.fooddel.login;
import com.example.fooddel.register;
import com.example.fooddel.restaurants;

public class fragment_home extends Fragment {

    ImageView imageh;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_fragment_home, container, false);

        imageh = root.findViewById(R.id.imageView3);
        imageh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), restaurants.class);
                startActivity(intent);
            }
        });

        return root;
    }


}





