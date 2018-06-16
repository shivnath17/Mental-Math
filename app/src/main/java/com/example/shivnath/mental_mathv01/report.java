package com.example.shivnath.mental_mathv01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

public class report extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_report );
        TextView date = findViewById ( R.id.Date );
        TextView Question = findViewById ( R.id.attempt_Question );
        TextView Answer = findViewById ( R.id.Right_answer );
        TextView points = findViewById ( R.id.Points_fnish );
        Button Close = findViewById ( R.id.Close );
        Close.setOnClickListener ( this );
        Question.setText ( "10" + "   " + "Queestion Attempt" );
        String poi = getIntent ().getStringExtra ( "add" );
        points.setText (poi +"   "+"Points");
        int ans = Integer.valueOf ( poi );
        if (ans >3){
            int a = ans/5;
            String st =String.valueOf ( a );
            Answer.setText ( st + "   " + "Right Answer" );
        }else{
            Answer.setText ( "0" + "   "+"Right Answer");
        }
        String current_date  = DateFormat.getDateInstance ().format ( new Date());
        date.setText ( current_date );

    }

    @Override
    public void onClick(View v) {
        Intent intent1 = new Intent (report.this, MainActivity.class);
        startActivity (intent1);
    }
}
