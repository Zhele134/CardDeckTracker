package model;

public class Weapon extends Card {

    public Weapon() {
        this.type = "Weapon";
    }

    //MODIFIES: THIS
    //EFFECTS: sets attack to inputted value
    public void setAttack(int attack) {
        this.attack = attack;
    }

    //EFFECTS: returns value of attack
    public Integer getAttack() {
        return attack;
    }

    //MODIFIES: THIS
    //EFFECTS: sets durability to inputted value
    public void setHealth(int health) {
        this.health = health;
    }

    //EFFECTS: returns value of durability
    public Integer getHealth() {
        return health;
    }


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
