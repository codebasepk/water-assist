package com.byteshaft.waterassist;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class PlumberActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().setBackgroundDrawable(new
                ColorDrawable(getResources().getColor(R.color.plumber_normal)));
        super.onCreate(savedInstanceState);
        setTitle("Plumber Assist");
        setContentView(R.layout.layout_plumber_assist);
    }
}
