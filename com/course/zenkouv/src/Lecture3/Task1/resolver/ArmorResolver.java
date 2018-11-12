package Lecture3.Task1.resolver;

import Lecture3.Task1.model.Armor;
import Lecture3.Task1.model.Outfit;

import java.util.List;

public class ArmorResolver implements OutfitResolver {

    @Override
    public boolean resolve(List<Outfit> outfits, Outfit outfit) {
        for (Outfit knightOutfit : outfits) {
            if (knightOutfit instanceof Armor) {
                if (knightOutfit.getType() == outfit.getType()) {
                    System.out.printf("I have a %s and me don't need any %s!\n",
                            (knightOutfit).getType().toString().toLowerCase(),
                            (knightOutfit).getType().toString().toLowerCase());
                    return false;
                }
            }
        }
        return true;
    }
}
