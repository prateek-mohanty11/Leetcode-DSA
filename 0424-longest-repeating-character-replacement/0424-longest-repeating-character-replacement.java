class Solution {

    public int find(int[] freq) {
        int maxCount = -1;

        for (int i = 0; i < 256; i++) {
            maxCount = Math.max(maxCount, freq[i]);
        }

        return maxCount;
    }

    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] freq = new int[256];

        int left = 0;
        int maxLen = Integer.MIN_VALUE;

        for (int right = 0; right < n; right++) {

            freq[s.charAt(right)]++;

            int maxCount = find(freq);
            int len = right - left + 1;
            int diff = len - maxCount;

            while (diff > k) {
                freq[s.charAt(left)]--;
                left++;

                maxCount = find(freq);
                len = right - left + 1;
                diff = len - maxCount;
            }

            len = right - left + 1;
            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }
}