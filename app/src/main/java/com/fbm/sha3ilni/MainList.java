package com.fbm.sha3ilni;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

public class MainList extends AppCompatActivity {

    List<Worker> workersListNear, workersListAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            ((ScrollView) findViewById(R.id.main_scroll)).setNestedScrollingEnabled(false);

        }

        ((TextView) findViewById(R.id.see_more_1)).setTypeface(Typeface.createFromAsset(getAssets(), "stc.otf"));

        ((TextView) findViewById(R.id.see_more_2)).setTypeface(Typeface.createFromAsset(getAssets(), "stc.otf"));

        ((TextView) findViewById(R.id.other_me_text)).setTypeface(Typeface.createFromAsset(getAssets(), "stc.otf"));

        ((TextView) findViewById(R.id.near_me_text)).setTypeface(Typeface.createFromAsset(getAssets(), "stc.otf"));

         RequestManager.getWorkers(false, new Callback() {
            @Override
            public void onResult(Object result) {

                workersListAll = (List<Worker>) result;

                List<Worker>[] res =  Worker.getNearMe(workersListAll);

                workersListNear = res[0];

                workersListAll = res[1];

                MainList.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        initializeLists1();

                        initializeLists2();
                    }
                });
            }
        });


        findViewById(R.id.see_more_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainList.this, FullList.class);

                String serializdObj = new Gson().toJson(workersListNear);

                intent.putExtra("extra",serializdObj);

                intent.putExtra("title",(MainList.this.getString(R.string.near_me)));

                MainList.this.startActivity(intent);

            }
        });

        findViewById(R.id.see_more_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainList.this, FullList.class);

                String serializdObj = new Gson().toJson(workersListAll);

                intent.putExtra("extra",serializdObj);

                intent.putExtra("title",(MainList.this.getString(R.string.other)));

                MainList.this.startActivity(intent);

            }
        });
    }


    public void initializeLists1() {

        MainListAdapter adapter = new MainListAdapter(MainList.this, workersListNear, workersListNear.size() < 3? workersListNear.size() : 3);

        LinearLayoutManager manager = new LinearLayoutManager(MainList.this);

        manager.setOrientation(LinearLayoutManager.VERTICAL);

        RecyclerView list = (RecyclerView) findViewById(R.id.main_list_1);

        list.setNestedScrollingEnabled(false);

        list.setLayoutManager(manager);

        list.setAdapter(adapter);

    }


    public void initializeLists2() {

        MainListAdapter adapter = new MainListAdapter(MainList.this, workersListAll, workersListAll.size() < 3? workersListAll.size() : 3);

        LinearLayoutManager manager = new LinearLayoutManager(MainList.this);

        manager.setOrientation(LinearLayoutManager.VERTICAL);

        RecyclerView list = (RecyclerView) findViewById(R.id.main_list_2);

        list.setNestedScrollingEnabled(false);

        list.setLayoutManager(manager);

        list.setAdapter(adapter);

    }
}
