package sorting;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * This class is responsible for writing the results of sorting operations to a file.
 */
public class Writer {

    private final String filePath;

    /**
     * Constructs a new Writer object.
     *
     * @param path The path where the file will be written.
     */
    public Writer(String path) {
        this.filePath = path;
    }

    /**
     * Writes the results of sorting operations to a file.
     *
     * @param filename The name of the file to write to.
     * @param operations The list of operations to write to the file.
     * @param jump The increment for the index of operations.
     */
    public void write(String filename, List<Integer> operations, int jump) {
        try (PrintWriter writer = new PrintWriter(filePath + filename, StandardCharsets.UTF_8)) {
            writer.println("operations,objects");
            writer.println("0, 0");

            int index = jump;
            for (Integer opt : operations){
                // Write the operation and its index to the file
                writer.write(String.format("%d, %d\n", opt, index));
                System.out.println(opt);
                index += jump;
            }
        } catch (IOException ignored) {
            // Ignore any IOExceptions
        }
    }
}