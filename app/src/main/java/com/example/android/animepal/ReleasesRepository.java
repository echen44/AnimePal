package com.example.android.animepal;

import java.util.List;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
public class ReleasesRepository {
    private final String baseURL = "https://www.masterani.me/";
    private OkHttpClient client;
    private ReleaseListFragment view;

    public ReleasesRepository(OkHttpClient client, ReleaseListFragment view) {
        this.client = client;
        this.view = view;
    }

    public void getReleases(final ReleasesListener listener){


        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client);
        Retrofit retrofit = builder
                .build();

        ReleasesService service = retrofit.create(ReleasesService.class);

        Observable<List<Release>> releasesObservable = service.getReleases();

        releasesObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResults);


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

    private void handleResults(List<Release> releases){
        view.callback(releases);
    }
}
