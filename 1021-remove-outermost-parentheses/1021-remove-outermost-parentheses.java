class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        int idx = 0;
        int depth = 0;
        String ans = "";
        for(int i = 0; i<n ; i++){
            char ch = s.charAt(i);
            if(ch == '(') depth++;
            else {
                depth--;
                if(depth == 0) {
                    String sub = s.substring(idx+1,i);
                    ans += sub;
                    idx = i+1;
                }
            }
        }

        return ans;
    }
}