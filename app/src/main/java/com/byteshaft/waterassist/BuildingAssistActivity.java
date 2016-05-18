package com.byteshaft.waterassist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;


public class BuildingAssistActivity extends Activity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    private EditText details;
    private Button submitButton;
    private RadioGroup radioGroup;
    private String mRadioText;
    private String mReceiverEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_building_assist);
        overridePendingTransition(R.anim.anim_left_in, R.anim.anim_left_out);
        mReceiverEmail = getString(R.string.email_string);

        details = (EditText) findViewById(R.id.building_assist_et);
        submitButton = (Button) findViewById(R.id.submit);
        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        submitButton.setOnClickListener(this);
        radioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        switch (checkedId) {
            case R.id.building_survey:
                mRadioText = "Building Survey";
                break;

            case R.id.repair_survey:
                mRadioText = "Repair Survey";
                break;

            case R.id.insurance_survey:
                mRadioText = "Insurance Survey";
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.submit:
                String finalMessage = details.getText().toString();
                System.out.println(mRadioText + finalMessage);

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{mReceiverEmail});
                intent.putExtra(Intent.EXTRA_SUBJECT, mRadioText);
                intent.putExtra(Intent.EXTRA_TEXT, finalMessage);
                startActivity(Intent.createChooser(intent, "Send Email"));
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.anim_right_in, R.anim.anim_right_out);
    }
}
