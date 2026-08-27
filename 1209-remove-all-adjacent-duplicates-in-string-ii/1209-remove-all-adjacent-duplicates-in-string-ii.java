class Solution {
    public String removeDuplicates(String s, int k) {

        int n = s.length();

        Stack<Pair<Character, Integer>> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            char c = s.charAt(i);

            if (st.empty()) {
                st.push(new Pair<>(c, 1));
                continue;
            }

            if (st.peek().getKey() != c) {
                st.push(new Pair<>(c, 1));
                continue;
            }

            Pair<Character, Integer> p = st.pop();

            if (p.getValue() == k - 1) {
                continue;
            }

            st.push(new Pair<>(p.getKey(), p.getValue() + 1));
        }

        StringBuilder ans = new StringBuilder();

        while (!st.empty()) {
            Pair<Character, Integer> p = st.pop();

            for (int i = 0; i < p.getValue(); i++) {
                ans.append(p.getKey());
            }
        }

        return ans.reverse().toString();
    }
}