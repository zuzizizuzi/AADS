package recursion;

public class Recur {
    public static int factorial(int n) {
        //условие выхода
        if (n <= 1) {
            return 1;
        }
        return n*factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(factorial(4));
    }

}
