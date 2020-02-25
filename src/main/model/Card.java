package model;

public class Card {
    protected String type;
    protected String name;
    protected int cost;
    protected String description;
    protected String gameClass;
    protected String rarity;
    protected String tribe;
    protected int attack;
    protected int health;
    protected String rewardDesc;
    protected int rewardCost;


    //MODIFIES: THIS
    //EFFECTS: Sets cost of Card
    public void setCost(int cost) {
        this.cost = cost;

    }

    //EFFECTS: returns cost
    public int getCost() {
        return cost;
    }

    //MODIFIES: THIS
    //EFFECTS: Sets description of Card
    public void setDesc(String desc) {
        this.description = desc;

    }

    //EFFECTS: returns description
    public String getDesc() {
        return description;
    }

    //MODIFIES: THIS
    //EFFECTS: Sets type of Card
    public void setType(String type) {
        this.type = type;
    }

    //EFFECTS: returns type
    public String getType() {
        return type;
    }

    //MODIFIES: THIS
    //EFFECTS: Sets name of Card
    public void setName(String name) {
        this.name = name;

    }

    //EFFECTS: returns name
    public String getName() {
        return name;
    }

    //MODIFIES: THIS
    //EFFECTS: Sets class of card
    public void setClass(String gameClass) {
        this.gameClass = gameClass;

    }

    //EFFECTS: returns game class of card
    public String getGameClass() {
        return gameClass;
    }

    //MODIFIES: THIS
    //EFFECTS: Sets rarity of card
    public void setRarity(String rarity) {
        this.rarity = rarity;

    }

    //EFFECTS: returns rarity of card
    public String getRarity() {
        return rarity;
    }



    //========================================================================================================

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

    //MODIFIES: THIS
    //EFFECTS: sets reward cost to inputted value
    public void setRewardCost(int rewardCost) {
        this.rewardCost = rewardCost;
    }

    //EFFECTS: returns value of reward cost
    public Integer getRewardCost() {
        return rewardCost;
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
}
