package lecture4.task2.util.writer;

import lecture3.task1.model.Armor;

import java.io.FileWriter;
import java.io.IOException;

public class ArmorWriter extends CustomWriter<Armor> {

    public ArmorWriter(String path) {
        super(path);
    }

    @Override
    public void write(Armor armor) {
        try (FileWriter writer = new FileWriter(getFile(), true)) {
            writer.write(armor.getCost() + " ");
            writer.write(Double.toString(armor.getWeight()) + " ");
            writer.write(armor.getDefense() + " ");
            writer.write(armor.getMaterial().toString() + " ");
            writer.write(armor.getType().toString() + "\n");
        } catch (IOException e) {
            System.out.println("The data wasn't wrote to file " + getFile());
        }
    }
}
