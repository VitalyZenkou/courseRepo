package lecture3.task1.util.validator;

import lecture3.task1.model.Outfit;

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
