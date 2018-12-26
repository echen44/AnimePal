
package com.example.android.animepal;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AnimeDetails {

    @SerializedName("info")
    @Expose
    private Info info;
    @SerializedName("synonyms")
    @Expose
    private List<Synonym> synonyms = null;
    @SerializedName("genres")
    @Expose
    private List<Genre> genres = null;
    @SerializedName("poster")
    @Expose
    private String poster;
    @SerializedName("franchise_count")
    @Expose
    private Integer franchiseCount;
    @SerializedName("wallpapers")
    @Expose
    private List<Wallpaper> wallpapers = null;
    @SerializedName("episodes")
    @Expose
    private List<Episode> episodes = null;

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<Synonym> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(List<Synonym> synonyms) {
        this.synonyms = synonyms;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Integer getFranchiseCount() {
        return franchiseCount;
    }

    public void setFranchiseCount(Integer franchiseCount) {
        this.franchiseCount = franchiseCount;
    }

    public List<Wallpaper> getWallpapers() {
        return wallpapers;
    }

    public void setWallpapers(List<Wallpaper> wallpapers) {
        this.wallpapers = wallpapers;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }

}
