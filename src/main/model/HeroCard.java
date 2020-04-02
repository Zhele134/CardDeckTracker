package model;

public class HeroCard extends Card {
    Card hero;

    public HeroCard() {
        this.type = "HeroCard";
    }



    //MODIFIES: THIS
    //EFFECTS: sets ArmorGain to inputted value
    public void setHealth(int health) {
        this.health = health;
    }

    //EFFECTS: returns value of ArmorGain
    public Integer getHealth() {
        return health;
    }

    @Override
    public void setAttack(int attack) {
        System.out.println("Can't set this");
    }

    @Override
    public Integer getAttack() {
        return null;
    }

    @Override
    public void setTribe(String tribe) {
        System.out.println("Can't set this");
    }

    @Override
    public String getTribe() {
        return null;
    }


}
