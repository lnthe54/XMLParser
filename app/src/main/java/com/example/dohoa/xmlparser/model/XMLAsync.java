package com.example.dohoa.xmlparser.model;

import android.os.AsyncTask;

import java.util.ArrayList;

import javax.xml.parsers.SAXParserFactory;

public class XMLAsync extends AsyncTask<String, Void, ArrayList<News>> {
    @Override
    protected ArrayList<News> doInBackground(String... strings) {
        try{
            SAXParserFactory
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(ArrayList<News> news) {
        super.onPostExecute(news);
    }
}
