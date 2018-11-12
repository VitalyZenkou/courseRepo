package Lecture3.Task1.factory.outfitFactory;

import Lecture3.Task1.model.Outfit;
import Lecture3.Task1.model.OutfitType;

public interface OutfitFactory {

    Outfit createDefaultOutfit(OutfitType outfitType);
}
