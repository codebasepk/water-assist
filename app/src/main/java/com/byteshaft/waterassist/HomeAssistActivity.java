package com.byteshaft.waterassist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class HomeAssistActivity extends Activity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    RadioGroup radioGroup;
    EditText details;
    Button submitButton;
    private String mRadioText;
    private String mReceverEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_home_assist);
        mReceverEmail = getString(R.string.email_string);
        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        details = (EditText) findViewById(R.id.home_assist_et);
        submitButton = (Button) findViewById(R.id.submit);
        radioGroup.setOnCheckedChangeListener(this);
        submitButton.setOnClickListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        switch (checkedId) {
            case R.id.home_buyer_survey:
                mRadioText = "Home Buyer Survey";
                break;
            case R.id.home_buyer_drain_survey:
                mRadioText = "Home Buyer Drain Survey";
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
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {mReceverEmail});
                intent.putExtra(Intent.EXTRA_SUBJECT, mRadioText);
                intent.putExtra(Intent.EXTRA_TEXT, finalMessage);
                startActivity(Intent.createChooser(intent, "Send Email"));
                break;
        }
    }
}
