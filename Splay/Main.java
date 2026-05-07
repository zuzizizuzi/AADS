
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. Генерируем данные (если еще не созданы)
        DataGenerator generator = new DataGenerator();
        generator.generateAll(); 

        // 2. Файл для записи результатов (чтобы потом просто вставить в Excel)
        try (FileWriter resultsFile = new FileWriter("results.csv")) {
            resultsFile.write("Size;Random_Insert_ms;Sorted_Insert_ms\n");

            int[] sizes = {100, 1000, 5000, 10000, 50000, 100000 , 200000, 200000*2, 200000*4};

            for (int size : sizes) {
                // Тестируем случайные данные
                List<Integer> randomData = readData("datasets/data_" + size + ".txt");
                long randomTime = measureInsertTime(randomData);

                // Тестируем отсортированные данные
                List<Integer> sortedData = generateSortedList(size); // создаем прямо в памяти
                long sortedTime = measureInsertTime(sortedData);

                // Записываем в CSV
                resultsFile.write(size + ";" + randomTime + ";" + sortedTime + "\n");
                System.out.println("Size " + size + " processed.");
            }
        }
        System.out.println("Тестирование завершено. Результаты в results.csv");
    }

    // Метод для замера времени
    private static long measureInsertTime(List<Integer> data) {
        SplayTree tree = new SplayTree();
        long start = System.nanoTime();
        for (int val : data) {
            tree.insert(val);
        }
        long end = System.nanoTime();
        // Возвращаем в миллисекундах
        return (end - start) / 1_000_000;
    }

    // Вспомогательный метод для создания отсортированного списка
    private static List<Integer> generateSortedList(int size) {
        List<Integer> list = new java.util.ArrayList<>(size);
        for (int i = 0; i < size; i++) list.add(i);
        return list;
    }
    
    public static List<Integer> readData(String filePath) throws IOException {
        List<Integer> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            if (line != null) {
                String[] parts = line.split(";");
                for (String part : parts) {
                    if (!part.isEmpty()) list.add(Integer.parseInt(part));
                }
            }
        }
        return list;
    }
}