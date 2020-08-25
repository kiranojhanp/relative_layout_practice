package com.example.gharmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    Button second;
    TextView name;
    Spinner spinCountry;
    AutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        second = findViewById(R.id.btnBack);
        name = findViewById(R.id.name);

        autoCompleteTextView = findViewById(R.id.searchField);
        SearchBar();

        spinCountry = findViewById(R.id.spinCountry);
        spinnerWidget();

        Intent i = getIntent();
        String str = i.getStringExtra("key");

        name.setText(str);

        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void spinnerWidget(){
        String countries[] = {"Nepal", "India", "China", "Uk", "US"};
        ArrayAdapter adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                countries
        );
        spinCountry.setAdapter(adapter);
    }

    private void SearchBar() {
        String language[] = {"C", "C#", "Nodejs", "Java", "Swift", "Python", "Asp.net", "Php"};
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.select_dialog_item,
                language
        );
        autoCompleteTextView.setAdapter(stringArrayAdapter);
        autoCompleteTextView.setThreshold(1);
    }
}
