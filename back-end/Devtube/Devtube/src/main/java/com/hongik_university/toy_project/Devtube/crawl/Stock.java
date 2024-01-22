package com.hongik_university.toy_project.Devtube.crawl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Stock {
    public static void main(String[] args) throws IOException {
        String url = "https://www.youtube.com/@codingapple/playlists";
        Document doc = Jsoup.connect(java.net.URLEncoder.encode(url,"utf-8")).header("User-Agent" , "Mozilla/5.0").get();

        System.out.println(doc);
        Elements e1=doc.getElementsByAttributeValue("class","yt-simple-endpoint style-scope yt-formatted-string");
        Element e2 = doc.getElementById("details");
        System.out.println(e2);
        System.out.println(e1.text());
    }
}
