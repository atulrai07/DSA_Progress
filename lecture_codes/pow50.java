public class pow50 {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }
    
    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public static void main(String[] args) {
        pow50 solution = new pow50();
        
        double x1 = 2.00000;
        int n1 = 10;
        double result1 = solution.myPow(x1, n1);
        System.out.println("Test Case 1: " + result1); 
        
    }
}
//test commit
