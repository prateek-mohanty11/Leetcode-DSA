class Solution {
    private int next(int num){
        int sum = 0;
        while(num > 0){
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        while(fast != 1){
            slow = next(slow);
            fast = next(next(fast));
            if(slow == fast && slow != 1){
                return false;
            }
        }
        return true;
    }
}