package model;

public class Minion extends Card {
    Card minion;

    public Minion() {
        this.type = "Minion";
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
