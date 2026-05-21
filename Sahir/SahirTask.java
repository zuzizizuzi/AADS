package Sahir;

import java.util.*;

public class SahirTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        String[] floor = new String[n];
        int lastFloor = -1;
        
        // Считываем снизу вверх: floor[0] - это самый нижний этаж
        for (int i = n - 1; i >= 0; i--) {
            floor[i] = sc.next();
        }
        
        // Ищем самый верхний этаж, где горит свет
        for (int i = n - 1; i >= 0; i--) {
            if (floor[i].contains("1")) {
                lastFloor = i;
                break;
            }
        }

        if (lastFloor == -1) { 
            System.out.println(0); 
            return; 
        }

        int[][] dp = new int[n][2];
        
        // Находим крайние лампочки для нулевого этажа
        int first0 = floor[0].indexOf('1');
        int last0 = floor[0].lastIndexOf('1');
        
        if (lastFloor == 0) {
            // Если свет только на 0 этаже, просто идем до последней лампочки справа
            System.out.println(last0 == -1 ? 0 : last0);
            return;
        }

        // Инициализация для 0 этажа (нужно вернуться к лестницам, так как пойдем выше)
        dp[0][0] = last0 == -1 ? 0 : 2 * last0;
        dp[0][1] = m + 1; // Проход насквозь до правой лестницы

        for (int i = 1; i <= lastFloor; i++) {
            int first = floor[i].indexOf('1');
            int last = floor[i].lastIndexOf('1');
            
            if (i == lastFloor) {
                // На последнем этаже не нужно возвращаться к лестнице!
                // На левую лестницу: либо пришли слева и дошли до last, либо справа и дошли до first
                int leftDist = last == -1 ? 0 : last;
                int rightDist = first == -1 ? 0 : (m + 1) - first;
                
                dp[i][0] = Math.min(dp[i-1][0] + 1 + leftDist, dp[i-1][1] + 1 + rightDist);
                break; 
            }
            
            // Для промежуточных этажей:
            if (last == -1) {
                // Если на этаже вообще нет света, просто переносим шаги + 1 за подъем
                dp[i][0] = Math.min(dp[i-1][0] + 1, dp[i-1][1] + 1 + (m + 1));
                dp[i][1] = Math.min(dp[i-1][1] + 1, dp[i-1][0] + 1 + (m + 1));
            } else {
                // dp[i][0] (заканчиваем на ЛЕВОЙ лестнице):
                // Вариант А: пришли слева, сходили туда-обратно до 'last' (+ 2*last)
                // Вариант Б: пришли справа, прошли весь этаж насквозь (+ m + 1)
                dp[i][0] = Math.min(dp[i-1][0] + 1 + 2 * last, dp[i-1][1] + 1 + (m + 1));
                
                // dp[i][1] (заканчиваем на ПРАВОЙ лестнице):
                // Вариант А: пришли справа, сходили туда-обратно до 'first'
                // Вариант Б: пришли слева, прошли весь этаж насквозь (+ m + 1)
                dp[i][1] = Math.min(dp[i-1][1] + 1 + 2 * ((m + 1) - first), dp[i-1][0] + 1 + (m + 1));
            }
        }
        
        System.out.println(dp[lastFloor][0]);
    }
}