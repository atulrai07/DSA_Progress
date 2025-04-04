import java.util.Arrays;
import java.util.Scanner;

public class aggresiveCows {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        while (t > 0) {
            int n = sc.nextInt(); // Number of stalls
            int c = sc.nextInt(); // Number of cows
            int stall[] = new int[n];
            for (int i = 0; i < n; i++) {
                stall[i] = sc.nextInt(); // Stall positions
            }
            Arrays.sort(stall); // Sort the stall positions
            Aggressive(stall, c);
            t--;
        }
    }

    public static void Aggressive(int stall[], int totalcows) {
        int low = 1; // Minimum distance between cows
        int high = stall[stall.length - 1] - stall[0]; // Maximum distance between cows
        int ans = 0; // Final answer initialized to 0
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(stall, mid, totalcows)) {
                ans = mid; // If possible, store the answer
                low = mid + 1; // Search for more distance
            } else {
                high = mid - 1; // Search for less distance
            }
            System.out.println(ans);
        }
    }

    public static boolean isPossible(int stall[], int mid, int totalcows) {
        int cow = 1;
        int pos = stall[0]; // First cow is placed at the first stall
        for (int i = 1; i < stall.length; i++) {
            if (stall[i] - pos >= mid) { // Fixed the syntax error here
                cow++;
                pos = stall[i];
            }
            if (cow == totalcows) {
                return true;
            }
        }
        return false;
    }
}