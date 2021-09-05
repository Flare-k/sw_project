package project.core.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.IOException;




public class CrollingController {
    public void getDataFromWeb() throws IOException {
        Document doc = Jsoup.connect("https://www.afreecatv.com/total_search.html?szLocation=vod_main&szSearchType=video&szKeyword=%EA%B3%A0%EC%96%91%EC%9D%B4&szStype=di&szActype=&has_hint=false&pk_cnt=0").get();
        log(doc.body().data());
    }
    private static void log(String msg, String... vals) {
        System.out.println(String.format(msg, vals));
    }
}
