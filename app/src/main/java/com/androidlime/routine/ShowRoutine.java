package com.androidlime.routine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ShowRoutine extends AppCompatActivity {
    private Button sun;
    private Button mon;
    private Button tue;
    private Button wed;
    private Button thr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_routine);
        sun=(Button)findViewById(R.id.sunday);
        mon=(Button)findViewById(R.id.monday);
        tue=(Button)findViewById(R.id.tuesday);
        wed=(Button)findViewById(R.id.wednesday);
        thr=(Button)findViewById(R.id.thursday);
        sun.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i=new Intent(ShowRoutine.this,Display.class);
                        i.putExtra("day","Sunday");
                        startActivity(i);
                    }
                }
        );
        mon.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i=new Intent(ShowRoutine.this,Display.class);
                        i.putExtra("day","Monday");
                        startActivity(i);
                    }
                }
        );
        tue.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i=new Intent(ShowRoutine.this,Display.class);
                        i.putExtra("day","Tuesday");
                        startActivity(i);
                    }
                }
        );
        wed.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i=new Intent(ShowRoutine.this,Display.class);
                        i.putExtra("day","Wednesday");
                        startActivity(i);
                    }
                }
        );
        thr.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i=new Intent(ShowRoutine.this,Display.class);
                        i.putExtra("day","Thursday");
                        startActivity(i);
                    }
                }
        );
    }
}
