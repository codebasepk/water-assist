package com.byteshaft.waterassist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetailsActivity extends AppCompatActivity {

    private EditText name;
    private EditText address;
    private EditText postCode;
    private EditText homeNumber;
    private EditText mobileNumber;
    private EditText emailAddress;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Provide details");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        name = (EditText) findViewById(R.id.name);
        address = (EditText) findViewById(R.id.address);
        postCode = (EditText) findViewById(R.id.post_code);
        homeNumber = (EditText) findViewById(R.id.home_number);
        mobileNumber = (EditText) findViewById(R.id.mobile_number);
        emailAddress = (EditText) findViewById(R.id.email_address);
        saveButton = (Button) findViewById(R.id.button_save);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder sb = new StringBuilder();
                sb.append(name.getText().toString());
                sb.append("\n");
                sb.append(address.getText().toString());
                sb.append("\n");
                sb.append(postCode.getText().toString());
                sb.append("\n");
                sb.append(homeNumber.getText().toString());
                sb.append("\n");
                sb.append(mobileNumber.getText().toString());
                sb.append("\n");
                sb.append(emailAddress.getText().toString());
                sb.append("\n");
                Helpers.saveDataToSharedPreferences("basic", sb.toString());

            }
        });
    }
}
