package Lecture4.Task2.factory;

import Lecture3.Task1.model.Armor;
import Lecture3.Task1.model.Outfit;
import Lecture3.Task1.model.Weapon;
import Lecture4.Task2.util.Path;
import Lecture4.Task2.util.writer.ArmorWriter;
import Lecture4.Task2.util.writer.CustomWriter;
import Lecture4.Task2.util.writer.MessageWriter;
import Lecture4.Task2.util.writer.WeaponWriter;
import Lecture4.task1.exeption.WriterNotFoundException;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class WriterFactory {

    private List<CustomWriter> writers;

    public WriterFactory() {
        try {
            writers = Arrays.asList(new MessageWriter(Path.MESSAGE_PATH), new WeaponWriter(Path.WEAPON_PATH), new ArmorWriter(Path.ARMOR_PATH));
        } catch (IOException e) {
            System.out.println("The writer wasn't created!");
        }
    }

    public List<CustomWriter> getWriters() {
        return writers;
    }

    public CustomWriter getOutfitWriter(Outfit outfit) {
        for (CustomWriter writer : this.writers) {
            if (outfit instanceof Weapon) {
                if (writer instanceof WeaponWriter) {
                    return writer;
                }
            } else if (outfit instanceof Armor) {
                if (writer instanceof ArmorWriter) {
                    return writer;
                }
            }
        }
        throw new WriterNotFoundException("The are not available writer for " + outfit.getClass());
    }

    public CustomWriter getSimpleWriter() {
        for (CustomWriter writer : this.writers) {
            if (writer instanceof MessageWriter) {
                return writer;
            }
        }
        throw new WriterNotFoundException("The message writer wasn't found!");
    }
}
