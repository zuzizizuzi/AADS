package patience_sort;
import java.io.*;
import java.util.Random;


public class DataGenerator {
    public static void generateFiles(int count, int minSize, int maxSize) throws IOException{
        Random rnd = new Random();
        for (int i = 0; i<count; i++) {
            int size = rnd.nextInt(maxSize - minSize) + minSize;
            try (PrintWriter out = new PrintWriter("data_" + i + ".txt")) {
                for (int j = 0; j < size; j++){
                    out.println(rnd.nextInt(100000));
                }
            }
        }
    }
}
