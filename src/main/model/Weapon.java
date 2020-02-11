package model;

public class Weapon extends Card {
    Card weapon;
    private int weaponAttack;
    private int durability;

    public Weapon() {

    }

    //MODIFIES: THIS
    //EFFECTS: sets attack to inputted value
    public void setAttack(int attack) {

    }

    //EFFECTS: returns value of attack
    public Integer getAttack() {
        return 0;
    }

    //MODIFIES: THIS
    //EFFECTS: sets durability to inputted value
    public void setHealth(int health) {

    }

    //EFFECTS: returns value of durability
    public Integer getHealth() {
        return 0;
    }

    @Override
    public void setTribe(String tribe) {

    }

    @Override
    public String getTribe() {
        return null;
    }

    @Override
    public void setRewardCost(int rewardCost) {

    }

    @Override
    public Integer getRewardCost() {
        return 0;
    }

    @Override
    public void setRewardDesc(String rewardDesc) {

    }

    @Override
    public String getRewardDesc() {
        return null;
    }
}
