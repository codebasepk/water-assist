package com.byteshaft.waterassist;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class PlumberActivity extends Activity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {


    RadioGroup radioGroup;
    EditText details;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_plumber_assist);

        radioGroup = (RadioGroup) findViewById(R.id.radio_group_plumber_assist);
        details = (EditText) findViewById(R.id.plumber_assist_et);
        submitButton = (Button) findViewById(R.id.submit);
        radioGroup.setOnCheckedChangeListener(this);
        submitButton.setOnClickListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        switch (checkedId) {
            case R.id.repair_plumbing:
                break;
            case R.id.renewal_of_plumbing_installation:
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.submit:
                // TODO: 09/05/2016 code for sending email
        }
    }
}
