package model;

public class Weapon extends Card {
    Card weapon;
    private int weaponAttack;
    private int durability;

    public Weapon() {
        this.type = "Weapon";
    }

    //MODIFIES: THIS
    //EFFECTS: sets attack to inputted value
    public void setAttack(int attack) {
        weaponAttack = attack;
    }

    //EFFECTS: returns value of attack
    public Integer getAttack() {
        return weaponAttack;
    }

    //MODIFIES: THIS
    //EFFECTS: sets durability to inputted value
    public void setHealth(int health) {
        durability = health;

    }

    //EFFECTS: returns value of durability
    public Integer getHealth() {
        return durability;
    }

    /*
    -----------------------------------------------------------------------------------------------------------------
     */
    @Override
    public void setTribe(String tribe) {
        System.out.println("Can't set this");
    }

    @Override
    public String getTribe() {
        return null;
    }

    @Override
    public void setRewardCost(int rewardCost) {
        System.out.println("Can't set this");
    }

    @Override
    public Integer getRewardCost() {
        return null;
    }

    @Override
    public void setRewardDesc(String rewardDesc) {
        System.out.println("Can't set this");
    }

    @Override
    public String getRewardDesc() {
        return null;
    }
}
