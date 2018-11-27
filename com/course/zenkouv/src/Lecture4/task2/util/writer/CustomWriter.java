package Lecture4.Task2.util.writer;

import java.io.File;
import java.io.IOException;

public abstract class CustomWriter<T> {

    private final File file;

    CustomWriter(String path) {
        file = new File(path);
    }

    public File getFile() {
        return file;
    }

    public abstract void write(T t) throws IOException;
}
