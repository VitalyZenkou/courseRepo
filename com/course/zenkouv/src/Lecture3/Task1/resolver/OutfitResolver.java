package Lecture3.Task1.resolver;

import Lecture3.Task1.model.Outfit;

import java.util.List;

public interface OutfitResolver {

    boolean resolve(List<Outfit> outfits, Outfit outfit);
}
