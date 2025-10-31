package com.example.flowersorder;

import android.app.Activity;
import android.view.View;
import android.widget.*;

public class flowersSpinner {
    private Spinner spinner;
    private String selectedFlower;
    private ArrayAdapter<String>adapter;
    private Order order;

    public flowersSpinner(Activity activity, int spinnerId, String[] flowers, TextView currentTextView, Order order) {
        spinner = activity.findViewById(spinnerId);
        this.order = order;

        adapter = new ArrayAdapter<>(activity, android.R.layout.simple_spinner_item, flowers);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedFlower = (String) parent.getItemAtPosition(position);
                if (currentTextView != null) {
                    currentTextView.setText(selectedFlower);
                }
                order.setSelectedFlower(selectedFlower);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public String getSelectedFlower() {
        return selectedFlower;
    }

    // Метод для установки выбранного элемента
    public void setSelectedFlower(String flower) {
        int position = adapter.getPosition(flower);
        if (position >= 0) {
            spinner.setSelection(position);
        }
    }

}
