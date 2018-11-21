package com.example.android.animepal;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.ListPreloader;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.integration.recyclerview.RecyclerViewPreloader;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.util.ViewPreloadSizeProvider;
import com.example.android.animepal.dummy.DummyContent;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements ReleaseListFragment.OnListFragmentInteractionListener{
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

    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
