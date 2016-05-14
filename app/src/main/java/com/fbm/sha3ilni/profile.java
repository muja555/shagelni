package com.fbm.sha3ilni;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Button;

import com.google.gson.Gson;

/**
 * Created by Bara Jallad on 5/14/2016.
 */
public class Profile extends AppCompatActivity {
    ImageView iv;
    TextView tv1,tv2,tv3,tv4,tv5;
    Button b1;
    RatingBar rb;
    Worker worker;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        worker = new Gson().fromJson(getIntent().getStringExtra("extra"), Worker.class);


        //font like this
        //tv5.setTypeface(Typeface.createFromAsset(getAssets(), "stc.otf"));
    }


    }

