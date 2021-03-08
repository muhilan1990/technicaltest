package com.du.technicaltest.model;

import com.google.gson.annotations.SerializedName;


public class MovieModel {

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("title")
    private String title;

    public MovieModel(String posterPath, String title) {
        this.posterPath = posterPath;
        this.title = title;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath =  posterPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
