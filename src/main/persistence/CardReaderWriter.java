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


    public CardReaderWriter() {
        //https://mkyong.com/java/how-to-parse-json-with-gson/
        libraryWriter = new GsonBuilder().setPrettyPrinting().create();

    }

    //Effect: Save card library to desired location
    public void saveLibrary(HashMap library, String path) {
        try {
            FileWriter file = new FileWriter(path);
            libraryWriter.toJson(library, file);
            //https://stackoverflow.com/questions/45995067/writer-not-working-for-json
            // -file-using-gson-json-file-is-blank-after-code-execu
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //EFFECT: Loads the library from the desired location
    public HashMap<String, Card> readLibrary(String path, Type type) {
        HashMap<String, Card> clonedLibrary = new HashMap<>();
        try {
            FileReader reader = new FileReader(path);
            clonedLibrary = libraryWriter.fromJson(reader, type);
            return clonedLibrary;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return clonedLibrary;
    }



}

