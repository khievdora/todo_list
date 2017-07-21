package dora.edu.data.cache;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Dora on 7/21/2017.
 */

@Singleton
public class FileManager {

    @Inject
    public FileManager() {

    }

    public void writeToFile(File file, String fileContent) {
        if (!file.exists()) {
            FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter(file);
                fileWriter.write(fileContent);
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String readFromFile(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        if (file.exists()) {
            String stringLine = null;
            try {
                FileReader fileReader  = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                while((stringLine = bufferedReader.readLine()) != null) {
                    stringBuilder.append(stringLine).append("\n");
                }
                bufferedReader.close();
                fileReader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }

}
