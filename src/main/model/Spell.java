package model;

public class Spell extends Card {
    Card spell;

    public Spell() {
        this.type = "Spell";
    }

    /*
    -----------------------------------------------------------------------------------------------------------------
     */
    @Override
    public void setAttack(int attack) {

    }

    @Override
    public Integer getAttack() {
        return 0;
    }

    @Override
    public void setHealth(int health) {

    }

    @Override
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
