class Solution {
    public double rec(int a,int b,double[][] dp){
        if(a<=0||b<=0){
            if(a<=0&&a==b) return 0.5;
            if((a<=0&&b>a)) return 1;
            if((a>0&&b<=0)||(a<=0&&b<a)) return 0;
        }
        // System.out.println(a+" "+b);
        if(dp[a][b]!=-1) return dp[a][b];
        double op1 = rec(a-100,b,dp);
        double op2 = rec(a-75,b-25,dp);
        double op3 = rec(a-50,b-50,dp);
        double op4 = rec(a-25,b-75,dp);
        return dp[a][b] = 0.25*(op1+op2+op3+op4);
    }
    public double soupServings(int n) {
        if(n>=4800) return 1; // threshold 
        double[][] dp = new double[n+1][n+1];
        for(double[] c: dp) Arrays.fill(c,-1);
        return rec(n,n,dp);
    }
}