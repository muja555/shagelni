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
public class Profilee extends AppCompatActivity {
    ImageView iv;
    TextView tv1,tv2,tv3,tv4,tv5;
    Button b1;
    RatingBar rb;
    Worker worker;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        worker = new Gson().fromJson(getIntent().getStringExtra("extra"), Worker.class);
        tv1=(TextView)findViewById(R.id.textView0);
        tv2=(TextView)findViewById(R.id.textView1);
        tv3=(TextView)findViewById(R.id.textView);
        tv4=(TextView)findViewById(R.id.textView3);
        tv5=(TextView)findViewById(R.id.textView5);

        iv=(ImageView)findViewById((R.id.imageView));

        b1=(Button)findViewById(R.id.button2);
        rb=(RatingBar)findViewById(R.id.ratingBar);


        //font like this
        tv1.setTypeface(Typeface.createFromAsset(getAssets(), "stc.otf"));
        tv2.setTypeface(Typeface.createFromAsset(getAssets(), "stc.otf"));
        tv3.setTypeface(Typeface.createFromAsset(getAssets(), "stc.otf"));
        tv4.setTypeface(Typeface.createFromAsset(getAssets(), "stc.otf"));
        tv5.setTypeface(Typeface.createFromAsset(getAssets(), "stc.otf"));



        tv1.setText(worker.getFullName());

        tv2.setText(worker.getCity() + ", " + worker.getAddress());
        tv3.setText(worker.getRateHour() +"$ "+ "\\ " + "ساعة");
        tv4.setText(worker.getDescription());
        //tv5.setReviewModel[](worker.getReviewModels());

        iv.setImageBitmap(Helperr.fromBase64(worker.getImage()));

       // rb.setOnRatingBarChangeListener(worker.getStars());


        }

    }


