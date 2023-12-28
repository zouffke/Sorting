package sorting;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Writer {

    private final String filePath;

    public Writer(String path) {
        this.filePath = path;
    }

    public void write(String filename, List<Integer> operations, int jump) {
        try (PrintWriter writer = new PrintWriter(filePath + filename, StandardCharsets.UTF_8)) {
            writer.println("operations,objects");

            int index = jump;

            for (Integer opt : operations){
                writer.write(String.format("%d, %d", opt, index));
                System.out.println(opt);
                index += jump;
            }
        } catch (IOException ignored) {

        }
    }

}

