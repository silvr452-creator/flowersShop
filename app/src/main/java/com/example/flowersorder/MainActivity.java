package com.example.flowersorder;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    final String TAG = "SHOW_LOG";
    final String[] flowers = { "Розы", "Тюльпаны", "Хризантемы", "Подсолнухы", "Кактусы"};
    private Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        order = new Order();

        TextView spiner = findViewById(R.id.flowersTextView);
        TextView radioButton = findViewById(R.id.tvradioOutput);
        TextView checkBox = findViewById(R.id.outChB);

        flowersSpinner flws = new flowersSpinner(this, R.id.spinner, flowers, spiner,order);
        flowersCheckBox flrchb = new flowersCheckBox(this, R.id.outChB, R.id.smallCheckBox, R.id.mediumCheckBox, R.id.bigCheckBox,order);
        flowersRadioButton flwrb = new flowersRadioButton(this, R.id.tvradioOutput, R.id.radioGroup, order);

    }

    public void submit (View view) {
        Intent intent = new Intent(this, CustomerActivity.class);
        intent.putExtra("ORDER", order);
        startActivity(intent);
    }
}