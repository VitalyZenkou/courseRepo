package lecture4.task2.util.reader;

import lecture3.task1.model.Armor;
import lecture3.task1.model.Material;
import lecture3.task1.model.Outfit;
import lecture3.task1.model.OutfitType;
import lecture4.task3.ReadDataValidator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArmorReader extends OutfitReader {

    public ArmorReader(String path) throws FileNotFoundException {
        super(path);
    }

    @Override
    public List<Outfit> read() {
        List<Outfit> armors = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(fileReader)) {
            reader.lines().forEach((line) -> {
                if (ReadDataValidator.isOutfit(line)) {
                    String[] armorParams = line.split(" ");
                    armors.add(new Armor(Integer.parseInt(armorParams[0]),
                            Double.parseDouble(armorParams[1]),
                            Integer.parseInt(armorParams[2]),
                            Material.getMaterial(armorParams[3]),
                            OutfitType.getOutfitType(armorParams[4])));
                } else {
                    System.out.printf("Wrong data format from file %s\n", file);
                }
            });
        } catch (IOException ex) {
            throw new RuntimeException("Can't read data from file!");
        }
        return armors;
    }
}
