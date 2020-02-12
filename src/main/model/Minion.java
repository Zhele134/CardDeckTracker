package model;

public class Minion extends Card {
    Card minion;

    public Minion() {
        this.type = "Minion";
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
    //EFFECTS: sets health to inputted value
    public void setHealth(int health) {
        this.health = health;

    }

    //EFFECTS: returns value of health
    public Integer getHealth() {
        return health;
    }

    //MODIFIES: THIS
    //EFFECTS: sets tribe to inputted value
    public void setTribe(String tribe) {
        this.tribe = tribe;

    }

    //EFFECTS: returns value of tribe
    public String getTribe() {
        return tribe;
    }

    /*
    *
    * ----------------------------------------------------------------------------------------------------------------
    *
     */
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
