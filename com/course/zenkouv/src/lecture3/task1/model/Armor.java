package lecture3.task1.model;

import java.util.Objects;

public class Armor extends Outfit {

    public final static int DEFAULT_COST = 5;
    public final static int DEFAULT_DEFENCE = 9;
    public final static Material DEFAULT_MATERIAL = Material.LEATHER;
    private final int defense;

    public Armor(int cost, double weight, int defense, Material material, OutfitType type) {
        super(cost, weight, material, type);
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Armor armor = (Armor) o;
        return defense == armor.defense;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), defense);
    }

    @Override
    public String toString() {
        return String.format("Type: %-10s, defence - %-3d, %s", super.getType().toString().toLowerCase(), defense, super.toString());
    }
}
