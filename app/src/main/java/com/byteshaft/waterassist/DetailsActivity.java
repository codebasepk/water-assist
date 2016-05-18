package com.byteshaft.waterassist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity implements CheckBox.OnCheckedChangeListener {

    private EditText name;
    private EditText address;
    private EditText postCode;
    private EditText homeNumber;
    private EditText mobileNumber;
    private EditText emailAddress;
    private EditText billingName;
    private EditText billingAddress;
    private Button saveButton;
    private CheckBox billing_name_checkBox;
    private CheckBox billing_address_checkBox;

    private String mName;
    private String mAddress;
    private String mPostCode;
    private String mHomeNumber;
    private String mMobileNumber;
    private String mEmailAddress;
    private String mBillingName;
    private String mBillingAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Provide details");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        overridePendingTransition(R.anim.anim_left_in, R.anim.anim_left_out);
        name = (EditText) findViewById(R.id.name);
        address = (EditText) findViewById(R.id.address);
        postCode = (EditText) findViewById(R.id.post_code);
        homeNumber = (EditText) findViewById(R.id.home_number);
        mobileNumber = (EditText) findViewById(R.id.mobile_number);
        emailAddress = (EditText) findViewById(R.id.email_address);
        billingName = (EditText) findViewById(R.id.billing_name);
        billingAddress = (EditText) findViewById(R.id.billing_address);
        saveButton = (Button) findViewById(R.id.button_save);
        billing_name_checkBox = (CheckBox) findViewById(R.id.checkbox_name);
        billing_address_checkBox = (CheckBox) findViewById(R.id.checkbox_address);
        billing_address_checkBox.setOnCheckedChangeListener(this);
        billing_name_checkBox.setOnCheckedChangeListener(this);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validateEdittext()) {
                    Toast.makeText(getApplicationContext(), "please provide all the details",
                            Toast.LENGTH_SHORT).show();
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Name: " + name.getText().toString());
                    sb.append("\n");
                    sb.append("Address: " + address.getText().toString());
                    sb.append("\n");
                    sb.append("Post code: " + postCode.getText().toString());
                    sb.append("\n");
                    sb.append("Home Number: " + homeNumber.getText().toString());
                    sb.append("\n");
                    sb.append("Mobile Number: " + mobileNumber.getText().toString());
                    sb.append("\n");
                    sb.append("Email Address: " + emailAddress.getText().toString());
                    sb.append("\n");

                    if (billing_name_checkBox.isChecked()) {
                        billingName.setText(mName);
                    } else {
                        sb.append("Billing Name :" + billingName.getText().toString());
                        sb.append("\n");
                    }

                    if (billing_address_checkBox.isChecked()) {
                        billingAddress.setText(mAddress);
                    } else {
                        sb.append("Billing Address :" + billingAddress.getText().toString());
                        sb.append("\n");
                    }

                    sb.append("\n");
                    sb.append("Details are: \n ");

                    Helpers.saveDataToSharedPreferences("basic", sb.toString());
                    Helpers.detailsStatus(true);
                    startActivity(new Intent(DetailsActivity.this, MainActivity.class));
                }

            }
        });
    }

    private boolean validateEdittext() {

        boolean valid = true;
        mName = name.getText().toString();
        mAddress = address.getText().toString();
        mPostCode = postCode.getText().toString();
        mHomeNumber = homeNumber.getText().toString();
        mMobileNumber = mobileNumber.getText().toString();
        mEmailAddress = emailAddress.getText().toString();
        mBillingName = billingName.getText().toString();
        mBillingAddress = billingAddress.getText().toString();

        if (mName.trim().isEmpty() || name.length() < 3) {
            name.setError("at least 3 characters");
            valid = false;
        } else {
            name.setError(null);
        }

        if (mAddress.trim().isEmpty() || mAddress.length() < 3) {
            address.setError("incorrect address");
            valid = false;
        } else {
            address.setError(null);
        }

        if (mPostCode.trim().isEmpty() || mPostCode.length() < 3) {
            postCode.setError("Enter post code");
            valid = false;
        } else {
            postCode.setError(null);
        }

        if (mHomeNumber.trim().isEmpty() || mHomeNumber.length() < 3) {
            homeNumber.setError("Enter Home Number");
            valid = false;
        } else {
            homeNumber.setError(null);
        }

        if (mMobileNumber.trim().isEmpty() || mMobileNumber.length() < 3) {
            mobileNumber.setError("Enter Mobile Number");
            valid = false;
        } else {
            mobileNumber.setError(null);
        }

        if (mEmailAddress.trim().isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(mEmailAddress).matches()) {
            emailAddress.setError("please provide a valid email");
            valid = false;
        } else {
            emailAddress.setError(null);
        }


        return valid;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.anim_right_in, R.anim.anim_right_out);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.checkbox_name:
                if (isChecked) {
                    System.out.println("Click");
                    billingName.setEnabled(false);
                    billingName.setText(null);
                } else {
                    billingName.setVisibility(View.VISIBLE);
                    billingName.setEnabled(true);
                }
                break;
            case R.id.checkbox_address:
                if (isChecked) {
                    System.out.println("Click");
                    billingAddress.setEnabled(false);
                    billingAddress.setText(null);
                } else {
                    billingAddress.setEnabled(true);
                }
                break;
        }
    }
}
