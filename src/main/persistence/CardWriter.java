package persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.google.gson.reflect.TypeToken;
import model.*;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;


public class CardWriter {

    private static final String TEST_FILE = "./data/Test/CardLibrary.txt";
    GsonBuilder libWriter;
    Gson libraryWriter;
    Gson cardWriter;

    public CardWriter() {
        //https://mkyong.com/java/how-to-parse-json-with-gson/
        cardWriter = new GsonBuilder().setPrettyPrinting().create();
        libraryWriter = new GsonBuilder().setPrettyPrinting().create();

    }

    public void saveCard(Card card) {
        String gsonCard = cardWriter.toJson(card);
        System.out.println(gsonCard);
    }

    public void saveLibrary(HashMap library) {
        try {
            FileWriter file = new FileWriter(TEST_FILE);
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

    public HashMap<String, Card> exportLibrary(Type type) {
        try {
            FileReader reader = new FileReader(TEST_FILE);
            HashMap<String, Card> clonedLibrary = libraryWriter.fromJson(reader, type);
            System.out.println(clonedLibrary);
            return clonedLibrary;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


}

