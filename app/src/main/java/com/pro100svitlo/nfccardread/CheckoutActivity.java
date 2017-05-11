package com.pro100svitlo.nfccardread;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class CheckoutActivity extends AppCompatActivity {
    private Button registerTable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.registerTable = (Button) findViewById(R.id.register_table);
        this.registerTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CheckoutActivity.this, ScannerActivity.class);
                startActivity(i);
            }
        });
    }
}
