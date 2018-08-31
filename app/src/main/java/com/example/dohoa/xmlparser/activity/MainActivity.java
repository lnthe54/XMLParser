package com.example.dohoa.xmlparser.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dohoa.xmlparser.R;
import com.example.dohoa.xmlparser.adapter.NewsAdapter;
import com.example.dohoa.xmlparser.model.News;
import com.example.dohoa.xmlparser.model.XMLAsync;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements XMLAsync.XMLParserCallBack {

    private RecyclerView rvListNews;
    private ArrayList<News> listNews = new ArrayList<>();
    private NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String link = "https://www.24h.com.vn/upload/rss/bongda.rsshttps://www.24h.com.vn/upload/rss/bongda.rss";
        XMLAsync async = new XMLAsync(this);
        async.execute(link);

        initViews();
    }

    private void initViews() {
        rvListNews = findViewById(R.id.rv_list_news);
        rvListNews.setLayoutManager(new LinearLayoutManager(MainActivity.this,
                LinearLayoutManager.VERTICAL, false));
        rvListNews.setHasFixedSize(true);

        newsAdapter = new NewsAdapter(this, listNews);
        rvListNews.setAdapter(newsAdapter);
    }

    @Override
    public void onParseResult(ArrayList<News> newListNews) {
        listNews.addAll(newListNews);
    }
}
