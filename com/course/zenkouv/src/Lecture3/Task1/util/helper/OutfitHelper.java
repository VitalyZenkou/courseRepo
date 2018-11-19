package Lecture3.Task1.util.helper;

import Lecture3.Task1.model.Outfit;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OutfitHelper {

    private OutfitHelper() {
    }

    public static List<Outfit> compareOutfitsByCost(List<Outfit> outfits) {
        return compareByParams(outfits, Comparator.comparingInt(Outfit ::getCost));
    }

    public static List<Outfit> compareOutfitsByWeight(List<Outfit> outfits) {
        return compareByParams(outfits, Comparator.comparingDouble(Outfit ::getWeight));
    }

    private static List<Outfit> compareByParams(List<Outfit> outfits, Comparator comparator){
        List<Outfit> compareOutfits = new ArrayList<>(outfits);
        compareOutfits.sort(comparator);
        return compareOutfits;
    }
}
