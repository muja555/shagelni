package com.fbm.sha3ilni;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    EditText usernameField, passwordField;


    Button b1,b2;
    int count=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameField = (EditText) findViewById(R.id.username);

        passwordField = (EditText) findViewById(R.id.password);

        usernameField.setTypeface(Typeface.createFromAsset(getAssets(), "stc.otf"));
        passwordField.setTypeface(Typeface.createFromAsset(getAssets(), "stc.otf"));
        b1=(Button)findViewById(R.id.button);
        usernameField=(EditText)findViewById(R.id.username);
        passwordField=(EditText)findViewById(R.id.password);

        b2=(Button)findViewById(R.id.button1);

        b2.setTypeface(Typeface.createFromAsset(getAssets(), "stc.otf"));

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Signup.class);

                startActivity(intent);

            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainList.class);
                startActivity(intent);
            }
        });

        b1.setTypeface(Typeface.createFromAsset(getAssets(), "stc.otf"));

        ((TextView)findViewById(R.id.dd)).setText("خدمة تنظيف المنازل اصبحت اسهل واسرع !");
        ((TextView)findViewById(R.id.dd)).setTypeface(Typeface.createFromAsset(getAssets(), "stc.otf"));
    }
    }

