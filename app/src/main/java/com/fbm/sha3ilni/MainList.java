package com.fbm.sha3ilni;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainList extends AppCompatActivity {

    List<Worker> workersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);

         RequestManager.getWorkers(new Callback() {
            @Override
            public void onResult(Object result) {

                workersList = (List<Worker>) result;

                MainList.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        initializeList();
                    }
                });
            }
        });
    }


    public void initializeList() {

        MainListAdapter adapter = new MainListAdapter(MainList.this, workersList);

        LinearLayoutManager manager = new LinearLayoutManager(MainList.this);

        manager.setOrientation(LinearLayoutManager.VERTICAL);

        RecyclerView list = (RecyclerView) findViewById(R.id.main_list);

        list.setLayoutManager(manager);

        list.setAdapter(adapter);

    }
}
