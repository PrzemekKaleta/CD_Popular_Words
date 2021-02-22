package chemicalboy.base;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {




        JSoupConnection jsoup = new JSoupConnection();
        BasicData basicData = new BasicData();
        FilesConnection filesConnection = new FilesConnection();

        //TO CHECK
        ArrayList<String> stringToCheck = new ArrayList<>();

        stringToCheck.add("cat");
        stringToCheck.add("dog");
        stringToCheck.add("mice");

        filesConnection.saveToFile(stringToCheck, basicData.getPath());







    }
}
