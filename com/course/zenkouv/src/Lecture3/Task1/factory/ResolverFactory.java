package Lecture3.Task1.factory;

import Lecture3.Task1.model.Armor;
import Lecture3.Task1.model.Outfit;
import Lecture3.Task1.model.Weapon;
import Lecture3.Task1.resolver.ArmorResolver;
import Lecture3.Task1.resolver.OutfitResolver;
import Lecture3.Task1.resolver.WeaponResolver;

public class ResolverFactory {

    private static final OutfitResolver weaponResolver = new WeaponResolver();
    private static final OutfitResolver armorResolver = new ArmorResolver();

    private ResolverFactory() {
    }

    public static OutfitResolver getResolver(Outfit outfit) {
        if (outfit instanceof Weapon) {
            return weaponResolver;
        } else if (outfit instanceof Armor) {
            return armorResolver;
        }
        throw new IllegalArgumentException("Incorrect type of outfit " + outfit.getClass());
    }
}
