package Lecture3.Task1.factory;

import Lecture3.Task1.model.Armor;
import Lecture3.Task1.model.Outfit;
import Lecture3.Task1.model.Weapon;
import Lecture3.Task1.resolver.ArmorResolver;
import Lecture3.Task1.resolver.OutfitResolver;
import Lecture3.Task1.resolver.WeaponResolver;

public class ResolverFactory {

    private ResolverFactory() {
    }

    public static OutfitResolver getResolver(Outfit outfit) {
        if (outfit instanceof Weapon) {
            return new WeaponResolver();
        } else if (outfit instanceof Armor) {
            return new ArmorResolver();
        }
        throw new IllegalArgumentException("Incorrect type of outfit " + outfit.getClass());
    }
}
