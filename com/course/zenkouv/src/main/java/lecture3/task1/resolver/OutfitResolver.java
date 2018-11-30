package lecture3.task1.resolver;

import lecture3.task1.model.Outfit;

import java.util.List;

public interface OutfitResolver {

    boolean resolve(List<Outfit> outfits, Outfit outfit);
}
