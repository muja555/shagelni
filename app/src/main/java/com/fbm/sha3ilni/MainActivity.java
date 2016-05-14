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

        b1=(Button)findViewById(R.id.button);
        usernameField=(EditText)findViewById(R.id.username);
        passwordField=(EditText)findViewById(R.id.password);

        b2=(Button)findViewById(R.id.button1);


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  if(usernameField.getText().toString().equals("admin") &&

                        passwordField.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(), "Redirecting...",Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();

                }
                */
                Intent intent = new Intent(MainActivity.this, Signup.class);
               // EditText editText = (EditText) findViewById(R.id.edit_message);
              //  String message = editText.getText().toString();
               // intent.putExtra(EXTRA_MESSAGE, message);
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
    }
    }

