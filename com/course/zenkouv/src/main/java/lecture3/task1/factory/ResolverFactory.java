package lecture3.task1.factory;

import lecture3.task1.model.Armor;
import lecture3.task1.model.Outfit;
import lecture3.task1.model.Weapon;
import lecture3.task1.resolver.ArmorResolver;
import lecture3.task1.resolver.OutfitResolver;
import lecture3.task1.resolver.WeaponResolver;

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
