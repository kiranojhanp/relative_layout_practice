package com.example.gharmarket;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    Button first,exit;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        first = findViewById(R.id.btnPress);
        exit = findViewById(R.id.btnExit);

        builder = new AlertDialog.Builder(this);

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = "Kiran Ojha";
                Intent i = new Intent(FirstActivity.this, SecondActivity.class);
                i.putExtra("key" , name);
                startActivity(i);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setMessage("Do you want to close this application?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                                Toast.makeText(FirstActivity.this, "You clicked Yes", Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                Toast.makeText(FirstActivity.this, "You clicked No", Toast.LENGTH_LONG).show();
                            }
                        });

                // Create dialog box
                AlertDialog alert = builder.create();
                alert.setTitle("My title");
                alert.show();
            }
        });
    }
}
