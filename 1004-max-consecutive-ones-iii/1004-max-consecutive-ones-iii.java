class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int z_count = 0;
        int maxLen = 0;
        for ( int right = 0; right < nums.length; right++){
            if(nums[right] == 0){
                z_count++;
            }
            while( z_count > k){
                if(nums[left] == 0)
                    z_count--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}