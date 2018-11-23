package com.example.android.animepal;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.bumptech.glide.RequestManager;
import com.example.android.animepal.dummy.DummyContent;

import java.util.ArrayList;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity implements ReleaseListFragment.AnimeSelectedListener, EpisodeFragment.OnListFragmentInteractionListener {
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
//        thumbnailRequest = GlideApp.with(this);
//
////        set up the recycler view
//        view = findViewById(R.id.recyclerview);
//        view.setHasFixedSize(true);
//        mLayoutManager = new GridLayoutManager(this, spanCount);
//        view.setLayoutManager(mLayoutManager);
////        postersAdapter = new PostersAdapter(releases, this);
////        view.setAdapter(postersAdapter);
//
////        api request, get EVERYTHING
//        final Request request = new Request.Builder().url(releasesURL).build();
//        JSONArray jsonArray;
//        client = new OkHttpClient();
//        try {
//            client.newCall(request).enqueue(new Callback() {
//                @Override
//                public void onFailure(Call call, IOException e) {
//
//                }
//
//                @Override
//                public void onResponse(Call call, Response response) throws IOException {
//                    final String string = response.body().string();
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            Log.e("mainactivity", "http request");
//                            update(string);
//                        }
//                    });
//
//                }
//            });
//        }
//        catch (NullPointerException e){
//            e.printStackTrace();
//        }
    }

//    private void update(String string){
//        try{
//            releases = Release.parseResponse(string);
//        }
//        catch (JSONException e){
//            Log.e("MainActivity", "error update");
//        }
//        postersAdapter = new PostersAdapter(releases, this);
//
////        ListPreloader.PreloadSizeProvider sizeProvider = new ViewPreloadSizeProvider();
////        ListPreloader.PreloadModelProvider modelProvider = new AnimePreloadModelProvider();
////        RecyclerViewPreloader<Release> preloader = new RecyclerViewPreloader<Release>(GlideApp.with(this), modelProvider, sizeProvider, 6);
////        view.addOnScrollListener(preloader);
//
//
//        view.setAdapter(postersAdapter);
////        textView.setText(releases.get(5).getAnime().getTitle());
////        Glide.with(this).load(new String(posterURL).concat(releases.get(2).getAnime().getPosterURL())).apply(RequestOptions.noTransformation()).into(view);
//
//    }

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
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
