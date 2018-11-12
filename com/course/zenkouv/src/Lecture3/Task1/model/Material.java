package Lecture3.Task1.model;

public enum Material {

    STEEL(4, 1, 5, 5), LEATHER(2, 0.5, 2, 0), WOOD(1, 0.7, 2, 1), CHAINMAIL(3, 0.8, 4, 0);

    private int costRatio;
    private double weightRatio;
    private int defenceRatio;
    private int damageRatio;

    Material(int costRatio, double weightRatio, int defenceRatio, int damageRatio) {
        this.costRatio = costRatio;
        this.weightRatio = weightRatio;
        this.defenceRatio = defenceRatio;
        this.damageRatio = damageRatio;
    }

    public int getCostRatio() {
        return costRatio;
    }

    public double getWeightRatio() {
        return weightRatio;
    }

    public int getDefenceRatio() {
        return defenceRatio;
    }

    public int getDamageRatio() {
        return damageRatio;
    }
}
