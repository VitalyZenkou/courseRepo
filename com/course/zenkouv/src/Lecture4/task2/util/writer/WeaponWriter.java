package Lecture4.Task2.util.writer;

import Lecture3.Task1.model.Weapon;

import java.io.FileWriter;
import java.io.IOException;

public class WeaponWriter extends CustomWriter<Weapon> {

    public WeaponWriter(String path) {
        super(path);
    }

    @Override
    public void write(Weapon weapon) {
        try (FileWriter writer = new FileWriter(getFile(), true)) {
            writer.write(weapon.getCost() + " ");
            writer.write(Double.toString(weapon.getWeight()) + " ");
            writer.write(weapon.getDamage() + " ");
            writer.write(weapon.getMaterial().toString() + " ");
            writer.write(weapon.getType().toString() + "\n");
        } catch (IOException e) {
            System.out.println("The data wasn't wrote to file " + getFile());
        }
    }
}
