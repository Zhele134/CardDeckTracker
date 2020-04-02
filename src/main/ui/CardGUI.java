package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Type;
import java.util.HashMap;

import com.google.gson.reflect.TypeToken;
import model.*;



public class CardGUI extends PlaySound implements ActionListener {

    private JButton makeCardButton;
    private JButton viewLibrary;
    private JButton saveLibrary;

    private HashMap<String, Card> library = new HashMap<>();
    private static final String HS_CARD_LIBRARY = "./data/Cards/HSCardLibrary.txt";

    private SaveAndLoad saveAndLoad;

    public CardGUI() {
        initialize();
    }

    //EFFECT: Develop Card menu GUI
    private void initialize() {
        initializeFields();
        JFrame cardWindow = new JFrame("Cards");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setCardWindowSize(cardWindow, screenSize);

        JPanel startButtons = new JPanel();
        startButtons.setLayout(new BoxLayout(startButtons, BoxLayout.Y_AXIS));
        startButtons.add(Box.createRigidArea(new Dimension(0, screenSize.height / 30)));
        startButtons.add(makeStartLabel());
        startButtons.add(Box.createRigidArea(new Dimension(0, screenSize.height / 30)));
        startButtons.add(makeMakeCardButton());
        startButtons.add(Box.createRigidArea(new Dimension(0, screenSize.height / 30)));
        startButtons.add(makeViewLibraryButton());
        startButtons.add(Box.createRigidArea(new Dimension(0, screenSize.height / 30)));
        startButtons.add(makeSaveLibraryButton());

        cardWindow.setContentPane(startButtons);

    }

    //EFFECT: initializes fields
    private void initializeFields() {
        saveAndLoad = new SaveAndLoad();
        Type type = new TypeToken<HashMap<String, Card>>() {
        }.getType();
        library = saveAndLoad.loadLibrary(HS_CARD_LIBRARY, type);
    }

    //EFFECT: sets the size of the card window
    private void setCardWindowSize(JFrame cardWindow, Dimension screenSize) {
        int width = screenSize.width * 2 / 10;
        int height = screenSize.height * 2 / 4;
        cardWindow.setSize(width, height);
        cardWindow.setLocationRelativeTo(null);
        cardWindow.setVisible(true);
    }

    //EFFECT: makes the "Start" label
    private JLabel makeStartLabel() {
        JLabel startLabel = new JLabel("Choose Card Function");
        startLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        startLabel.setFont(new Font("Ariel", Font.PLAIN, 40));
        return startLabel;
    }

    //EFFECT: makes the "Make Card" button
    private JButton makeMakeCardButton() {
        makeCardButton = new JButton("Make A Card");
        makeCardButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        makeCardButton.setFont(new Font("Ariel", Font.PLAIN, 40));
        makeCardButton.addActionListener(this);
        return makeCardButton;
    }

    //EFFECT: makes the "Save Library" button
    private JButton makeSaveLibraryButton() {
        saveLibrary = new JButton("Save Card Library");
        saveLibrary.setAlignmentX(Component.CENTER_ALIGNMENT);
        saveLibrary.setFont(new Font("Ariel", Font.PLAIN, 40));
        saveLibrary.addActionListener(this);
        return saveLibrary;
    }

    //EFFECT: makes the "View Library" button
    private JButton makeViewLibraryButton() {
        viewLibrary = new JButton("View Card Library");
        viewLibrary.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewLibrary.setFont(new Font("Ariel", Font.PLAIN, 40));
        viewLibrary.addActionListener(this);
        return viewLibrary;
    }

    //EFFECT: opens the GUI for the associated button when they're clicked, and plays a sound when button is pressed
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == makeCardButton) {
            playSound(clickSound);
            new MakeCardGUI(library);
        } else if (e.getSource() == saveLibrary) {
            playSound(clickSound);
            saveAndLoad.saveLibrary(library, HS_CARD_LIBRARY);
            saveAndLoad.makeSaveLibraryWindow();

        } else if (e.getSource() == viewLibrary) {
            playSound(clickSound);
            viewLibrary();
        }
    }

    //EFFECT: opens a GUI that allows user to see their card library
    public void viewLibrary() {
        JFrame libraryView = new JFrame();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        JPanel vl = new JPanel();
        JTextArea libraryTextArea = new JTextArea(50, 100);
        for (String name : library.keySet()) {
            libraryTextArea.append(name + "\r\n");
        }
        libraryTextArea.setFont(new Font("Arial", Font.PLAIN, 25));
        JScrollPane libraryScroll = new JScrollPane(libraryTextArea);
        libraryScroll.setPreferredSize(new Dimension(screenSize.width * 2 / 9, screenSize.height / 3));
        libraryScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        vl.add(libraryScroll);

        libraryView.setSize(new Dimension(screenSize.width / 4, screenSize.height / 3));
        libraryView.setContentPane(vl);
        libraryView.setLocationRelativeTo(null);
        libraryView.setVisible(true);
    }



}
