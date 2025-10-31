package com.example.flowersorder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class DeliveryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);

        TextView type = findViewById(R.id.flowerType);
        TextView count = findViewById(R.id.flowersCount);
        TextView decor = findViewById(R.id.decorValue);

        TextView contacts = findViewById(R.id.contactValue);
        TextView delivery = findViewById(R.id.deliveryTimeValue);

        Order order = (Order) getIntent().getSerializableExtra("ORDER");

        if (order != null) {
            String getType = order.getSelectedFlower();
            String getCount = order.getRadioSelection();
            String getDecor = order.getCheckboxSelection();

            type.setText(getType);
            count.setText(getCount);
            decor.setText(getDecor);

            //Пользователь
            String getName = order.getCustomerName();
            String getTelephone = order.getCustomerPhone();
            String getAdress = order.getCustomerAddress();
            String getDeliveryDate = order.getCustomerDateDelivery();

            contacts.setText(getName + "\n" + getTelephone + "\n" + getAdress);
            delivery.setText(getDeliveryDate);
        }
    }

    public void back (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void submitOrder (View view){
        Toast.makeText(this, "Спасибо за заказ!", Toast.LENGTH_LONG).show();
    }
}