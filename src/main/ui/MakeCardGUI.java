package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;

import model.*;

public class MakeCardGUI extends PlaySound implements ItemListener {

    private JFrame makeCardWindow;

    private String type;
    private JTextField minionClassField;
    private JTextField minionCostField;
    private JTextField minionNameField;
    private JTextField minionAttackField;
    private JTextField minionHealthField;
    private JTextField minionDescField;
    private JTextField minionRarityField;
    private JTextField minionTribeField;

    private JTextField spClassField;
    private JTextField spCostField;
    private JTextField spNameField;
    private JTextField spDescField;
    private JTextField spRarityField;


    private JTextField weaponClassField;
    private JTextField weaponCostField;
    private JTextField weaponNameField;
    private JTextField weaponAttackField;
    private JTextField weaponHealthField;
    private JTextField weaponDescField;
    private JTextField weaponRarityField;

    private JTextField heroClassField;
    private JTextField heroCostField;
    private JTextField heroNameField;
    private JTextField heroHealthField;
    private JTextField heroDescField;
    private JTextField heroRarityField;
    private JTextField heroPowerCostField;
    private JTextField heroPowerDescField;

    private JPanel cards;
    private JComboBox selectTypeBox;

    HashMap library;


    public MakeCardGUI(HashMap library) {
        this.library = library;
        makeCardWindow = new JFrame("Making Card");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setMakeCardWindowSize(makeCardWindow, screenSize);

        JPanel selectType = new JPanel();
        selectType.setLayout(new GridLayout(1, 2));
        JLabel typeLabel = new JLabel("Select card type");
        typeLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        selectType.add(typeLabel);
        selectTypeBox = makeTypeComboBox();
        selectType.add(selectTypeBox);

        cards = new JPanel(new CardLayout());
        cards.add(makeMinionPanel(), "Minion");
        cards.add(makeSpellPanel(), "Spell");
        cards.add(makeWeaponPanel(), "Weapon");
        cards.add(makeHeroPanel(), "Hero Card");

        makeCardWindow.getContentPane().setLayout(new BorderLayout(5, 5));
        makeCardWindow.add(selectType, BorderLayout.PAGE_START);
        makeCardWindow.add(cards, BorderLayout.CENTER);
    }

    private void setMakeCardWindowSize(JFrame cardWindow, Dimension screenSize) {
        int width = screenSize.width * 2 / 5;
        int height = screenSize.height * 2 / 4;
        cardWindow.setSize(width, height);
        cardWindow.setLocationRelativeTo(null);
        cardWindow.setVisible(true);
    }

    private JComboBox makeTypeComboBox() {
        String[] cardTypes = {"Minion", "Spell", "Weapon", "Hero Card"};
        JComboBox selectBox = new JComboBox(cardTypes);
        selectBox.setFont(new Font("Arial", Font.PLAIN, 30));
        selectBox.addItemListener(this);
        return selectBox;
    }


    private JPanel makeMinionPanel() {
        JPanel makeMinionPanel = new JPanel();
        makeMinionPanel.setLayout(new GridLayout(0, 2));
        initializeMinionFields();
        makeMinionPanel.add(new JLabel("Class: "));
        makeMinionPanel.add(minionClassField);
        makeMinionPanel.add(new JLabel("Cost: "));
        makeMinionPanel.add(minionCostField);
        makeMinionPanel.add(new JLabel("Name: "));
        makeMinionPanel.add(minionNameField);
        makeMinionPanel.add(new JLabel("Attack: "));
        makeMinionPanel.add(minionAttackField);
        makeMinionPanel.add(new JLabel("Health: "));
        makeMinionPanel.add(minionHealthField);
        makeMinionPanel.add(new JLabel("Description: "));
        makeMinionPanel.add(minionDescField);
        makeMinionPanel.add(new JLabel("Rarity: "));
        makeMinionPanel.add(minionRarityField);
        makeMinionPanel.add(new JLabel("Tribe: "));
        makeMinionPanel.add(minionTribeField);
        makeMinionPanel.add(new JLabel(""));
        makeMinionPanel.add(confirmStats());

        changeFieldText(makeMinionPanel, new Font("Arial", Font.PLAIN, 30));
        return makeMinionPanel;
    }

    private void initializeMinionFields() {
        minionClassField = new JTextField(50);
        minionCostField = new JTextField(50);
        minionNameField = new JTextField(50);
        minionAttackField = new JTextField(50);
        minionHealthField = new JTextField(50);
        minionDescField = new JTextField(50);
        minionRarityField = new JTextField(50);
        minionTribeField = new JTextField(50);
    }

