package com.fbm.sha3ilni;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.NumberPicker;



public class Payment extends AppCompatActivity {


    NumberPicker np;
    Button b1,b2;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);




        np =(NumberPicker)findViewById(R.id.numberPicker);
        b1 =(Button)findViewById(R.id.button3);
        b1 =(Button)findViewById(R.id.button2);

    }
}
