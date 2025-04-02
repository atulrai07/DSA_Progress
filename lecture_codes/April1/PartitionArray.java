import java.util.Arrays;

public class PartitionArray { public static void main(String[] args) { 
    int[] arr = {5, 8, 7, 6, 7, 1, 3, 9, 4}; 
    int pivotIndex = partition(arr); 
    System.out.println("Partitioned Array: " + Arrays.toString(arr)); 
    System.out.println("Pivot Element Position: " + pivotIndex); 
}

public static int partition(int[] arr) {
    int pivot = arr[arr.length - 1]; // Choose last element as pivot
    int i = -1; // Position of smaller elements
    
    for (int j = 0; j < arr.length - 1; j++) {
        if (arr[j] < pivot) { // If element is smaller than pivot
            i++;
            swap(arr, i, j);
        }
    }
    // Place the pivot in its correct position
    swap(arr, i + 1, arr.length - 1);
    return i + 1;
}

private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

}