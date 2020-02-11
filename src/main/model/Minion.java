package model;

public class Minion extends Card {
    Card minion;

    public Minion() {
        minion = new Minion();

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
    //EFFECTS: sets health to inputted value
    public void setHealth(int health) {

    }

    //EFFECTS: returns value of health
    public Integer getHealth() {
        return 0;
    }

    //MODIFIES: THIS
    //EFFECTS: sets tribe to inputted value
    public void setTribe(String tribe) {

    }

    //EFFECTS: returns value of tribe
    public String getTribe() {
        return "";
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
