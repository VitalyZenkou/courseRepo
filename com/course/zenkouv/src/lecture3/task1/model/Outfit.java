package lecture3.task1.model;

import java.util.Objects;

public abstract class Outfit {

    private final int cost;
    private final double weight;
    private final Material material;
    private final OutfitType outfitType;

    Outfit(int cost, double weight, Material material, OutfitType outfitType) {
        this.cost = cost;
        this.weight = weight;
        this.material = material;
        this.outfitType = outfitType;
    }

    public int getCost() {
        return cost;
    }

    public double getWeight() {
        return weight;
    }

    public Material getMaterial() {
        return material;
    }

    public OutfitType getType() {
        return outfitType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Outfit outfit = (Outfit) o;
        return cost == outfit.cost &&
                Double.compare(outfit.weight, weight) == 0 &&
                material == outfit.material &&
                outfitType == outfit.outfitType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cost, weight, material, outfitType);
    }

    @Override
    public String toString() {
        return String.format("material: - %-10s, cost - %-3d, weight - %-3.2fkg.\n", material.toString().toLowerCase(), cost, weight);
    }
}
