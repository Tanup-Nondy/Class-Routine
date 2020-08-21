package com.androidlime.routine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Wednesday extends AppCompatActivity {

    private TextView tvwed;
    private Button btnthr;
    private EditText etc;
    private EditText ett;
    private Button btns;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wednesday);
        tvwed=(TextView) findViewById(R.id.tvwed);
        etc=(EditText)findViewById(R.id.etc);
        ett=(EditText)findViewById(R.id.ett);
        btns=(Button)findViewById(R.id.btns);
        btnthr=(Button)findViewById(R.id.btnthurs);
        final Database ob=new Database(getApplicationContext());
        btns.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String day=tvwed.getText().toString();
                        String time=ett.getText().toString();
                        String clas=etc.getText().toString();
                        ob.insert(day,clas,time);
                    }
                }
        );
        btnthr.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i=new Intent(Wednesday.this,Thursday.class);
                        startActivity(i);
                    }
                }
        );
    }
}
