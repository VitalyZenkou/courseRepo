package lecture3.task1.resolver;

import lecture3.task1.model.Outfit;
import lecture3.task1.model.Weapon;

import java.util.List;

public class WeaponResolver implements OutfitResolver {

    @Override
    public boolean resolve(List<Outfit> outfits, Outfit outfit) {
        for (Outfit knightOutfit : outfits) {
            if (knightOutfit instanceof Weapon) {
                System.out.printf("I have a %s and me don't need any weapon!\n",
                        knightOutfit.getType().toString().toLowerCase());
                return false;
            }
        }
        return true;
    }
}
