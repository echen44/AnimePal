
package com.example.android.animepal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Mirror {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("host_id")
    @Expose
    private Integer hostId;
    @SerializedName("embed_id")
    @Expose
    private String embedId;
    @SerializedName("quality")
    @Expose
    private Integer quality;
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("host")
    @Expose
    private Host host;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHostId() {
        return hostId;
    }

    public void setHostId(Integer hostId) {
        this.hostId = hostId;
    }

    public String getEmbedId() {
        return embedId;
    }

    public void setEmbedId(String embedId) {
        this.embedId = embedId;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

}
