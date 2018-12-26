package com.example.android.animepal;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class AnimeDetailsRepository {
    private final String baseURL = "https://www.masterani.me/";
    private OkHttpClient client;
    private EpisodeFragment view;

    public AnimeDetailsRepository(OkHttpClient client, EpisodeFragment view) {
        this.client = client;
        this.view = view;
    }

    public void getEpisodes(int id) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client);
        Retrofit retrofit = builder
                .build();

        DetailsService service = retrofit.create(DetailsService.class);

        Observable<AnimeDetails> episodesObservable = service.getAnimeDetails(id);

        episodesObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResults);
    }

    private void handleResults(AnimeDetails details) {
        view.callback(details);
    }
}