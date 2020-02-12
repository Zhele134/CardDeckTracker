package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DeckTest {

    private Card minion1;
    private Card minion2;
    private Card spell1;
    private Card spell2;
    private Card weapon1;
    private Card weapon2;
    private Card hero;
    private Deck deck;

    @BeforeEach
    void runBefore() {
        deck = new Deck();
        minion1 = new Minion();
        minion2 = new Minion();
        spell1 = new Spell();
        spell2 = new Spell();
        weapon1 = new Weapon();
        weapon2 = new Weapon();
        hero = new HeroCard();

        deck.changeDeckLimit(10);
        minion1.setType("Minion");
        minion1.setClass("Rogue");
        minion1.setAttack(3);
        minion1.setHealth(3);
        minion1.setCost(3);
        minion1.setName("Blink Fox");
        minion1.setDesc("Battlecry: Add a random card to your hand (from your opponent's class)");
        minion1.setRarity("Common");
        minion1.setTribe("Beast");

        minion2.setType("Minion");
        minion2.setClass("Rogue");
        minion2.setAttack(3);
        minion2.setHealth(5);
        minion2.setCost(5);
        minion2.setName("Bazaar Mugger");
        minion2.setDesc("Rush, Battlecry: Add a random minion from another class to your hand");
        minion2.setRarity("Rare");
        minion2.setTribe("");

        spell1.setType("Spell");
        spell1.setClass("Mage");
        spell1.setCost(10);
        spell1.setName("Puzzle Box of Yogg-Saron");
        spell1.setRarity("Epic");
        spell1.setDesc("Cast 10 random spells (targets chosen randomly)");

        spell2.setType("Spell");
        spell2.setClass("Rogue");
        spell2.setCost(0);
        spell2.setName("Backstab");
        spell2.setRarity("Common");
        spell2.setDesc("Deal 2 damage to an undamaged minion");

        weapon1.setType("Weapon");
        weapon1.setClass("Warrior");
        weapon1.setCost(3);
        weapon1.setAttack(2);
        weapon1.setHealth(2);
        weapon1.setName("Ancharrr");
        weapon1.setRarity("Legendary");
        weapon1.setDesc("After your hero attacks, draw a Pirate from your deck");

        weapon2.setType("Weapon");
        weapon2.setClass("Rogue");
        weapon2.setCost(4);
        weapon2.setAttack(4);
        weapon2.setHealth(2);
        weapon2.setName("Waggle Pick");
        weapon2.setRarity("Epic");
        weapon2.setDesc("Deathrattle: Return a random friendly minion to your hand. It costs (2) less");

        hero.setType("HeroCard");
        hero.setClass("Hunter");
        hero.setCost(10);
        hero.setName("Zul'jin");
        hero.setHealth(5);
        hero.setDesc("Battlecry: Cast all spells you've played this game (targets chosen randomly)");
        hero.setRarity("Legendary");
        hero.setRewardCost(2);
        hero.setRewardDesc("Deal 2 damage to any enemy");
    }

    @Test
    void testAdd1CardType() {
        deck.addCard(minion1, 2);
        assertTrue(deck.isCardInDeck(minion1));
        assertEquals(80, deck.getDustCost());
    }

    @Test
    void testAddTooManyCards() {
        deck.addCard(minion2, 3);
        assertFalse(deck.isCardInDeck(minion2));
        assertEquals(0, deck.getDustCost());
    }

    @Test
    void testAddTooManyLegendaries() {
        deck.addCard(hero, 2);
        assertFalse(deck.isCardInDeck(hero));
        assertEquals(0, deck.getDustCost());
    }

    @Test
    void testAddMultipleCards() {
        deck.addCard(minion2, 2);
        deck.addCard(spell1, 2);
        deck.addCard(weapon1, 2);
        deck.addCard(weapon1, 1);
        deck.addCard(minion1, 2);
        deck.addCard(spell2, 2);
        deck.addCard(hero, 1);
        assertEquals(10, deck.countDeckSize());
        assertTrue(deck.isCardInDeck(weapon1));
        assertEquals(4360, deck.getDustCost());
    }

    @Test
    void testSuccessfulAddDuplicates() {
        deck.addCard(minion1, 1);
        assertEquals(1, deck.countDeckSize());
        deck.addCard(minion1, 1);
        assertEquals(2, deck.countDeckSize());
        assertEquals(80, deck.getDustCost());
    }

    @Test
    void testNotSuccessfulDuplicateAddition() {
        deck.addCard(minion1, 2);
        assertTrue(deck.isCardInDeck(minion1));
        deck.addCard(minion1, 1);
        assertEquals(2, deck.countDeckSize());

        deck.addCard(weapon1, 1);
        assertTrue(deck.isCardInDeck(weapon1));
        deck.addCard(weapon1, 1);
        assertEquals(3, deck.countDeckSize());
    }

    @Test
    void testAddPastDeckLimit() {
        deck.addCard(minion2, 2);
        deck.addCard(spell1, 2);
        deck.addCard(weapon1, 1);
        deck.addCard(minion1, 2);
        deck.addCard(spell2, 2);
        deck.addCard(hero, 1);
        deck.addCard(weapon2, 1);
        assertFalse(deck.isCardInDeck(weapon2));
        assertEquals(10, deck.countDeckSize());
    }

    @Test
    void testRemoveCard() {
        deck.addCard(minion2, 2);
        deck.addCard(spell1, 2);
        deck.addCard(weapon1, 1);
        deck.addCard(minion1, 2);
        deck.addCard(spell2, 2);
        deck.addCard(hero, 1);
        deck.removeCard(minion2);
        assertFalse(deck.isCardInDeck(minion2));
        assertEquals(8, deck.countDeckSize());
        assertEquals(4160, deck.getDustCost());
    }

    @Test
    void testDefaultCase() {
        minion1.setRarity("Wowie Wow Wow");
        deck.addCard(minion1, 2);
        assertEquals(0, deck.getDustCost());
    }






}
