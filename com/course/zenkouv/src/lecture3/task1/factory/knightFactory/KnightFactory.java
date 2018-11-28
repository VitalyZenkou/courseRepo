package lecture3.task1.factory.knightFactory;

import lecture3.task1.Knight;
import lecture3.task1.factory.outfitFactory.Blacksmith;
import lecture3.task1.model.OutfitType;

public class KnightFactory {

    private static Blacksmith blacksmith = new Blacksmith();

    private KnightFactory() {
    }

    public static Knight createEquippedKnight(String name) {
        return addDefaultEquipment(new Knight(name));
    }

    private static Knight addDefaultEquipment(Knight knight) {
        knight.addOutfit(blacksmith.createOutfit(OutfitType.SWORD));
        knight.addOutfit(blacksmith.createOutfit(OutfitType.BOOTS));
        knight.addOutfit(blacksmith.createOutfit(OutfitType.HELM));
        knight.addOutfit(blacksmith.createOutfit(OutfitType.SHIELD));
        knight.addOutfit(blacksmith.createOutfit(OutfitType.GLOVES));
        knight.addOutfit(blacksmith.createOutfit(OutfitType.MAIL));
        knight.addOutfit(blacksmith.createOutfit(OutfitType.PANTS));
        return knight;
    }
}
