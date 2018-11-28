package lecture3.task1.util.filter;

import lecture3.task1.model.Armor;
import lecture3.task1.model.Outfit;
import lecture3.task1.model.Weapon;

import java.util.List;
import java.util.stream.Collectors;

public class OutfitFilter {

    private OutfitFilter() {
    }

    public static List<Outfit> filterOutfitFromMinToMaxCost(List<Outfit> outfits, int minCost, int maxCost) {
        return outfits.stream()
                .filter(outfit -> outfit.getCost() >= minCost && outfit.getCost() <= maxCost)
                .collect(Collectors.toList());
    }

    public static List<Outfit> filterOutfitFromMinToMaxDamage(List<Outfit> outfits, int minDamage, int maxDamage) {
        return outfits.stream()
                .filter(outfit -> outfit instanceof Weapon)
                .filter(weapon -> (((Weapon) weapon).getDamage() >= minDamage && ((Weapon) weapon).getDamage() <= maxDamage))
                .collect(Collectors.toList());
    }

    public static List<Outfit> filterOutfitFromMinToMaxDefence(List<Outfit> outfits, int minDefence, int maxDefence) {
        return outfits.stream()
                .filter(outfit -> outfit instanceof Armor)
                .filter(armor -> ((Armor) armor).getDefense() >= minDefence && ((Armor) armor).getDefense() <= maxDefence)
                .collect(Collectors.toList());
    }
}
