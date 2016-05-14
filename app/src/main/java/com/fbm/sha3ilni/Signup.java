package com.fbm.sha3ilni;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        ((EditText)findViewById(R.id.etfullname)).setTypeface(Typeface.createFromAsset(getAssets(), "stc.otf"));
        ((EditText)findViewById(R.id.etphone)).setTypeface(Typeface.createFromAsset(getAssets(), "stc.otf"));

        ((EditText)findViewById(R.id.city)).setTypeface(Typeface.createFromAsset(getAssets(), "stc.otf"));
        ((EditText)findViewById(R.id.address)).setTypeface(Typeface.createFromAsset(getAssets(), "stc.otf"));
        ((EditText)findViewById(R.id.etEmail)).setTypeface(Typeface.createFromAsset(getAssets(), "stc.otf"));
        ((EditText)findViewById(R.id.etUserName)).setTypeface(Typeface.createFromAsset(getAssets(), "stc.otf"));
        ((EditText)findViewById(R.id.etPass)).setTypeface(Typeface.createFromAsset(getAssets(), "stc.otf"));

        ((EditText)findViewById(R.id.etDesc)).setTypeface(Typeface.createFromAsset(getAssets(), "stc.otf"));
        ((Button)findViewById(R.id.btnSingIn)).setTypeface(Typeface.createFromAsset(getAssets(), "stc.otf"));

        ((Button)findViewById(R.id.btnSingIn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Signup.this, MainList.class);
                startActivity(intent);

            }
        });

    }
}
