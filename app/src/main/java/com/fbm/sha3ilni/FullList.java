package com.fbm.sha3ilni;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FullList extends AppCompatActivity {

    String title = "";
    List<Worker> list = new ArrayList<>();
    TextView text1, text2, near_me_text;
    RecyclerView recyclerView;
    LinearLayout sortByPrice, sortByRate;
    boolean sortByRatingT = true, sortByPriceT = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_list);


        title = getIntent().getStringExtra("title");

        list = new Gson().fromJson(getIntent().getStringExtra("extra"),  new TypeToken<List<Worker>>(){}.getType());


        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        near_me_text = (TextView) findViewById(R.id.near_me_text);
        recyclerView = (RecyclerView) findViewById(R.id.main_list_1);
        sortByPrice = (LinearLayout) findViewById(R.id.sort_price);
        sortByRate = (LinearLayout) findViewById(R.id.sort_rating);


        near_me_text.setText(title);

        sortRating(true);

        initializeList();


        sortByPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortByPriceT = !sortByPriceT;

                sortPrice(sortByPriceT);

                initializeList();

            }
        });

        sortByRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sortByRatingT = ! sortByRatingT;

                sortRating(sortByRatingT);

                initializeList();

            }
        });




    }

    public void initializeList() {

        MainListAdapter adapter = new MainListAdapter(this, list, list.size());

        LinearLayoutManager manager = new LinearLayoutManager(this);

        manager.setOrientation(LinearLayoutManager.VERTICAL);

        RecyclerView list = (RecyclerView) findViewById(R.id.main_list_1);

        list.setLayoutManager(manager);

        list.setAdapter(adapter);

    }

    public void sortRating(final boolean desc) {

        Collections.sort(list, new Comparator<Worker>() {
            @Override
            public int compare(Worker lhs, Worker rhs) {

                Worker l = (Worker) lhs;
                Worker r = (Worker) rhs;

                if (l.getStars() > r.getStars()) {

                    return desc? -1 : 1;

                } else if (l.getStars() < r.getStars()) {

                    return desc? 1 : -1;
                }

                return 0;
            }

        });
    }

    public void sortPrice(final boolean desc) {

        Collections.sort(list, new Comparator<Worker>() {
            @Override
            public int compare(Worker lhs, Worker rhs) {

                Worker l = (Worker) lhs;
                Worker r = (Worker) rhs;

                if (l.getRateHour() > r.getRateHour()) {

                    return !desc? -1 : 1;

                } else if (l.getRateHour() < r.getRateHour()) {

                    return !desc? 1 : -1;
                }

                return 0;
            }

        });
    }
}
