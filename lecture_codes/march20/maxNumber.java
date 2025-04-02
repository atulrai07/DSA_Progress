public class maxNumber {
    public static void main(String[] args) {
        int[] arr = {10,2,8,12};
        int largest = 0;
        int nextLargest = 0;
        int thirdLargest = 0;
        for (int i = 0; i < arr.length; i++) {
            if (largest < arr[i]){
                largest = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > nextLargest && arr[i] < largest) { 
                nextLargest = arr[i];
            }
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > thirdLargest && arr[i] < nextLargest){
                thirdLargest = arr[i];
            }
        }
        System.out.println(largest);
        System.out.println(nextLargest);
        System.out.println(thirdLargest);
    }
}
