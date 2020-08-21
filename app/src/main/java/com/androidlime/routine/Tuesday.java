package com.androidlime.routine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Tuesday extends AppCompatActivity {

    private TextView tvtue;
    private Button btnwed;
    private EditText etc;
    private EditText ett;
    private Button btns;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuesday);
        tvtue=(TextView) findViewById(R.id.tvtues);
        etc=(EditText)findViewById(R.id.etc);
        ett=(EditText)findViewById(R.id.ett);
        btns=(Button)findViewById(R.id.btns);
        btnwed=(Button)findViewById(R.id.btnwed);
        final Database ob=new Database(getApplicationContext());
        btns.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String day=tvtue.getText().toString();
                        String time=ett.getText().toString();
                        String clas=etc.getText().toString();
                        ob.insert(day,clas,time);
                    }
                }
        );
        btnwed.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i=new Intent(Tuesday.this,Wednesday.class);
                        startActivity(i);
                    }
                }
        );
    }
}
