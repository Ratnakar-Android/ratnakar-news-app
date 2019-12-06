package com.news.model;

import com.example.abhishek.newsapp.network.NewsApi;

import java.util.Locale;

public class Specification {

    private String category;
    // Default country
    private String country = Locale.getDefault().getCountry().toLowerCase();

    public String getCategory() {
        return category;
    }

    public void setCategory(NewsApi.Category category) {
        this.category = category.name();
    }

    public String getCountry() {
        return country;
    }

}
