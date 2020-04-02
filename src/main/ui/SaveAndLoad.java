package ui;

import model.Card;
import model.Deck;
import persistence.CardReaderWriter;
import persistence.DeckReaderWriter;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.lang.reflect.Type;
import java.util.HashMap;


public class SaveAndLoad extends PlaySound {

    CardReaderWriter cardReaderWriter;
    DeckReaderWriter deckReaderWriter;
    HashMap<String, Card> cardLibrary = new HashMap<>();

    private Deck deck;
    private JTextField saveTextField;
    private JButton saveDeckButton;
    private JFrame saveDeckFrame;


    public SaveAndLoad() {
        cardReaderWriter = new CardReaderWriter();
        deckReaderWriter = new DeckReaderWriter();
    }

    public void makeSaveLibraryWindow() {
        JFrame saveConfirmation = new JFrame("Library saved");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        JPanel sc = new JPanel();
        JLabel text = new JLabel("Library has been saved!");
        text.setFont(new Font("Arial", Font.PLAIN, 40));
        sc.add(text);
        saveConfirmation.setContentPane(sc);

        int width = screenSize.width * 2 / 9;
        int height = screenSize.height * 2 / 16;
        saveConfirmation.setSize(width, height);
        saveConfirmation.setLocationRelativeTo(null);
        saveConfirmation.setVisible(true);
    }

    public void saveLibrary(HashMap<String, Card> library, String path) {
        cardReaderWriter.saveLibrary(library, path);
    }

    public HashMap<String, Card> loadLibrary(String path, Type type) {
        cardLibrary = cardReaderWriter.readLibrary(path, type);
        return cardLibrary;
    }


    public void makeSaveDeckGUI(Deck deck) {
        this.deck = deck;
        saveDeckFrame = new JFrame();
        JPanel saveDeckLabel = new JPanel();
        setSaveDeckSize(saveDeckFrame);

        JLabel nameLabel = new JLabel("Choose a name for your deck");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 40));
        saveDeckLabel.add(nameLabel);

        JPanel saveDeckComponents = makeSaveDeckComponents();

        saveDeckFrame.add(saveDeckLabel, BorderLayout.PAGE_START);
        saveDeckFrame.add(saveDeckComponents, BorderLayout.CENTER);

    }

    private void setSaveDeckSize(JFrame saveDeckFrame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        saveDeckFrame.setSize(screenSize.width * 2 / 7, screenSize.height * 2 / 15);
        saveDeckFrame.setLocationRelativeTo(null);
        saveDeckFrame.setVisible(true);
    }

    private JPanel makeSaveDeckComponents() {
        JPanel saveDeckComponents = new JPanel();
        saveDeckComponents.setLayout(new GridLayout(1, 2));
        saveTextField = new JTextField(50);
        saveTextField.setFont(new Font("Arial", Font.PLAIN, 30));
        saveDeckComponents.add(saveTextField);

        saveDeckButton = new JButton("Save Deck");
        saveDeckButton.setFont(new Font("Arial", Font.PLAIN, 25));
        addSaveListener(saveDeckButton);
        saveDeckComponents.add(saveDeckButton);
        return saveDeckComponents;
    }

    private void addSaveListener(JButton saveDeckButton) {
        saveDeckButton.addActionListener(e -> {
            playSound(clickSound);
            String saveDummy = "./data/Decks/";
            String deckName = saveTextField.getText();
            deckName.replaceAll(" ", "_");
            saveDummy = saveDummy + deckName + ".txt";
            deckReaderWriter.saveDeck(deck, saveDummy);
            JOptionPane.showMessageDialog(saveDeckFrame, "Deck saved successfully!");
            saveDeckFrame.dispose();
        });
    }

    // EFFECT: opens file selection window allowing user to select the deck file they want to load
    public Deck loadDeck() {
        Type type = new TypeToken<Deck>() {
        }.getType();
        File startingPath = new File("./data/Decks");
        JFileChooser deckChoice = new JFileChooser();
        deckChoice.setFileSelectionMode(JFileChooser.FILES_ONLY);
        JDialog window = new JDialog((Window) null);
        window.setLocationRelativeTo(null);
        window.setFont(new Font("Arial", Font.PLAIN, 30));

        deckChoice.setCurrentDirectory(startingPath);
        deckChoice.showOpenDialog(window);
        String name = deckChoice.getSelectedFile().getName();

        String deckName = "./data/Decks/" + name;
        return deckReaderWriter.readDeck(deckName, type);
    }


}
