class Solution {
    public int maximumSum(int[] arr) {
        int noDelete = arr[0];
        int oneDelete = Integer.MIN_VALUE;
        int ans = arr[0];
        for(int i = 1; i < arr.length; i++){
            int prevNoDelete = noDelete;
            int prevOneDelete = oneDelete;
            noDelete = Math.max(prevNoDelete + arr[i], arr[i]);
            //checking for error while adding INT_MIN
            int choice1;
            if(prevOneDelete == Integer.MIN_VALUE){
                choice1 = arr[i];
            }else {
                choice1 = prevOneDelete + arr[i];
            }
            oneDelete = Math.max(choice1, prevNoDelete);
            ans = Math.max(ans , Math.max(noDelete, oneDelete));
        }
        return ans;
    }
}