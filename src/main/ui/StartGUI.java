package ui;


import net.miginfocom.swing.MigLayout;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class StartGUI implements ActionListener {

    private static final Insets insets = new Insets(0,0,0,0);
    private JButton cardButton;
    private JButton deckButton;

    public StartGUI() {
        initialize();
    }

    private void initialize() {
        JFrame startWindow = new JFrame("Start");
        startWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //https://stackoverflow.com/questions/6777135/java-jframe-size-according-to-screen-resolution
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.Y_AXIS));
        buttonPane.add(Box.createRigidArea(new Dimension(0, screenSize.height / 20)));
        JLabel startLabel = new JLabel("Welcome!");
        startLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        startLabel.setFont(new Font("Ariel", Font.PLAIN, 40));
        buttonPane.add(startLabel);
        buttonPane.add(Box.createRigidArea(new Dimension(0, screenSize.height / 20)));
        cardButton = makeCardButton();
        buttonPane.add(cardButton);
        buttonPane.add(Box.createRigidArea(new Dimension(0, screenSize.height / 30)));
        deckButton = makeDeckButton();
        buttonPane.add(deckButton);


        startWindow.setContentPane(buttonPane);



        startWindow.pack();
        int width = screenSize.width * 2 / 10;
        int height = screenSize.height * 2 / 4;
        //startWindow.setBounds(width, height / 3, width, height);
        startWindow.setSize(width, height);
        startWindow.setLocationRelativeTo(null);

        startWindow.setVisible(true);

    }

    private JButton makeCardButton() {
        JButton cardButton = new JButton("Edit Cards");
        cardButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        cardButton.setFont(new Font("Ariel", Font.PLAIN, 40));
        cardButton.addActionListener(this);
        return cardButton;
    }

    private JButton makeDeckButton() {
        JButton deckButton = new JButton("Edit Decks");
        deckButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        deckButton.setFont(new Font("Ariel", Font.PLAIN, 40));
        deckButton.addActionListener(this);
        return deckButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cardButton) {
            new CardGUI();
        } else if (e.getSource() == deckButton) {
            new DeckGUI();
        }

    }

//    //http://www.java2s.com/Tutorial/Java/0240__Swing/UsingGridBagConstraints.htm
//    private static void addComponent(Container container, Component component, int gridx, int gridy,
//                                     int gridwidth, int gridheight, int anchor, int fill) {
//        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy, gridwidth, gridheight, 1.0, 1.0,
//                anchor, fill, insets, 0, 0);
//        container.add(component, gbc);
//    }

}


