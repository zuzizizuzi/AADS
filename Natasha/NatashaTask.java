package Natasha;

import java.util.Scanner;

public class NatashaTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Проверяем, есть ли данные на входе
        if (!scanner.hasNextInt()) {
            return;
        }
        
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        
        int maxOfMins = 0; // Сюда Эмма сохранит наилучший из худших вариантов
        
        // Проходим по каждой улице (строке)
        for (int i = 0; i < n; i++) {
            int rowMin = Integer.MAX_VALUE; // Инициализируем заведомо большим числом
            
            // Ищем самый дешевый ресторан на текущей улице
            for (int j = 0; j < m; j++) {
                int cost = scanner.nextInt();
                if (cost < rowMin) {
                    rowMin = cost;
                }
            }
            
            // Эмма выбирает строку, где этот минимум будет как можно больше
            if (rowMin > maxOfMins) {
                maxOfMins = rowMin;
            }
        }
        
        System.out.println(maxOfMins);
        scanner.close();
    }
}
