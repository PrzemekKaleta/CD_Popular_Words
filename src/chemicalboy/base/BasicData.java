package chemicalboy.base;

import java.util.ArrayList;

public class BasicData {

    private String pathBasis = "basic_file.txt";

    private String pathSecond = "second_file.txt";

    private String pathThird = "third_File.txt";

    private String pathEnd = "end_file.txt";

    private String pathForbiddenWords = "forbidden_words.txt";

    private String[] webTitles = {"onet","interia","wp"};

    private String begining = "http://www.";

    private String ends = ".pl/";

    private int lenghtWord = 3;

    private int lenghtLine = 25;

    public ArrayList<String> takeWebs(){

        ArrayList<String> stringsToBack = new ArrayList<>();

        for(int i = 0; i < webTitles.length; i++){

            StringBuilder stringBuilder = new StringBuilder();
            stringsToBack.add(stringBuilder.append(begining).append(webTitles[i]).append(ends).toString());

        }

        return stringsToBack;

    }

    public String getPathBasis() {
        return pathBasis;
    }

    public String getPathSecond() {
        return pathSecond;
    }

    public String getPathThird() {
        return pathThird;
    }

    public int getLenghtWord() {
        return lenghtWord;
    }

    public int getLenghtLine() {
        return lenghtLine;
    }

    public String getPathForbiddenWords() {
        return pathForbiddenWords;
    }

    public String getPathEnd() {
        return pathEnd;
    }
}
