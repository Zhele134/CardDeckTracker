package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Type;
import java.util.HashMap;

import com.google.gson.reflect.TypeToken;
import model.Deck;
import model.Card;
import model.CardInDeck;


public class DeckGUI extends PlaySound implements ActionListener {

    private Deck deck;
    private HashMap<String, Card> library = new HashMap<>();
    private static final String HS_CARD_LIBRARY = "./data/Cards/HSCardLibrary.txt";

    private JTextArea deckText;
    private JButton addCard;
    private JButton removeCard;
    private JButton saveDeck;
    private JButton loadDeck;

    private JFrame removeCardFrame;
    private JButton removeCardButton;
    private JTextField removeCardTextField;

    private JButton addCardButton;

    private JTextField addCardTextField;
    private JTextField addCardCopiesTextField;
    private JFrame addCardFrame;

    private SaveAndLoad saveAndLoad;


    public DeckGUI() {
        makeDeckGUI();
    }

    public void makeDeckGUI() {
        initializeFields();
        JFrame deckWindow = new JFrame("Build deck");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setDeckWindowSize(deckWindow, screenSize);

        deckWindow.add(makeDeckButtons(), BorderLayout.LINE_START);
        deckWindow.add(makeDeckText(), BorderLayout.CENTER);
    }

    public void initializeFields() {
        deck = new Deck();
        saveAndLoad = new SaveAndLoad();
        Type type = new TypeToken<HashMap<String, Card>>() {
        }.getType();
        library = saveAndLoad.loadLibrary(HS_CARD_LIBRARY, type);
    }

    private void setDeckWindowSize(JFrame deckWindow, Dimension screenSize) {
        int width = screenSize.width * 2 / 4;
        int height = screenSize.height * 2 / 3;
        deckWindow.setSize(width, height);
        deckWindow.setLocationRelativeTo(null);
        deckWindow.setVisible(true);
    }

    private JPanel makeDeckButtons() {
        JPanel deckButtons = new JPanel();
        deckButtons.setLayout(new GridLayout(4, 1));
        deckButtons.add(makeAddCardButton());
        deckButtons.add(makeRemoveCardButton());
        deckButtons.add(makeSaveDeckButton());
        deckButtons.add(makeLoadDeckButton());
        changeFieldText(deckButtons, new Font("Arial", Font.PLAIN, 40));
        return deckButtons;
    }

    private JButton makeAddCardButton() {
        addCard = new JButton("Add Card");
        addCard.addActionListener(this);
        return addCard;
    }

    private JButton makeRemoveCardButton() {
        removeCard = new JButton("Remove Card");
        removeCard.addActionListener(this);
        return removeCard;
    }

    private JButton makeSaveDeckButton() {
        saveDeck = new JButton("Save Deck");
        saveDeck.addActionListener(this);
        return saveDeck;
    }

    private JButton makeLoadDeckButton() {
        loadDeck = new JButton("Load Deck");
        loadDeck.addActionListener(this);
        return loadDeck;
    }

    //https://stackoverflow.com/questions/12730230/set-the-same-font-for-all-component-java
    private void changeFieldText(Component component, Font font) {
        component.setFont(font);
        if (component instanceof Container) {
            for (Component child : ((Container) component).getComponents()) {
                changeFieldText(child, font);
            }
        }
    }

