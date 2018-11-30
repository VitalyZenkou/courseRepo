package lecture3.task1.model;

import java.util.Objects;

public class Weapon extends Outfit {

    public final static int DEFAULT_COST = 8;
    public final static int DEFAULT_DAMAGE = 15;
    public final static Material DEFAULT_MATERIAL = Material.STEEL;
    private final int damage;

    public Weapon(int cost, double weight, int damage, Material material, OutfitType type) {
        super(cost, weight, material, type);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Weapon weapon = (Weapon) o;
        return damage == weapon.damage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), damage);
    }

    @Override
    public String toString() {
        return String.format("Type: %-10s, damage - %-3d, %s", super.getType().toString().toLowerCase(), damage, super.toString());
    }
}
