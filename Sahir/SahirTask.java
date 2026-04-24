package Sahir;

import java.util.*;

public class SahirTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] floor = new String[n];
        int lastFloor = -1;
        for (int i = 0; i < n; i++) {
            floor[i] = sc.next();
            if (floor[i].contains("1")) lastFloor = i;
        }

        if (lastFloor == -1) { System.out.println(0); return; }

        int[][] dp = new int[n][2];
        
        // Первый этаж
        dp[0][0] = getDist(floor[0], true, m, true); 
        dp[0][1] = getDist(floor[0], false, m, true);

        for (int i = 1; i <= lastFloor; i++) {
            boolean isLast = (i == lastFloor);
            dp[i][0] = Math.min(dp[i-1][0] + 1 + getDist(floor[i], true, m, isLast),
                                dp[i-1][1] + m + 2 + getDist(floor[i], true, m, isLast));
            dp[i][1] = Math.min(dp[i-1][1] + 1 + getDist(floor[i], false, m, isLast),
                                dp[i-1][0] + m + 2 + getDist(floor[i], false, m, isLast));
        }
        System.out.println(Math.min(dp[lastFloor][0], dp[lastFloor][1]));
    }

    static int getDist(String s, boolean toLeft, int m, boolean isLast) {
        int first = -1, last = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                if (first == -1) first = i;
                last = i;
            }
        }
        if (first == -1) return 0;
        
        if (isLast) {
            return toLeft ? last : (m + 1) - first;
        } else {
            return toLeft ? 2 * last : 2 * ((m + 1) - first);
        }
    }
}