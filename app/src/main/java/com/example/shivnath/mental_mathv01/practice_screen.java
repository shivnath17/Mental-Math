package com.example.shivnath.mental_mathv01;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class practice_screen extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.practice_screen );
        Button genrate = findViewById ( R.id.genrate );
        genrate.setOnClickListener ( this );
        Button check = findViewById ( R.id.check );
        check.setOnClickListener (che);

    }
    private int p = 0;
    public int question_limit = 0;
    String a;


    // Quition limit................
    public void limit(){
        if (p >=1){
            a = String.valueOf ( p );
        }else {
            a = "0";
        }
        if (question_limit >=10){
            Intent intent2 = new Intent (practice_screen.this, report.class);
            intent2.putExtra ( "add",a);
            startActivity ( intent2 );
        }
    }

    // Timer...............
    private CountDownTimer coundown;
    public void timer(){
        final TextView timer = findViewById ( R.id.timer );
    coundown = new CountDownTimer (10000, 1000) {

        public void onTick(long millisUntilFinished) {
            timer.setText("" + millisUntilFinished / 1000);
        }

    public void onFinish() {
        timer.setText("Time Out!");
        EditText et = findViewById (R.id.answer);
        if (timer.getText ().toString () == "Time Out!"){
            et.setEnabled ( false );
            Toast.makeText ( getApplicationContext (), "Time Out! Please click NEXT :)", Toast.LENGTH_LONG ).show ();
        }
    }
}.start ();
    }

    //onClickListener.....................
    @Override
    public void onClick(View v) {
        generate ();
        timer ();
        EditText et = findViewById ( R.id.answer );
        et.setEnabled ( true );
        et.setText ( null );
        Button bt = findViewById ( R.id.genrate );
        bt.setText ( "NEXT" );
        question_limit++;
        limit ();
    }
    View.OnClickListener che = new View.OnClickListener () {
        @Override
        public void onClick(View v) {
            check ();
            coundown.cancel ();
            EditText et = findViewById ( R.id.answer );
            if (et.getText ().toString ().isEmpty ()) {
                et.setEnabled ( true);
            }else{
                et.setEnabled ( false );
            }
        }
    };


    // Question Genrate Button...................................

    public void generate() {
        Integer num1, num2;
        TextView tv;
        num1 = generateRandom ();
        num2 = generateRandom ();

        tv = findViewById ( R.id.question );
        String all = (num1.toString ()) + " " + getIntent().getStringExtra ( "add" )+ " "+ (num2.toString ());
        tv.setText ( all );
    }

    // Random Number Genrate.......................................
    public int generateRandom() {
        Random rand = new Random ();
        return rand.nextInt ( 100 );
    }
// Answer check Button........................................

    public void check() {
        // Find the TextView and GetText From Their............
        TextView tv2;
        tv2 = findViewById ( R.id.question );
        String getquestion = tv2.getText ().toString ();
        // Split the Text into Arryas..........................
        String sp[];

        // Assign the Arrays to Integer Variable................
        sp = getquestion.split ( " " );
        String num3, num4;
        num3 = sp[0];
        num4 = sp[2];
        // HAVE PROBLEMS IN CONVERT the Numbers..................................
        Integer num5, num6, num7;
        num5 = Integer.valueOf ( num3 );
        num6 = Integer.valueOf ( num4 );
        Integer mun;
        boolean add, minus, multi, divid;

        add = sp[1] == "+";
        switch (sp[1]) {
            case "+":
                mun = num5 + num6;
                break;
            case "-":
                mun = num5 - num6;
                break;
            case "x":
                mun = num5 * num6;
                break;
            default:
                mun = num5 / num6;
                break;
        }


        //Get Text From EditText.................................

        EditText et;
        et = findViewById ( R.id.answer );
        String st;
        st = et.getText ().toString ();
        if (st.isEmpty ()) {
            Toast.makeText ( getApplicationContext (), "Please Enter Your Answer :)", Toast.LENGTH_LONG ).show ();
        } else {
        int convert = Integer.parseInt ( st );



            // If and Else Condition................................
            TextView point = findViewById ( R.id.point );


            if (mun == convert) {
                tv2.setText ( "Right Answer :)" );
                if (true) {
                    p = (p) + 5;
                    point.setText ( String.valueOf ( p ) );
                    Toast.makeText ( getApplicationContext (), "+ 5", Toast.LENGTH_LONG ).show ();
                }
            } else {
                tv2.setText ( "Wrong Answer:(" );
                if (p > 0) {
                    p = (p) - 5;
                    point.setText ( String.valueOf ( p ) );
                    Toast.makeText ( getApplicationContext (), "- 5", Toast.LENGTH_LONG ).show ();
                }
            }
        }
    }
}
