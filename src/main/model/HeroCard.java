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

    //MODIFIES: THIS
    //EFFECTS: sets reward description to inputted value
    public void setRewardDesc(String rewardDesc) {
        this.rewardDesc = rewardDesc;

    }

    //EFFECTS: returns value of reward description
    public String getRewardDesc() {
        return rewardDesc;
    }

    //MODIFIES: THIS
    //EFFECTS: sets reward cost to inputted value
    public void setRewardCost(int rewardCost) {
        this.rewardCost = rewardCost;

    }

    //EFFECTS: returns value of reward cost
    public Integer getRewardCost() {
        return rewardCost;
    }
    /*
    -------------------------------------------------------------------------------------------------------------------
     */

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
