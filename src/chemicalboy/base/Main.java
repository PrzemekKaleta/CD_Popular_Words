package chemicalboy.base;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        JSoupConnection jSoupConnection = new JSoupConnection();
        BasicData basicData = new BasicData();
        FilesConnection filesConnection = new FilesConnection();


        ArrayList<String> linksToSearch = basicData.takeWebs();

        for(int i = 0; i < linksToSearch.size(); i++){

            filesConnection.saveToFile(jSoupConnection.stringsFromWeb(linksToSearch.get(i)),basicData.getPath());

            System.out.println("iteracja = " + i + " " + linksToSearch.get(i));
        }









    }
}
