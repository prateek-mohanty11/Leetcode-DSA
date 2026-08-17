class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int low = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        int n = nums.length;
        for(int high = 0; high < n; high++){
            sum += nums[high];
            while(sum >= target){
                minLen = Math.min(minLen, high - low + 1);
                low++;
                sum -= nums[low - 1];
            }
        }
        return (minLen == Integer.MAX_VALUE)? 0 : minLen;
    }
}