package com.example.flowersorder;

import android.app.Activity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class flowersRadioButton {
    private TextView currentTextView;
    private RadioGroup radioGroup;
    private Order order;

    public flowersRadioButton(Activity activity, int textViewId, int radioGroupId, Order order) {
        currentTextView = activity.findViewById(textViewId);
        radioGroup = activity.findViewById(radioGroupId);
        this.order = order;

        radioButtonClick();
    }

    public void radioButtonClick() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton selectedRadio = group.findViewById(checkedId);
                if (selectedRadio != null && currentTextView != null) {
                    String text = selectedRadio.getText().toString();
                    switch(text) {
                        case "Маленький":
                            currentTextView.setText("Маленький");
                            break;
                        case "Средний":
                            currentTextView.setText("Средний");
                            break;
                        case "Большой":
                            currentTextView.setText("Большой");
                            break;
                    }
                    order.setRadioSelection(text);
                }
            }
        });
    }

    public String getSelectedSize() {
        if (radioGroup != null) {
            int selectedId = radioGroup.getCheckedRadioButtonId();
            if (selectedId != -1) {
                RadioButton selectedRadio = radioGroup.findViewById(selectedId);
                return selectedRadio.getText().toString();
            }
        }
        return "";
    }

}