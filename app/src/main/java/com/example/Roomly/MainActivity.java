package com.example.Roomly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String USER_EMAIL = "email";
    public static final String USER_PASS = "pass";

    EditText editEmail, editPass;
    Button loginBtn, signUpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editEmail.getText().toString();
                String pass = editPass.getText().toString();
                if(validateUser(email,pass)) {
                    Intent intent = new Intent(MainActivity.this, ProfileNavigationActivity.class);
                    intent.putExtra(USER_EMAIL, email);
                    intent.putExtra(USER_PASS, pass);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Welcome back", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Please check email or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    private boolean validateUser(String email, String pass) {
        //TODO: add real function to check email and password
        return (email.toLowerCase().equals("rossgeller@gmail.com") && pass.equals("123"));
    }

    private void initView() {

        editEmail = findViewById(R.id.editTextEmail);
        editPass = findViewById(R.id.editTextPassword);
        loginBtn = findViewById(R.id.loginBtn);
        signUpBtn = findViewById(R.id.signUpBtn);

        editEmail.setText(R.string.rossEmail);
        editPass.setText(R.string.rossPass);
    }
}