class Solution {
    private int dig(int num){
        int sum = 0;
        int product = 1;
        while(num > 0){
            int digit = num % 10;
            sum += digit;
            product *= digit;
            num /= 10;
        }
        return sum + product;
    }
    public boolean checkDivisibility(int n) {
        if(n % dig(n) == 0){
            return true;
        }
        return false;
    }
}