package chemicalboy.base;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;


public class JSoupConnection {

    public ArrayList<String> stringsFromWeb(String web) {

        ArrayList<String> toBackFromWeb = new ArrayList<>();

        Connection connect = Jsoup.connect(web);

        toBackFromWeb.add(web);

        try {
            Document document = connect.get();

            Elements links = document.select("a");
            for (Element elem : links) {
                toBackFromWeb.add(elem.text());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        toBackFromWeb.add("");

        return toBackFromWeb;

    }
}
