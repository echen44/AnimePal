package com.example.android.animepal;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ReleasesService {
    @GET("api/releases")
    Observable<List<Release>> getReleases();
}
