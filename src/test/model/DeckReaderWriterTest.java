package model;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import persistence.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeckReaderWriterTest {

    Card minion1;
    Card spell1;
    Card weapon1;
    Card hero1;
    DeckReaderWriter deckReaderWriter;
    Deck deck;
    final String SAVE_DECK = "./data/Test/SaveDeck.txt";
    final String LOAD_DECK = "./data/Test/LoadDeck.txt";

    @BeforeEach
    void runBefore() {
        deckReaderWriter = new DeckReaderWriter();
        minion1 = new Minion();
        spell1 = new Spell();
        weapon1 = new Weapon();
        hero1 = new HeroCard();
        deck = new Deck();

        makeMinion1();
        makeSpell1();

        deck.addCard(minion1, 2);
        deck.addCard(spell1, 1);

        deckReaderWriter.saveDeck(deck, SAVE_DECK);
    }

    @Test
    void testSaveDeck() {
        Type type = new TypeToken<Deck>() {}.getType();
        Deck clonedDeck = deckReaderWriter.readDeck(SAVE_DECK, type);

        assertTrue(clonedDeck.isCardInDeck(minion1));
        assertTrue(clonedDeck.isCardInDeck(spell1));
        assertEquals(120, clonedDeck.getDustCost());
        assertEquals(3, clonedDeck.countDeckSize());
        assertEquals(2, clonedDeck.getCard(minion1.getName()).getCopies());
        assertEquals(1, clonedDeck.getCard(spell1.getName()).getCopies());

        Card clonedMinion1 = clonedDeck.getCard(minion1.getName()).getCard();
        Card clonedSpell1 = clonedDeck.getCard(spell1.getName()).getCard();

        assertEquals("Minion", clonedMinion1.getType());
        assertEquals("Neutral", clonedMinion1.getGameClass());
        assertEquals(5, clonedMinion1.getAttack());
        assertEquals(5, clonedMinion1.getHealth());
        assertEquals(5, clonedMinion1.getCost());
        assertEquals("Big Ol' Whelp", clonedMinion1.getName());
        assertEquals("Battlecry: Draw a card.",
                clonedMinion1.getDesc());
        assertEquals("Common", clonedMinion1.getRarity());
        assertEquals("Dragon", clonedMinion1.getTribe());

        assertEquals("Spell", clonedSpell1.getType());
        assertEquals("Hunter", clonedSpell1.getGameClass());
        assertEquals(2, clonedSpell1.getCost());
        assertEquals("Corrosive Breath", clonedSpell1.getName());
        assertEquals("Deal 3 damage to a minion. If you're holding a dragon, it also hits the enemy hero",
                clonedSpell1.getDesc());
        assertEquals("Common", clonedSpell1.getRarity());
    }

    @Test
    void testLoadDeck() {
        Type type = new TypeToken<Deck>() {}.getType();
        Deck clonedDeck = deckReaderWriter.readDeck(LOAD_DECK, type);

        assertEquals(1800, clonedDeck.getDustCost());
        assertEquals(3, clonedDeck.countDeckSize());

        weapon1 = clonedDeck.getCard("Ritual Chopper").getCard();
        hero1 = clonedDeck.getCard("The Amazing Reno").getCard();

        assertEquals("Weapon", weapon1.getType());
        assertEquals("Warrior", weapon1.getGameClass());
        assertEquals(2 , weapon1.getCost() );
        assertEquals("Ritual Chopper", weapon1.getName());
        assertEquals(1, weapon1.getAttack());
        assertEquals(2, weapon1.getHealth());
        assertEquals("Battlecry: Invoke Galakrond", weapon1.getDesc());
        assertEquals("Rare",weapon1.getRarity() );

        assertEquals("HeroCard", hero1.getType());
        assertEquals("Mage", hero1.getGameClass());
        assertEquals(10 , hero1.getCost() );
        assertEquals("The Amazing Reno", hero1.getName());
        assertEquals(5, hero1.getHealth());
        assertEquals("Battlecry: Make all minions disappear. *Poof!*",
                hero1.getDesc());
        assertEquals("Legendary",hero1.getRarity() );
        assertEquals(-1, hero1.getRewardCost());
        assertEquals("Passive Hero Power: At the start of your turn, cast a random spell.",
                hero1.getRewardDesc());
    }

    void makeMinion1() {
        minion1.setType("Minion");
        minion1.setClass("Neutral");
        minion1.setAttack(5);
        minion1.setHealth(5);
        minion1.setCost(5);
        minion1.setName("Big Ol' Whelp");
        minion1.setDesc("Battlecry: Draw a card.");
        minion1.setRarity("Common");
        minion1.setTribe("Dragon");
    }

    void makeSpell1() {
        spell1.setType("Spell");
        spell1.setClass("Hunter");
        spell1.setCost(2);
        spell1.setName("Corrosive Breath");
        spell1.setRarity("Common");
        spell1.setDesc("Deal 3 damage to a minion. If you're holding a dragon, it also hits the enemy hero");
    }
}
