import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputTest {
    public static void main(String[] args) throws IOException {
        int c;
        try {
            String path = "/Users/mindy/Dropbox/Class/cmpsc221/designpatterns/LowerCaseInputStream/src/test.txt";
            InputStream in =
                    new LowerCaseInputStream(
                            new BufferedInputStream(
                                    new FileInputStream(path)));
            while ((c = in.read()) >= 0) {
                System.out.print((char) c);
            }
            in.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
