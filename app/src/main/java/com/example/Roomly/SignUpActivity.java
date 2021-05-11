package com.example.Roomly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    private Button signUpBtn;
    public static final String USER_EMAIL = "email";
    public static final String USER_NAME = "name";
    private EditText editEmail, editName, editPass, editPhone, editGroupName;
    private RadioGroup genderRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initView();

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, ProfileNavigationActivity.class);
                startActivity(intent);

                Toast.makeText(SignUpActivity.this, "Signed up successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        signUpBtn = findViewById(R.id.btn_sign_up);
        editEmail = findViewById(R.id.editEmail);
        editName = findViewById(R.id.editName);
        editPass = findViewById(R.id.editPassword);
        editPhone = findViewById(R.id.editPhone);
        editGroupName = findViewById(R.id.editGroupName);
        genderRadio = findViewById(R.id.radioGender);
    }
}