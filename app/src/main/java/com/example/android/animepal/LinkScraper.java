package com.example.android.animepal;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class LinkScraper implements Subscriber<String> {
    @Override
    public void onSubscribe(Subscription s) {

    }

    @Override
    public void onNext(String s) {

    }

    @Override
    public void onError(Throwable t) {

    }

    @Override
    public void onComplete() {

    }

    public static List<Mirror> scrape(String URL) {
        List<Mirror> mirrorList = null;
        try {
            Document doc = Jsoup.connect(URL).get();
            Element mirrors = doc.selectFirst("video-mirrors");
            String mirrorsString = mirrors.attr(":mirrors");
            Gson gson = new Gson();
            Type listMirrorType = new TypeToken<List<Mirror>>(){}.getType();
            mirrorList = gson.fromJson(mirrorsString, listMirrorType);
        }
        catch (IOException e) {
            Log.e("LinkScraper", "Scraping Error");
        }
        return mirrorList;
    }
}
