package Lecture3.Task1.factory.outfitFactory;

import Lecture3.Task1.model.Outfit;
import Lecture3.Task1.model.OutfitType;
import Lecture3.Task1.model.Weapon;
import Lecture3.Task1.util.calculator.OutfitCalculator;

public class WeaponFactory implements OutfitFactory {

    @Override
    public Outfit createDefaultOutfit(OutfitType outfitType) {
        return new Weapon(OutfitCalculator.calculateCost(Weapon.DEFAULT_MATERIAL, outfitType),
                OutfitCalculator.calculateWeight(Weapon.DEFAULT_MATERIAL, outfitType),
                OutfitCalculator.calculateDamage(Weapon.DEFAULT_MATERIAL, outfitType),
                Weapon.DEFAULT_MATERIAL, outfitType);
    }
}
