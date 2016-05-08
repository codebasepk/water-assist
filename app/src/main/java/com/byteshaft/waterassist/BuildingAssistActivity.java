package com.byteshaft.waterassist;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;


public class BuildingAssistActivity extends AppCompatActivity {

    private EditText details;
    private Button submitButton;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setBackgroundDrawable(new
                ColorDrawable(getResources().getColor(R.color.building_assist_pressed)));
        super.onCreate(savedInstanceState);
        setTitle("Building Assist");
        setContentView(R.layout.layout_building_assist);

        details = (EditText) findViewById(R.id.building_assist_et);
        submitButton = (Button) findViewById(R.id.btn_building_assist);
        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
    }
}
