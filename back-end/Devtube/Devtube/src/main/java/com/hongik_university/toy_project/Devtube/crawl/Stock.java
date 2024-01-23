package com.hongik_university.toy_project.Devtube.crawl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Stock {
    public static void main(String[] args) throws IOException {
        String url = "https://www.youtube.com/@codingapple/playlists";

        // UTF-8로 파싱
        Document doc = Jsoup.connect(url).get();

        // 동영상 목록의 각 항목을 선택하는 선택자
        Elements videoDetailsElements = doc.select(".video-details");

        // 각 동영상의 제목 출력
        for (Element videoDetailsElement : videoDetailsElements) {
            Element titleElement = videoDetailsElement.selectFirst(".video-title");
            System.out.println("Title: " + titleElement.text());
        }

        // og:title 속성 값 가져오기
        Element metaTag = doc.select("meta[property=og:title]").first();
        if (metaTag != null) {
            String ogTitle = metaTag.attr("content");
            System.out.println("og:title: " + ogTitle);
        } else {
            System.out.println("og:title not found.");
        }

        System.out.println(doc);
    }
}
