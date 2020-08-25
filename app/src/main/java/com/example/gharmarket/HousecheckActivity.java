package com.example.gharmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class HousecheckActivity extends AppCompatActivity implements View.OnClickListener {
    RadioButton house1, house2, house3;
    ImageView houseImgview;
    Button loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_housecheck);

        house1 = findViewById(R.id.house1);
        house2 = findViewById(R.id.house2);
        house3 = findViewById(R.id.house3);

        loginbtn = (Button) findViewById(R.id.btnLogin);

        houseImgview = findViewById(R.id.houseImgview);

        house1.setOnClickListener(this);
        house2.setOnClickListener(this);
        house3.setOnClickListener(this);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(HousecheckActivity.this, "You clicked No", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(HousecheckActivity.this, LoginActivity.class);
//                i.putExtra(EXTRA_MESSAGE, "Kiran Ojha");
                startActivity(i);
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.house1:
                houseImgview.setImageResource(R.drawable.house);
                break;

            case R.id.house2:
                houseImgview.setImageResource(R.drawable.house2);
                break;

            case R.id.house3:
                houseImgview.setImageResource(R.drawable.house3);
                break;
        }
    }
}
