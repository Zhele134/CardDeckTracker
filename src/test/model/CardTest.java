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
        minion.setAttack(5);
    }

}