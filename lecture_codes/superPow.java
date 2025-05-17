public class superPow {
    static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        a %= MOD;
        int result = 1;

        for (int i = b.length - 1; i >= 0; i--) {
            result = (result * modPow(a, b[i])) % MOD;
            a = modPow(a, 10); // raise a to 10 for the next digit
        }

        return result;
    }

    // Helper function: calculates (a^k) % MOD
    private int modPow(int a, int k) {
        int result = 1;
        a %= MOD;

        for (int i = 0; i < k; i++) {
            result = (result * a) % MOD;
        }

        return result;
    }

    public static void main(String[] args) {
        superPow obj = new superPow();
        int a = 3;
        int[] b = {2, 0};
        int result = obj.superPow(a, b);
        System.out.println("Result: " + result); // Output: 1024
    }
}
