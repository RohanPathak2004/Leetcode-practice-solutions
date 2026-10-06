class Solution {
    public int minAddToMakeValid(String s) {
        int n = s.length();
        var stack = new Stack<Character>();
        for(int i = 0; i<n ; i++) {
            if(stack.isEmpty()) stack.push(s.charAt(i));
            else {
                char top = stack.peek();
                char ch = s.charAt(i);
                if(top == '(' && ch == ')') stack.pop();
                else stack.push(ch);
            }
        }
        return stack.size();
    }
}