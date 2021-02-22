package chemicalboy.base;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;


public class JSoupConnection {

    public ArrayList<String> stringsFromWeb(ArrayList<String> webs) {

        ArrayList<String> toBackFromWeb = new ArrayList<>();

        Connection connect = Jsoup.connect("http://www.onet.pl/");

        try {
            Document document = connect.get();

            Elements links = document.select("span.title");
            for (Element elem : links) {
                System.out.println(elem.text());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return toBackFromWeb;

    }
}
