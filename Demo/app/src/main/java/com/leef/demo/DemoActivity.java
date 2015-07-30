package com.leef.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.leef.demo.demo_bitmaps.BitmapsActivity;
import com.leef.demo.demo_gridview.GridViewActivity;
import com.leef.demo.demo_loadmore.LoadMoreActivity;
import com.leef.demo.demo_mvp.view.UserActivity;
import com.leef.demo.demo_recyclerview.RecyclerViewActivity;
import com.leef.demo.demo_rxandroid.RxAndroidActivity;
import com.leef.demo.demo_volley_okhttp.NetworkActivity;

public class DemoActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        initView();
    }

    private void initView() {
        findViewById(R.id.demo_gridview).setOnClickListener(this);
        findViewById(R.id.demo_loadmore).setOnClickListener(this);
        findViewById(R.id.demo_volley_okhttp).setOnClickListener(this);
        findViewById(R.id.demo_bitmap).setOnClickListener(this);
        findViewById(R.id.demo_recycler).setOnClickListener(this);
        findViewById(R.id.demo_mvp).setOnClickListener(this);
        findViewById(R.id.demo_rx_android).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_demo, menu);
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.demo_gridview:
                startActivity(new Intent(this, GridViewActivity.class));
                break;
            case R.id.demo_loadmore:
                startActivity(new Intent(this, LoadMoreActivity.class));
                break;
            case R.id.demo_volley_okhttp:
                startActivity(new Intent(this, NetworkActivity.class));
                break;
            case R.id.demo_bitmap:
                startActivity(new Intent(this, BitmapsActivity.class));
                break;
            case R.id.demo_recycler:
                startActivity(new Intent(this, RecyclerViewActivity.class));
                break;
            case R.id.demo_mvp:
                startActivity(new Intent(this, UserActivity.class));
                break;
            case R.id.demo_rx_android:
                startActivity(new Intent(this, RxAndroidActivity.class));
                break;
            default:
                break;
        }
    }
}
