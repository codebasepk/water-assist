package com.byteshaft.waterassist.drainassist;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.byteshaft.waterassist.R;

/**
 * Created by husnain on 5/7/16.
 */
public class SepticOrTreatmentTankActivity extends Activity implements RadioGroup.OnCheckedChangeListener {

    private Button button_submit;
    private RadioGroup radioGroup;
    private EditText editText;
    private RadioButton radioButton;
    private String radio_button_Text;
    private String details_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.septic_or_treatment_tank_activity);
        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        button_submit = (Button) findViewById(R.id.submit);
        editText = (EditText) findViewById(R.id.septic_or_treatment_tank_et);
        radioGroup.setOnCheckedChangeListener(this);

        details_text = editText.getText().toString();
        radio_button_Text = radioButton.getText().toString();

        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        radioButton = (RadioButton) findViewById(checkedId);
    }
}
