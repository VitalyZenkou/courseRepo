package Lecture4.Task2.factory;

import Lecture4.Task2.util.Path;
import Lecture4.Task2.util.reader.ArmorReader;
import Lecture4.Task2.util.reader.OutfitReader;
import Lecture4.Task2.util.reader.WeaponReader;

import java.io.FileNotFoundException;

public class OutfitReaderFactory {

    private final OutfitReader weaponReader;
    private final OutfitReader armorReader;

    public OutfitReaderFactory() {
        try {
            weaponReader = new WeaponReader(Path.WEAPON_PATH_NEW_DESTINATION);
            armorReader = new ArmorReader(Path.ARMOR_PATH_NEW_DESTINATION);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("The files weren't found: " + Path.WEAPON_PATH_NEW_DESTINATION + ", " + Path.ARMOR_PATH_NEW_DESTINATION);
        }
    }

    public OutfitReader getWeaponReader() {
        return weaponReader;
    }

    public OutfitReader getArmorReader() {
        return armorReader;
    }
}
