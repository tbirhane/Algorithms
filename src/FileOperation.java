import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileOperation {
    public static void main(String[] args) {
        Path file = Paths.get("c:/DBAR_Ver.txt");
        try
        {
            //Java 8: Stream class
            Stream<String> lines = Files.lines( file, StandardCharsets.UTF_8 );

            for( String line : (Iterable<String>) lines::iterator )
            {
                System.out.println(line);
            }

        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
