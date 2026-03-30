class Solution {
    public class Pair{
        char ch;
        int idx;
        public Pair(char ch,int idx){
            this.ch = ch;
            this.idx = idx;
        }
    }
    public int longestValidParentheses(String s) {
        Stack<Pair> st = new Stack<>();
        int n = s.length();
        int i = 0;
        int ans = 0;
        while(i<n){
            char ch = s.charAt(i);
            if(st.size()>0&&st.peek().ch=='('&&ch==')'){
                st.pop();
            }else{
                st.push(new Pair(ch,i));
            }
            i++;
        }
        if(st.size()==0) return n;
        int top = n;
        while(st.size()!=0){
            Pair p = st.pop();
            ans = Math.max(ans,top-p.idx-1);
            // System.out.println(p.ch+" "+p.idx+" "+top);
            top = p.idx;
        }
        ans = Math.max(ans,top-0);
        return ans;
    }
}