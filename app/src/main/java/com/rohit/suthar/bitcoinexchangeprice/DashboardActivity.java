package com.rohit.suthar.bitcoinexchangeprice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class DashboardActivity extends AppCompatActivity {
    private Context mContext;
    private TextView mTvPrice;
    private String API_URL = "https://apiv2.bitcoinaverage.com/indices/global/ticker/BTCUSD";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        initialize();
        fetchData();
    }

    private void initialize() {
        mContext = DashboardActivity.this;
        mTvPrice = findViewById(R.id.tv_price);
    }

    private void fetchData() {
        //make volley request
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, API_URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("BT",response.toString());
            }
        },
        new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Volley.newRequestQueue(mContext).add(jsonObjectRequest);
    }

    private void updateView(String res) {
        mTvPrice.setText(res);
    }
}
