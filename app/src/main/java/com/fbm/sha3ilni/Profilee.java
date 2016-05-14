package com.fbm.sha3ilni;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Button;

import com.google.gson.Gson;

/**
 * Created by Bara Jallad on 5/14/2016.
 */
public class Profilee extends AppCompatActivity {
    RoundedImageView iv;
    TextView tv1,tv2,tv3,tv4,tv5;
    Button b1;
    RatingBar ratingBar;
    RatingBar rb;
    Worker worker;
    RecyclerView list;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        worker = new Gson().fromJson(getIntent().getStringExtra("extra"), Worker.class);
        tv1=(TextView)findViewById(R.id.textView0);
        tv2=(TextView)findViewById(R.id.textView1);
        tv3=(TextView)findViewById(R.id.textView);
        tv4=(TextView)findViewById(R.id.textView3);
        tv5=(TextView)findViewById(R.id.textView4);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        list = (RecyclerView) findViewById(R.id.list);


        iv=(RoundedImageView)findViewById((R.id.imageView));

        b1=(Button)findViewById(R.id.button2);
        rb=(RatingBar)findViewById(R.id.ratingBar);


        //font like this
        tv1.setTypeface(Typeface.createFromAsset(getAssets(), "stc.otf"));
        tv2.setTypeface(Typeface.createFromAsset(getAssets(), "stc.otf"));
        tv3.setTypeface(Typeface.createFromAsset(getAssets(), "stc.otf"));
        tv4.setTypeface(Typeface.createFromAsset(getAssets(), "stc.otf"));
        tv5.setTypeface(Typeface.createFromAsset(getAssets(), "stc.otf"));
        ((TextView) findViewById(R.id.textView2)).setTypeface(Typeface.createFromAsset(getAssets(), "stc.otf"));
        ((TextView) findViewById(R.id.textView4)).setTypeface(Typeface.createFromAsset(getAssets(), "stc.otf"));
        ((Button) findViewById(R.id.button2)).setTypeface(Typeface.createFromAsset(getAssets(), "stc.otf"));


        ratingBar.setRating(worker.getStars());
        ratingBar.setNumStars(5);

        tv1.setText(worker.getFullName());

        tv2.setText(worker.getCity() + ", " + worker.getAddress());
        tv3.setText(worker.getRateHour() +"$ "+ "\\ " + "ساعة");
        tv4.setText(worker.getDescription());


        iv.setImageBitmap(Helperr.fromBase64(worker.getImage()));


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            ((ScrollView) findViewById(R.id.scroll)).setNestedScrollingEnabled(false);

        }

        ReviewListAdapter adapter = new ReviewListAdapter(this, worker.getReviewModels());

        LinearLayoutManager manager = new LinearLayoutManager(this);

        manager.setOrientation(LinearLayoutManager.VERTICAL);

        RecyclerView list = (RecyclerView) findViewById(R.id.list);

        list.setNestedScrollingEnabled(false);

        list.setLayoutManager(manager);

        list.setAdapter(adapter);


        ((ScrollView) findViewById(R.id.scroll)).post(new Runnable() {
            @Override
            public void run() {

                ((ScrollView) findViewById(R.id.scroll)).scrollTo(0,0);

            }
        });

        }

    }


