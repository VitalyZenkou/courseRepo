package lecture4.task2.util.reader;

import lecture3.task1.model.Outfit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public abstract class OutfitReader {

    final String path;
    final File file;
    final FileReader fileReader;

    OutfitReader(String path) throws FileNotFoundException {
        this.path = path;
        file = new File(path);
        fileReader = new FileReader(file);
    }

    public abstract List<Outfit> read();
}
