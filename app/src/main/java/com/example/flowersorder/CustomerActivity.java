package com.example.flowersorder;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CustomerActivity extends AppCompatActivity {
    final String TAG = "SHOW_LOG";
    private Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
    }

    public void next (View view) {
        EditText name = (EditText) findViewById(R.id.nameEditText);
        EditText adress = (EditText) findViewById(R.id.addressEditText);
        EditText telephone = (EditText) findViewById(R.id.phoneEditText);
        EditText deliveryDate = (EditText) findViewById(R.id.deliveryDateEditText);


        order = (Order) getIntent().getSerializableExtra("ORDER");

        try {
            String getName = name.getText().toString();
            String getAdress = adress.getText().toString();
            String getTelephone = telephone.getText().toString();
            String getDeliveryDate = deliveryDate.getText().toString();

            if (name.getText().toString().isEmpty()) {
                Toast.makeText(this, "Введите имя", Toast.LENGTH_SHORT).show();
                return;
            }
            if (adress.getText().toString().isEmpty()) {
                Toast.makeText(this, "Введите адрес", Toast.LENGTH_SHORT).show();
                return;
            }
            if (telephone.getText().toString().isEmpty()) {
                Toast.makeText(this, "Введите телефон", Toast.LENGTH_SHORT).show();
                return;
            }
            if (deliveryDate.getText().toString().isEmpty()) {
                Toast.makeText(this, "Введите дату доставки", Toast.LENGTH_SHORT).show();
                return;
            }

            order.setCustomerName(getName);
            order.setCustomerPhone(getTelephone);
            order.setCustomerAddress(getAdress);
            order.setCustomerDateDelivery(getDeliveryDate);

            Intent intent = new Intent(this, DeliveryActivity.class);
            intent.putExtra("ORDER", order);

            startActivity(intent);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage().toString());
        }
    }


}