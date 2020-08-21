package com.androidlime.routine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Display extends AppCompatActivity {

    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        lv=(ListView)findViewById(R.id.lv);
        Database ob=new Database(getApplicationContext());
        String name=getIntent().getStringExtra("day");
        String[] data=ob.show(name);
        lv.setAdapter(new ArrayAdapter(getApplicationContext(),R.layout.lvlayout,R.id.text,data));

    }
}