    private JPanel makeDeckText() {
        JPanel deckTextPanel = new JPanel();
        deckText = new JTextArea(40, 35);
        deckText.setEditable(false);
        deckTextPanel.add(deckText);
        changeFieldText(deckTextPanel, new Font("Arial", Font.PLAIN, 30));
        updateDeckText();
        return deckTextPanel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveDeck) {
            playSound(clickSound);
            saveAndLoad.makeSaveDeckGUI(deck);
        } else if (e.getSource() == loadDeck) {
            playSound(clickSound);
            deck = saveAndLoad.loadDeck();
            updateDeckText();
        } else if (e.getSource() == addCard) {
            playSound(clickSound);
            addCard();
        } else if (e.getSource() == removeCard) {
            playSound(clickSound);
            removeCard();
        }

    }


    public void addCard() {
        addCardFrame = new JFrame();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        addCardFrame.setSize(screenSize.width * 2 / 6, screenSize.height * 2 / 5);
        addCardFrame.setLocationRelativeTo(null);
        addCardFrame.setVisible(true);

        JPanel addCardComponents = makeAddCardComponents();
        addCardFrame.add(addCardComponents, BorderLayout.PAGE_START);
        JTextArea cardLibrary = new JTextArea();
        cardLibrary.append("CARD LIBRARY \r\n ------------------------ \r\n\n");
        cardLibrary.setFont(new Font("Arial", Font.PLAIN, 25));
        for (String name : library.keySet()) {
            cardLibrary.append(name + "\r\n");
        }
        JScrollPane sp = new JScrollPane(cardLibrary);
        addCardFrame.add(sp, BorderLayout.CENTER);

    }

    private JPanel makeAddCardComponents() {
        JPanel addCardComponents = new JPanel();
        addCardComponents.setLayout(new GridLayout(2, 3));
        addCardTextField = new JTextField(50);
        addCardTextField.setFont(new Font("Arial", Font.PLAIN, 30));
        JLabel namePanel = new JLabel("Card name: ");
        namePanel.setFont(new Font("Arial", Font.PLAIN, 30));
        addCardComponents.add(namePanel);
        addCardComponents.add(addCardTextField);

        addCardButton = new JButton("Add Card");
        addCardButton.setFont(new Font("Arial", Font.PLAIN, 25));
        addAddCardListener(addCardButton);
        addCardComponents.add(addCardButton);

        addCardCopiesTextField = new JTextField(50);
        addCardCopiesTextField.setFont(new Font("Arial", Font.PLAIN, 25));
        JLabel copiesPanel = new JLabel("# of copies: ");
        copiesPanel.setFont(new Font("Arial", Font.PLAIN, 30));
        addCardComponents.add(copiesPanel);
        addCardComponents.add(addCardCopiesTextField);
        addCardComponents.add(new JLabel(""));
        return addCardComponents;
    }

    private void addAddCardListener(JButton addCardButton) {
        addCardButton.addActionListener(e -> {
            try {
                playSound(clickSound);
                String cardName = addCardTextField.getText();
                int cardCopies = getIntegerValue(addCardCopiesTextField.getText());
                if (library.containsKey(cardName)) {
                    if (deck.addCard(library.get(cardName), cardCopies)) {
                        JOptionPane.showMessageDialog(addCardFrame, "Card added successfully");
                        updateDeckText();
                    } else {
                        JOptionPane.showMessageDialog(addCardFrame, "Too many copies "
                                + "(2 max, 1 only for legendaries)", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(addCardFrame, "Card not found in library", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(addCardFrame, "Insert an integer for the copies value",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    //EFFECT: parses an Integer from a text field
    //https://stackoverflow.com/questions/41410863/numberformat-exception-for-converting-jtextfield-to-int/41410915#41410915
    private int getIntegerValue(String s) {
        return "".equals(s) ? 0 : Integer.parseInt(s);
    }

    public void removeCard() {
        removeCardFrame = new JFrame();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        removeCardFrame.setSize(screenSize.width * 2 / 6, screenSize.height * 2 / 18);
        removeCardFrame.setLocationRelativeTo(null);
        removeCardFrame.setVisible(true);

        JPanel removeCardComponents = makeRemoveCardComponents();
        removeCardFrame.add(removeCardComponents, BorderLayout.CENTER);
    }

    public JPanel makeRemoveCardComponents() {
        JPanel removeCardComponents = new JPanel();
        removeCardComponents.setLayout(new GridLayout(1, 3));

        JLabel removeCardLabel = new JLabel("Card To Remove: ");
        removeCardLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        removeCardComponents.add(removeCardLabel);

        removeCardTextField = new JTextField(50);
        removeCardTextField.setFont(new Font("Arial", Font.PLAIN, 30));
        removeCardComponents.add(removeCardTextField);

        removeCardButton = new JButton("Remove Card");
        removeCardButton.setFont(new Font("Arial", Font.PLAIN, 30));
        addRemoveCardListener(removeCardButton);
        removeCardComponents.add(removeCardButton);
        return removeCardComponents;
    }

    public void addRemoveCardListener(JButton removeCardButton) {
        removeCardButton.addActionListener(e -> {
            String cardName = removeCardTextField.getText();
            try {
                playSound(clickSound);
                if (library.containsKey(cardName)) {
                    deck.removeCard(library.get(cardName));
                    updateDeckText();
                    JOptionPane.showMessageDialog(removeCardFrame, "Card removed successfully");
                } else {
                    JOptionPane.showMessageDialog(removeCardFrame, "Couldn't find card in deck", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                }
            } catch (NullPointerException npe) {
                JOptionPane.showMessageDialog(removeCardFrame, "Card not found in deck", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public void updateDeckText() {
        deckText.setText("");
        deckText.append("Deck " + "\r\n" + "" + "\r\n");
        for (CardInDeck card : deck.retrieveCards()) {
            deckText.append((card.getCard().getName() + " x " + card.getCopies()) + "\r\n");
        }
        deckText.append("\r\n\r\n This deck will cost " + deck.getDustCost() + " to make.");
    }
}
