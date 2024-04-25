package com.example.fooddel.ui.ui.home;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.example.fooddel.R;
import com.example.fooddel.Pages.restaurantsPage;

public class fragment_home extends Fragment {

    ImageView imageh;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_fragment_home, container, false);

        imageh = root.findViewById(R.id.imageView3);
        imageh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), restaurantsPage.class);
                startActivity(intent);
            }
        });

        return root;
    }


}





