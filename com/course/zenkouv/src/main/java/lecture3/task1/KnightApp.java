package lecture3.task1;

import lecture3.task1.factory.knightFactory.KnightFactory;
import lecture3.task1.model.Outfit;
import lecture3.task1.util.calculator.OutfitCalculator;
import lecture3.task1.util.filter.OutfitFilter;
import lecture3.task1.util.helper.OutfitHelper;
import lecture4.task2.factory.OutfitReaderFactory;
import lecture4.task2.factory.WriterFactory;
import lecture4.task2.util.operation.FileOperation;
import lecture4.task2.util.writer.CustomWriter;

import java.io.IOException;
import java.util.List;

class KnightApp {

    private static final Knight ARTUR = KnightFactory.createEquippedKnight("Artur");
    private static final Knight LANCELOT = new Knight("Lancelot");
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

        try {
            WriterFactory writerFactory = new WriterFactory();
            FileOperation.writeOutfitsToFile(writerFactory, ARTUR.getOutfits());

            OutfitReaderFactory readerFactory = new OutfitReaderFactory();
            FileOperation.renameAndMoveFile(writerFactory);
            LANCELOT.setOutfits(FileOperation.readOutfitsFromFile(readerFactory));

            CustomWriter messageWriter = writerFactory.getSimpleWriter();

            messageWriter.write(LANCELOT.toString());
            messageWriter.write(ARTUR.toString());
            FileOperation.renameAndMoveFile(writerFactory);
            FileOperation.deleteFiles(writerFactory);
        } catch (IOException e) {
            System.out.println("The writer wasn't created!");
        }
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
