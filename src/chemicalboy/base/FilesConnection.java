package chemicalboy.base;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FilesConnection {

    public void saveToFile(ArrayList<String> stringsToSave, String path){

        try{
            FileWriter fileWriter = new FileWriter(path, false);

            for(String str:stringsToSave){

                fileWriter.append(str).append(" ");
            }

            fileWriter.close();

        }catch (IOException e){
            System.out.println("Błąd zapisu");
        }

    }

}
