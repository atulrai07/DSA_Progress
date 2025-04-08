public class peakElement_852Leetcode {
    public int findPeakElement(int[] arr) {
        for (int i = 1; i < arr.length - 1; i++){
            if (arr[i-1]<arr[i] && arr[i]>arr[i+1]){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        peakElement_852Leetcode obj = new peakElement_852Leetcode();
        int[] arr = {1,3,2,5,8,4};
        int peakIndex = obj.findPeakElement(arr);
        System.out.println("Peak element index: " + peakIndex);
    }
}