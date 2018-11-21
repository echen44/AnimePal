
package com.example.android.animepal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Release {

    @SerializedName("anime")
    @Expose
    private Anime anime;
    @SerializedName("episode")
    @Expose
    private String episode;
    @SerializedName("created_at")
    @Expose
    private String createdAt;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Release() {
    }

    /**
     * 
     * @param episode
     * @param createdAt
     * @param anime
     */
    public Release(Anime anime, String episode, String createdAt) {
        super();
        this.anime = anime;
        this.episode = episode;
        this.createdAt = createdAt;
    }

    public Anime getAnime() {
        return anime;
    }

    public void setAnime(Anime anime) {
        this.anime = anime;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

}
