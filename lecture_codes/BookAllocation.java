public class BookAllocation {
    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 40};
        int nos = 2; // Number of students
        Allocation(arr, nos);
    }

    public static void Allocation(int arr[], int nos) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        int ans = -1;

        for (int num : arr) {
            high += num;
            low = Math.max(low, num); // minimum pages = max single book
        }

        while (low <= high) {
            int mid = (low + high) / 2;

            if (isPossible(arr, mid, nos)) {
                ans = mid; // potential answer
                high = mid - 1; // try to minimize
            } else {
                low = mid + 1; // increase mid
            }
        }

        System.out.println(ans); // Output the minimum of the maximum pages
    }

    public static boolean isPossible(int arr[], int mid, int nos) {
        int studentCount = 1;
        int sum = 0;

        for (int pages : arr) {
            if (sum + pages <= mid) {
                sum += pages;
            } else {
                studentCount++;
                sum = pages;

                if (studentCount > nos) {
                    return false;
                }
            }
        }

        return true;
    }
}
