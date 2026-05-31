class Solution {
    public int free(int i, int n, int[][] item){
        int count = 0;
        for(int j = 0; j<n ; j++){
            if(i!=j){
                if(item[j][0]%item[i][0]==0) count++;
            }
        }
        return count;
    }
    public int rec(int i,int[][] item,int b, int n,int[] fac,boolean[] vis,int[][][] dp){
        if(i>=n||b<=0){
            return 0;
        }
        int pos = vis[i]?0:1;
        if(dp[i][b][pos]!=-1) return dp[i][b][pos];
        int skip = rec(i+1,item,b,n,fac,vis,dp);
        if(b<item[i][1]) return skip;
        int pick = 0;
        if(vis[i]){
            pick = 1+rec(i,item,b-item[i][1],n,fac,vis,dp);
        }else{
            vis[i] = true;
            pick = 1+fac[i]+rec(i,item,b-item[i][1],n,fac,vis,dp);
            vis[i] = false;
        }

        return dp[i][b][pos] = Math.max(skip,pick);
    }
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] fac = new int[n];
        boolean[] vis = new boolean[n]; 
        for(int i = 0; i<n ;i++){
            fac[i] = free(i,n,items);
        }
        int[][][] dp = new int[n][budget+1][2];
        for(int[][] mat:dp){
            for(int[] r:mat) Arrays.fill(r,-1);
        }
        return rec(0,items,budget,n,fac,vis,dp);
    }
}