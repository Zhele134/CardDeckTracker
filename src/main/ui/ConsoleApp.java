package ui;


import model.*;


import java.util.*;

public class ConsoleApp {
    private Scanner input;
    private HashMap<String, Card> library;
    private Deck deck;

    public ConsoleApp() {
        startApp();
    }

    //Inspired from the method RunTeller in the TellerApp class in CPSC210 Example
    private void startApp() {
        input = new Scanner(System.in);
        String command = null;
        boolean stillRunning = true;
        deck = new Deck();
        library = new HashMap<String, Card>();

        while (stillRunning) {
            displayStartMenu();
            command = input.nextLine();
            command = command.toLowerCase();

            if (command.equals("q")) {
                stillRunning = false;
            } else if (command.equals("c")) {
                makeCard();
            } else if (command.equals("d")) {
                makeDeck();
            } else if (command.equals("v")) {
                viewCardLibrary();
            } else {
                System.out.println("Invalid selection, try again");
            }
        }

        System.out.println("\nThank you for using the application.");
    }


    private void displayStartMenu() {
        System.out.println("\nWelcome to the app, please select your choice:");
        System.out.println("\tc -> Make a card");
        System.out.println("\td -> Make a deck");
        System.out.println("\tv -> View card library");
        System.out.println("\nq -> Quit");
    }

    private void makeCard() {
        boolean runningCard = true;
        Card card;
        while (runningCard) {
            displayCardTypes();
            String type = input.nextLine().toLowerCase();
            switch (type) {
                case "m": card = new Minion();
                    chooseStats(card);
                    break;
                case "s": card = new Spell();
                    chooseStats(card);
                    break;
                case "w": card = new Weapon();
                    chooseStats(card);
                    break;
                case "h": card = new HeroCard();
                    chooseStats(card);
                    break;
                case "b": runningCard = false;
                          break;
                default: System.out.println("Invalid input, try again");
            }
        }
    }

    private void displayCardTypes() {
        System.out.println("\nWhat type of card are you making?");
        System.out.println("\tm -> Minion");
        System.out.println("\ts -> Spell");
        System.out.println("\tw -> Weapon");
        System.out.println("\th -> Hero Card");
        System.out.println("\tb -> Go Back To Previous Menu");
    }

    private void chooseStats(Card card) {
        System.out.println("Input class");
        String gameClass = input.nextLine().toLowerCase();
        card.setClass(gameClass);
        if (card instanceof Minion) {
            card.setType("Minion");
            inputMinionStats(card);
        } else if (card instanceof Spell) {
            card.setType("Spell");
            inputSpellStats(card);
        } else if (card instanceof Weapon) {
            card.setType("Weapon");
            inputWeaponStats(card);
        } else if (card instanceof HeroCard) {
            inputHeroStats(card);
        }
        System.out.println("");
        printStats(card);
        library.put(card.getName(), card);
    }

    private void inputMinionStats(Card card) {
        System.out.println("Input Cost");
        int cost = input.nextInt();
        card.setCost(cost);
        System.out.println("Input Attack");
        int attack = input.nextInt();
        card.setAttack(attack);
        System.out.println("Input Health");
        int health = input.nextInt();
        input.nextLine();
        card.setHealth(health);
        System.out.println("Input Name");
        String name = input.nextLine();
        card.setName(name);
        System.out.println("Input Description");
        String desc = input.nextLine();
        card.setDesc(desc);
        System.out.println("Input Rarity");
        String rarity = input.nextLine();
        card.setRarity(rarity);
        System.out.println("Input Tribe");
        String tribe = input.nextLine();
        card.setTribe(tribe);
    }

    private void inputSpellStats(Card card) {
        System.out.println("Input Cost");
        int cost = input.nextInt();
        input.nextLine();
        card.setCost(cost);
        System.out.println("Input Name");
        String name = input.nextLine();
        card.setName(name);
        System.out.println("Input Description");
        String desc = input.nextLine();
        card.setDesc(desc);
        System.out.println("Input Rarity");
        String rarity = input.nextLine();
        card.setRarity(rarity);
    }

    private void inputWeaponStats(Card card) {
        System.out.println("Input Cost");
        int cost = input.nextInt();
        card.setCost(cost);
        System.out.println("Input Attack");
        int attack = input.nextInt();
        card.setAttack(attack);
        System.out.println("Input Durability");
        int health = input.nextInt();
        input.nextLine();
        card.setHealth(health);
        System.out.println("Input Name");
        String name = input.nextLine();
        card.setName(name);
        System.out.println("Input Description");
        String desc = input.nextLine();
        card.setDesc(desc);
        System.out.println("Input Rarity");
        String rarity = input.nextLine();
        card.setRarity(rarity);
    }

    private void inputHeroStats(Card card) {
        System.out.println("Input Cost");
        int cost = input.nextInt();
        card.setCost(cost);
        System.out.println("Input Armor Gain");
        int health = input.nextInt();
        input.nextLine();
        card.setHealth(health);
        System.out.println("Input Name");
        String name = input.nextLine();
        card.setName(name);
        System.out.println("Input Desc");
        String desc = input.nextLine();
        card.setDesc(desc);
        System.out.println("Input Hero Power Cost");
        int hpCost = input.nextInt();
        input.nextLine();
        card.setRewardCost(hpCost);
        System.out.println("Input Hero Power Description");
        String hpDesc = input.nextLine();
        card.setRewardDesc(hpDesc);
        System.out.println("Input Rarity");
        String rarity = input.nextLine();
        card.setRarity(rarity);
    }

