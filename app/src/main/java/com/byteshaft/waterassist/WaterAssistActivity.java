package com.byteshaft.waterassist;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class WaterAssistActivity extends Activity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {


    RadioGroup radioGroup;
    EditText details;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_water_assist);
        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        details = (EditText) findViewById(R.id.water_assist_et);
        submitButton = (Button) findViewById(R.id.submit);
        radioGroup.setOnCheckedChangeListener(this);
        submitButton.setOnClickListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        switch (checkedId) {
            case R.id.repair_to_leaking:
                break;
            case R.id.renewal_pipe:
                break;
            case R.id.new_installation:
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.submit:
                // TODO: 09/05/2016
        }
    }
}