    private JPanel makeSpellPanel() {
        JPanel makeSpellPanel = new JPanel();
        makeSpellPanel.setLayout(new GridLayout(0, 2));
        initializeSpellFields();
        makeSpellPanel.add(new JLabel("Class"));
        makeSpellPanel.add(spClassField);
        makeSpellPanel.add(new JLabel("Cost: "));
        makeSpellPanel.add(spCostField);
        makeSpellPanel.add(new JLabel("Name: "));
        makeSpellPanel.add(spNameField);
        makeSpellPanel.add(new JLabel("Description: "));
        makeSpellPanel.add(spDescField);
        makeSpellPanel.add(new JLabel("Rarity: "));
        makeSpellPanel.add(spRarityField);
        makeSpellPanel.add(new JLabel(""));
        makeSpellPanel.add(confirmStats());

        changeFieldText(makeSpellPanel, new Font("Arial", Font.PLAIN, 30));
        return makeSpellPanel;
    }

    private void initializeSpellFields() {
        spClassField = new JTextField(50);
        spCostField = new JTextField(50);
        spNameField = new JTextField(50);
        spDescField = new JTextField(50);
        spRarityField = new JTextField(50);
    }

    private JPanel makeWeaponPanel() {
        JPanel makeWeaponPanel = new JPanel();
        makeWeaponPanel.setLayout(new GridLayout(0, 2));
        initializeWeaponFields();
        makeWeaponPanel.add(new JLabel("Class: "));
        makeWeaponPanel.add(weaponClassField);
        makeWeaponPanel.add(new JLabel("Cost: "));
        makeWeaponPanel.add(weaponCostField);
        makeWeaponPanel.add(new JLabel("Name: "));
        makeWeaponPanel.add(weaponNameField);
        makeWeaponPanel.add(new JLabel("Attack: "));
        makeWeaponPanel.add(weaponAttackField);
        makeWeaponPanel.add(new JLabel("Durability: "));
        makeWeaponPanel.add(weaponHealthField);
        makeWeaponPanel.add(new JLabel("Description: "));
        makeWeaponPanel.add(weaponDescField);
        makeWeaponPanel.add(new JLabel("Rarity: "));
        makeWeaponPanel.add(weaponRarityField);
        makeWeaponPanel.add(new JLabel(""));
        makeWeaponPanel.add(confirmStats());

        changeFieldText(makeWeaponPanel, new Font("Arial", Font.PLAIN, 30));
        return makeWeaponPanel;
    }

    private void initializeWeaponFields() {
        weaponClassField = new JTextField(50);
        weaponCostField = new JTextField(50);
        weaponNameField = new JTextField(50);
        weaponAttackField = new JTextField(50);
        weaponHealthField = new JTextField(50);
        weaponDescField = new JTextField(50);
        weaponRarityField = new JTextField(50);
    }


    private JPanel makeHeroPanel() {
        JPanel makeHeroPanel = new JPanel();
        makeHeroPanel.setLayout(new GridLayout(0, 2));
        initializeHeroFields();
        makeHeroPanel.add(new JLabel("Class: "));
        makeHeroPanel.add(heroClassField);
        makeHeroPanel.add(new JLabel("Cost: "));
        makeHeroPanel.add(heroCostField);
        makeHeroPanel.add(new JLabel("Name: "));
        makeHeroPanel.add(heroNameField);
        makeHeroPanel.add(new JLabel("Armor Gain Amount: "));
        makeHeroPanel.add(heroHealthField);
        makeHeroPanel.add(new JLabel("Description: "));
        makeHeroPanel.add(heroDescField);
        makeHeroPanel.add(new JLabel("Rarity: "));
        makeHeroPanel.add(heroRarityField);
        makeHeroPanel.add(new JLabel("Hero Power Cost"));
        makeHeroPanel.add(heroPowerCostField);
        makeHeroPanel.add(new JLabel("Hero Power Desc"));
        makeHeroPanel.add(heroPowerDescField);
        makeHeroPanel.add(new JLabel(""));
        makeHeroPanel.add(confirmStats());

        changeFieldText(makeHeroPanel, new Font("Arial", Font.PLAIN, 30));
        return makeHeroPanel;
    }

    private void initializeHeroFields() {
        heroClassField = new JTextField(50);
        heroCostField = new JTextField(50);
        heroNameField = new JTextField(50);
        heroHealthField = new JTextField(50);
        heroDescField = new JTextField(50);
        heroRarityField = new JTextField(50);
        heroPowerCostField = new JTextField(50);
        heroPowerDescField = new JTextField(50);
    }

