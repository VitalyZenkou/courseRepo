package Lecture3.Task1.model;

public enum OutfitType {

    HELM(3, 1, 1), BOOTS(5, 1.5, 2), GLOVES(8, 1.8, 2), SHIELD(10, 3, 3), PANTS(13, 3.3, 3), MAIL(20, 4.2, 5),
    DAGGER(11, 2, 1), LANCE(14, 4.5, 3), AXE(18, 4, 5), BOW(20, 2.8, 10), SWORD(21, 4.2, 12), MACE(23, 5, 9);

    private int costRatio;
    private double weightRatio;
    private int specificOptionRatio;

    OutfitType(int costRatio, double weightRatio, int specificOptionRatio) {
        this.costRatio = costRatio;
        this.weightRatio = weightRatio;
        this.specificOptionRatio = specificOptionRatio;
    }

    public int getCostRatio() {
        return costRatio;
    }

    public double getWeightRatio() {
        return weightRatio;
    }

    public int getSpecificOptionRatio() {
        return specificOptionRatio;
    }
}
