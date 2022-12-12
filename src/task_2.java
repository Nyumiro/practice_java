import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class task_2 {
    //Обнаружение несовпадений между двумя файлами.
    //Написать программу, которая обнаруживает несовпадения между двумя файлами на байтовом уровне.

    static boolean compareFiles(String f1, String f2) throws IOException {
        byte[] array_1 = Files.readAllBytes(Paths.get(f1));
        byte[] array_2 = Files.readAllBytes(Paths.get(f2));
        return Arrays.equals(array_1, array_2);
    }
}
