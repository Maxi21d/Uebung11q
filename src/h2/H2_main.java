package h2;

public class H2_main {

    public static final int[] cache = new int[1000];

    public static void main(String[] args) {
        benchmark(15);
    }

    public static void benchmark(int n) {
        long startTime, endTime, elapsed;

        // fibonacci(n):
        startTime = System.nanoTime();
        fibonacci(n);
        endTime = System.nanoTime();
        elapsed = endTime - startTime;
        System.out.println("Elapsed nanoseconds (fibonacci -> rekursiv): " + elapsed);

        // fibonacciCached(n):
        startTime = System.nanoTime();
        fibonacciCached(n);
        endTime = System.nanoTime();
        elapsed = endTime - startTime;
        System.out.println("Elapsed nanoseconds (fibonacci -> rekursiv mit Cache): " + elapsed);

        // fibonacci_iterativ(n):
        startTime = System.nanoTime();
        fibonacci_iterativ(n);
        endTime = System.nanoTime();
        elapsed = endTime - startTime;
        System.out.println("Elapsed nanoseconds (fibonacci -> iterativ mit for-Schleife): " + elapsed);

    }
    public static int fibonacci(int n) {
        if(n == 1 || n == 2) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static int fibonacciCached(int n) {
        if(n == 1|| n == 2) return 1;

        if(n < cache.length) {
            if(cache[n] != 0) {
                return cache[n];
            } else {
                int fibonacci_n = fibonacciCached(n-1) + fibonacciCached(n-2);
                cache[n] = fibonacci_n;
                return fibonacci_n;
            }
        }
        return fibonacciCached(n-1) + fibonacciCached(n-2);
    }

    public static int fibonacci_iterativ(int n) {
        if(n == 1 || n == 2) return 1;

        int next = 0;
        int f_1 = 1;
        int f_2 = 1;

        for(int i = 3; i <= n; i++) {
            next = f_1 + f_2;
            f_1 = f_2;
            f_2 = next;
        }
        return next;
    }

}
