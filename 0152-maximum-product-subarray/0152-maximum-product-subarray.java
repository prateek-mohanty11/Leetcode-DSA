class Solution {
    public int maxProduct(int[] nums) {
        int maxEnd = nums[0];
        int minEnd = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++){
            int c1 = maxEnd * nums[i];
            int c2 = minEnd * nums[i];
            int c3 = nums[i];
            maxEnd = Math.max(c1, Math.max(c2, c3));
            minEnd = Math.min(c1, Math.min(c2, c3));
            ans = Math.max(ans, Math.max(minEnd, maxEnd));
        }
        return ans;
    }
}