package com.du.technicaltest.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class MoviesResponse {

    @SerializedName("results")
    private List<MovieModel> results;

    public List<MovieModel> getResults() {
        return results;
    }

    public void setResults(List<MovieModel> results) {
        this.results = results;
    }

}
