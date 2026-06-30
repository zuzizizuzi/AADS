package patience_sort;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileWriter;

public class Benchmarking {
    public static void runBenchmark() throws IOException {
        List<ResultsRow> results = new ArrayList<>(); 
        for (int i = 0; i < 50; i++) {
            List<Integer> data = new ArrayList<>();
            //cчитывание без замера времени
            try (Scanner scanner = new Scanner(new File("data_" + i + ".txt"))) {
                while (scanner.hasNextInt()) data.add(scanner.nextInt());
            }

            //замер алгоритма
            PatienceSort.Metrics m = PatienceSort.sort(data);

            results.add(new ResultsRow(i, data.size(), m.timeNs, m.iterations));
            System.out.println("Set " + i + ": Time=" + m.timeNs + "ns, Iterations=" + m.iterations);
        }
        saveMetricsToCSV("results.csv", results);
        System.out.println("saveee");


    }

    public static void saveMetricsToCSV(String filename, List<ResultsRow> results) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("SetNumber,ArraySize,TimeNs,Iterations");
            for (ResultsRow row : results) {
                writer.printf("%d,%d,%d,%d\n", row.id, row.size, row.time, row.iterations);
            }
        }
    }

    public static class ResultsRow {
        int id, size;
        long time, iterations;

        public ResultsRow(int id, int size, long time, long iterations) {
            this.id = id;
            this.size = size;
            this.time = time;
            this.iterations = iterations;
        }
    }


}