    //https://stackoverflow.com/questions/12730230/set-the-same-font-for-all-component-java
    //EFFECT: changes the text of all components within a container
    private void changeFieldText(Component component, Font font) {
        component.setFont(font);
        if (component instanceof Container) {
            for (Component child : ((Container) component).getComponents()) {
                changeFieldText(child, font);
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, (String) e.getItem());
    }

    private JButton confirmStats() {
        JButton confirmStats = new JButton("Confirm Stats");
        confirmStats.addActionListener(e -> {
            playSound(clickSound);
            type = (String) selectTypeBox.getSelectedItem();

            try {
                if (type == "Minion") {
                    setMinionStats();
                } else if (type.equals("Spell")) {
                    setSpellStats();
                } else if (type.equals("Weapon")) {
                    setWeaponStats();
                } else if (type.equals("Hero Card")) {
                    setHeroStats();
                }
            } catch (NumberFormatException nfe) {
                showErrorDialog();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(makeCardWindow, "Something went wrong!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
        return confirmStats;
    }

    //EFFECT: displays error window when user inputs a non-integer in a text field that requires an integer
    private void showErrorDialog() {
        JOptionPane.showMessageDialog(makeCardWindow, "Please insert an integer for Cost, Attack, "
                        + "Health, Durability, Armor Gain, or Hero Power Cost values", "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    public void setMinionStats() {
        Card minion = new Minion();
        minion.setType(type);
        String minionClass = minionClassField.getText();
        minion.setClass(minionClass);
        String name = minionNameField.getText();
        minion.setName(name);
        int cost = getIntegerValue(minionCostField.getText());
        minion.setCost(cost);
        String desc = minionDescField.getText();
        minion.setDesc(desc);
        String rarity = minionRarityField.getText();
        minion.setRarity(rarity);
        int attack = getIntegerValue(minionAttackField.getText());
        minion.setAttack(attack);
        int health = getIntegerValue(minionHealthField.getText());
        minion.setHealth(health);
        String tribe = minionTribeField.getText();
        minion.setTribe(tribe);

        JOptionPane.showMessageDialog(makeCardWindow, "Card made successfully");
        library.put(minion.getName(), minion);
    }

    public void setSpellStats() {
        Card spell = new Spell();

        spell.setType(type);
        String spellClass = spClassField.getText();
        spell.setClass(spellClass);
        String name = spNameField.getText();
        spell.setName(name);
        int cost = getIntegerValue(spCostField.getText());
        spell.setCost(cost);
        String desc = spDescField.getText();
        spell.setDesc(desc);
        String rarity = spRarityField.getText();
        spell.setRarity(rarity);

        JOptionPane.showMessageDialog(makeCardWindow, "Card made successfully");
        library.put(spell.getName(), spell);
    }

    public void setWeaponStats() {
        Card weapon = new Weapon();

        weapon.setType(type);
        String weaponClass = weaponClassField.getText();
        weapon.setClass(weaponClass);
        String name = weaponNameField.getText();
        weapon.setName(name);
        int cost = getIntegerValue(weaponCostField.getText());
        weapon.setCost(cost);
        String desc = weaponDescField.getText();
        weapon.setDesc(desc);
        String rarity = weaponRarityField.getText();
        weapon.setRarity(rarity);
        int attack = getIntegerValue(weaponAttackField.getText());
        weapon.setAttack(attack);
        int health = getIntegerValue(weaponHealthField.getText());
        weapon.setHealth(health);

        JOptionPane.showMessageDialog(makeCardWindow, "Card made successfully");
        library.put(weapon.getName(), weapon);
    }

    public void setHeroStats() {
        Card hero = new HeroCard();
        hero.setType(type);
        String heroClass = heroClassField.getText();
        hero.setClass(heroClass);
        String name = heroNameField.getText();
        hero.setName(name);
        int cost = getIntegerValue(heroCostField.getText());
        hero.setCost(cost);
        String desc = heroDescField.getText();
        hero.setDesc(desc);
        String rarity = heroRarityField.getText();
        hero.setRarity(rarity);
        int health = getIntegerValue(heroHealthField.getText());
        hero.setHealth(health);
        int heroPowerCost = getIntegerValue(heroPowerCostField.getText());
        hero.setRewardCost(heroPowerCost);
        String heroPowerDesc = heroPowerDescField.getText();
        hero.setRewardDesc(heroPowerDesc);

        JOptionPane.showMessageDialog(makeCardWindow, "Card made successfully");
        library.put(hero.getName(), hero);

    }

    //https://stackoverflow.com/questions/41410863/numberformat-exception-for-converting-jtextfield-to-int/41410915#41410915
    //EFFECT: parses an Integer from a JTextField
    private int getIntegerValue(String s) {
        return "".equals(s) ? 0 : Integer.parseInt(s);
    }
}
