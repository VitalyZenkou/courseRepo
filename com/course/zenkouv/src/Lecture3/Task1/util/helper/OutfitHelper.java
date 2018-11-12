package Lecture3.Task1.util.helper;

import Lecture3.Task1.model.Outfit;
import Lecture3.Task1.util.filter.OutfitFilter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OutfitHelper {

    private OutfitHelper() {
    }

    public static List<Outfit> compareOutfitsByCost(List<Outfit> outfits) {
        List<Outfit> outfitsSortedByCost = new ArrayList<>(outfits);
        outfitsSortedByCost.sort(Comparator.comparingInt(Outfit::getCost));
        return outfitsSortedByCost;
    }

    public static List<Outfit> compareOutfitsByWeight(List<Outfit> outfits) {
        List<Outfit> outfitsSortedByWeight = new ArrayList<>(outfits);
        outfitsSortedByWeight.sort(Comparator.comparingDouble(Outfit::getWeight));
        return outfitsSortedByWeight;
    }
}
