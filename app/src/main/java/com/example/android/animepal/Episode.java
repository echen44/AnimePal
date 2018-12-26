
package com.example.android.animepal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Episode {

    @SerializedName("info")
    @Expose
    private EpisodeInfo info;
    @SerializedName("thumbnail")
    @Expose
    private Object thumbnail;

    public EpisodeInfo getInfo() {
        return info;
    }

    public void setInfo(EpisodeInfo info) {
        this.info = info;
    }

    public Object getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Object thumbnail) {
        this.thumbnail = thumbnail;
    }

}
