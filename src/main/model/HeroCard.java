package model;

public class HeroCard extends Card {
    Card hero;
    private int armor;
    private String rewardDesc;
    private String rewardCost;

    public HeroCard() {
        hero = new HeroCard();
    }

    @Override
    public void setAttack(int attack) {

    }

    @Override
    public Integer getAttack() {
        return 0;
    }

    //MODIFIES: THIS
    //EFFECTS: sets ArmorGain to inputted value
    public void setHealth(int health) {

    }

    //EFFECTS: returns value of ArmorGain
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

    //MODIFIES: THIS
    //EFFECTS: sets reward description to inputted value
    public void setRewardDesc(String rewardDesc) {

    }

    //EFFECTS: returns value of reward description
    public String getRewardDesc() {
        return "";
    }

    //MODIFIES: THIS
    //EFFECTS: sets reward cost to inputted value
    public void setRewardCost(int rewardCost) {

    }

    //EFFECTS: returns value of reward cost
    public Integer getRewardCost() {
        return 0;
    }



}
