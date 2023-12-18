package com.example.jsoup;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupTest {
    public static void main(String[] args) {
        try {
            String url = "https://tw.stock.yahoo.com/quote/2330.TW";
            Document doc = Jsoup.connect(url).get();

            Elements spans = doc.select("span");
            for (Element span : spans) {
                if (span.hasClass("Fw(600)")) {
                    System.out.println(span.text());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}