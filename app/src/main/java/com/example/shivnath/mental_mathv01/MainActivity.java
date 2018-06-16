package com.example.shivnath.mental_mathv01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button addition =(Button) findViewById ( R.id.addition );
        addition.setOnClickListener (this);
        Button subtraction =(Button) findViewById ( R.id.subtraction );
        subtraction.setOnClickListener (sub);
        Button multiplication =(Button) findViewById ( R.id.multiplication);
        multiplication.setOnClickListener (multi);
        Button division =(Button) findViewById ( R.id.division);
        division.setOnClickListener (div);
    }

        @Override
        public void onClick(View v) {
            value = "+";
            data ();
        }
        View.OnClickListener sub = new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                value = "-";
                data ();
            }
        };
        View.OnClickListener multi = new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                value = "x";
                data ();
            }
        };
        View.OnClickListener div = new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                value = "/";
                data ();
            }
        };
        String value;
    public void  data (){
        Intent intent1 = new Intent (MainActivity.this, practice_screen.class);
        intent1.putExtra ( "add",value);
        startActivity (intent1);
    }
}