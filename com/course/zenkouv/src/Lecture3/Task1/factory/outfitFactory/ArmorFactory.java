package Lecture3.Task1.factory.outfitFactory;

import Lecture3.Task1.model.*;
import Lecture3.Task1.util.calculator.OutfitCalculator;

public class ArmorFactory implements OutfitFactory {

    @Override
    public Outfit createDefaultOutfit(OutfitType outfitType) {
        return new Armor(OutfitCalculator.calculateCost(Armor.DEFAULT_MATERIAL, outfitType),
                OutfitCalculator.calculateWeight(Armor.DEFAULT_MATERIAL, outfitType),
                OutfitCalculator.calculateDefence(Armor.DEFAULT_MATERIAL, outfitType),
                Armor.DEFAULT_MATERIAL, outfitType);
    }
}
