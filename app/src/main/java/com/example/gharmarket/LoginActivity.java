package com.example.gharmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText etFirst, etSecond;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setupUI();
        setListener();
    }

    private void setupUI(){
        etFirst = findViewById(R.id.email);
        etSecond = findViewById(R.id.password);
        btnAdd = findViewById(R.id.btnAdd);
    }

    private void setListener() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int res = Integer.parseInt(etFirst.getText().toString()) + Integer.parseInt(etSecond.getText().toString());
                Toast.makeText(LoginActivity.this, "The sum is " + res, Toast.LENGTH_LONG).show();
            }
        });
    }
}

