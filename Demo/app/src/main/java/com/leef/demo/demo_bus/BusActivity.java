package com.leef.demo.demo_bus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


import com.leef.demo.R;
import com.leef.demo.demo_bus.event.TestEvent;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;

public class BusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);


    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        EventBus.getDefault().register(this);
    }

    public void onEvent(TestEvent event) {
        Log.e("Event", event.getWhat());
    }

    public void onEventMainThread(TestEvent event) {
        Log.e("EventMainThread", event.getWhat());
    }

    public void onEventBackgroundThread(TestEvent event) {
        Log.e("EventBackgroundThread", event.getWhat());
    }

    public void onEventAsync(TestEvent event) {
        Log.e("EventAsync", event.getWhat());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bus, menu);
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
