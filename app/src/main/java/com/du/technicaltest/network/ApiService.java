package com.du.technicaltest.network;

import com.du.technicaltest.model.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("popular")
    Call<MoviesResponse> getMovieList(@Query("api_key") String apiKey);
}
