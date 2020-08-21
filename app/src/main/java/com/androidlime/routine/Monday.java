package com.androidlime.routine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Monday extends AppCompatActivity {

    private TextView tvmon;
    private Button btntue;
    private EditText etc;
    private EditText ett;
    private Button btns;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monday);
        tvmon=(TextView) findViewById(R.id.tvmon);
        etc=(EditText)findViewById(R.id.etc);
        ett=(EditText)findViewById(R.id.ett);
        btns=(Button)findViewById(R.id.btns);
        btntue=(Button)findViewById(R.id.btntues);
        final Database ob=new Database(getApplicationContext());
        btns.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String day=tvmon.getText().toString();
                        String time=ett.getText().toString();
                        String clas=etc.getText().toString();
                        ob.insert(day,clas,time);
                    }
                }
        );
        btntue.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i=new Intent(Monday.this,Tuesday.class);
                        startActivity(i);
                    }
                }
        );
    }
}
