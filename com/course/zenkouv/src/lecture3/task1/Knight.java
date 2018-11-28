package lecture3.task1;

import lecture3.task1.factory.ResolverFactory;
import lecture3.task1.model.Outfit;
import lecture3.task1.resolver.OutfitResolver;

import java.util.ArrayList;
import java.util.List;

public class Knight {

    private final String name;
    private List<Outfit> outfits = new ArrayList<>();
    private int outfitsCost;

    public Knight(String name) {
        this.name = name;
    }

    public List<Outfit> getOutfits() {
        return outfits;
    }

    public void setOutfitsCost(int cost) {
        outfitsCost = cost;
    }

    public void setOutfits(List<Outfit> outfits) {
        this.outfits = outfits;
    }

    public void addOutfit(Outfit outfit) {
        if (outfitChecker(outfit)) {
            outfits.add(outfit);
        }
    }

    public void removeOutfit(Outfit outfit) {
            outfits.remove(outfit);
    }

    private boolean outfitChecker(Outfit outfit) {
        OutfitResolver resolver = ResolverFactory.getResolver(outfit);
        return resolver.resolve(outfits, outfit);
    }

    @Override
    public String toString() {
        return String.format("My name is %s and i have next outfits:\n%s\nTotal cost: %d\n", name, outfits, outfitsCost);
    }
}
