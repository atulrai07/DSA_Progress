public class pow {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return Pow(x, N);
    }
    
    public double Pow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = Pow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public static void main(String[] args) {
        pow solution = new pow();
        double x = 2.0;
        int n = 10;
        double result = solution.myPow(x, n);
        System.out.println("Result: " + result);
    }
}