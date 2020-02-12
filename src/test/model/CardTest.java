package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    private Card minion;
    private Card spell;
    private Card weapon;
    private Card hero;

    @BeforeEach
    void runBefore() {
        minion = new Minion();
        spell = new Spell();
        weapon = new Weapon();
        hero = new HeroCard();
    }

    @Test
    void testMakeMinionCard() {
        minion.setType("Minion");
        minion.setClass("Rogue");
        minion.setAttack(3);
        minion.setHealth(3);
        minion.setCost(3);
        minion.setName("Blink Fox");
        minion.setDesc("Battlecry: Add a random card to your hand (from your opponent's class)");
        minion.setRarity("Common");
        minion.setTribe("Beast");

        minion.setRewardDesc("Bad");
        minion.setRewardCost(2);

        assertEquals("Minion", minion.getType());
        assertEquals("Rogue", minion.getGameClass());
        assertEquals(3, minion.getAttack() );
        assertEquals(3, minion.getHealth() );
        assertEquals(3,minion.getCost() );
        assertEquals("Blink Fox", minion.getName() );
        assertEquals("Battlecry: Add a random card to your hand (from your opponent's class)",
                minion.getDesc());
        assertEquals("Common",minion.getRarity() );
        assertEquals("Beast", minion.getTribe());

        assertEquals(null, minion.getRewardDesc());
        assertEquals(null, minion.getRewardCost());
    }

    @Test
    void testMakeSpellCard() {
        spell.setType("Spell");
        spell.setClass("Mage");
        spell.setCost(10);
        spell.setName("Puzzle Box of Yogg-Saron");
        spell.setRarity("Epic");
        spell.setDesc("Cast 10 random spells (targets chosen randomly)");

        spell.setRewardCost(2);
        spell.setRewardDesc("Bad");
        spell.setTribe("Spell");
        spell.setAttack(2);
        spell.setHealth(2);


        assertEquals("Spell", spell.getType());
        assertEquals("Mage", spell.getGameClass());
        assertEquals(10 , spell.getCost() );
        assertEquals("Puzzle Box of Yogg-Saron", spell.getName());
        assertEquals("Cast 10 random spells (targets chosen randomly)",
                spell.getDesc());
        assertEquals("Epic",spell.getRarity() );

        assertEquals(null, spell.getRewardCost());
        assertEquals(null, spell.getRewardDesc());
        assertEquals(null, spell.getTribe());
        assertEquals(null, spell.getAttack());
        assertEquals(null, spell.getHealth());
    }

    @Test
    void testMakeWeaponCard() {
        weapon.setType("Weapon");
        weapon.setClass("Warrior");
        weapon.setCost(3);
        weapon.setAttack(2);
        weapon.setHealth(2);
        weapon.setName("Ancharrr");
        weapon.setRarity("Legendary");
        weapon.setDesc("After your hero attacks, draw a Pirate from your deck");

        weapon.setRewardDesc("Weapon");
        weapon.setRewardCost(2);
        weapon.setTribe("Also Weapon");

        assertEquals("Weapon", weapon.getType());
        assertEquals("Warrior", weapon.getGameClass());
        assertEquals(3 , weapon.getCost() );
        assertEquals("Ancharrr", weapon.getName());
        assertEquals(2, weapon.getAttack());
        assertEquals(2, weapon.getHealth());
        assertEquals("After your hero attacks, draw a Pirate from your deck", weapon.getDesc());
        assertEquals("Legendary",weapon.getRarity() );

        assertEquals(null, weapon.getRewardDesc());
        assertEquals(null, weapon.getRewardCost());
        assertEquals(null, weapon.getTribe());
    }

    @Test
    void testMakeHeroCard() {
        hero.setType("HeroCard");
        hero.setClass("Hunter");
        hero.setCost(10);
        hero.setName("Zul'jin");
        hero.setHealth(5);
        hero.setDesc("Battlecry: Cast all spells you've played this game (targets chosen randomly)");
        hero.setRarity("Legendary");
        hero.setRewardCost(2);
        hero.setRewardDesc("Deal 2 damage to any enemy");

        hero.setAttack(1);
        hero.setTribe("I need a hero");

        assertEquals("HeroCard", hero.getType());
        assertEquals("Hunter", hero.getGameClass());
        assertEquals(10 , hero.getCost() );
        assertEquals("Zul'jin", hero.getName());
        assertEquals(5, hero.getHealth());
        assertEquals("Battlecry: Cast all spells you've played this game (targets chosen randomly)",
                hero.getDesc());
        assertEquals("Legendary",hero.getRarity() );
        assertEquals(2, hero.getRewardCost());
        assertEquals("Deal 2 damage to any enemy", hero.getRewardDesc());

        assertEquals(null, hero.getAttack());
        assertEquals(null, hero.getTribe());
    }



}