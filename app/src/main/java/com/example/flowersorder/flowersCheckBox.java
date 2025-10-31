package com.example.flowersorder;

import android.app.Activity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class flowersCheckBox {
    private CheckBox smallCheckBox;
    private CheckBox mediumCheckBox;
    private CheckBox bigCheckBox;
    private TextView textViewCheckBox;
    private Order order;

    flowersCheckBox(Activity activity, int tvCheckBox, int small, int medium, int big, Order order) {
        textViewCheckBox = activity.findViewById(tvCheckBox);
        smallCheckBox = activity.findViewById(small);
        mediumCheckBox = activity.findViewById(medium);
        bigCheckBox = activity.findViewById(big);
        this.order = order;

        setupCheckBoxListeners();

        // Инициализируем начальные данные
        updateAll();
    }

    private void setupCheckBoxListeners() {
        CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateAll();
            }
        };

        smallCheckBox.setOnCheckedChangeListener(listener);
        mediumCheckBox.setOnCheckedChangeListener(listener);
        bigCheckBox.setOnCheckedChangeListener(listener);
    }

    private void updateAll() {
        String selectedText = getTextCheckBox();
        updateTextView(selectedText);
        updateOrderData(selectedText);
    }

    private void updateTextView(String text) {
        if (textViewCheckBox != null) {
            textViewCheckBox.setText(text);
        }
    }

    private void updateOrderData(String text) {
        if (order != null) {
            order.setCheckboxSelection(text);
        }
    }

    public String getTextCheckBox() {
        StringBuilder selectedItems = new StringBuilder();

        if (smallCheckBox != null && smallCheckBox.isChecked()) {
            if (selectedItems.length() > 0) selectedItems.append(", ");
            selectedItems.append(smallCheckBox.getText().toString());
        }
        if (mediumCheckBox != null && mediumCheckBox.isChecked()) {
            if (selectedItems.length() > 0) selectedItems.append(", ");
            selectedItems.append(mediumCheckBox.getText().toString());
        }
        if (bigCheckBox != null && bigCheckBox.isChecked()) {
            if (selectedItems.length() > 0) selectedItems.append(", ");
            selectedItems.append(bigCheckBox.getText().toString());
        }

        return selectedItems.length() > 0 ? selectedItems.toString() : "Ничего не выбрано";
    }
}