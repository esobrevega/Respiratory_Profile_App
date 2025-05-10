package com.example.respiratoryprofileapp;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class IdealBodyWeight extends AppCompatActivity {

    String genderSelect;
    String devine;
    Double Ddevine, Drobinson, Dmiller, Dhamwi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ideal_body_weight);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Resources res = getResources();
        Drawable darkblue = ResourcesCompat.getDrawable(res, R.color.darkblue, null);
        Drawable white = ResourcesCompat.getDrawable(res, R.color.bgwhite,null);

        ImageButton male, female;
        Button getIBWbtn;
        NumberPicker height;
        TextView devineIBW, robinsonIBW, millerIBW, hamwiIBW, getGender, getHeight;

        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        height = findViewById(R.id.height);
        getIBWbtn = findViewById(R.id.getIDWbtn);
        devineIBW = findViewById(R.id.devineIBW);
        robinsonIBW = findViewById(R.id.robinsonIBW);
        millerIBW = findViewById(R.id.millerIBW);
        hamwiIBW = findViewById(R.id.hamwiIBW);
        getGender = findViewById(R.id.getGender);
        getHeight = findViewById(R.id.getHeight);

        height.setMaxValue(250);
        height.setMinValue(100);

        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                male.setBackground(darkblue);
                female.setBackground(white);
                genderSelect = "M";
            }
        });

        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                female.setBackground(darkblue);
                male.setBackground(white);
                genderSelect = "F";
            }
        });

        getIBWbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                height.clearFocus();
                getGender.setText("Gender = " + genderSelect);
                getHeight.setText("Weight = " + height.getValue());

                if (Objects.equals(genderSelect, "M")){
                    Ddevine = 50.0 + 2.3 * ((height.getValue() - 152.4)/2.54);
                    //50 + (0.91 * height.getValue() - 152.4)
                    devineIBW.setText(String.format("%.5f", Ddevine) + " kg");

                    Drobinson = 52.0 + 1.9 * ((height.getValue() - 152.4)/2.54);
                    robinsonIBW.setText(String.format("%.5f", Drobinson) + " kg");

                    Dmiller = 56.2 + 1.41 * ((height.getValue() - 152.4)/2.54);
                    millerIBW.setText(String.format("%.5f", Dmiller) + " kg");

                    Dhamwi = 48.0 + 2.7 * ((height.getValue() - 152.4)/2.54);
                    hamwiIBW.setText(String.format("%.5f", Dhamwi) + " kg");
                }
                if (Objects.equals(genderSelect, "F")) {
                    Ddevine = 45.5 + (0.91 * (height.getValue() - 152.4));
                    devineIBW.setText(String.format("%.5f", Ddevine) + " kg");

                    Drobinson = 49 + 1.7 * ((height.getValue() - 152.4)/2.54);
                    robinsonIBW.setText(String.format("%.5f", Drobinson) + " kg");

                    Dmiller = 53.1 + 1.36 * ((height.getValue() - 152.4)/2.54);
                    millerIBW.setText(String.format("%.5f", Dmiller) + " kg");

                    Dhamwi = 45.5 + 2.2 * ((height.getValue() - 152.4)/2.54);
                    hamwiIBW.setText(String.format("%.5f", Dhamwi) + " kg");
                }
            }
        });

    }
}