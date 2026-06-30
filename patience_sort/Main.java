package patience_sort;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        
        try {
        

            DataGenerator.generateFiles(51, 100, 1000);
            //запускаем бенчмарк
            Benchmarking.runBenchmark();
            
            
            
            System.out.println("Готово! Файл results.csv создан.");
        } catch (IOException e) {
            System.err.println("Произошла ошибка при работе с файлами: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
