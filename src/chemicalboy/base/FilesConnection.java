package chemicalboy.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class FilesConnection {

    public void saveToFile(ArrayList<String> stringsToSave, String path, boolean saveAsNext){

        try{
            FileWriter fileWriter = new FileWriter(path, saveAsNext);

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

    public void deleteForbiddenWords(String pathForbidden, String pathRead, String pathSave){

        try {

            File fileRead = new File(pathRead);
            File fileForbidden = new File(pathForbidden);
            FileWriter fileWriter = new FileWriter(pathSave, false);

            Scanner scanForbidden = new Scanner(fileForbidden);
            Scanner scanFile = new Scanner(fileRead);

            ArrayList<String> arrayForbidden = new ArrayList<>();

            while (scanForbidden.hasNextLine()){
                arrayForbidden.add(scanForbidden.nextLine());
            }


            while(scanFile.hasNextLine()) {

                String simpeWord = scanFile.nextLine();

                boolean isForbidden = arrayForbidden.stream().anyMatch(s -> s.equals(simpeWord));

                if(!isForbidden){
                    fileWriter.append(simpeWord).append("\n");
                }

            }

            fileWriter.close();

        }catch (FileNotFoundException ex){
            System.out.println("nie znaleziono pliku");
        }catch (IOException ex){
            System.out.println("błąd zapisu");
        }


    }

    public void countElements (String pathIn, String pathOut) {

        Map<String, Long> resultMap = new HashMap<>();

        try {

            File file = new File(pathIn);
            Scanner scanner = new Scanner(file);

            List<String> wordList = new ArrayList<>();

            while (scanner.hasNextLine()) {
                wordList.add(scanner.nextLine());
            }


            wordList.forEach(e -> resultMap.put(e, resultMap.getOrDefault(e, 0L) + 1L));


        } catch (FileNotFoundException ex) {
            System.out.println("nie znaleziono pliku");
        }

        try {
            FileWriter fileWriter = new FileWriter(pathOut, false);
            List<Map.Entry<String,Long>>list = new ArrayList<>(resultMap.entrySet());
            list.sort(Map.Entry.comparingByValue());
                     


            for(Map.Entry<String,Long> entry : list){
                fileWriter.append(entry.getKey() + " " + entry.getValue() + "\n");

            }
            fileWriter.close();


        }catch (IOException ex){
            System.out.println("błąd zapisu do pliku");
        }


    }



}
