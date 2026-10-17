class Solution {
    public char repeatedCharacter(String s) {
        int n = s.length();
        HashMap <Character, Integer> freq = new HashMap<>();
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            if (freq.get(c) > 1){
                return c;
            }
        }
        return ' ';
    }
}