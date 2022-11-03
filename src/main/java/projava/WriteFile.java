package projava;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteFile {
    public static void main(String[] args) throws IOException {
        var p = Path.of("test.txt");
        String s = Files.readString(p);
        System.out.println(s);
    }
}
