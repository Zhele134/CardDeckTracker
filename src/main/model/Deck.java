package model;

import java.util.*;

public class Deck {
    public int deckLimit = 30;
    public static final int DUPLICATE_LIMIT = 2;
    public static final int LEGENDARY_LIMIT = 1;
    private int dustCost;
    private int deckSize;
    private HashMap<String, CardInDeck> deck;

    public Deck() {
        deck = new HashMap<String, CardInDeck>();
        dustCost = 0;
    }

    //MODIFIES: THIS (deck, dustCost)
    //EFFECTS: First checks to make sure cards added won't exceed deck limit, won't add cards if it does
    /*         Then, checks if card is already in deck, where it checks if copies added exceed duplicate limit.
                    Won't add cards if it does
               If card is not in there, checks rarity of card to make sure copies of cards added don't exceed duplicate
               limit, won't add card if it does.
               In all instances that the card is added, total dust value of deck is updated.
     */
    public void addCard(Card card, int copies) {
        //Check if adding cards will exceed card limit
        System.out.println("Before, there are " + countDeckSize() + " cards in this deck");
        if ((countDeckSize() + copies) <= deckLimit) {

            //Check if card is already within deck
            if (deck.containsKey(card.getName())) {

                //Make sure you can add copies of card to deck
                if (checkAddCopiesToExistingCard(deck.get(card.getName()), copies)) {

                    //Modifies number of copies of card within deck if true
                    deck.get(card.getName()).setCopies(returnTotalAddedCopies(deck.get(card.getName()), copies));
                    dustCost = dustCost + (dustForCard(card.getRarity()) * copies);
                    System.out.println("Copies added successfully, now " + countDeckSize() + " cards in deck now");

                } else {
                    //can't add that many copies of the card to the deck
                    System.out.println("Past duplicate limit");
                }

            } else {

                //make sure number of copies added doesn't exceed duplicate limits for rarities
                if ((!isLegendary(card) && (copies <= DUPLICATE_LIMIT))
                        || (isLegendary(card) && (copies <= LEGENDARY_LIMIT))) {

                    //creates new CardInDeck object, adds it to deck, update deck cost
                    CardInDeck cardInDeck = new CardInDeck(card, copies);
                    deck.put(card.getName(), cardInDeck);
                    dustCost = dustCost + dustForCard(cardInDeck.getCard().getRarity()) * cardInDeck.getCopies();
                    System.out.println("Cards added successfully, there are now " + countDeckSize() + " cards in deck");

                } else {
                    //Can't add that many of that card to deck
                    System.out.println("Can't add that many copies");
                }
            }

        } else {
            //Too many cards will be added to deck
            System.out.println("Too many cards in deck");
        }
    }

    //MODIFIES: THIS (deck, dustCost)
    //EFFECTS: removes card from deck, then removes dust from cards from deck
    public void removeCard(Card card) {
        int removedCopies = deck.get(card.getName()).getCopies();
        deck.remove(card.getName());
        int dust = (dustForCard(card.getRarity()) * removedCopies);
        dustCost = dustCost - dust;
        System.out.println("Cards removed, there are now " + countDeckSize() + " cards in deck");
    }

    //EFFECT: returns dust cost of deck
    public int getDustCost() {
        return dustCost;
    }

    //EFFECT: checks if card is in deck
    public boolean isCardInDeck(Card card) {
        return deck.containsKey(card.getName());
    }

    public void changeDeckLimit(int num) {
        deckLimit = num;
    }

    //EFFECT: returns dust value associated with rarity
    public int dustForCard(String rarity) {
        switch (rarity) {
            case "Common":
                return 40;
            case "Rare":
                return 100;
            case "Epic":
                return 400;
            case "Legendary":
                return 1600;
            default:
                return 0;
        }
    }

    //EFFECT: counts number of cards in deck
    public int countDeckSize() {
        Collection<CardInDeck> theDeck = deck.values();
        int countingDeckSize = 0;
        for (CardInDeck cid : theDeck) {
            countingDeckSize = countingDeckSize + cid.getCopies();
        }

        return countingDeckSize;
    }

    //EFFECT: return true if you can add copiesAdded copies of the card to your deck, return false it not
    private boolean checkAddCopiesToExistingCard(CardInDeck cid, int copiesAdded) {
        if (isLegendary(cid.getCard())) {
            System.out.println("Can't add any more legendary cards");
            return false;
        } else {
            if ((cid.getCopies() + copiesAdded) <= DUPLICATE_LIMIT) {
                return true;
            } else {
                System.out.println("Already " + cid.getCopies() + " in deck, can't add past " + DUPLICATE_LIMIT);
                return false;
            }
        }
    }

    //EFFECT: check is card is legendary
    private boolean isLegendary(Card card) {
        if (card.getRarity().equals("Legendary")) {
            return true;
        }  else {
            return false;
        }
    }

    //EFFECT: return total added copies of card within deck
    private int returnTotalAddedCopies(CardInDeck cid, int copiesAdded) {
        return (cid.getCopies() + copiesAdded);
    }



}
