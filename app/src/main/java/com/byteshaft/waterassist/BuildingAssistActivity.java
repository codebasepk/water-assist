package com.byteshaft.waterassist;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;


public class BuildingAssistActivity extends Activity {

    private EditText details;
    private Button submitButton;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_building_assist);

        details = (EditText) findViewById(R.id.building_assist_et);
        submitButton = (Button) findViewById(R.id.submit);
        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
    }
}
