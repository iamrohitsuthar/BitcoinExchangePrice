package com.rohit.suthar.bitcoinexchangeprice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {
    private Context mContext;
    private TextView mTvPrice;
    private String API_URL = "https://apiv2.bitcoinaverage.com/indices/global/ticker/BTCUSD";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        initialize();
    }

    private void initialize() {
        mContext = DashboardActivity.this;
        mTvPrice = findViewById(R.id.tv_price);
    }

    private void fetchData() {
        //make volley request
    }

    private void updateView() {

    }
}
