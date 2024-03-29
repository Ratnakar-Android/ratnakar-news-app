package com.news.network;

import com.example.abhishek.newsapp.BuildConfig;
import com.example.abhishek.newsapp.models.ArticleResponseWrapper;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * An Api interface to send network requests
 * Includes Category enum that provides category names for requests
 */
public interface NewsApi {
    String API_KEY = BuildConfig.NewsApiKey;

    @Headers("X-Api-Key:" + API_KEY)
    @GET("/v2/top-headlines")
    Single<Response<ArticleResponseWrapper>> getHeadlines(
            @Query("category") String category,
            @Query("country") String country
    );


    enum Category {
        business("Business"),
        entertainment("Entertainment"),
        general("General"),
        health("Health"),
        science("Science"),
        sports("Sports"),
        technology("Technology");

        public final String title;

        Category(String title) {
            this.title = title;
        }
    }
}