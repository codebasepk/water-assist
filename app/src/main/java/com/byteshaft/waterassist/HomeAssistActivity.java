package com.byteshaft.waterassist;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class HomeAssistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setBackgroundDrawable(new
                ColorDrawable(getResources().getColor(R.color.home_assist_normal)));
        super.onCreate(savedInstanceState);
        setTitle("Home Assist");
        setContentView(R.layout.layout_home_assist);
    }
}
