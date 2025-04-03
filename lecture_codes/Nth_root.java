public class Nth_root {
    public static void main (String[] args) {
        int n = 150; // Example number
        int k = 3;  // Example root
        root(n, k); // Call the method to find the k-th root of n
    }

    public static void root (int n , int k){
        int low = 1;
        int high = n;
        int ans = 0;
        while (low <= high) { 
            int mid = (low + high) / 2;
            if (Math.pow(mid, k) == n) {
                ans = mid;
                break;
            } else if (Math.pow(mid, k) < n) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
