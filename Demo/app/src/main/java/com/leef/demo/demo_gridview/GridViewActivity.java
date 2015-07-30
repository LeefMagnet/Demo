package com.leef.demo.demo_gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import com.leef.demo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class GridViewActivity extends AppCompatActivity {
    List<Map<String, Object>> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        initPreData();
        initView();
    }

    private void initPreData() {
        list = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            Map<String, Object> map = new HashMap<>();
            if (i % 2 == 0) {
                map.put("image", R.mipmap.ic_launcher);
                map.put("text", "number " + i + " is Even ");
                list.add(map);
            } else {
                map.put("image", R.mipmap.ic_launcher);
                map.put("text", "number = " + i);
                list.add(map);
            }
        }
    }

    private void initView() {
        NoScrollGridView mGridView = (NoScrollGridView) findViewById(R.id.gridview);
        ChildItemGridviewAdapter mAdapter = new ChildItemGridviewAdapter(this, list);
        mGridView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_grid_view, menu);
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
