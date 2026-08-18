class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int low = 0, res = -1;
        Map<Integer, Integer> freq = new HashMap<>();
        for(int high = 0; high < n; high++){
            int frt = fruits[high];
            freq.put(frt, freq.getOrDefault(frt, 0) + 1);
            while(freq.size() > 2){
                int leftFrt = fruits[low];
                freq.put(leftFrt, freq.get(leftFrt) - 1);
                if(freq.get(leftFrt) == 0){
                    freq.remove(leftFrt);
                }
                low++;
            }
            if(freq.size() <= 2){
                res = Math.max(res, high - low + 1);
            }
        }
        return res;
    }
}