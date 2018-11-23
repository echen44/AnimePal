
package com.example.android.animepal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Synonym {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("type")
    @Expose
    private Integer type;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

}
