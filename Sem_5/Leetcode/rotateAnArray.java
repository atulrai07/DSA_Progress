package Leetcode;
//189 Leetcode: Rotate Array
public class rotateAnArray {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int s, int e){
        while(s < e){
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
    }
    public static void main(String[] args) {
        rotateAnArray solution = new rotateAnArray();
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        solution.rotate(nums, k);
        System.out.print("Rotated array: ");
        for(int num : nums){
            System.out.print(num + " ");
        }
    }
}
