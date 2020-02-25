package persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.*;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;


public class CardReaderWriter {

    private static final String TEST_FILE = "./data/Test/CardLibrary.txt";
    private static final String HS_CARD_LIBRARY = "./data/Cards/HSCardLibrary.txt";
    Gson libraryWriter;
    Gson cardWriter;

    public CardReaderWriter() {
        //https://mkyong.com/java/how-to-parse-json-with-gson/
        cardWriter = new GsonBuilder().setPrettyPrinting().create();
        libraryWriter = new GsonBuilder().setPrettyPrinting().create();

    }

    public void saveLibrary(HashMap library, String path) {
        try {
            FileWriter file = new FileWriter(path);
            libraryWriter.toJson(library, file);
            //https://stackoverflow.com/questions/45995067/writer-not-working-for-json
            // -file-using-gson-json-file-is-blank-after-code-execu
            file.flush();
            file.close();

            String testLibrary = libraryWriter.toJson(library);
            System.out.println(testLibrary);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public HashMap<String, Card> readLibrary(String path, Type type) {
        try {
            FileReader reader = new FileReader(path);
            HashMap<String, Card> clonedLibrary = libraryWriter.fromJson(reader, type);
            System.out.println(clonedLibrary);
            return clonedLibrary;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}


}

