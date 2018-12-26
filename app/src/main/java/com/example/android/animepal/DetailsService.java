package com.example.android.animepal;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DetailsService {
    @GET("api/anime/{id}/detailed")
    Observable<AnimeDetails> getAnimeDetails(@Path("id") int id);
}
