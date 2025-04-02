import java.util.Arrays;

public class merge_sorted_array {
    public static void main(String[] args) {
        int arr[] = {1,3,5,7};
        int arr2[] = {2,4,6,8,10};
        System.out.print("{ ");
        Merge(arr,arr2);
        System.out.println("}");
    }
    public static void Merge(int[] arr, int[] arr2) {
        int n = arr.length, m = arr2.length;
        int merged[] = new int[n + m];

        for (int i = 0; i < n; i++) {
            merged[i] = arr[i];
        }
        for (int i = 0; i < m; i++) {
            merged[n + i] = arr2[i];
        }

        Arrays.sort(merged);

        for (int i = 0; i < merged.length; i++) {
            System.out.print(merged[i]+ ", ");
        }
    }
}
