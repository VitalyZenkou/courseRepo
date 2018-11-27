package Lecture3.Task1.util.validator;

import Lecture3.Task1.model.Outfit;

import java.util.List;

public class OutfitValidator {

    private OutfitValidator() {
    }

    public static boolean haveAnyOutfits(List<Outfit> outfits) {
        if (outfits.isEmpty()) {
            System.out.println("I haven't any outfit!");
            return false;
        }
        return true;
    }
}
