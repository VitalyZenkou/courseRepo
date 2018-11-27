package Lecture3.Task1.factory.outfitFactory;

import Lecture3.Task1.model.Outfit;
import Lecture3.Task1.model.OutfitType;

public class Blacksmith {

    private static final OutfitFactory ARMOR_FACTORY = new ArmorFactory();
    private static final OutfitFactory WEAPON_FACTORY = new WeaponFactory();

    public Outfit createOutfit(OutfitType outfitType) {
        return switchFactory(outfitType).createDefaultOutfit(outfitType);
    }

    private OutfitFactory switchFactory(OutfitType outfitType) {
        switch (outfitType) {
            case AXE:
            case BOW:
            case MACE:
            case DAGGER:
            case SWORD:
            case LANCE: {
                return WEAPON_FACTORY;
            }
            case BOOTS:
            case HELM:
            case MAIL:
            case PANTS:
            case GLOVES:
            case SHIELD: {
                return ARMOR_FACTORY;
            }
            default: {
                throw new IllegalArgumentException("It's illegal outfit type " + outfitType.getClass());
            }
        }
    }
}
