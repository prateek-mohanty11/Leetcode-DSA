class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {

            // Opening brackets → push
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            }

            else {
                if (st.isEmpty()) {
                    return false;
                }

                char top = st.peek();

                if ((ch == ')' && top == '(') ||
                    (ch == '}' && top == '{') ||
                    (ch == ']' && top == '[')) {
                    
                    st.pop();
                } else {
                    return false;
                }
            }
        }
        // Valid only if no opening brackets are left
        return st.isEmpty();
    }
}