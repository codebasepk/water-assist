package com.byteshaft.waterassist.drainassist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.byteshaft.waterassist.Helpers;
import com.byteshaft.waterassist.R;

public class DrainageSurveyActivity extends Activity implements RadioGroup.OnCheckedChangeListener {

    private Button button_submit;
    private RadioGroup radioGroup;
    private EditText editText;
    private RadioButton radioButton;
    private String details_text;

    private String mReceverEmail;
    private String radio_button_Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drainage_survey_activity);
        overridePendingTransition(R.anim.anim_left_in, R.anim.anim_left_out);
        mReceverEmail = getString(R.string.email_string);
        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        button_submit = (Button) findViewById(R.id.submit);
        editText = (EditText) findViewById(R.id.drainage_survey_et);
        radioGroup.setOnCheckedChangeListener(this);

        details_text = editText.getText().toString();

        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String finalMessage = Helpers.getStringFromSharedPreferences("basic") +
                        editText.getText().toString();
                System.out.println(radio_button_Text + finalMessage);

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {mReceverEmail});
                intent.putExtra(Intent.EXTRA_SUBJECT, radio_button_Text);
                intent.putExtra(Intent.EXTRA_TEXT, finalMessage);
                startActivity(Intent.createChooser(intent, "Send Email"));
            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        radioButton = (RadioButton) findViewById(checkedId);
        radio_button_Text = radioButton.getText().toString();
        System.out.println(radio_button_Text);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.anim_right_in, R.anim.anim_right_out);
    }
}
