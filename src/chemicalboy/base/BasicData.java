package chemicalboy.base;

import java.util.ArrayList;

public class BasicData {

    private String path = "basic_file.txt";

    private String[] webTitles = {"onet","interia","wp"};

    private String begining = "http://www.";

    private String ends = ".pl/";

    public ArrayList<String> takeWebs(){

        ArrayList<String> stringsToBack = new ArrayList<>();

        for(int i = 0; i < webTitles.length; i++){

            StringBuilder stringBuilder = new StringBuilder();
            stringsToBack.add(stringBuilder.append(begining).append(webTitles[i]).append(ends).toString());

        }

        return stringsToBack;

    }

    public String getPath() {
        return path;
    }
}
