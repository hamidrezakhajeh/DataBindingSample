package com.hrkhajeh.databindingsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    public static final int MALE_ID = 0;
    public static final int FEMALE_ID = 1;
    private EditText editTextName, editTextLastName, editTextJob;
    private RadioButton radioButtonMale, radioButtonFeMale;
    private Button buttonLogin;
    private int gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });
    }

    private void initViews() {
        editTextName = (EditText) findViewById(R.id.name_EditText);
        editTextLastName = (EditText) findViewById(R.id.lastName_EditText);
        editTextJob = (EditText) findViewById(R.id.job_editText);
        radioButtonMale = (RadioButton) findViewById(R.id.male_radio);
        radioButtonFeMale = (RadioButton) findViewById(R.id.female_radio);
        buttonLogin = (Button) findViewById(R.id.login_button);
    }

    private void Login() {
        ///get views Value From User
        String name = editTextName.getText().toString();
        String lastName = editTextLastName.getText().toString();
        String job = editTextJob.getText().toString();

        ///get gender from radio buttons!
        radioButtonMale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    gender = MALE_ID;
                }
            }
        });

        radioButtonFeMale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    gender = FEMALE_ID;
                }
            }
        });


        if (!name.isEmpty() && !lastName.isEmpty() && !job.isEmpty()) {
            Intent intent = new Intent(this, ProfileActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("last_name", lastName);
            intent.putExtra("job", job);
            intent.putExtra("gender", gender);
            startActivity(intent);

        } else {
            Toast.makeText(this, "Please enter all the values", Toast.LENGTH_SHORT).show();
        }
    }
}
