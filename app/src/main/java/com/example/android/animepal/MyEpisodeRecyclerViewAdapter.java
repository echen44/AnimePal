package com.example.android.animepal;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.request.RequestOptions;
import com.example.android.animepal.EpisodeFragment.OnListFragmentInteractionListener;
import com.example.android.animepal.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyEpisodeRecyclerViewAdapter extends RecyclerView.Adapter<MyEpisodeRecyclerViewAdapter.EpisodeViewHolder> {

    private final List<Episode> episodes;
    private final OnListFragmentInteractionListener mListener;
    private EpisodeFragment fragment;
//    https://cdn.masterani.me/episodes/48837U0HqMTm9.jpg
    private final String THUMBNAILS_URL = "https://cdn.masterani.me/episodes/";

    public MyEpisodeRecyclerViewAdapter(List<Episode> items, OnListFragmentInteractionListener listener, EpisodeFragment fragment) {
        episodes = items;
        mListener = listener;
        this.fragment = fragment;
    }

    @Override
    public EpisodeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ConstraintLayout v = (ConstraintLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_episode, parent, false);
        return new EpisodeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final EpisodeViewHolder holder, int position) {
        Episode episode = episodes.get(position);
        EpisodeInfo episodeInfo = episode.getInfo();
        ConstraintLayout view = holder.anime_episode;
        holder.number.setText(episodeInfo.getEpisode());
        holder.title.setText((String) episodeInfo.getTitle());
        GlideApp.with(fragment).load(THUMBNAILS_URL + episode.getThumbnail()).apply(RequestOptions.noTransformation()).override(com.bumptech.glide.request.target.Target.SIZE_ORIGINAL, com.bumptech.glide.request.target.Target.SIZE_ORIGINAL).into(holder.imageView);

//        holder.mView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (null != mListener) {
//                    // Notify the active callbacks interface (the activity, if the
//                    // fragment is attached to one) that an item has been selected.
//                    mListener.onListFragmentInteraction(holder.mItem);
//                }
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return episodes.size();
    }

    public class EpisodeViewHolder extends RecyclerView.ViewHolder {
        public ConstraintLayout anime_episode;
        public ImageView imageView;
        public TextView number;
        public TextView title;
        public EpisodeViewHolder(ConstraintLayout itemView) {
            super(itemView);
            this.anime_episode = itemView;
            imageView = itemView.findViewById(R.id.imageview);
            number = itemView.findViewById(R.id.episode_number);
            title = itemView.findViewById(R.id.name);
        }

//        @Override
//        public String toString() {
//            return super.toString() + " '" + mContentView.getText() + "'";
//        }
    }
}
