package com.androidlime.routine;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Button btnc;
    private Button btns;
    private TextView name;
    private TextView add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(TextView)findViewById(R.id.tv4);
        add=(TextView)findViewById(R.id.tv5);
        btnc = (Button) findViewById(R.id.btnc);
        btns = (Button) findViewById(R.id.btnv);
        name.setMovementMethod(LinkMovementMethod.getInstance());
        final Database ob = new Database(getApplicationContext());
        btnc.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder mybuilder=new AlertDialog.Builder(MainActivity.this);
                        mybuilder.setTitle("Are you sure to delete and create a new routine?");
                        mybuilder.setIcon(R.drawable.iconalert);
                        mybuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ob.CreateTable();
                                Intent i = new Intent(MainActivity.this, CreateSunday.class);
                                startActivity(i);
                            }
                        });
                        mybuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        mybuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        AlertDialog dialogue=mybuilder.create();
                        dialogue.show();

                    }
                }
        );
        btns.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MainActivity.this, ShowRoutine.class);
                        startActivity(i);
                    }
                }
        );

    }


}