    private void printStats(Card card) {
        if (card instanceof Minion) {
            printMinionStats(card);
        } else if (card instanceof Spell) {
            printSpellStats(card);
        } else if (card instanceof Weapon) {
            printWeaponStats(card);
        } else if (card instanceof HeroCard) {
            printHeroStats(card);
        }
    }

    private void printMinionStats(Card card) {
        System.out.println("Type: " + card.getType());
        System.out.println("Class: " + card.getGameClass());
        System.out.println("Name: " + card.getName());
        System.out.println("Cost: " + card.getCost());
        System.out.println("Attack: " + card.getAttack());
        System.out.println("Health: " + card.getHealth());
        System.out.println("Description: " + card.getDesc());
        System.out.println("Tribe: " + card.getTribe());
        System.out.println("Rarity: " + card.getRarity());
    }

    private void printSpellStats(Card card) {
        System.out.println("Type: " + card.getType());
        System.out.println("Class: " + card.getGameClass());
        System.out.println("Name: " + card.getName());
        System.out.println("Cost: " + card.getCost());
        System.out.println("Description: " + card.getDesc());
        System.out.println("Rarity: " + card.getRarity());
    }

    private void printWeaponStats(Card card) {
        System.out.println("Type: " + card.getType());
        System.out.println("Class: " + card.getGameClass());
        System.out.println("Name: " + card.getName());
        System.out.println("Cost: " + card.getCost());
        System.out.println("Attack: " + card.getAttack());
        System.out.println("Durability: " + card.getHealth());
        System.out.println("Description: " + card.getDesc());
        System.out.println("Rarity: " + card.getRarity());
    }

    private void printHeroStats(Card card) {
        System.out.println("Type: " + card.getType());
        System.out.println("Class: " + card.getGameClass());
        System.out.println("Name: " + card.getName());
        System.out.println("Cost: " + card.getCost());
        System.out.println("Armor: " + card.getHealth());
        System.out.println("Description: " + card.getDesc());
        System.out.println("Hero Power Description: " + card.getRewardDesc());
        System.out.println("Hero Power Cost: " + card.getRewardCost());
        System.out.println("Rarity: " + card.getRarity());
    }

    private void viewCardLibrary() {
        for (String name : library.keySet()) {
            System.out.println(name);
        }
    }

    private void makeDeck() {
        boolean deckRunning = true;
        while (deckRunning) {
            displayDeckMenu();
            String choice = input.nextLine().toLowerCase();
            switch (choice) {
                case "a": addCardToDeck();
                break;
                case "r": removeCardFromDeck();
                break;
                case "v": viewDeck();
                break;
                case "d": viewDustCost();
                break;
                case "b": deckRunning = false;
                break;
                default: System.out.println("Invalid output, try again");
            }

        }

    }

    private void displayDeckMenu() {
        System.out.println("\nChoose what to do with the deck");
        System.out.println("\ta -> Add Card");
        System.out.println("\tr -> Remove Card");
        System.out.println("\tv -> View Deck");
        System.out.println("\td -> View Dust Cost of Deck");
        System.out.println("\tb -> Go Back");
    }

    private void addCardToDeck() {
        boolean addRunning = true;
        while (addRunning) {
            System.out.println("\n Input name of card you want to add");
            String cardName = input.nextLine();
            System.out.println("Input number of copies you want to add");
            int cardCopies = input.nextInt();
            input.nextLine();
            if (library.containsKey(cardName)) {
                if (deck.addCard(library.get(cardName), cardCopies)) {
                    System.out.println("Card(s) added successfully");
                    addRunning = askAddAnother();
                } else {
                    System.out.println("Can't add cards");
                    addRunning = askAddAnother();
                }
            } else {
                System.out.println("Card not found in library, try again");
                addRunning = askAddAnother();
            }
        }
    }

    private boolean askAddAnother() {
        while (true) {
            System.out.println("\nAdd another card? (Type y or n)");
            String decision = input.nextLine().toLowerCase();
            if (decision.equals("y")) {
                return true;
            } else if (decision.equals("n")) {
                return false;
            } else {
                System.out.println("Invalid Input");
            }
        }
    }

    private void removeCardFromDeck() {
        boolean removeRunning = true;
        while (removeRunning) {
            System.out.println("\n Input name of card you want to remove");
            String cardName = input.nextLine();
            if (library.containsKey(cardName)) {
                deck.removeCard(library.get(cardName));
                System.out.println("Card(s) removed successfully");
                removeRunning = askRemoveAnother();
            } else {
                System.out.println("Card not found in library, try again");
                removeRunning = askRemoveAnother();
            }
        }
    }

    private Boolean askRemoveAnother() {
        while (true) {
            System.out.println("\nRemove another card? (Type y or n)");
            String decision = input.nextLine().toLowerCase();
            if (decision.equals("y")) {
                return true;
            } else if (decision.equals("n")) {
                return false;
            } else {
                System.out.println("Invalid Input");
            }
        }
    }

    private void viewDeck() {
        for (CardInDeck card : deck.retrieveCards()) {
            System.out.println(card.getCard().getName() + " x " + card.getCopies());
        }
    }

    private void viewDustCost() {
        System.out.println("This deck currently costs " + deck.getDustCost() + " dust to create.");
    }




}
