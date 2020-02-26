package model;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import persistence.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardReaderWriterTest {

    Card minion1;
    Card spell1;
    Card weapon1;
    Card hero1;
    CardReaderWriter cardWriter;
    HashMap<String, Card> library;
    final String TEST_FILE = "./data/Test/CardLibrary.txt";
    final String TEST_FILE_1 = "./data/Test/TestFile1.txt";

    //final String HS_CARD_LIBRARY = "./data/Cards/HSCardLibrary.txt";

    @BeforeEach
    void runBefore() {

        cardWriter = new CardReaderWriter();
        minion1 = new Minion();
        spell1 = new Spell();
        weapon1 = new Weapon();
        hero1 = new HeroCard();
        library = new HashMap<String, Card>();

        makeMinion1();
        makeSpell1();

        library.put(minion1.getName(), minion1);
        library.put(spell1.getName(), spell1);

        cardWriter.saveLibrary(library, TEST_FILE);
    }

    @Test
    void testCardLibrary() {
        Type type = new TypeToken<HashMap<String, Card>>() {}.getType();
        HashMap<String, Card> clonedLibrary = cardWriter.readLibrary(TEST_FILE, type);

        assertTrue(clonedLibrary.containsKey(minion1.getName()));
        assertTrue(clonedLibrary.containsKey(spell1.getName()));

        Card clonedMinion1 = clonedLibrary.get(minion1.getName());
        Card clonedSpell1 = clonedLibrary.get(spell1.getName());

        assertEquals("Minion", clonedMinion1.getType());
        assertEquals("Rogue", clonedMinion1.getGameClass());
        assertEquals(3, clonedMinion1.getAttack());
        assertEquals(3, clonedMinion1.getHealth());
        assertEquals(3, clonedMinion1.getCost());
        assertEquals("Blink Fox", clonedMinion1.getName());
        assertEquals("Battlecry: Add a random card to your hand (from your opponent's class)",
                clonedMinion1.getDesc());
        assertEquals("Common", clonedMinion1.getRarity());
        assertEquals("Beast", clonedMinion1.getTribe());

        assertEquals("Spell", clonedSpell1.getType());
        assertEquals("Mage", clonedSpell1.getGameClass());
        assertEquals(10, clonedSpell1.getCost());
        assertEquals("Puzzle Box of Yogg-Saron", clonedSpell1.getName());
        assertEquals("Cast 10 random spells (targets chosen randomly)",
                clonedSpell1.getDesc());
        assertEquals("Epic", clonedSpell1.getRarity());
    }

    @Test
    void testReadLibrary() {
        Type type = new TypeToken<HashMap<String, Card>>() {}.getType();
        HashMap<String, Card> clonedLibrary = cardWriter.readLibrary(TEST_FILE_1, type);

        assertTrue(clonedLibrary.containsKey("Ancharrr"));
        assertTrue(clonedLibrary.containsKey("Zul'jin"));

        weapon1 = clonedLibrary.get("Ancharrr");
        hero1 = clonedLibrary.get("Zul'jin");

        assertEquals("Weapon", weapon1.getType());
        assertEquals("warrior", weapon1.getGameClass());
        assertEquals(3 , weapon1.getCost() );
        assertEquals("Ancharrr", weapon1.getName());
        assertEquals(2, weapon1.getAttack());
        assertEquals(2, weapon1.getHealth());
        assertEquals("After your hero attacks, draw a Pirate from your deck", weapon1.getDesc());
        assertEquals("Legendary",weapon1.getRarity() );

        assertEquals("HeroCard", hero1.getType());
        assertEquals("hunter", hero1.getGameClass());
        assertEquals(10 , hero1.getCost() );
        assertEquals("Zul'jin", hero1.getName());
        assertEquals(5, hero1.getHealth());
        assertEquals("Battlecry: Cast all spells you've played this game (targets chosen randomly)",
                hero1.getDesc());
        assertEquals("Legendary",hero1.getRarity() );
        assertEquals(2, hero1.getRewardCost());
        assertEquals("Deal 2 damage to any enemy", hero1.getRewardDesc());



    }


    void makeMinion1() {
        minion1.setType("Minion");
        minion1.setClass("Rogue");
        minion1.setAttack(3);
        minion1.setHealth(3);
        minion1.setCost(3);
        minion1.setName("Blink Fox");
        minion1.setDesc("Battlecry: Add a random card to your hand (from your opponent's class)");
        minion1.setRarity("Common");
        minion1.setTribe("Beast");
    }

    void makeSpell1() {
        spell1.setType("Spell");
        spell1.setClass("Mage");
        spell1.setCost(10);
        spell1.setName("Puzzle Box of Yogg-Saron");
        spell1.setRarity("Epic");
        spell1.setDesc("Cast 10 random spells (targets chosen randomly)");
    }


}
