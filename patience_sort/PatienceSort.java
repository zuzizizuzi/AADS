package patience_sort;

import java.util.*;

public class PatienceSort {


    public static class Metrics {
        public long timeNs;
        public long iterations;
    }
    

   public static <T extends Comparable<T>> Metrics sort(List<T> list) {
        Metrics metrics = new Metrics();
        int n = list.size();
        List<List<T>> piles = new ArrayList<>();

        long startTime = System.nanoTime();

        for (T card : list) {
            int left = 0;
            int right = piles.size() - 1;
            int pos = -1;

        while (left <= right) {
            metrics.iterations++; //подсчет итераций вложенного цикла
            int mid = left + (right-left) / 2;
            if (piles.get(mid).get(piles.get(mid).size() -1).compareTo(card) >= 0) {
                pos = mid;
                right = mid - 1; //левая граница
            } else {
                left = mid + 1;
            }
            
        }

        if (pos == -1) {
            piles.add(new ArrayList<>(Collections.singletonList(card)));

        } else {
            piles.get(pos).add(card);
        }
    }


    PriorityQueue<Node> pq = new PriorityQueue<>();
    for (int i =0; i < piles.size(); i++) {
        List<T> pile = piles.get(i);
        pq.add(new Node<>(pile.get(pile.size() - 1), i, pile.size() -1));
    }    
    
    metrics.timeNs = System.nanoTime() - startTime;
    return metrics;    

    }


}
