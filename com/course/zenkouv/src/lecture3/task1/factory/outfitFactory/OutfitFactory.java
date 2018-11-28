package lecture3.task1.factory.outfitFactory;

import lecture3.task1.model.Outfit;
import lecture3.task1.model.OutfitType;

public interface OutfitFactory {

    Outfit createDefaultOutfit(OutfitType outfitType);
}
