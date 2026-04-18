class Solution {
    public int climbStairs(int n) {
        if(n==1||n==2) return n;
        int ans = 0;
        int x =  1;
        int y = 2;
        for(int i = 3; i<=n ; i++){
            ans = x+y;
            x=y;
            y =ans;
        }
        return ans;
    }
}