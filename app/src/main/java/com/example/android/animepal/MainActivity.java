package com.example.android.animepal;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bumptech.glide.RequestManager;
import com.example.android.animepal.dummy.DummyContent;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity implements ReleaseListFragment.AnimeSelectedListener, EpisodeFragment.OnListFragmentInteractionListener, MirrorSelectDialogFragment.OnFragmentInteractionListener, BrowserFragment.OnFragmentInteractionListener {
    private RequestManager thumbnailRequest;
    private final int spanCount = 3;
    private OkHttpClient client;
    private RecyclerView view;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Release> releases;
    private PostersAdapter postersAdapter;
    private final String posterAPI = "https://cdn.masterani.me/poster/1/";
    private final String releasesURL = "https://www.masterani.me/api/releases";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        ReleaseListFragment fragment = new ReleaseListFragment();
        fragmentTransaction.add(R.id.root, fragment);
        fragmentTransaction.commit();
    }

    public void animeSelected(Integer id) {
        EpisodeFragment episodeFragment = new EpisodeFragment();
        Bundle args = new Bundle();
        args.putInt(EpisodeFragment.ARG_ID, id);
        args.putInt(EpisodeFragment.ARG_COLUMN_COUNT, 2);
        episodeFragment.setArguments(args);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.root, episodeFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void MirrorSelected(Mirror mirror) {
        Log.e("cat", mirror.toString());
        BrowserFragment browserFragment = BrowserFragment.newInstance(mirror.getEmbedURL());
//        BrowserFragment browserFragment = new BrowserFragment();
//        Bundle args = new Bundle();
//        args.putInt(BrowserFragment.ARG_URL, mirror.getEmbedURL();
//        browserFragment.setArguments(args);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.root, browserFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
