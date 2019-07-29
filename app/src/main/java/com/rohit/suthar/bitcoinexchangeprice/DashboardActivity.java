package com.rohit.suthar.bitcoinexchangeprice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

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
        StringRequest vollStringRequest = new StringRequest(Request.Method.POST, API_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                updateView(response.trim());
            }
        },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("BT",error.toString());
                }
            }
        );
        Volley.newRequestQueue(mContext).add(vollStringRequest);
    }

    private void updateView(String res) {
        mTvPrice.setText(res);
    }
}
