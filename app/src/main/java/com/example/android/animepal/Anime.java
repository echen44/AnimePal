
package com.example.android.animepal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Anime {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("duration")
    @Expose
    private Integer duration;
    @SerializedName("age")
    @Expose
    private String age;
    @SerializedName("poster")
    @Expose
    private String poster;
    @SerializedName("wallpaper")
    @Expose
    private Object wallpaper;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Anime() {
    }

    /**
     * 
     * @param id
     * @param duration
     * @param title
     * @param wallpaper
     * @param age
     * @param poster
     * @param slug
     */
    public Anime(Integer id, String title, String slug, Integer duration, String age, String poster, Object wallpaper) {
        super();
        this.id = id;
        this.title = title;
        this.slug = slug;
        this.duration = duration;
        this.age = age;
        this.poster = poster;
        this.wallpaper = wallpaper;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Object getWallpaper() {
        return wallpaper;
    }

    public void setWallpaper(Object wallpaper) {
        this.wallpaper = wallpaper;
    }

}
