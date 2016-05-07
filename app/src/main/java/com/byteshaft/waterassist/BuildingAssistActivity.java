package com.byteshaft.waterassist;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class BuildingAssistActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setBackgroundDrawable(new
                ColorDrawable(getResources().getColor(R.color.building_assist_pressed)));
        setTitle("Building Assist");
        setContentView(R.layout.layout_building_assist);
    }
}
