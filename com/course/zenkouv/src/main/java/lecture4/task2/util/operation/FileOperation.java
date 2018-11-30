package lecture4.task2.util.operation;

import lecture3.task1.model.Outfit;
import lecture4.task2.factory.OutfitReaderFactory;
import lecture4.task2.factory.WriterFactory;
import lecture4.task2.util.writer.CustomWriter;
import lecture4.task2.util.Path;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileOperation {

    private FileOperation() {
    }

    public static void deleteFiles(WriterFactory writerFactory) {
        for (CustomWriter writer : writerFactory.getWriters()) {
            deleteFile(writer);
        }
    }

    public static void renameAndMoveFile(WriterFactory writerFactory) {
        for (CustomWriter writer : writerFactory.getWriters()) {
            switch (writer.getFile().getPath()) {
                case Path.MESSAGE_PATH:
                    printMessage(writer.getFile().renameTo(new File(Path.MESSAGE_PATH_NEW_DESTINATION)), writer.getFile());
                    break;
                case Path.ARMOR_PATH:
                    printMessage(writer.getFile().renameTo(new File(Path.ARMOR_PATH_NEW_DESTINATION)), writer.getFile());
                    break;
                case Path.WEAPON_PATH:
                    printMessage(writer.getFile().renameTo(new File(Path.WEAPON_PATH_NEW_DESTINATION)), writer.getFile());
                    break;
                default:
                    System.out.println("The file wasn't found!");
            }
        }
    }

    public static void writeOutfitsToFile(WriterFactory factory, List<Outfit> outfits) {
        for (Outfit outfit : outfits) {
            CustomWriter writers = factory.getOutfitWriter(outfit);
            try {
                writers.write(outfit);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<Outfit> readOutfitsFromFile(OutfitReaderFactory factory) {
        List<Outfit> outfits = new ArrayList<>();
        outfits.addAll(factory.getWeaponReader().read());
        outfits.addAll(factory.getArmorReader().read());
        return outfits;
    }

    private static void printMessage(boolean check, File file) {
        if (check) {
            System.out.printf("The file %s was moved and renamed\n", file);
        } else {
            System.out.printf("The file %s was moved, but wasn't renamed!\n", file);
        }
    }

    private static void deleteFile(CustomWriter writer) {
        File file = writer.getFile();
        if (file.exists()) {
            file.deleteOnExit();
        }
    }
}

