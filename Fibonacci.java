import java.util.ArrayList;
public class Fibonacci{
    public static int fibonacciR(int n) {
        return (n <= 1) ? 1 : (fibonacciR(n - 2) + fibonacciR(n - 1));
    }
    public static int fibonacciFastWorker(int prev2, int prev1, int current) {
        if (current <= 1) {
            return prev1;
        }
        return fibonacciFastWorker(prev1, prev2 + prev1, --current);
    }
    public static int fibonacciArrayWorker(int n, ArrayList<Integer> prevFibs) {
        if (n <= 1) {
            return 1;
        }
        else if (n < prevFibs.size() - 1) {
            return prevFibs.get(n);
        }
        else if (n == prevFibs.size()) {
            prevFibs.add(prevFibs.get(n - 1) + prevFibs.get(n - 2));
        }
        return fibonacciArrayWorker(n - 1, prevFibs) + fibonacciArrayWorker(n - 2, prevFibs);
    }
    public static int fibonacciFast(int n) {
        return fibonacciFastWorker(1, 1, n);
    }
    public static int fibonacciArray(int n) {
        ArrayList<Integer> fibs = new ArrayList<Integer>();
        fibs.add(1);
        fibs.add(1);
        return fibonacciArrayWorker(n, fibs);
    }
    public static int fibonacciI(int n) {
        if (n <= 1) {
            return 1;
        }
        int prev2 = 1, prev1 = 1;
        int temp = prev1;
        for (int i = 2;i <= n;i++) {
            temp = prev1;
            prev1 = prev1 + prev2;
            prev2 = temp;
        }
        return prev1;
    }
    public static void main(String[] args) {
        long startTime;
        for (int i = 0;i < 30;i++) {
            startTime = System.nanoTime();
            System.out.println("Standard recursive fib: " + fibonacciR(i) + " in " + (System.nanoTime() - startTime) + " ns");
            startTime = System.nanoTime();
            System.out.println("Standard iterative fib: " + fibonacciI(i) + " in " + (System.nanoTime() - startTime) + " ns");
            startTime = System.nanoTime();
            System.out.println("Fast recursive fib: " + fibonacciFast(i) + " in " + (System.nanoTime() - startTime) + " ns");
            startTime = System.nanoTime();
            System.out.println("Recursive with array fib: " + fibonacciArray(i) + " in " + (System.nanoTime() - startTime) + " ns");
        }
    }
}
