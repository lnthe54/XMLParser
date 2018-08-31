package com.example.dohoa.xmlparser.model;

import android.os.AsyncTask;

import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class XMLAsync extends AsyncTask<String, Void, ArrayList<News>> {
    private XMLParserCallBack callBack;

    public XMLAsync(XMLParserCallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    protected ArrayList<News> doInBackground(String... strings) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XMLParser xmlParser = new XMLParser();
            String link = strings[0];

            parser.parse(link, xmlParser);

            return xmlParser.getListNew();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(ArrayList<News> news) {
        super.onPostExecute(news);
        callBack.onParseResult(news);
    }

    public interface XMLParserCallBack {
        void onParseResult(ArrayList<News> listNews);
    }
}
