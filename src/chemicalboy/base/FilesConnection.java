package chemicalboy.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FilesConnection {

    public void saveToFile(ArrayList<String> stringsToSave, String path){

        try{
            FileWriter fileWriter = new FileWriter(path, true);

            for(String str:stringsToSave){

                fileWriter.append(str).append("\n");
            }

            fileWriter.close();

        }catch (IOException e){
            System.out.println("Błąd zapisu");
        }

    }

    public void reReadFile(int lengthLine, int lengthWord, String pathRead, String pathSave){

        try {

            File file = new File(pathRead);
            FileWriter fileWriter = new FileWriter(pathSave, false);

            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine()) {

                String lineFile = scanner.nextLine().replaceAll("(\\.|,|\\?|\"|!|:)","");


                if (lineFile.length() > lengthLine) {

                    String[] words = lineFile.split(" ");

                    for (int i = 0; i < words.length; i++) {

                        if (words[i].trim().length() > lengthWord) {

                            fileWriter.append(words[i].trim().toLowerCase()).append("\n");
                        }

                    }

                }

            }

            fileWriter.close();

        }catch (FileNotFoundException ex){
            System.out.println("nie znaleziono pliku");
        }catch (IOException ex){
            System.out.println("błąd zapisu");
        }

    }

}
