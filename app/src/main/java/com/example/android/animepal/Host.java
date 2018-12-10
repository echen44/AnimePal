
package com.example.android.animepal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Host {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("embed_prefix")
    @Expose
    private String embedPrefix;
    @SerializedName("embed_suffix")
    @Expose
    private Object embedSuffix;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmbedPrefix() {
        return embedPrefix;
    }

    public void setEmbedPrefix(String embedPrefix) {
        this.embedPrefix = embedPrefix;
    }

    public Object getEmbedSuffix() {
        return embedSuffix;
    }

    public void setEmbedSuffix(Object embedSuffix) {
        this.embedSuffix = embedSuffix;
    }

}
