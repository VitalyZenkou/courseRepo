package Lecture4.Task2.util.reader;
import Lecture3.Task1.model.Material;
import Lecture3.Task1.model.Outfit;
import Lecture3.Task1.model.OutfitType;
import Lecture3.Task1.model.Weapon;
import Lecture4.task3.ReadDataValidator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WeaponReader extends OutfitReader {

    public WeaponReader(String path) throws FileNotFoundException {
        super(path);
    }

    @Override
    public List<Outfit> read() {
        List<Outfit> weapons = new ArrayList<>();
        String params;
        try (BufferedReader reader = new BufferedReader(fileReader)) {
            reader.lines().forEach((line) -> {
                if (ReadDataValidator.isOutfit(line)) {
                    String[] weaponParams = line.split(" ");
                    weapons.add(new Weapon(Integer.parseInt(weaponParams[0]),
                            Double.parseDouble(weaponParams[1]),
                            Integer.parseInt(weaponParams[2]),
                            Material.getMaterial(weaponParams[3]),
                            OutfitType.getOutfitType(weaponParams[4])));
                } else {
                    System.out.printf("Wrong data format from file %s\n", file);
                }
            });
        } catch (IOException ex) {
            throw new RuntimeException("Can't read data from file!");
        }
        return weapons;
    }
}
