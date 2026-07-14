class Solution {
    public String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        int[] freq = new int[128];
        for (char ch : t.toCharArray()){
            freq[ch]++;
        }
        int left = 0, start = 0;
        int minLen = Integer.MAX_VALUE;
        int req = t.length();

        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            if( freq[ch] > 0){
                req--;
            }
            freq[ch]--;

            while( req == 0 ){
                //update if smaller found
                if( right - left + 1< minLen ){
                    minLen = right - left + 1;
                    start = left;
                }
                char rm = s.charAt(left);
                freq[rm]++;
                if( freq[rm] > 0){
                    req++;
                }
                left++;
            }
        }
        if ( minLen == Integer.MAX_VALUE)
            return "";
        return s.substring(start, start + minLen);
    }
}