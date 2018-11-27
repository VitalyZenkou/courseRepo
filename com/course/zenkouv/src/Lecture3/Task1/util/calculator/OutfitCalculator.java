package Lecture3.Task1.util.calculator;

import Lecture3.Task1.model.*;
import Lecture3.Task1.util.validator.OutfitValidator;

import java.util.List;

public class OutfitCalculator {

    private OutfitCalculator() {
    }

    public static int calculateOutfitsCost(List<Outfit> outfits) {
        if (OutfitValidator.haveAnyOutfits(outfits)) {
            return outfits.stream().mapToInt(Outfit::getCost).sum();
        }
        return 0;
    }

    public static int calculateCost(Material material, OutfitType outfitType) {
        switch (outfitType) {
            case AXE:
            case BOW:
            case MACE:
            case DAGGER:
            case SWORD:
            case LANCE: {
                return Weapon.DEFAULT_COST * material.getCostRatio() * outfitType.getCostRatio();
            }
        }
        return Armor.DEFAULT_COST * material.getCostRatio() * outfitType.getCostRatio();
    }

    public static double calculateWeight(Material material, OutfitType outfitType) {
        return material.getWeightRatio() * outfitType.getWeightRatio();
    }

    public static int calculateDamage(Material material, OutfitType outfitType) {
        return Weapon.DEFAULT_DAMAGE * material.getDamageRatio() * outfitType.getSpecificOptionRatio();
    }

    public static int calculateDefence(Material material, OutfitType outfitType) {
        return Armor.DEFAULT_DEFENCE * material.getDefenceRatio() * outfitType.getSpecificOptionRatio();
    }
}
