class Solution {
    public double rec(int a,int b,double[][] dp){
        if(a<=0&&b<=0) return 0.5;
        if(a<=0) return 1.0;
        if(b<=0) return 0.0;
        // System.out.println(a+" "+b);
        if(dp[a][b]!=-1) return dp[a][b];
        double op1 = rec(a-4,b,dp);
        double op2 = rec(a-3,b-1,dp);
        double op3 = rec(a-2,b-2,dp);
        double op4 = rec(a-1,b-3,dp);
        return dp[a][b] = 0.25*(op1+op2+op3+op4);
    }
    public double soupServings(int n) {
        if(n>=4800) return 1; // threshold 
        int units = (int)Math.ceil(n/25.0);
        double[][] dp = new double[units+1][units+1];

        for(double[] c: dp) Arrays.fill(c,-1);
        return rec(units,units,dp);
    }
}