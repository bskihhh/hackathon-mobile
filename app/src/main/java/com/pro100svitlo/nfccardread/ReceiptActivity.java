package com.pro100svitlo.nfccardread;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.pro100svitlo.nfccardread.dto.OrderDetails;
import com.pro100svitlo.nfccardread.dto.OrderId;
import com.pro100svitlo.nfccardread.dto.Visit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by chenb on 5/11/17.
 */

public class ReceiptActivity extends Activity {

    private Button checkout;
    private TextView orderInfo;
    private String orderId;
    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_checkout);                // Set the scanner view as the content view
        checkout = (Button) findViewById(R.id.checkout);
        orderInfo = (TextView) findViewById(R.id.orderInfo);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoboPayClient goboPayClient = new Dependencies().getGoboPayClient();
                OrderId orderId = new OrderId();
                ReceiptActivity.this.orderId = getIntent().getStringExtra("orderId");
                orderId.setOrderId(ReceiptActivity.this.orderId);
                goboPayClient.checkout(orderId)
                        .enqueue(new Callback<OrderDetails>() {
                            @Override
                            public void onResponse(Call<OrderDetails> call, Response<OrderDetails> response) {
                                showOrderAndPayment (response.body());
                            }

                            @Override
                            public void onFailure(Call<OrderDetails> call, Throwable t) {
                                showOrderAndPayment (null);
                            }
                        });
            }
        });
    }

    private void showOrderAndPayment (OrderDetails visit) {
        orderInfo.setText(visit.toString());
        checkout.setText("Start NFC");
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ReceiptActivity.this, MainActivity.class);
                i.putExtra("orderId", ReceiptActivity.this.orderId);
                i.putExtra("totalAmount", 1000.00);
                startActivity(new Intent(ReceiptActivity.this, MainActivity.class));
            }
        });
    }

}
