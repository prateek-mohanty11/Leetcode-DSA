class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int low = 0, res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int high = 0; high < n;high++){
            char ch = s.charAt(high);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            while(map.get(ch) > 1){
                char leftChar = s.charAt(low);
                map.put(leftChar, map.get(leftChar) - 1);
                if(map.get(leftChar) == 0){
                    map.remove(leftChar);
                }
                low++;
            }
            res = Math.max(res, high - low + 1);  
        }
        return res;
    }
}