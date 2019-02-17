package com.hrkhajeh.databindingsample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.hrkhajeh.databindingsample.databinding.ActivityProfileBinding;

import static com.hrkhajeh.databindingsample.LoginActivity.MALE_ID;

public class ProfileActivity extends AppCompatActivity {
    private String userName, userLastName, userJob;
    private int userGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ///get login values
        getUserInfoFromLoginPage();

        ///create data model from login values
        Person person = new Person();
        person.setPersonName("Name: " + userName);
        person.setPersonLastName("LastName: " + userLastName);
        person.setPersonJob("Job: " + userJob);
        if (userGender == MALE_ID) {
            person.setPersonGender("Gender: Male");

        } else {
            person.setPersonGender("Gender: Female");
        }

        ///data Binding!
        ActivityProfileBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_profile);
        binding.setPerson(person);
    }

    private void getUserInfoFromLoginPage() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            userName = bundle.getString("name");
            userLastName = bundle.getString("last_name");
            userJob = bundle.getString("job");
            userGender = bundle.getInt("gender");
        }
    }
}
