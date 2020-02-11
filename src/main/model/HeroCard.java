package model;

public class HeroCard extends Card {
    Card hero;
    private int armor;
    private String rewardDesc;
    private int rewardCost;

    public HeroCard() {
        this.type = "HeroCard";
    }



    //MODIFIES: THIS
    //EFFECTS: sets ArmorGain to inputted value
    public void setHealth(int health) {
        armor = health;
    }

    //EFFECTS: returns value of ArmorGain
    public Integer getHealth() {
        return armor;
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

    }

    @Override
    public Integer getAttack() {
        return 0;
    }

    @Override
    public void setTribe(String tribe) {

    }

    @Override
    public String getTribe() {
        return null;
    }


}
