package com.news.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.news.R;
import com.news.fragment.NewsFragment;
import com.news.network.NewsApi;

public class NewsAppMainActivity extends AppCompatActivity {
    private final FragmentManager fragmentManager = getSupportFragmentManager();
    private NewsAppMainActivityBinding binding;
    private NewsFragment mNewsFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        if (savedInstanceState == null) {
            mNewsFragment = NewsFragment.newInstance(NewsApi.Category.valueOf(general.name()));
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container, mNewsFragment)
                    .commit();
        }
        setupToolbar();

    }

    private void setupToolbar() {
        setSupportActionBar(binding.toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.app_name));
        }
    }
}
