package com.fbm.sha3ilni;

import android.util.Log;

import com.algolia.search.saas.AlgoliaException;
import com.algolia.search.saas.Client;
import com.algolia.search.saas.CompletionHandler;
import com.algolia.search.saas.Index;
import com.algolia.search.saas.Query;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Mojahed Dameri on 5/13/16.
 */
public class RequestManager {


    public static void getWorkers(boolean nearMe, final Callback callback) {

        Client client = new Client("CTSGPUBNQA", "197ca101550ea189a5db4569f18b0bb1");

        final Index index = client.initIndex("workers");

        final Query query = new Query();

        query.setAroundLatLngViaIP(nearMe);

        try {

            JSONObject settings = new JSONObject().accumulate("customRanking", "desc(stars)");

            index.setSettingsAsync(settings, new CompletionHandler() {
                @Override
                public void requestCompleted(JSONObject content, AlgoliaException error) {

                    index.searchAsync(query, new CompletionHandler() {
                        @Override
                        public void requestCompleted(JSONObject content, AlgoliaException error) {

                            List<Worker> workers = new ArrayList();

                            try {

                                org.json.JSONArray jsonObject = content.getJSONArray("hits");

                                workers = new Gson().fromJson(jsonObject.toString(), new TypeToken<List<Worker>>(){}.getType());

                                Collections.sort(workers, new Comparator<Worker>() {
                                    @Override
                                    public int compare(Worker lhs, Worker rhs) {

                                        Worker l = (Worker) lhs;
                                        Worker r = (Worker) rhs;

                                        if (l.getStars() > r.getStars()) {

                                            return -1;

                                        } else if (l.getStars() < r.getStars()) {

                                            return 1;
                                        }

                                        return 0;
                                    }
                                });

                            } catch (Throwable t) {

                                Log.e("dsdsad", "dsds" ,t);
                            }


                            callback.onResult(workers);
                        }
                    });
                }
            });

        } catch (Throwable t) {

            Log.e("dsdasdas", "erorrorororo" ,t);
        }



    }
}
