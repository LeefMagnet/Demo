package com.leef.demo.demo_recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.alibaba.fastjson.JSON;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.leef.demo.MyApplication;
import com.leef.demo.R;
import com.leef.demo.demo_recyclerview.model.PixivDR;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    static String pixiv = "http://www.moe123.com/widget/pixiv_daily.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        getDaily();
    }

    private void getDaily() {
        Request request = new StringRequest(Request.Method.GET, pixiv,
                new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        ArrayList<PixivDR> daily = null;
                        try {
                            daily = new ArrayList<>(JSON.parseArray(response, PixivDR.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (daily != null) {
                            Log.e("Pixiv", daily.get(0).toString());
                        }
                    }
                },
                new com.android.volley.Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        MyApplication.queue.add(request);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_recycler_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
