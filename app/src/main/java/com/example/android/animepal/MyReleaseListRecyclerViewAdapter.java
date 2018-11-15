package com.example.android.animepal;

import android.app.Activity;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.request.RequestOptions;
import com.example.android.animepal.ReleaseListFragment.OnListFragmentInteractionListener;
import com.example.android.animepal.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyReleaseListRecyclerViewAdapter extends RecyclerView.Adapter<MyReleaseListRecyclerViewAdapter.PosterViewHolder> {

    private ArrayList<Release> releases;
//    private final OnListFragmentInteractionListener mListener;
    private Fragment fragment;
    private final String posterAPI = "https://cdn.masterani.me/poster/1/";

    public MyReleaseListRecyclerViewAdapter(ArrayList<Release> releases, Fragment fragment) {
        this.releases = releases;
        this.fragment = fragment;

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
    public MyReleaseListRecyclerViewAdapter.PosterViewHolder onCreateViewHolder(ViewGroup parent,
                                                              int viewType) {
        // create a new view
        ConstraintLayout v = (ConstraintLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.anime_poster, parent, false);
        MyReleaseListRecyclerViewAdapter.PosterViewHolder vh = new MyReleaseListRecyclerViewAdapter.PosterViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyReleaseListRecyclerViewAdapter.PosterViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Release release = releases.get(position);
        ConstraintLayout view = holder.anime_poster;
        ImageView imageView = (ImageView) view.getViewById(R.id.imageview);
        TextView episode_number = (TextView) view.getViewById(R.id.episode_number);
        TextView name = (TextView) view.getViewById(R.id.name);
        String posterURL = release.getAnime().getPosterURL();

        name.setText(release.getAnime().getTitle());
        episode_number.setText("" + release.getEpisode());
        Log.e("adapter", "onBindViewHolder: loading image");
        GlideApp.with(fragment).load(posterAPI + posterURL).apply(RequestOptions.noTransformation()).override(com.bumptech.glide.request.target.Target.SIZE_ORIGINAL, com.bumptech.glide.request.target.Target.SIZE_ORIGINAL).into(imageView);
    }

    @Override
    public int getItemCount() {
        return releases.size();
    }
}