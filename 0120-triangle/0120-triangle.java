class Solution {
    public int rec(int i,int j,List<List<Integer>> list,int[][] dp){
        if(i>=list.size()||j>=list.get(i).size()) return Integer.MAX_VALUE;
        if(i==list.size()-1) return list.get(i).get(j);
        if(dp[i][j]!=Integer.MAX_VALUE) return dp[i][j];
        return dp[i][j] = list.get(i).get(j)+Math.min(rec(i+1,j,list,dp),rec(i+1,j+1,list,dp));
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m][m];
        for(int[] row: dp){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        return rec(0,0,triangle,dp);
    }
}