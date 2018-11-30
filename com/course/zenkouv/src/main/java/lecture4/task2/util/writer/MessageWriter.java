package lecture4.task2.util.writer;

import java.io.FileWriter;
import java.io.IOException;

public class MessageWriter extends CustomWriter<String> {

    public MessageWriter(String path) throws IOException {
        super(path);
    }

    @Override
    public void write(String message) {
        try (FileWriter writer = new FileWriter(getFile(), true)) {
            writer.write(message + ".\n");
        } catch (IOException e) {
            System.out.println("The data was't wrote to file " + getFile());
        }
    }
}
