package com.androidlime.routine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Thursday extends AppCompatActivity {

    private TextView tvthr;
    private Button btnmain;
    private EditText etc;
    private EditText ett;
    private Button btns;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thursday);
        tvthr=(TextView) findViewById(R.id.tvthurs);
        etc=(EditText)findViewById(R.id.etc);
        ett=(EditText)findViewById(R.id.ett);
        btns=(Button)findViewById(R.id.btns);
        btnmain=(Button)findViewById(R.id.btnshow);
        final Database ob=new Database(getApplicationContext());
        btns.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String day=tvthr.getText().toString();
                        String time=ett.getText().toString();
                        String clas=etc.getText().toString();
                        ob.insert(day,clas,time);
                    }
                }
        );
        btnmain.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i=new Intent(Thursday.this,MainActivity.class);
                        startActivity(i);
                    }
                }
        );
    }
}
