package com.example.dohoa.xmlparser.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dohoa.xmlparser.R;
import com.example.dohoa.xmlparser.model.News;
import com.example.dohoa.xmlparser.model.XMLAsync;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements XMLAsync.XMLParserCallBack {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String link = "https://www.24h.com.vn/upload/rss/bongda.rsshttps://www.24h.com.vn/upload/rss/bongda.rss";
        XMLAsync async = new XMLAsync(this);
        async.execute(link);
    }

    @Override
    public void onParseResult(ArrayList<News> listNews) {

    }
}
