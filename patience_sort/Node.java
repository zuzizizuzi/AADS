package patience_sort;

public class Node<T extends Comparable<T>> implements Comparable<Node<T>>{
    T val;
    int pileInd;
    int cardInd;

    public Node(T val, int pileInd, int cardInd) {
        this.cardInd = cardInd;
        this.pileInd = pileInd;
        this.val = val;
    }


    @Override
    public int compareTo(Node<T> other) {
        return this.val.compareTo(other.val);
    }

}
