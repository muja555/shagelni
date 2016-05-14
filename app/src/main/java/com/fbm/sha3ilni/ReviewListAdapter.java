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
public class ReviewListAdapter extends RecyclerView.Adapter<ReviewListAdapter.MainListViewHolder> {

    Context context;

    ReviewModel[] reviewModels;


    public ReviewListAdapter(Context c, ReviewModel[] reviewModels){

        context = c;

        this.reviewModels = reviewModels;

    }

    @Override
    public MainListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_review_list_item, parent, false);
        return new MainListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainListViewHolder holder, final int position) {

        holder.name.setText(reviewModels[position].getName());
        holder.description.setText(reviewModels[position].getComment());
        holder.title.setText(reviewModels[position].getTitle());
        if (reviewModels[position].getImage() != null && !reviewModels[position].getImage().isEmpty()) {
            holder.image.setImageBitmap(Helperr.fromBase64(reviewModels[position].getImage()));
        }
        holder.ratingBar.setRating(reviewModels[position].getStars());

    }

    @Override
    public int getItemCount() {
        return reviewModels.length;
    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class MainListViewHolder extends RecyclerView.ViewHolder{

        View itemView;
        TextView name, description, title;
        RoundedImageView image;
        RatingBar ratingBar;

        public MainListViewHolder(View itemView) {
            super(itemView);

            this.itemView = itemView;

            name  = (TextView) itemView.findViewById(R.id.name);

            description  = (TextView) itemView.findViewById(R.id.dec);

            image = (RoundedImageView) itemView.findViewById(R.id.image);

            ratingBar = (RatingBar) itemView.findViewById(R.id.ratingBar);

            title = (TextView) itemView.findViewById(R.id.title);

            name.setTypeface(Typeface.createFromAsset(context.getAssets(), "stc.otf"));

            description.setTypeface(Typeface.createFromAsset(context.getAssets(), "stc.otf"));

            title.setTypeface(Typeface.createFromAsset(context.getAssets(), "stc.otf"));

            ratingBar.setNumStars(5);

        }

    }

}
