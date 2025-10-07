public class MaxConsecutiveOnes {
    public static int countLength(int[] nums, int k){
        int maxLen = 0;
        int left = 0;
        int zeroes = 0;

        for (int right = 0; right < nums.length; right++){
            if(nums[right]==0){
                zeroes++;
            }
            while (zeroes>k) {
                if(nums[left] == 0){
                    zeroes--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, (right-left+1));
        }


        return maxLen;
    }

    public static void main (String[] args){
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(countLength(nums, 2));
    }
}
