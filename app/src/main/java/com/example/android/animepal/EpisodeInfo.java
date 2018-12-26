
package com.example.android.animepal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EpisodeInfo {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("anime_id")
    @Expose
    private Integer animeId;
    @SerializedName("episode")
    @Expose
    private String episode;
    @SerializedName("title")
    @Expose
    private Object title;
    @SerializedName("tvdb_id")
    @Expose
    private Object tvdbId;
    @SerializedName("aired")
    @Expose
    private Object aired;
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("duration")
    @Expose
    private Integer duration;
    @SerializedName("description")
    @Expose
    private Object description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAnimeId() {
        return animeId;
    }

    public void setAnimeId(Integer animeId) {
        this.animeId = animeId;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public Object getTitle() {
        return title;
    }

    public void setTitle(Object title) {
        this.title = title;
    }

    public Object getTvdbId() {
        return tvdbId;
    }

    public void setTvdbId(Object tvdbId) {
        this.tvdbId = tvdbId;
    }

    public Object getAired() {
        return aired;
    }

    public void setAired(Object aired) {
        this.aired = aired;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

}
