package com.example.android.animepal;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.ListPreloader;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.integration.recyclerview.RecyclerViewPreloader;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.ViewPreloadSizeProvider;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class PostersAdapter extends RecyclerView.Adapter<PostersAdapter.PosterViewHolder>{
    private final int maxPreload = 6;
    private Activity activity;
    private ArrayList<Release> releases;
    private final String posterAPI = "https://cdn.masterani.me/poster/1/";
//    private ListPreloader.PreloadSizeProvider sizeProvider;

    public PostersAdapter(ArrayList<Release> releases, Activity activity) {
        this.releases = releases;
        this.activity = activity;

    }



    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class PosterViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ConstraintLayout anime_poster;

        public PosterViewHolder(ConstraintLayout itemView) {
            super(itemView);
            this.anime_poster = itemView;
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public PostersAdapter.PosterViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        ConstraintLayout v = (ConstraintLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.anime_poster, parent, false);
        PosterViewHolder vh = new PosterViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(PostersAdapter.PosterViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Release release = releases.get(position);
        ConstraintLayout view = holder.anime_poster;
        ImageView imageView = (ImageView) view.getViewById(R.id.imageview);
        TextView episode_number = (TextView) view.getViewById(R.id.episode_number);
        TextView name = (TextView) view.getViewById(R.id.name);
        String posterURL = release.getAnime().getPoster();

        name.setText(release.getAnime().getTitle());
        episode_number.setText("" + release.getEpisode());
        Log.e("adapter", "onBindViewHolder: loading image");
        GlideApp.with(activity).load(posterAPI + posterURL).apply(RequestOptions.noTransformation()).override(com.bumptech.glide.request.target.Target.SIZE_ORIGINAL, com.bumptech.glide.request.target.Target.SIZE_ORIGINAL).into(imageView);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return releases.size();
    }
}
