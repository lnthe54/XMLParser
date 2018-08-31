package com.example.dohoa.xmlparser.model;

import com.example.dohoa.xmlparser.config.XMLTag;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class XMLParser extends DefaultHandler {
    private ArrayList<News> listNew = new ArrayList<>();
    private News news;
    private String value;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if (qName.equals(XMLTag.ITEM)) {
            news = new News();
        }
        value = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        value += new String(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if (news == null) {
            return;
        }

        switch (qName) {
            case XMLTag.TITLE: {
                news.setTitle(value);
                break;
            }
            case XMLTag.DESCRIPTION: {
                String src = "src'";
                int index = value.indexOf(src) + src.length();
                value = value.substring(index);
                String img = value.substring(0, value.indexOf("'"));
                news.setImage(img);

                String br = "</a><br />";
                index = value.indexOf(br) + br.length();
                String desc = value.substring(index);
                news.setDescription(desc);
                break;
            }
            case XMLTag.PUB_DATE: {
                news.setPubDate(value);
                break;
            }
            case XMLTag.LINK: {
                news.setLink(value);
                break;
            }
            case XMLTag.ITEM: {
                listNew.add(news);
                break;
            }
        }
    }

    public ArrayList<News> getListNew() {
        return listNew;
    }
}
