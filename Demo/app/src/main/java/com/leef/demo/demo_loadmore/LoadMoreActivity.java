package com.leef.demo.demo_loadmore;

import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.leef.demo.R;

import java.util.ArrayList;


public class LoadMoreActivity extends AppCompatActivity implements EListView.ILoadListener {

    ArrayList<PersonBean> arrays;

    EListView mListView;
    EListViewAdapter mAdapter;
    Context mContext;
    int current = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_more);

        mContext = this;
        mListView = (EListView) findViewById(R.id.expand_list);
        mListView.setInterface(this);

        arrays = new ArrayList<>();
        getData();
        showEListView(arrays);
    }

    private void showEListView(ArrayList<PersonBean> arrays) {
        if (mAdapter == null) {
            mAdapter = new EListViewAdapter(mContext, arrays);
            mListView.setAdapter(mAdapter);
        } else {
            mAdapter.onDataChanged(arrays);
        }
    }

    private void getData() {
        getLoadData();
        showEListView(arrays);
        mListView.loadComplete();
    }

    private void getLoadData() {
        ArrayList<PersonBean> beans = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            PersonBean p = new PersonBean();
            p.setName("ABC" + i);
            p.setGender(0);
            p.setAge(20 + (i * 2));
            beans.add(p);
        }
        arrays.addAll(beans);
    }

    @Override
    public void onLoad() {
        if (current < 3) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    getLoadData();
                    showEListView(arrays);
                    mListView.loadComplete();
                }
            }, 2000);
            current = current++;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_load_more, menu);
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
