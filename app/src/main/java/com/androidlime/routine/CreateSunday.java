package com.androidlime.routine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CreateSunday extends AppCompatActivity {

    private TextView tvsun;
    private Button btnmon;
    private EditText etc;
    private EditText ett;
    private Button btns;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_sunday);
        tvsun=(TextView) findViewById(R.id.tvsun);
        etc=(EditText)findViewById(R.id.etc);
        ett=(EditText)findViewById(R.id.ett);
        btns=(Button)findViewById(R.id.btns);
        btnmon=(Button)findViewById(R.id.btnmon);
        final Database ob=new Database(getApplicationContext());
        btns.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String day=tvsun.getText().toString();
                        String clas=etc.getText().toString();
                        String time=ett.getText().toString();
                        ob.insert(day,clas,time);
                    }
                }
        );
        btnmon.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i=new Intent(CreateSunday.this,Monday.class);
                        startActivity(i);
                    }
                }
        );
    }
}
