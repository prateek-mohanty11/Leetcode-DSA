class Solution {
    public int maxProduct(int[] nums) {
        int minEnd = nums[0];
        int maxEnd = nums[0];
        int res = nums[0];
        for( int i = 1; i < nums.length; i++){
            int c1 = nums[i];
            int c2 = minEnd * nums[i];
            int c3 = maxEnd * nums[i];
            minEnd = Math.min(c1, Math.min(c2, c3));
            maxEnd = Math.max(c1, Math.max(c2, c3));
            res = Math.max(res, Math.max(minEnd, maxEnd));
        }
        return res;
    }
}