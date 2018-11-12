package Lecture3.Task1;

import Lecture3.Task1.factory.knightFactory.KnightFactory;
import Lecture3.Task1.model.Outfit;
import Lecture3.Task1.util.calculator.OutfitCalculator;
import Lecture3.Task1.util.filter.OutfitFilter;
import Lecture3.Task1.util.helper.OutfitHelper;

import java.util.List;

class KnightApp {

    private static final Knight ARTUR = KnightFactory.createEquippedKnight("Artur");
    private static final int MAX_COST = 100;
    private static final int MIN_COST = 30;
    private static final int MIN_DAMAGE = 100;
    private static final int MAX_DAMAGE = 900;
    private static final int MIN_DEFENCE = 15;
    private static final int MAX_DEFENCE = 50;

    public static void main(String[] args) {

        ARTUR.setOutfitsCost(OutfitCalculator.calculateOutfitsCost(ARTUR.getOutfits()));
        printKnight(ARTUR);
        ARTUR.setOutfits(OutfitHelper.compareOutfitsByCost(ARTUR.getOutfits()));
        printKnight(ARTUR);
        ARTUR.setOutfits(OutfitHelper.compareOutfitsByWeight(ARTUR.getOutfits()));
        printKnight(ARTUR);
        printOutfitsByMinToMaxParams(ARTUR.getOutfits());
    }

    private static void printKnight(Knight knight) {
        System.out.println(knight);
        System.out.println("-----------------------------------------------------------------");
    }

    private static void printOutfitsByMinToMaxParams(List<Outfit> outfits) {
        System.out.println(OutfitFilter.filterOutfitFromMinToMaxCost(outfits, KnightApp.MIN_COST, KnightApp.MAX_COST));
        System.out.println(OutfitFilter.filterOutfitFromMinToMaxDamage(outfits, KnightApp.MIN_DAMAGE, KnightApp.MAX_DAMAGE));
        System.out.println(OutfitFilter.filterOutfitFromMinToMaxDefence(outfits, KnightApp.MIN_DEFENCE, KnightApp.MAX_DEFENCE));
    }
}
