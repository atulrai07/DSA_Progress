package Leetcode;
import java.util.Arrays;
//leetcode 287: Find the Duplicate Number
public class duplicateNumbers {
    public int findDuplicate(int[] nums){
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            if((nums[i] ^ nums[i+1]) == 0){
                return nums[i];
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        duplicateNumbers solution = new duplicateNumbers();
        int[] nums = {1,3,4,2,2};
        int result = solution.findDuplicate(nums);
        System.out.println("The duplicate number is: " + result);
    }
}
