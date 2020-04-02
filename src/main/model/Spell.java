package model;

public class Spell extends Card {
    Card spell;

    public Spell() {
        this.type = "Spell";
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
    public void setHealth(int health) {
        System.out.println("Can't set this");
    }

    @Override
    public Integer getHealth() {
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
