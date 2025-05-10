package com.example.respiratoryprofileapp;

import static com.google.android.material.internal.ContextUtils.getActivity;

import android.accessibilityservice.AccessibilityService;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class ATV extends AppCompatActivity {

    String genderSelect;

    Double DIBW, DETT, DTV1, DTV2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_atv);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Resources res = getResources();
        Drawable darkblue = ResourcesCompat.getDrawable(res, R.color.darkblue, null);
        Drawable white = ResourcesCompat.getDrawable(res, R.color.bgwhite,null);

        Button TVbtn;
        TextView IBW, ETT, TV;
        ImageButton male, female;
        NumberPicker height;

        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        height = findViewById(R.id.height);
        TVbtn = findViewById(R.id.TVbtn);
        IBW = findViewById(R.id.IBW);
        ETT = findViewById(R.id.ETT);
        TV = findViewById(R.id.TV);

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


        TVbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                height.clearFocus();

                DETT = 0.1 * height.getValue() + 4;
                ETT.setText(String.format("%.2f",DETT) + " cm");

                if (Objects.equals(genderSelect, "M")) {
                    DIBW = 50.0 + 2.3 * ((height.getValue() - 152.4) / 2.54);
                    IBW.setText(String.format("%.5f", DIBW) + " kg");
                    DTV1 = DIBW * 6;
                    DTV2 = DIBW * 8;

                    TV.setText("Target tidal volume ranges from " + String.format("%.2f", DTV1) + " mL to " + String.format("%.2f", DTV2) + " mL");

                }

                if (Objects.equals(genderSelect, "F")) {
                    DIBW = 45.5 + (0.91 * (height.getValue() - 152.4));
                    IBW.setText(String.format("%.5f", DIBW) + " kg");
                    DTV1 = DIBW * 6;
                    DTV2 = DIBW * 8;

                    TV.setText("Target tidal volume ranges from " + String.format("%.2f", DTV1) + " mL to " + String.format("%.2f", DTV2) + " mL");
                }

            }
        });



    }
}