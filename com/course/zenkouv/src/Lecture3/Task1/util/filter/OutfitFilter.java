package Lecture3.Task1.util.filter;

import Lecture3.Task1.model.Armor;
import Lecture3.Task1.model.Outfit;
import Lecture3.Task1.model.Weapon;

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
