import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Random;

public class DataGenerator {
    private static final String DIR = "datasets";
    private final Random random = new Random();

    public void generateAll() {
        new File(DIR).mkdir();
        
        // Генерируем наборы разного размера: 100, 1000, 5000, 10000, 50000, 100000 и тд
        int[] sizes = {100, 1000, 5000, 10000, 50000, 100000, 200000, 200000*2, 200000*4};
        
        for (int size : sizes) {
            String fileName = DIR + "/data_" + size + ".txt";
            try (FileWriter fw = new FileWriter(fileName)) {
                for (int i = 0; i < size; i++) {
                    fw.write(random.nextInt(1000000) + ";");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}