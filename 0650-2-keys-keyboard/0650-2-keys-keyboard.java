class Solution {
    public long rec(int dis, int pas, int n){
        if(dis==n) return 0;
        if(dis>n) return Integer.MAX_VALUE;
        long p = 1+rec(dis+pas,pas,n);
        long pc = 2 + rec(dis+pas,dis+pas, n);
        return Math.min(p,pc);
    }
    public int minSteps(int n) {
        if(n==1) return 0;
        return 1 + (int)rec(1,1,n);
    }
}