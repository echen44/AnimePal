package com.example.android.animepal;

import android.app.Activity;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Anime {
    private final String posterAPI = "https://cdn.masterani.me/poster/1/";
    public enum Age {
        NONE("None"), G("G - All Ages"), PG("PG - Children"), PG13("PG-13 - Teens 13 or older"), R("R - 17+ (violence & profanity)");

        private String age;

        private static final Map<String, Age> lookup = new HashMap<String, Age>();

        static {
            for (Age a : Age.values()){
                lookup.put(a.age(), a);
            }
        }

        Age(String age) {
            this.age = age;
        }
        public String age(){
            return age;
        }

        public static Age get(String age) {
            return lookup.get(age);
        }
    }
    private Activity activity;
    private int id;
    private String title;
    private String slug;
    private int duration;
    private Age age;
    private String posterURL;
    private String wallpaperURL;

    public Anime(Activity activity,
                 int id,
                 String title,
                 String slug,
                 int duration,
                 Anime.Age age,
                 String posterURL,
                 String wallpaperURL) {
        this.activity = activity;
        this.id = id;
        this.title = title;
        this.slug = slug;
        this.duration = duration;
        this.age = age;
        this.posterURL = posterURL;
        this.wallpaperURL = wallpaperURL;
    }

    public Anime(JSONObject jsonObject){
        try {
            this.id = jsonObject.getInt("id");
        }
        catch (JSONException e){
            Log.e("Anime", "error getting id");
        }

        try {
            this.title = jsonObject.getString("title");
        }
        catch (JSONException e){
            Log.e("Anime", "error getting title");
        }

        try {
            this.slug = jsonObject.getString("slug");
        }
        catch (JSONException e){
            Log.e("Anime", "error getting slug");
        }

        this.duration = jsonObject.optInt("duration");

        try {
            this.age = Age.get(jsonObject.getString("age"));
        }
        catch (JSONException e){
            Log.e("Anime", "error getting age");
        }

        try {
            this.posterURL = jsonObject.getString("poster");
//            Glide.with(activity).load(posterAPI + posterURL).apply(RequestOptions.noTransformation());
        }
        catch (JSONException e){
            Log.e("Anime", "error getting poster");
        }

        this.wallpaperURL = jsonObject.optString("wallpaper");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Anime.Age getAge() {
        return age;
    }

    public void setAge(Anime.Age age) {
        this.age = age;
    }

    public String getPosterURL() {
        return posterURL;
    }

    public void setPosterURL(String posterURL) {
        this.posterURL = posterURL;
    }

    public String getWallpaperURL() {
        return wallpaperURL;
    }

    public void setWallpaperURL(String wallpaperURL) {
        this.wallpaperURL = wallpaperURL;
    }
}
