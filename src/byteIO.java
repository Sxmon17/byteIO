import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import static java.lang.System.in;
import static java.lang.System.out;

public class byteIO {
    public static void main(String[] args) throws IOException {
        copyFile("src/srcFile.txt", "src/destFile.txt");
    }
    public static void copyFile(String srcFile, String destFile) throws IOException {
        try {
            InputStream in = Files.newInputStream(Paths.get(srcFile));
            OutputStream out = Files.newOutputStream(Paths.get(destFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] buffer = new byte[2048];
        int bytesRead;
        while((bytesRead = in.read(buffer, 0, buffer.length)) > 0) {
            out.write(buffer, 0, bytesRead);
        }
        out.println(bytesRead);
    }
}
