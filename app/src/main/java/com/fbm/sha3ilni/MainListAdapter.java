package com.fbm.sha3ilni;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by Mojahed Dameri on 5/14/16.
 */
public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.MainListViewHolder> {

    Context context;

    List<Worker> workerList;

    int itemsCount = 0;

    public MainListAdapter(Context c,  List<Worker> wLi, int itemsCount){

        context = c;

        workerList = wLi;

        this.itemsCount = itemsCount;

    }

    @Override
    public MainListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_main_list_item, parent, false);
        final int pos = viewType;
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, Profilee.class);

                String serializdObj = new Gson().toJson(workerList.get(pos));

                intent.putExtra("extra",serializdObj);

                context.startActivity(intent);
            }
        });
        return new MainListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainListViewHolder holder, final int position) {

        holder.name.setText(workerList.get(position).getFullName());

        holder.address.setText(workerList.get(position).getCity() +", "+workerList.get(position).getAddress());

        holder.image.setImageBitmap(Helperr.fromBase64(workerList.get(position).getImage()));

        holder.ratingBar.setRating(workerList.get(position).getStars());

        holder.rate.setText(workerList.get(position).getRateHour() +"$ "+ "\\ " + "ساعة");

    }

    @Override
    public int getItemCount() {
        return itemsCount;
    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class MainListViewHolder extends RecyclerView.ViewHolder{

        View itemView;
        TextView name, address, rate;
        RoundedImageView image;
        RatingBar ratingBar;

        public MainListViewHolder(View itemView) {
            super(itemView);

            this.itemView = itemView;

            name  = (TextView) itemView.findViewById(R.id.name);

            address  = (TextView) itemView.findViewById(R.id.address);

            image = (RoundedImageView) itemView.findViewById(R.id.image);

            ratingBar = (RatingBar) itemView.findViewById(R.id.ratingBar);

            rate = (TextView) itemView.findViewById(R.id.rate);

            name.setTypeface(Typeface.createFromAsset(context.getAssets(), "stc.otf"));

            address.setTypeface(Typeface.createFromAsset(context.getAssets(), "stc.otf"));

            ratingBar.setNumStars(5);

        }


        public int getScreenHeight() {
            WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            return  size.y;

        }
    }

}
