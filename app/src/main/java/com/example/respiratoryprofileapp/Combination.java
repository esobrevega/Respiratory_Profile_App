package com.example.respiratoryprofileapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Combination extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_combination);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        LinearLayout CombiLinear;

        CombiLinear = findViewById(R.id.atvLinear);

        CardView cardView = new CardView(this);
        LinearLayout.LayoutParams cardViewParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        cardView.setLayoutParams(cardViewParams);

        ViewGroup.MarginLayoutParams cardViewMarginParams = (ViewGroup.MarginLayoutParams) cardView.getLayoutParams();
        cardViewMarginParams.setMargins(50, 50, 50, 50);
        cardView.requestLayout();

        cardView.setLayoutParams(cardViewParams);
        cardView.setRadius(20);

        CombiLinear.addView(cardView);

        LayoutInflater inflater = (LayoutInflater)
                this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View myView = inflater.inflate(R.layout.activity_ideal_body_weight,null,false);
        cardView.addView(myView);
    }
}