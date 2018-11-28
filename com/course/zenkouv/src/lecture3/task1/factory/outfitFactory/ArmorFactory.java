package lecture3.task1.factory.outfitFactory;

import lecture3.task1.model.*;
import lecture3.task1.util.calculator.OutfitCalculator;

public class ArmorFactory implements OutfitFactory {

    @Override
    public Outfit createDefaultOutfit(OutfitType outfitType) {
        return new Armor(OutfitCalculator.calculateCost(Armor.DEFAULT_MATERIAL, outfitType),
                OutfitCalculator.calculateWeight(Armor.DEFAULT_MATERIAL, outfitType),
                OutfitCalculator.calculateDefence(Armor.DEFAULT_MATERIAL, outfitType),
                Armor.DEFAULT_MATERIAL, outfitType);
    }
}
