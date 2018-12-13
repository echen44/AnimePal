package com.example.android.animepal;

import android.support.constraint.ConstraintLayout;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.request.RequestOptions;
import com.example.android.animepal.EpisodeFragment.OnListFragmentInteractionListener;
import com.example.android.animepal.dummy.DummyContent.DummyItem;
import com.jakewharton.rxbinding3.view.RxView;

import java.net.URL;
import java.util.List;
import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.internal.observers.DisposableLambdaObserver;
import io.reactivex.schedulers.Schedulers;
import kotlin.Unit;

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
    private String slug;

    public MyEpisodeRecyclerViewAdapter(List<Episode> items, OnListFragmentInteractionListener listener, EpisodeFragment fragment, String slug) {
        episodes = items;
        mListener = listener;
        this.fragment = fragment;
        this.slug = slug;
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


//        String string = "https://www.masterani.me/anime/watch/" + slug + "/" + episode.getInfo().getEpisode();
        String string = "https://www.masterani.me/anime/watch/2296-pokemon-sun-moon/100";
//        LinkScraper.scrape(string);
//        Observable<List<Mirror>> mirrorObservable = RxView.clicks(view);
        RxView.clicks(view)
                .observeOn(Schedulers.io())
                .map(new Function<Object, List<Mirror>>() {
                    @Override
                    public List<Mirror> apply(Object o) throws Exception {
                        return LinkScraper.scrape(string);
                    }
                })
                .map(new Function<List<Mirror>, DialogFragment>() {
                    @Override
                    public DialogFragment apply(List<Mirror> mirrors) throws Exception {
//                        return MirrorSelectDialogFragment.newInstance(mirrors);
                        MirrorSelectDialogFragment dialogFragment = new MirrorSelectDialogFragment();
                        dialogFragment.setMirrors(mirrors);
                        return dialogFragment;
                    }
                })
//                .subscribeOn(Schedulers.io())
                .subscribe(f -> fragment.showMirrors(f));
//        Log.e("dog", );
        GlideApp.with(fragment).load(THUMBNAILS_URL + episode.getThumbnail()).apply(RequestOptions.noTransformation()).override(com.bumptech.glide.request.target.Target.SIZE_ORIGINAL, com.bumptech.glide.request.target.Target.SIZE_ORIGINAL).into(holder.imageView);
//        holder.anime_episode.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
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
