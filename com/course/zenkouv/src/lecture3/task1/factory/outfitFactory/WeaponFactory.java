package lecture3.task1.factory.outfitFactory;

import lecture3.task1.model.Outfit;
import lecture3.task1.model.OutfitType;
import lecture3.task1.model.Weapon;
import lecture3.task1.util.calculator.OutfitCalculator;

public class WeaponFactory implements OutfitFactory {

    @Override
    public Outfit createDefaultOutfit(OutfitType outfitType) {
        return new Weapon(OutfitCalculator.calculateCost(Weapon.DEFAULT_MATERIAL, outfitType),
                OutfitCalculator.calculateWeight(Weapon.DEFAULT_MATERIAL, outfitType),
                OutfitCalculator.calculateDamage(Weapon.DEFAULT_MATERIAL, outfitType),
                Weapon.DEFAULT_MATERIAL, outfitType);
    }
}
