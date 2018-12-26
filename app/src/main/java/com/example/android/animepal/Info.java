
package com.example.android.animepal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Info {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("synopsis")
    @Expose
    private String synopsis;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("score")
    @Expose
    private Double score;
    @SerializedName("users_watching")
    @Expose
    private Integer usersWatching;
    @SerializedName("users_completed")
    @Expose
    private Integer usersCompleted;
    @SerializedName("users_on_hold")
    @Expose
    private Integer usersOnHold;
    @SerializedName("users_planned")
    @Expose
    private Integer usersPlanned;
    @SerializedName("users_dropped")
    @Expose
    private Integer usersDropped;
    @SerializedName("episode_count")
    @Expose
    private Integer episodeCount;
    @SerializedName("started_airing_date")
    @Expose
    private String startedAiringDate;
    @SerializedName("finished_airing_date")
    @Expose
    private Object finishedAiringDate;
    @SerializedName("youtube_trailer_id")
    @Expose
    private String youtubeTrailerId;
    @SerializedName("age_rating")
    @Expose
    private String ageRating;
    @SerializedName("episode_length")
    @Expose
    private Integer episodeLength;
    @SerializedName("tvdb_id")
    @Expose
    private Integer tvdbId;
    @SerializedName("tvdb_season_id")
    @Expose
    private Object tvdbSeasonId;
    @SerializedName("tvdb_episode")
    @Expose
    private Object tvdbEpisode;
    @SerializedName("wallpaper_id")
    @Expose
    private String wallpaperId;
    @SerializedName("wallpaper_offset")
    @Expose
    private Integer wallpaperOffset;
    @SerializedName("franchise_count")
    @Expose
    private Integer franchiseCount;

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

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getUsersWatching() {
        return usersWatching;
    }

    public void setUsersWatching(Integer usersWatching) {
        this.usersWatching = usersWatching;
    }

    public Integer getUsersCompleted() {
        return usersCompleted;
    }

    public void setUsersCompleted(Integer usersCompleted) {
        this.usersCompleted = usersCompleted;
    }

    public Integer getUsersOnHold() {
        return usersOnHold;
    }

    public void setUsersOnHold(Integer usersOnHold) {
        this.usersOnHold = usersOnHold;
    }

    public Integer getUsersPlanned() {
        return usersPlanned;
    }

    public void setUsersPlanned(Integer usersPlanned) {
        this.usersPlanned = usersPlanned;
    }

    public Integer getUsersDropped() {
        return usersDropped;
    }

    public void setUsersDropped(Integer usersDropped) {
        this.usersDropped = usersDropped;
    }

    public Integer getEpisodeCount() {
        return episodeCount;
    }

    public void setEpisodeCount(Integer episodeCount) {
        this.episodeCount = episodeCount;
    }

    public String getStartedAiringDate() {
        return startedAiringDate;
    }

    public void setStartedAiringDate(String startedAiringDate) {
        this.startedAiringDate = startedAiringDate;
    }

    public Object getFinishedAiringDate() {
        return finishedAiringDate;
    }

    public void setFinishedAiringDate(Object finishedAiringDate) {
        this.finishedAiringDate = finishedAiringDate;
    }

    public String getYoutubeTrailerId() {
        return youtubeTrailerId;
    }

    public void setYoutubeTrailerId(String youtubeTrailerId) {
        this.youtubeTrailerId = youtubeTrailerId;
    }

    public String getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }

    public Integer getEpisodeLength() {
        return episodeLength;
    }

    public void setEpisodeLength(Integer episodeLength) {
        this.episodeLength = episodeLength;
    }

    public Integer getTvdbId() {
        return tvdbId;
    }

    public void setTvdbId(Integer tvdbId) {
        this.tvdbId = tvdbId;
    }

    public Object getTvdbSeasonId() {
        return tvdbSeasonId;
    }

    public void setTvdbSeasonId(Object tvdbSeasonId) {
        this.tvdbSeasonId = tvdbSeasonId;
    }

    public Object getTvdbEpisode() {
        return tvdbEpisode;
    }

    public void setTvdbEpisode(Object tvdbEpisode) {
        this.tvdbEpisode = tvdbEpisode;
    }

    public String getWallpaperId() {
        return wallpaperId;
    }

    public void setWallpaperId(String wallpaperId) {
        this.wallpaperId = wallpaperId;
    }

    public Integer getWallpaperOffset() {
        return wallpaperOffset;
    }

    public void setWallpaperOffset(Integer wallpaperOffset) {
        this.wallpaperOffset = wallpaperOffset;
    }

    public Integer getFranchiseCount() {
        return franchiseCount;
    }

    public void setFranchiseCount(Integer franchiseCount) {
        this.franchiseCount = franchiseCount;
    }

}
