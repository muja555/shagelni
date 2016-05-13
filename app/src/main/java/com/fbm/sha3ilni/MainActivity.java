package com.fbm.sha3ilni;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText usernameField, passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameField = (EditText) findViewById(R.id.username);

        passwordField = (EditText) findViewById(R.id.password);

        usernameField.setTypeface(Typeface.createFromAsset(getAssets(), "stc.otf"));

    }
}
