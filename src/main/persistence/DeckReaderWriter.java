package persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.*;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class DeckReaderWriter {

    private static final String TEST_FILE = "./data/Test/DeckTest1.txt";
    private static final String DECK = "./data/Decks/Deck1.txt";

    Gson deckReaderWriter;

    public DeckReaderWriter() {
        deckReaderWriter = new GsonBuilder().setPrettyPrinting().create();
    }

    public void saveDeck(Deck deck, String path) {
        try {
            FileWriter file = new FileWriter(path);
            deckReaderWriter.toJson(deck, file);
            //https://stackoverflow.com/questions/45995067/writer-not-working-for-json
            // -file-using-gson-json-file-is-blank-after-code-execu
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Deck readDeck(String path, Type type) {
        Deck clonedDeck = new Deck();
        try {
            FileReader deckReader = new FileReader(path);
            clonedDeck = deckReaderWriter.fromJson(deckReader, type);
            return clonedDeck;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return clonedDeck;
    }
}
