import java.util.Arrays;
public class MedianOfSortedArray {
    public static void main(String[] args) {
        int[] A = {1, 3, 8, 9, 15};
        int[] B = {7, 11, 18, 19, 21, 25};
        int n = A.length;

        double median = findMedianSortedArrays(A, B, n);
        System.out.println("Median is: " + median);
    }  
    static double findMedianSortedArrays(int[] A, int[] B, int n) {
        // Base case: size 1
        if (n == 1)
            return (A[0] + B[0]) / 2.0;
    
        // Base case: size 2
        if (n == 2)
            return (Math.max(A[0], B[0]) + Math.min(A[1], B[1])) / 2.0;
    
        double m1 = median(A, n);
        double m2 = median(B, n);
    
        if (m1 == m2)
            return m1;
    
        if (m1 < m2) {
            // median must be in A[n/2 to end] and B[0 to n/2]
            return findMedianSortedArrays(
                Arrays.copyOfRange(A, n / 2, n),
                Arrays.copyOfRange(B, 0, (n + 1) / 2),
                (n + 1) / 2
            );
        } else {
            // median must be in A[0 to n/2] and B[n/2 to end]
            return findMedianSortedArrays(
                Arrays.copyOfRange(A, 0, (n + 1) / 2),
                Arrays.copyOfRange(B, n / 2, n),
                (n + 1) / 2
            );
        }
    }
    
    static double median(int[] arr, int n) {
        if (n % 2 == 0)
            return (arr[n / 2] + arr[n / 2 - 1]) / 2.0;
        else
            return arr[n / 2];
    }
}