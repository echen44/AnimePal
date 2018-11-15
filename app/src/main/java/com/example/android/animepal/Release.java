package com.example.android.animepal;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Release {
    private Anime anime;
    private int episode;
    private Date created_at;

    public Release(Anime anime, int episode, String created_at_string){
        this.anime = anime;
        this.episode = episode;

    }

    public Release(JSONObject jsonObject) throws JSONException{
        this.anime = new Anime(jsonObject.getJSONObject("anime"));
        this.episode = jsonObject.getInt("episode");
        try {
            created_at =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).parse(jsonObject.getString("created_at"));
        }
        catch (ParseException e){
            Log.e("Release", "Error Parsing Date");
        }
    }

    public Anime getAnime() {
        return anime;
    }

    public void setAnime(Anime anime) {
        this.anime = anime;
    }

    public int getEpisode() {
        return episode;
    }

    public void setEpisode(int episode) {
        this.episode = episode;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public static ArrayList<Release> parseResponse(String response) throws JSONException{
//        JSONArray jsonArray = new JSONArray(response);
        ArrayList<Release> releases = new ArrayList<>();
//        Release release;
        JSONArray jsonArray = new JSONArray(response);
        for (int i=0; i<jsonArray.length(); i++) {
            releases.add(new Release(jsonArray.getJSONObject(i)));
        }
        return releases;
    }
}
