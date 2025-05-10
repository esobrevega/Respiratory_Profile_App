package com.example.respiratoryprofileapp;

import android.content.res.Resources;
import android.graphics.Color;
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

public class BMI extends AppCompatActivity {

    String genderSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bmi);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Resources res = getResources();
        Drawable darkblue = ResourcesCompat.getDrawable(res, R.color.darkblue, null);
        Drawable white = ResourcesCompat.getDrawable(res, R.color.bgwhite,null);

        ImageButton male, female;
        Button  getBMIbtn;
        NumberPicker age, height, weight;
        TextView ansBMITV, getGender, getAge, getHeight, getWeight;

        ansBMITV = findViewById(R.id.ansBMI);
        getBMIbtn = findViewById(R.id.getBMIbtn);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        age = findViewById(R.id.age);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        getAge = findViewById(R.id.getAge);
        getHeight = findViewById(R.id.getHeight);
        getGender = findViewById(R.id.getGender);
        getWeight = findViewById(R.id.getWeight);

        age.setMaxValue(150);
        age.setMinValue(30);
        height.setMaxValue(250);
        height.setMinValue(100);
        weight.setMaxValue(150);
        weight.setMinValue(30);

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

        getBMIbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                height.clearFocus();
                age.clearFocus();
                weight.clearFocus();

                double dblHeigt = (double) height.getValue()/100;
                double dblWeight = (double) weight.getValue()/100;

                double resultBMI = (dblWeight / (dblHeigt*dblHeigt))*100;
                String sresultBMI = String.format("%.5f", resultBMI);
                String statusBMI = "";

                if (resultBMI < 18.5) statusBMI = "Underweight";
                else if (resultBMI < 25.0) statusBMI = "Normal";
                else if (resultBMI < 30) statusBMI = "Overweight";
                    else statusBMI = "Obese";

                ansBMITV.setText(sresultBMI + "  (" + statusBMI+ ")");
                getAge.setText("Age = " + age.getValue());
                getGender.setText("Gender = " + genderSelect);
                getHeight.setText("Height = " + height.getValue());
                getWeight.setText("Weight = " + weight.getValue());
            }
        });
    }
}