package com.example.gharmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.util.Patterns.*;

public class LoginActivity extends AppCompatActivity {
    private EditText email, password;
    private Button btnLogin;
//    private RadioButton rdoSum, rdoSub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setupUI();
        setListener();
    }

    private void setupUI() {
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnAdd);
//        rdoSum = findViewById(R.id.sum);
//        rdoSub = findViewById(R.id.sub);
    }

    private void setListener() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValid()) {
                    String emailTxt = email.getText().toString();
                    String passwordTxt = password.getText().toString();
                    String res = emailTxt + passwordTxt;
//                    if (rdoSum.isChecked()){
//                        Toast.makeText(LoginActivity.this, "Sum ", Toast.LENGTH_LONG).show();
//                    } else {
//                        Toast.makeText(LoginActivity.this, "Subtraction" , Toast.LENGTH_LONG).show();
//                    }
                    // Toast.makeText(context, text, duration).show()
                    Toast.makeText(LoginActivity.this, "The sum is " + res, Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    private boolean isValid() {
        boolean flag = true;
        if (TextUtils.isEmpty(email.getText().toString())) {
            email.setError("Email can't be left empty");
            email.requestFocus();
            flag = false;
        } else if (TextUtils.isEmpty(password.getText().toString())) {
            password.setError("Password can't be left empty");
            password.requestFocus();
            flag = false;
        } else if (!isEmail(email.getText().toString())) {
            email.setError("Email isn't valid");
            email.requestFocus();
            flag = false;
        }
        else if(!isPasswordValid(password.getText().toString())){
            password.setError("Password isn't valid");
            password.requestFocus();
            flag = false;
        }
        return flag;
    }

    private boolean isEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    private boolean isPasswordValid(String password){
//                 ^                # start-of-string
//                (?=.*[0-9])       # a digit must occur at least once
//                (?=.*[a-z])       # a lower case letter must occur at least once
//                (?=.*[A-Z])       # an upper case letter must occur at least once
//                (?=.*[@#$%^&+=])  # a special character must occur at least once
//                (?=\S+$)          # no whitespace allowed in the entire string
//                .{8,}             # anything, at least eight places though
//                 $                # end-of-string

        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        return password.matches(regex);
    }

}

