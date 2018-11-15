package com.example.android.animepal;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class ReleasesRepository {
    private final String baseURL = "https://www.masterani.me/";
    private OkHttpClient client;

    public ReleasesRepository(OkHttpClient client) {
        this.client = client;
    }

    public void getReleases(final ReleasesListener listener){
//        MoshiConverterFactory.create()
        Retrofit.Builder  builder = new Retrofit.Builder()
                .baseUrl(baseURL)
//                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client);
        Retrofit retrofit = builder
                .build();

        ReleasesService service = retrofit.create(ReleasesService.class);

        Observable<List<Release>> releasesObservable = service.getReleases();

        releasesObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()


//        releasesCall.enqueue(new Callback<List<Release>>() {
//            @Override
//            public void onResponse(Call<List<Release>> call, Response<List<Release>> response) {
//                List<Release> releases = response.body();
//                listener.callback(releases);
//            }
//
//            @Override
//            public void onFailure(Call<List<Release>> call, Throwable t) {
//
//            }
//        });
    }

}
